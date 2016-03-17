package itu.msec.sensorserviceapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

/**
 * Created by martinosecchi on 17/03/16.
 */
public class PressureMonitor extends ContextMonitor {

    float value; // Atmospheric pressure in hPa (millibar)

    public PressureMonitor(){
        setId();
    }

    public PressureMonitor(Sensor sensor){
        setId();
        if (sensor.getType() == Sensor.TYPE_PRESSURE)
            setSensor(sensor);
    }

    public PressureMonitor(Sensor sensor, String type){
        setId();
        setType(type);
        if (sensor.getType() == Sensor.TYPE_PRESSURE)
            setSensor(sensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        value = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public String toString(){
        return  super.toString() + "value: " + value;
    }
}
