package itu.msec.sensorserviceapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martinosecchi on 17/03/16.
 */
public class ContextService extends Service {

    private SensorManager mSensorManager;
    private TemperatureMonitor tempMonitor;
    private PressureMonitor pressMonitor;
    private SoundMonitor soundMonitor;
    private Thread tempThread;
    private Thread pressThread;
    private Thread soundThread;

    public ContextService(){}

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor pressSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        Sensor tempSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        if (pressSensor != null) {
            pressMonitor = new PressureMonitor(pressSensor);
        } else {
            Log.i("ContextService", "NO PRESSURE SENSORS ON THIS DEVICE");
            pressMonitor = new PressureMonitor();
        }
        if (tempSensor != null) {
            tempMonitor = new TemperatureMonitor(tempSensor);
        } else {
            Log.i("ContextService", "NO TEMPERATURE SENSORS ON THIS DEVICE");
            tempMonitor = new TemperatureMonitor();
        }

        mSensorManager.registerListener( pressMonitor, pressSensor, SensorManager.SENSOR_DELAY_NORMAL );
        mSensorManager.registerListener( tempMonitor, tempSensor, SensorManager.SENSOR_DELAY_NORMAL );

        tempThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0; //for testing
                while (i<10){
                    Log.i("ContextService - TEMP" , tempMonitor.toString());
                    try {
                        Thread.sleep(5000);
                    } catch( InterruptedException exn){}
                    i++;
                }
            }
        });

        pressThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0; //for testing
                while (i<10){
                    Log.i("ContextService - PRESS" , pressMonitor.toString());
                    try {
                        Thread.sleep(5000);
                    } catch( InterruptedException exn){}
                    i++;
                }
            }
        });

        soundMonitor = new SoundMonitor( getFilesDir() );

        soundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                List samples = new ArrayList();
                for (int i = 0; i< 10; i++){
                    samples.add(soundMonitor.getSound());
                    Log.i( "ContextService - SOUND", "" + samples.get(i) );
                    try{
                        Thread.sleep(500);
                    } catch (InterruptedException exn){}
                }
            }
        });

        tempThread.start();
        pressThread.start();
        soundThread.start();

        return START_STICKY; //runs until explicitly stopped
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}