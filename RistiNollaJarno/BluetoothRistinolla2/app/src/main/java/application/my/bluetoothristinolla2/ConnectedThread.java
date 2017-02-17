package application.my.bluetoothristinolla2;

import android.app.Activity;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by jarno on 5.2.2017.
 */

public class ConnectedThread extends Thread{

    //socket from super class
    private Activity mActivity;
    private final BluetoothSocket mmSocket;
    private final OutputStream mmOutStream;
    private final InputStream mminStream;
    int  transferValue;
    int square;
    //info
    public TextView info;
    ConnectedThread(BluetoothSocket socket, TextView infotext, int tr,  Activity activity){
        mActivity = activity;
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
        mminStream = tmpIn;
        transferValue = tr;

    }



    public void run(){
        // buffer store for the stream
        // bytes returned from read()
        int bytes;
        //string to write in strean

        Button b0 = (Button)mActivity.findViewById(R.id.B0);
        Button b1 = (Button)mActivity.findViewById(R.id.B1);
        Button b2 = (Button)mActivity.findViewById(R.id.B2);
        Button b3 = (Button)mActivity.findViewById(R.id.B3);
        Button b4 = (Button)mActivity.findViewById(R.id.B4);
        Button b5 = (Button)mActivity.findViewById(R.id.B5);
        Button b6 = (Button)mActivity.findViewById(R.id.B6);
        Button b7 = (Button)mActivity.findViewById(R.id.B7);
        Button b8 = (Button)mActivity.findViewById(R.id.B8);


        byte[] inputBuffer = new byte[1];
        // Keep listening to the InputStream until an exception occurs
        try {

           /* b0.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 0;Log.d("TAGI","Button 0 clicked");}});
            b1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 1;Log.d("TAGI","Button 1 clicked");}});
            b2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 2;Log.d("TAGI","Button 2 clicked");}});
            b3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 3;Log.d("TAGI","Button 3 clicked");}});
            b4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 4;Log.d("TAGI","Button 4 clicked");}});
            b5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 5;Log.d("TAGI","Button 5 clicked");}});
            b6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 6;Log.d("TAGI","Button 6 clicked");}});
            b7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 7;Log.d("TAGI","Button 7 clicked");}});
            b8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {transferValue = 8;Log.d("TAGI","Button 8 clicked");}});*/
            Log.d("TAGI","transferValue is " + transferValue);
            //Write to the server
            mmOutStream.write(transferValue);
            // Read from the InputStream (from the server)
           // int numBytesRead = mminStream.read(inputBuffer);
           // char merkki = new  String(inputBuffer).charAt(0);
            //square = (int)merkki;
            info.post(new Update());

            mmOutStream.close();
            mmSocket.close();

        } catch (IOException e) {
            //break;
        }
    }
    class Update implements Runnable {
        Button b;
        public void run() {
            Log.d("TAGI","Updating info");
            Log.d("TAGI","Updating square" +square);
            if(transferValue == 9){
                info.setText("Game start");
                info.invalidate();
            } else {

               /* switch(square) {
                    case 0: b = (Button) mActivity.findViewById(R.id.B0);break;
                    case 1: b = (Button) mActivity.findViewById(R.id.B1);break;
                    case 2: b = (Button) mActivity.findViewById(R.id.B2);break;
                    case 3: b = (Button) mActivity.findViewById(R.id.B3);break;
                    case 4: b = (Button) mActivity.findViewById(R.id.B4);break;
                    case 5: b = (Button) mActivity.findViewById(R.id.B5);break;
                    case 6: b = (Button) mActivity.findViewById(R.id.B6);break;
                    case 7: b = (Button) mActivity.findViewById(R.id.B7);break;
                    case 8: b = (Button) mActivity.findViewById(R.id.B8);break;
                }
                b.setText("O");*/

            }
        }
    }
}
