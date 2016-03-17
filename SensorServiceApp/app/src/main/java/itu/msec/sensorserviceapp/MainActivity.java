package itu.msec.sensorserviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("--------", "WTF");
        startService(new Intent(this, ContextService.class));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        stopService(new Intent(this, ContextService.class));
    }
}
