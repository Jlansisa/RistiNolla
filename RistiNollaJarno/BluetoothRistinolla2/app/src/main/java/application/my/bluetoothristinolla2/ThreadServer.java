/**
 * Created by jarno on 5.2.2017.
 */
package application.my.bluetoothristinolla2;

import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothAdapter;
import java.io.IOException;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.widget.TextView;

public class ThreadServer extends Thread
{
    // Name for the SDP record when creating server socket
    public static final String MY_SERVICE_NAME = "RistinollaReceiver";
    //Self made unique ID
    public static final UUID MY_SERVICE_UUID =
            UUID.fromString("bb96d1d2-beac-20cd-9b28-1711311b8b55");
    //Socet for incoming connections
    private final BluetoothServerSocket mmServerSocket;
    //BT device
    private BluetoothAdapter mBluetoothAdapter;
    //Trigger to control socket status
    private boolean isRunning;
    //main activity imported from super class
    private Activity mActivity;
    //info
    private TextView info;


    /*
     * Construct
     */
    public ThreadServer(BluetoothAdapter baa, Activity activity, TextView infotext){
        mActivity = activity;
        info = infotext;
        BluetoothServerSocket tmp = null;
        try {
            //init BT adapger
            mBluetoothAdapter=baa;
            // MY_UUID is the app's UUID string, also used by the client code

            //luodaan server socket
            tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(MY_SERVICE_NAME, MY_SERVICE_UUID);
            //Log.d("TAGI","Palvelukutsu2");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mmServerSocket = tmp;

    }

    /*
     * Start
     */
    public void run() {

        //init socket
        BluetoothSocket socket = null;
        //num of sockets
        int num=1;
        isRunning = true;
        Log.d("TAGI","isRunning = true");
        // Keep listening until exception occurs or a socket is returned
        while (isRunning) {
            try {
                socket = mmServerSocket.accept();
            } catch (IOException e) {
                break;
            }
            // If a connection was accepted
            if (socket != null) {
                // Do work to manage the connection (in a separate thread)

                // Luodaan yhtä asiakasta palveleva säie ja käynnisteään se
                ClientHandler handler = new ClientHandler(socket, num, info);
                Thread clientThread = new Thread(handler);
                clientThread.start();

                num++;
            }else {
                Log.d("TAGI","Socket doesn't exist");
            }
        }

    }

    public void cancel() {
        try {
            mmServerSocket.close();
        } catch (IOException e) { }
    }
    public void stopTh(){
        isRunning=false;
    }
    public void startTh(){
        isRunning=true;
    }
}
