/**
 * Created by Johanna Länsisaari on 10.2.1017.
 * Updated on 12.2.2017
 */
package tictac.toe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameBoardActivity extends Activity {

    Button Button1, Button2, Button3, Button4, Button5,
            Button6, Button7, Button8, Button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        Button1 = (Button) findViewById(R.id.button);
        Button2 = (Button) findViewById(R.id.button2);
        Button3 = (Button) findViewById(R.id.button3);
        Button4 = (Button) findViewById(R.id.button4);
        Button5 = (Button) findViewById(R.id.button5);
        Button6 = (Button) findViewById(R.id.button6);
        Button7 = (Button) findViewById(R.id.button7);
        Button8 = (Button) findViewById(R.id.button8);
        Button9 = (Button) findViewById(R.id.button9);

        Button1.setOnClickListener(imgButtonHandler);
        Button2.setOnClickListener(imgButtonHandler);
        Button3.setOnClickListener(imgButtonHandler);
        Button4.setOnClickListener(imgButtonHandler);
        Button5.setOnClickListener(imgButtonHandler);
        Button6.setOnClickListener(imgButtonHandler);
        Button7.setOnClickListener(imgButtonHandler);
        Button8.setOnClickListener(imgButtonHandler);
        Button9.setOnClickListener(imgButtonHandler);
    }

    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    Button1.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button2:
                    Button2.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button3:
                    Button3.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button4:
                    Button4.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button5:
                    Button5.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button6:
                    Button6.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button7:
                    Button7.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button8:
                    Button8.setBackgroundResource(R.drawable.buttonstate3);
                    break;
                case R.id.button9:
                    Button9.setBackgroundResource(R.drawable.buttonstate3);
                    break;
            }
        }
    };
}