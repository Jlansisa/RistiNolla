package application.my.bluetoothristinolla2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity
{

    //main layout
    AppCompatActivity myactivity;
    //info field
    private TextView info ;
    private Button btnFind;
    private Button btnWait;
    //Bluetooth connection object
    Connection BT;
    //Adapter for listing devices on ListView
    private ArrayAdapter<String> BTArrayAdapter;

    /*
     * Construct
     */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set activity
        myactivity = this;

        //activate BT
        BT = new Connection(myactivity);
        //info = (TextView)findViewById(R.id.infotext);
        //info.setText(R.string.bt_activated);
        //start
        begin();
    }

    /*
     * Beginning
     */
    protected void begin(){

        //Button to find an opponent
        btnFind = (Button)findViewById(R.id.find);
        btnFind.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                //start discovering
                if(BT.enableDiscovery()){
                    //info.setText(R.string.bt_info_discovering);
                    //if clicked, disable to avoid another click
                    btnFind.setEnabled(false);
                    btnFind.setText(R.string.bt_finding);
                    btnWait.setEnabled(true);
                    btnWait.setText(R.string.Wait);
                } else {
                    info.setText(R.string.bt_error);
                }

            }
        });

        //Button to set discoverable and wait for an opponent
        btnWait = (Button)findViewById(R.id.wait);
        btnWait.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //set device visible
                if(BT.enableVisibility()){
                    //info.setText(R.string.bt_info_waiting);
                    //if clicked, disable to avoid another click
                    btnWait.setEnabled(false);
                    btnWait.setText(R.string.bt_waiting);
                    btnFind.setEnabled(true);
                    btnFind.setText(R.string.Find);

                } else {
                    info.setText(R.string.bt_error);
                }
            }
        });

    }




}
