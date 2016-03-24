package itu.msec.sensorserviceapp;

import android.media.MediaRecorder;
import android.util.Log;

import java.io.File;
import java.io.IOException;

/**
 * Created by martinosecchi on 17/03/16.
 */
public class SoundMonitor {

    private MediaRecorder mRecorder = null;
    private String fileName;

    public SoundMonitor(File directory){
        fileName = directory.getAbsolutePath() + "/tempaudiorec.3gp";
    }

    public double getSound(){
        start();
        double sample = getAmplitude();
        stop();
        return sample;
    }

    private void start(){
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(fileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mRecorder.prepare();
        }catch (IOException exn){
            Log.i("Sound Monitor" ,"failed to prepare audio recorder");
        }
        mRecorder.start();
    }

    private void stop() {
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
            File file = new File(fileName);
            boolean deleted = file.delete();
            Log.i("Sound Monitor", "file is deleted: " + deleted);
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
