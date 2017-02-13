/**
 * Created by jarno on 4.2.2017.
 */


package application.my.bluetoothristinolla2;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.ArrayAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.widget.ListView;
import android.widget.AdapterView;
import android.view.View;
import java.util.Set;

public class Connection
{

    //main activity
    private Activity mActivity;
    //info
    private TextView info;

    //BT permission request values
    private final  int REQUEST_CODE_ASK_ACCESS_FINE_LOCTION = 124;
    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_ENABLE_DISCOVERABILITY = 85;
    //BT adapter
    private BluetoothAdapter mBluetoothAdapter;
    //Adapter layout for listing devices on ListView
    private ArrayAdapter<String> BTArrayAdapter;  //Layout
    //Listview for devises
    private ListView myListView; //view
    //Selected device on devise listview
    private String selectedDevice=null;
    //device list
    private Set<BluetoothDevice> pairedDevices;
    //time how long device is discoverable
    private static final int REQUEST_DISCOVERABILITY_TIME = 300;
    //Server threat for incoming connections
    private ThreadServer threadServer=null;
    //threat server status. disabled when false
    private boolean serverStatus;


    /*
     * Construct
     */

    public Connection(AppCompatActivity activity){
        mActivity = activity;
        info = (TextView)mActivity.findViewById(R.id.infotext);
        //Check BT permissions
        while (!checkPermission()) {
            //if no permission, ask for user
            Toast.makeText(mActivity, (R.string.no_bt_permission) , Toast.LENGTH_LONG).show();
            requestPermission();
        }
        Toast.makeText(mActivity, (R.string.bt_permission_granted), Toast.LENGTH_LONG).show();

        //Get BT radio adapter
        if(!getAdapter()) {
            Toast.makeText(mActivity.getApplicationContext(),
                    (R.string.bt_not_supported),
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mActivity.getApplicationContext(),
                    (R.string.bt_is_supported),
                    Toast.LENGTH_LONG).show();
        }

        //Activate BT device
        if(activate()){
            Toast.makeText(mActivity.getApplicationContext(),
                    (R.string.bt_is_on),
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mActivity.getApplicationContext(),
                    (R.string.bt_was_on),
                    Toast.LENGTH_LONG).show();
        }
        //set server off as default
        serverStatus = false;
    }

    /*
     * Enable BT discovery
     */
    public boolean enableDiscovery(){

        //disable visibility while discovering
        if(!disableVisibility()){
            return false;
        }
        //Clear device list if exists
        if(BTArrayAdapter != null) {
            BTArrayAdapter.clear();
        }
        //activate discovery
        mBluetoothAdapter.startDiscovery();
        //call helper
        mActivity.registerReceiver(bReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));

        //Creat listview for found devices
        myListView = (ListView) mActivity.findViewById(R.id.listView1);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String deviceMacAddress="";
                selectedDevice=myListView.getItemAtPosition(i).toString() ;

                //setting the selected device
                if (selectedDevice!=null) {

                    //erotetaan stringista mac osoite
                    String [] s=selectedDevice.split("\n");
                    deviceMacAddress=s[1];
                }
                BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(deviceMacAddress);
                Log.d("TAGI", "MAC-osoite: "+deviceMacAddress);
                // Cancel discovery because it will slow down the connection
                mBluetoothAdapter.cancelDiscovery();
                //Threat for Client -> Server connection
                new ConnectThread(device, mActivity, info).start();
            }
        });
        BTArrayAdapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_list_item_1);
        myListView.setAdapter(BTArrayAdapter);
        pairedDevices = mBluetoothAdapter.getBondedDevices();
        for(BluetoothDevice device : pairedDevices) {
            BTArrayAdapter.add(device.getName() + "\n" + device.getAddress());//MAC-osoite
        }
        return true;
    }

    /*
     * my turn
     */
    public boolean turnDo(){
        if(!threadServer.isAlive()){
            threadServer.start();
        } else {
            threadServer.startTh();
        }
        return true;
    }


    /*
     * my turn
     */
    public boolean turnWait(){
        if(threadServer != null)
            threadServer.stopTh();
        return true;
    }

    /*
     * server status
     */
    public boolean getServerstatus(){
        return serverStatus;
    }

    /*
     * Helper for enableDiscovery
     */
    final BroadcastReceiver bReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // add the name and the MAC address of the object to the arrayAdapter
                BTArrayAdapter.add(device.getName() + "\n" + device.getAddress());

                //näytö päivitys uuden laitteen jälkeen
                BTArrayAdapter.notifyDataSetChanged();
            }
        }
    };

    /*
    * Enable BT visibility
    */
    public boolean enableVisibility(){

        //Clear device list if exists
        if(BTArrayAdapter != null) {
            BTArrayAdapter.clear();
        }

        //disable discovering while beign visible
        if(!disableDiscovery()){
            return false;
        }
        Intent disvoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        disvoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, REQUEST_DISCOVERABILITY_TIME);
        mActivity.startActivityForResult(disvoverableIntent,REQUEST_ENABLE_DISCOVERABILITY);

        //start a new thread to serve incoming connections
        threadServer=new ThreadServer(mBluetoothAdapter, mActivity, info);
        threadServer.start();

        //set server status on
        serverStatus = true;
        return true;
    }

    /*
    * Disable BT discovery
    */
    public boolean disableDiscovery(){
        if (mBluetoothAdapter.isDiscovering()) {
           if(mBluetoothAdapter.cancelDiscovery()){
               return true;
           } else {
               return false;
           }
        }
        return true;
    }

    /*
    * Disable BT visibility
    */
    public boolean disableVisibility(){
        Log.d("TAGI","disableVisibility");
        if(threadServer != null)
            threadServer.stopTh();
        serverStatus = false;
        return true;
    }

    /*
     * Permission check
     */

    private boolean checkPermission(){
        boolean hasPermission = (ContextCompat.checkSelfPermission(mActivity,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED);
        return hasPermission;
    }

    /*
     * Permission request
     */

    private void requestPermission(){
        ActivityCompat.requestPermissions(mActivity,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                REQUEST_CODE_ASK_ACCESS_FINE_LOCTION);
    }

    /*
     * BT device activation
     */

    private boolean getAdapter() {

        // take an instance of BluetoothAdapter - Bluetooth radio
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null) return false;
        else return true;
    }

    /*
     * BT connection activation
     */

    private boolean activate() {
        if (!mBluetoothAdapter.isEnabled()) {
            Intent turnOnIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            mActivity.startActivityForResult(turnOnIntent, REQUEST_ENABLE_BT); //REQUEST_ENABLE_BT vapaavalintainen numero
            return true;
        }
        return false;
    }



}
