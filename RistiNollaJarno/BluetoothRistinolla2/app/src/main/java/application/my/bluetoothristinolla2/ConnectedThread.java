package application.my.bluetoothristinolla2;

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
    private String result="";
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
        char str = 'X';

        // Keep listening to the InputStream until an exception occurs
        try {
            //Write to the server
            mmOutStream.write(str);
            // Read from the InputStream (from the server)
            bytes = mmInStream.read(buffer);
            System.out.println("mmInStream read succeed: "+bytes+" bytes");
            //Convert read bytes (array) to String
            result=new String(buffer);
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
            info.setText(result);
        }
    }
}
