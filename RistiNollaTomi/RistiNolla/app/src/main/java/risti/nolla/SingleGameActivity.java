package risti.nolla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Azumi on 9.2.2017.
 */

public class SingleGameActivity extends AppCompatActivity {
    boolean player1 = true;
    // boolean player2 = false;
    int x = 0;
    TextView teksti;
    CharHandler XCharhandler = new CharHandler();
    CharHandler OCharhandler = new CharHandler();
    Button bulc;
    Button bum;
    Button burc;
    Button brm;
    Button bm;
    Button brmc;
    Button bdlc;
    Button bdm;
    Button blm;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlegame);
       teksti = (TextView) findViewById(R.id.InfoTextView);
        bulc = (Button) findViewById(R.id.button1);
        bum = (Button) findViewById(R.id.button2);
        burc = (Button) findViewById(R.id.button3);
        brm = (Button) findViewById(R.id.button4);
        bm = (Button) findViewById(R.id.button5);
        brmc = (Button) findViewById(R.id.button6);
        bdlc = (Button) findViewById(R.id.button7);
        bdm = (Button) findViewById(R.id.button8);
        blm = (Button) findViewById(R.id.button9);


    }


    public void ULC(View v) {


        if (player1 == true ) {
            bulc.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("ULC");
        } else{
            bulc.setText("O");
            OCharhandler.calculateFields("ULC");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
        }

        bulc.setClickable(false);
        x++;
        tilanne();
    }

    public void UM(View v) {


        if (player1 == true ) {
            bum.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("UM");
        } else{
            bum.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("UM");
        }
        bum.setClickable(false);
        x++;
        tilanne();

    }

    public void URC(View v) {


        if (player1 == true) {
            burc.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("URC");
        } else{
            burc.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("URC");
        }
        burc.setClickable(false);
        x++;
        tilanne();
    }

    public void RM(View v) {


        if (player1 == true ) {
            brm.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("RM");
        } else{
            brm.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("RM");
        }
        brm.setClickable(false);
        x++;
        tilanne();
    }

    public void M(View v) {


        if (player1 == true ) {
            bm.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("M");
        } else {
            bm.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("M");
        }
        bm.setClickable(false);
        x++;
        tilanne();
    }

    public void RMC(View v) {


        if (player1 == true ) {
            brmc.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("RMC");
        } else {
            brmc.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("RMC");
        }
        brmc.setClickable(false);
        x++;
        tilanne();
    }

    public void DLC(View v) {


        if (player1 == true) {
            bdlc.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("DLC");
        } else {
            bdlc.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("DLC");
        }
        bdlc.setClickable(false);
        x++;
        tilanne();
    }

    public void DM(View v) {


        if (player1 == true) {
            bdm.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("DM");
        } else {
            bdm.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("DM");
        }
        bdm.setClickable(false);
        x++;
        tilanne();
    }

    public void LM(View v) {


        if (player1 == true ) {
            blm.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("LM");
        } else {
            blm.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("LM");
        }
        blm.setClickable(false);
        x++;
        tilanne();
    }

    public void stop_button(View v){

        Intent intent= new Intent(SingleGameActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void tilanne(){
        if(x == 9){
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("Ruudukot loppuivat");
        }
         if (XCharhandler.win() == true) {
            teksti.setText("X VOITTI");
             lopetus();


        }
        if(OCharhandler.win() == true){

            teksti.setText("O VOITTI");
            lopetus();
        }

    }

    public void reset(){



    }

    public void lopetus(){
        bulc.setClickable(false);
        bum.setClickable(false);
        burc.setClickable(false);
        blm.setClickable(false);
        bm.setClickable(false);
        brm.setClickable(false);
        bdlc.setClickable(false);
        bdm.setClickable(false);
        brmc.setClickable(false);

    }

}



