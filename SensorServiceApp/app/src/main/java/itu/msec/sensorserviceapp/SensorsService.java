package itu.msec.sensorserviceapp;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.IBinder;

/**
 * Created by martinosecchi on 17/03/16.
 */
public class SensorsService extends Service {

    private SensorManager mSensorManager;
    private Thread t;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        return START_STICKY; //runs until explicitly stopped
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
