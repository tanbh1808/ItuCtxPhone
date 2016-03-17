package itu.msec.sensorserviceapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SensorManager mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor pressSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);

        PressureMonitor example = new PressureMonitor( pressSensor, "Pressure" );

        Log.i("test", example.toString());
    }
}
