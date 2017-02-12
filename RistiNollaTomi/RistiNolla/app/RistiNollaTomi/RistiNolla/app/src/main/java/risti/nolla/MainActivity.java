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

public class MainActivity extends AppCompatActivity
{



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void singlePlay(View v){
        Intent intent= new Intent(MainActivity.this, SingleGameActivity.class);
         startActivity(intent);

    }




    public void multiPlay(View v){
        Intent intent= new Intent(MainActivity.this, BluetoothGameActivity.class);
        startActivity(intent);

    }





}
