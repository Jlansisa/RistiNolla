package risti.nolla;

import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jarno on 5.2.2017.
 */

public class ConnectedThread extends Thread{

    //socket from super class
    private final BluetoothSocket mmSocket;
    private final OutputStream mmOutStream;
    int  square;
    //info
    public TextView info;
    ConnectedThread(BluetoothSocket socket, TextView infotext){
        mmSocket = socket;
        info = infotext;
        //temporary stream variables
        InputStream tmpIn = null;
        OutputStream tmpOut = null;

        // Get the input and output streams, using temp objects because
        // member streams are final
        try {
            tmpIn = mmSocket.getInputStream();
            tmpOut = mmSocket.getOutputStream();
        } catch (IOException e) { }

        //assign temp streams as final
        mmOutStream = tmpOut;

    }

    public void run(){
        // buffer store for the stream
        byte[] buffer = new byte[1];
        // bytes returned from read()
        int bytes;
        //string to write in strean
        square = 9;

        // Keep listening to the InputStream until an exception occurs
        try {

            //Write to the server
            mmOutStream.write(square);
            // Read from the InputStream (from the server)


            mmOutStream.close();
            mmSocket.close();
            info.post(new Update());
        } catch (IOException e) {
            //break;
        }
    }
    class Update implements Runnable {
        public void run() {
            Log.d("TAGI","Updating info1");
            if(square == 9)info.setText("Game start");
            info.invalidate();
        }
    }
}