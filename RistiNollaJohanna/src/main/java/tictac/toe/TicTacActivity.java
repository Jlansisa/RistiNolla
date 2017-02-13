/**
 * Created by Johanna Länsisaari on 10.2.1017.
 * Updated on 12.2.2017
 */

package tictac.toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TicTacActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac);

        final Button button = (Button) findViewById(R.id.buttoni);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent gameboard = new Intent(TicTacActivity.this,GameBoardActivity.class);
                startActivity(gameboard);
            }
        });
    }
}
