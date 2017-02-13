

/**
 * Created by jarno on 5.2.2017.
 */
package risti.nolla;

import android.bluetooth.BluetoothDevice;
import android.app.Activity;
import android.bluetooth.BluetoothSocket;
import android.widget.TextView;

import java.io.IOException;


public class ConnectThread extends Thread  {
    //activitu from super class
    private Activity mActivity;
    //socket from super class
    private final BluetoothSocket mmSocket;
    //sevice from super class
    private final BluetoothDevice mmDevice;
    private TextView info ;


    public ConnectThread(BluetoothDevice device, Activity activity, TextView infotext){
        info = infotext;

        mActivity = activity;
        mmDevice = device;
        //temporary socket to assign as a final mmSocket
        BluetoothSocket tmp = null;

        // Get a BluetoothSocket to connect with the given BluetoothDevice
        try {
            // MY_UUID is the app's UUID string, also used by the server code
            tmp = device.createRfcommSocketToServiceRecord(ThreadServer.MY_SERVICE_UUID);
        } catch (IOException e) { }

        //assign final socket
        mmSocket = tmp;
    }

    public void run() {
        //info.post(new Update());
        try {
            // Connect the device through the socket. This will block
            // until it succeeds or throws an exception
            mmSocket.connect();
        } catch (IOException connectException) {
            // Unable to connect; close the socket and get out
            try {
                mmSocket.close();
            } catch (IOException closeException) {
            }
            return;
        }

        // Do work to manage the connection (in a separate thread)
        //manageConnectedSocket(mmSocket);
        new ConnectedThread(mmSocket, info).start();

    }
}