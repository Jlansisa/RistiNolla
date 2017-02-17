package application.my.bluetoothristinolla2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarno on 6.2.2017.
 */

public class GameActivity extends AppCompatActivity {
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8;
    String RMAC;
    Connection BT;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_game);
        //BT = new Connection(this);


        BT = new Connection(this);
        BT.setButton(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            RMAC = extras.getString("RMAC");
            BT.setRemoteMAC(RMAC);
        }
        Log.d("TAGI", "Remote MAC" + RMAC);
        b0 = (Button)findViewById(R.id.B0);

        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendTurn(0);
            }
        });

    }
    protected void endGame(View v){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void sendTurn(int sq){

        BT.sendTurn(sq);
        disableButton(sq , "X");
    }

    /*
     *  Disable button and set text
     */

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




}
