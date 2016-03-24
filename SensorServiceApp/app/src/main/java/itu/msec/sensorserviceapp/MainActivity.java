package itu.msec.sensorserviceapp;

import android.content.Intent;
import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(this, ContextService.class));
        startActivity(new Intent(this, AudioRecActivity.class));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        stopService(new Intent(this, ContextService.class));
    }
}
