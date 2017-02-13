package risti.nolla;

import android.bluetooth.BluetoothSocket;
import java.io.InputStream;
import java.io.OutputStream;

import android.util.Log;
import android.widget.TextView;
/**
 * Created by jarno on 5.2.2017.
 */

public class ClientHandler implements Runnable
{
    //Socet from super class
    protected BluetoothSocket clientSocket;
    //trigger
    private boolean running;
    //socket number
    private int number;
    //strings for input and output
    private String outMsg;
    private String inMsg;
    //info
    private TextView info;
    char merkki;
    int square;

    /*
     * Construct
     */
    public ClientHandler(BluetoothSocket aClientSocket, int num, TextView infotext){
        info = infotext;
        //set socket number
        number=num;

        //set socket
        clientSocket = aClientSocket;
    }

    /*
     * Start
     */
    public void run(){
        System.out.println("Clienthandler started");
        //start client handler
        try{
            //streams for input and output communications
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();

            //byte buffer for saving streams (2 bytes)
            byte[] inputBuffer = new byte[1];

            //set trigger for running
            running=true;

            //Now the handler is ready to run
            while(running){
                Log.d("TAGI","Clienthandler waiting");

                //read incoming bytes into buffer and save the num of bytes as numBytesRead
                int numBytesRead = in.read(inputBuffer);
                merkki = new String(inputBuffer).charAt(0);
                square = (int)merkki;
                Log.d("TAGI","Bytes read: "+numBytesRead);
                Log.d("TAGI","Square: "+square);
                info.post(new Update());



            }
            // The loop only terminates when the client disconnects. It's safe to close
            // down the connection. Just ignore any errors that happen when closing
           try
            {
                clientSocket.close();
            }
            catch (Exception ignore) {}

        } catch (Exception exc) {
            try
            {
                clientSocket.close();
            }
            catch (Exception ignore) {}
        }

    }
    class Update implements Runnable {
        public void run() {
            Log.d("TAGI","Updating info");
            if(square == 9)info.setText("Game start");
            info.invalidate();
        }
    }

}
