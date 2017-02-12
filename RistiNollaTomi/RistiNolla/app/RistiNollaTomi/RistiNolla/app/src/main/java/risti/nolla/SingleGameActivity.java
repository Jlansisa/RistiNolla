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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlegame);
       teksti = (TextView) findViewById(R.id.InfoTextView);


    }


    public void ULC(View v) {

        Button b1 = (Button) findViewById(R.id.button1);
        if (player1 == true ) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("ULC");
        } else{
            b1.setText("O");
            OCharhandler.calculateFields("ULC");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
        }

        b1.setClickable(false);
        x++;
        tilanne();
    }

    public void UM(View v) {

        Button b1 = (Button) findViewById(R.id.button2);
        if (player1 == true ) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("UM");
        } else{
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("UM");
        }
        b1.setClickable(false);
        x++;
        tilanne();

    }

    public void URC(View v) {

        Button b1 = (Button) findViewById(R.id.button3);
        if (player1 == true) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("URC");
        } else{
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("URC");
        }
        b1.setClickable(false);
        x++;
        tilanne();
    }

    public void RM(View v) {

        Button b1 = (Button) findViewById(R.id.button4);
        if (player1 == true ) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("RM");
        } else{
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("RM");
        }
        b1.setClickable(false);
        x++;
        tilanne();
    }

    public void M(View v) {

        Button b1 = (Button) findViewById(R.id.button5);
        if (player1 == true ) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("M");
        } else {
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("M");
        }
        b1.setClickable(false);
        x++;
        tilanne();
    }

    public void RMC(View v) {

        Button b1 = (Button) findViewById(R.id.button6);
        if (player1 == true ) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("RMC");
        } else {
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("RMC");
        }
        b1.setClickable(false);
        x++;
        tilanne();
    }

    public void DLC(View v) {

        Button b1 = (Button) findViewById(R.id.button7);
        if (player1 == true) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("DLC");
        } else {
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("DLC");
        }
        b1.setClickable(false);
        x++;
        tilanne();
    }

    public void DM(View v) {

        Button b1 = (Button) findViewById(R.id.button8);
        if (player1 == true) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("DM");
        } else {
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("DM");
        }
        b1.setClickable(false);
        x++;
        tilanne();
    }

    public void LM(View v) {

        Button b1 = (Button) findViewById(R.id.button9);
        if (player1 == true ) {
            b1.setText("X");
            player1 = false;
            teksti.setText("O-Pelaajan vuoro");
            XCharhandler.calculateFields("LM");
        } else {
            b1.setText("O");
            player1 = true;
            teksti.setText("X-Pelaajan vuoro");
            OCharhandler.calculateFields("LM");
        }
        b1.setClickable(false);
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


        }
        if(OCharhandler.win() == true){

            teksti.setText("O VOITTI");
        }

    }

    public void reset(){



    }

}



