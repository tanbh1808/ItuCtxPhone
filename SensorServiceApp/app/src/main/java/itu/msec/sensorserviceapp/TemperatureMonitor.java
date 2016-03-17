package itu.msec.sensorserviceapp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;

/**
 * Created by martinosecchi on 17/03/16.
 */
public class TemperatureMonitor extends ContextMonitor {
    float value; // ambient temperature in degree Celsius

    public TemperatureMonitor(){
        setId();
    }

    public TemperatureMonitor(Sensor sensor){
        setId();
        if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
            setSensor(sensor);
    }

    public TemperatureMonitor(Sensor sensor, String type){
        setId();
        setType(type);
        if (sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE)
            setSensor(sensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        value = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
