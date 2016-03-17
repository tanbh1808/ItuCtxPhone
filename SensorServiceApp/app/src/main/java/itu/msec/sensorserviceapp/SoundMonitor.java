package itu.msec.sensorserviceapp;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by martinosecchi on 17/03/16.
 */
public class SoundMonitor {

    private MediaRecorder mRecorder = null;
    private File temp;
    private int failCount = 0;

    public SoundMonitor(File cacheDir){
        temp = cacheDir;
    }

    public double getSound(){
        double sample = 0;
        start();
        sample = getAmplitude();
        stop();

        return sample;
    }

    private void start(){
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        mRecorder.setOutputFile(temp.getAbsolutePath());
        try {
            mRecorder.prepare();
        }catch (IOException exn){
            failCount++;
            if (failCount<5){

            }
            Log.i("Sound Monitor" ,"failed to prepare audio recorder");
        }
        failCount=0;
        mRecorder.start();
    }

    private void stop() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
            temp.delete();
        }
    }

    private void restart(){
        stop();
        start();
    }

    private double getAmplitude() {
        if (mRecorder != null)
            return mRecorder.getMaxAmplitude();
        else
            return 0;
    }
}
