package risti.nolla;

import android.bluetooth.BluetoothSocket;
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
    private final InputStream mmInStream;
    private final OutputStream mmOutStream;
    char merkki;
    int rsquare;
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
        mmInStream = tmpIn;
        mmOutStream = tmpOut;

    }

    public void run(){
        System.out.println("New ConncetedThread created");
        // buffer store for the stream
        byte[] buffer = new byte[1];
        // bytes returned from read()
        int bytes;
        //string to write in strean
        int square = 9;

        // Keep listening to the InputStream until an exception occurs
        try {
            //Write to the server
            mmOutStream.write(square);
            // Read from the InputStream (from the server)
            bytes = mmInStream.read(buffer);
            System.out.println("mmInStream read succeed: "+bytes+" bytes");
            //Convert read bytes (array) to String
            merkki = new String(buffer).charAt(0);
            int rsquare = (int)merkki;
            info.post(new Update());
            mmInStream.close();
            mmOutStream.close();
            mmSocket.close();
        } catch (IOException e) {
            //break;
        }
    }
    class Update implements Runnable {
        public void run() {
            info.setText(rsquare);
        }
    }
}
