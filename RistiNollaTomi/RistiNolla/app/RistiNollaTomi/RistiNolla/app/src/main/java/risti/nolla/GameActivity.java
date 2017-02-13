package risti.nolla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jarno on 6.2.2017.
 */

public class GameActivity extends AppCompatActivity {
    boolean player1 = true;
    // boolean player2 = false;
    boolean button1pressed = false;
    boolean button2pressed = false;
    boolean button3pressed = false;
    boolean button4pressed = false;
    boolean button5pressed = false;
    boolean button6pressed = false;
    boolean button7pressed = false;
    boolean button8pressed = false;
    boolean button9pressed = false;
    int x = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


    }
    /*
    protected void endGame(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    */

    public void button_1(View v) {

        Button b1 = (Button) findViewById(R.id.button1);
        if (player1 == true && button1pressed == false) {
            b1.setText("X");
            player1 = false;
            button1pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button1pressed == false) {
            b1.setText("O");
            player1 = true;
            button1pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }


    }

    public void button_2(View v) {

        Button b1 = (Button) findViewById(R.id.button2);
        if (player1 == true && button2pressed == false) {
            b1.setText("X");
            player1 = false;
            button2pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button2pressed == false) {
            b1.setText("O");
            player1 = true;
            button2pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }


    }

    public void button_3(View v) {

        Button b1 = (Button) findViewById(R.id.button3);
        if (player1 == true && button3pressed == false) {
            b1.setText("X");
            player1 = false;
            button3pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button3pressed == false) {
            b1.setText("O");
            player1 = true;
            button3pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }

    }

    public void button_4(View v) {

        Button b1 = (Button) findViewById(R.id.button4);
        if (player1 == true && button4pressed == false) {
            b1.setText("X");
            player1 = false;
            button4pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button4pressed == false) {
            b1.setText("O");
            player1 = true;
            button4pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }

    }

    public void button_5(View v) {

        Button b1 = (Button) findViewById(R.id.button5);
        if (player1 == true && button5pressed == false) {
            b1.setText("X");
            player1 = false;
            button5pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button5pressed == false) {
            b1.setText("O");
            player1 = true;
            button5pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }

    }

    public void button_6(View v) {

        Button b1 = (Button) findViewById(R.id.button6);
        if (player1 == true && button6pressed == false) {
            b1.setText("X");
            player1 = false;
            button6pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button6pressed == false) {
            b1.setText("O");
            player1 = true;
            button6pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }

    }

    public void button_7(View v) {

        Button b1 = (Button) findViewById(R.id.button7);
        if (player1 == true && button7pressed == false) {
            b1.setText("X");
            player1 = false;
            button7pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button7pressed == false) {
            b1.setText("O");
            player1 = true;
            button7pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }

    }

    public void button_8(View v) {

        Button b1 = (Button) findViewById(R.id.button8);
        if (player1 == true && button8pressed == false) {
            b1.setText("X");
            player1 = false;
            button8pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button8pressed == false) {
            b1.setText("O");
            player1 = true;
            button8pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }

    }

    public void button_9(View v) {

        Button b9 = (Button) findViewById(R.id.button9);
        if (player1 == true && button9pressed == false) {
            b9.setText("X");
            player1 = false;
            button9pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("O-Pelaajan vuoro");
            x++;
        } else if (player1 == false && button9pressed == false) {
            b9.setText("O");
            player1 = true;
            button9pressed = true;
            TextView teksti = (TextView) findViewById(R.id.InfoTextView);
            teksti.setText("X-Pelaajan vuoro");
            x++;
        }

    }

    public void stop_button(View v){

        Intent intent= new Intent(GameActivity.this, MainActivity.class);
        startActivity(intent);
    }

    }

