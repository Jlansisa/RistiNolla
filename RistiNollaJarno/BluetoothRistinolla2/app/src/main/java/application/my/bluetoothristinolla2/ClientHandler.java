package application.my.bluetoothristinolla2;

import android.app.Activity;
import android.bluetooth.BluetoothSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    int square, transferValue;

    AppCompatActivity mActivity;

    Button b;


    /*
     * Construct
     */
    public ClientHandler(BluetoothSocket aClientSocket, int num, TextView infotext, AppCompatActivity Activity, int tr){
        info = infotext;
        //set socket number
        number=num;

        //set socket
        clientSocket = aClientSocket;
        mActivity = Activity;
        transferValue = 10;
    }

    /*
     * Start
     */
    public void run(){

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
                if(transferValue < 9)
                    out.write(transferValue);




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
            if(square == 9){
                info.setText("Game start");
                info.invalidate();
            } else {
                switch(square){
                    case 0: b = (Button)mActivity.findViewById(R.id.B0); break;
                    case 1: b = (Button)mActivity.findViewById(R.id.B1); break;
                    case 2: b = (Button)mActivity.findViewById(R.id.B2); break;
                    case 3: b = (Button)mActivity.findViewById(R.id.B3); break;
                    case 4: b = (Button)mActivity.findViewById(R.id.B4); break;
                    case 5: b = (Button)mActivity.findViewById(R.id.B5); break;
                    case 6: b = (Button)mActivity.findViewById(R.id.B6); break;
                    case 7: b = (Button)mActivity.findViewById(R.id.B7); break;
                    case 8: b = (Button)mActivity.findViewById(R.id.B8); break;
                }
                b.setText("O");

            }
        }
    }


}
