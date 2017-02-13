package application.my.bluetoothristinolla2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by jarno on 6.2.2017.
 */

public class GameActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

    }
    protected void endGame(View v){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}