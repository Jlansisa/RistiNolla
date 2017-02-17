package application.my.bluetoothristinolla2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity
{
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8;
    //main layout
    AppCompatActivity myactivity;
    //info field
    private TextView info ;
    private Button btnFind;
    private Button btnWait;

    View grid;

    ListView list;
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
        BT = new Connection(this);

        info = (TextView)findViewById(R.id.infotext);
        b0 = (Button)findViewById(R.id.B0);
         b1 = (Button)findViewById(R.id.B1);
         b2 = (Button)findViewById(R.id.B2);
         b3 = (Button)findViewById(R.id.B3);
         b4 = (Button)findViewById(R.id.B4);
         b5 = (Button)findViewById(R.id.B5);
         b6 = (Button)findViewById(R.id.B6);
         b7 = (Button)findViewById(R.id.B7);
         b8 = (Button)findViewById(R.id.B8);
        grid = (View)findViewById(R.id.game_layout_grid);
        list = (ListView)findViewById(R.id.listView1);


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
                    list.setVisibility(View.GONE);
                    grid.setVisibility(View.VISIBLE);

                    /*b0.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            sendTurn(0);
                        }
                    });*/
                    b0.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(0);Log.d("TAGI","Button 0 clicked");}});
                    b1.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(1);Log.d("TAGI","Button 1 clicked");}});
                    b2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(2);Log.d("TAGI","Button 2 clicked");}});
                    b3.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(3);Log.d("TAGI","Button 3 clicked");}});
                    b4.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(4);Log.d("TAGI","Button 4 clicked");}});
                    b5.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(5);Log.d("TAGI","Button 5 clicked");}});
                    b6.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(6);Log.d("TAGI","Button 6 clicked");}});
                    b7.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(7);Log.d("TAGI","Button 7 clicked");}});
                    b8.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {sendTurn(8);Log.d("TAGI","Button 8 clicked");}});
                    //Intent intent= new Intent(myactivity, GameActivity.class);
                    //intent.putExtra("RMAC", BT.getRemoteMAC());
                    //Bundle bundle = new Bundle();
                   // bundle.putParcelable("data", BT);
                    //intent.putExtras(bundle);
                    //startActivity(intent);


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

            //disable find button
            disableButton(btnFind, R.string.bt_finding);
            enableButton(btnWait, (R.string.Wait));
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
            disableButton(btnWait, R.string.bt_waiting);
            enableButton(btnFind, (R.string.Find));
        } else {
            info.setText(R.string.bt_error);
        }
    }



    /*
     *  Disable button and set text
     */

    private void disableButton (Button b, int text){
        b.setEnabled(false);
        b.setText(text);
    }

    /*
     *  Enable button and set text
     */
    private void enableButton (Button b, int text){
        b.setEnabled(true);
        b.setText(text);
    }

    private void disableButton (int b, String text){
        Button btn = b0;
        switch(b){
            case 0: btn = b0; break;
            case 1: btn = b1; break;
            case 2: btn = b2; break;
            case 3: btn = b3; break;
            case 4: btn = b4; break;
            case 5: btn = b5; break;
            case 6: btn = b6; break;
            case 7: btn = b7; break;
            case 8: btn = b8; break;
        }
        btn.setText(text);
        btn.setEnabled(false);


    }

    private void sendTurn(int sq){

        BT.sendTurn(sq);
        disableButton(sq , "X");
    }






}
