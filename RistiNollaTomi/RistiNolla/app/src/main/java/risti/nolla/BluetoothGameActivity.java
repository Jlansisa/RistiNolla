package risti.nolla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.ArrayAdapter;

public class BluetoothGameActivity extends AppCompatActivity

    {

        //main layout
        AppCompatActivity myactivity;
        //info field
        private TextView info;
        private Button btnFind;
        private Button btnWait;
      //  private Button btnSingle;
        //Bluetooth connection object
        Connection BT;
        //Adapter for listing devices on ListView
        private ArrayAdapter<String> BTArrayAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_game);

        //set activity
        myactivity = this;

        //activate BT
        BT = new Connection(myactivity);

        info = (TextView)findViewById(R.id.infotext);


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
                    findOpponent();
                }
            });

            //Button to set discoverable and wait for an opponent
            btnWait = (Button)findViewById(R.id.wait);
            btnWait.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    waitOpponent();

                }
            });

            info.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(s.toString().equals("Game start")) {
                        Intent intent= new Intent(myactivity, GameActivity.class);
                        startActivity(intent);
                    }

                }
            });


        }
    /*
     * Find a new opponent activates State: waiting for turn
     */

        private void findOpponent(){
            //start discovering new devices
            //and list them on ListView
            if(BT.enableDiscovery()){
                //set state to wait and disable
                //find button
                turnWait();
            } else {
                info.setText(R.string.bt_error);
            }
        }

    /*
     * Wait for  opponent
     */

        private void waitOpponent(){
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


    /*
     * State: waiting for turn
     */

        private void turnWait(){
            //set device visible
            if(BT.turnWait()){

                //if clicked, disable find-button
                // to avoid another click
                btnWait.setEnabled(true);
                btnWait.setText(R.string.bt_waiting);
                btnFind.setEnabled(false);
                btnFind.setText(R.string.bt_finding);

            } else {
                info.setText(R.string.bt_error);
            }
        }

    /*
     * State: my turn
     */

        private void turnDo(){

            //start discovering
            if(BT.turnDo()){
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

        public void main_menu(View v){
            Intent intent = new Intent(BluetoothGameActivity.this, MainActivity.class);
            startActivity(intent);

        }


}

