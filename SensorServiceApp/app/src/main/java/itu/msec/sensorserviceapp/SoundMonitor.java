package itu.msec.sensorserviceapp;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

/**
 * Created by martinosecchi on 17/03/16.
 */
public class SoundMonitor {

    private MediaRecorder mRecorder = null;

    public void start(){
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.set
    }
}
