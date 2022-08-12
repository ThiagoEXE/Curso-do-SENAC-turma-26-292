package com.example.aula18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    private static final int REQUEST_AUDIO_PERMISSION_CODE=101;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;
    ImageView ibRecord;
    ImageView ibPlay;
    TextView tvTime;
    TextView tvRecordingPath;
    ImageView ivSimpleBg;
    boolean isRecording = false;
    boolean isPlaying = false;
    Handler handler;
    int seconds = 0;
    String path = null;
    int dummySecond = 0;
    int playAbleSeconds;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibRecord = findViewById(R.id.ib_record);
        ibPlay = findViewById(R.id.ib_play);
        tvTime = findViewById(R.id.tv_time);
        tvRecordingPath = findViewById(R.id.tv_recording_path);
        ivSimpleBg = findViewById(R.id.iv_simple_bg);
        mediaPlayer = new MediaPlayer();

        ibRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkRecordingPermission()){
                    if(!isRecording){
                        isRecording = true;
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                mediaRecorder = new MediaRecorder();
                                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                                mediaRecorder.setOutputFile(getRecordingFilePath());
                                //Paramos aqui
                                path = getRecordingFilePath();
                                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                                try {
                                    mediaRecorder.prepare();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                                mediaRecorder.start();

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tvRecordingPath.setText(getRecordingFilePath());
                                        playAbleSeconds = 0;
                                        seconds = 0;
                                        dummySecond = 0;
                                        ibRecord.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,
                                                R.drawable.gravando));
                                        runTime();
                                    }
                                });

                            }
                        });
                    } else {
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                mediaRecorder.stop();
                                mediaRecorder.release();
                                mediaRecorder = null;
                                playAbleSeconds = seconds;
                                seconds = 0;
                                isRecording = false;

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        handler.removeCallbacksAndMessages(null);
                                        ibRecord.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,
                                                R.drawable.ic_baseline_keyboard_voice_24));
                                    }
                                });
                            }
                        });
                    }
                }else{
                    requestRecordingPermission();
                }//paramos aqui
            }
        });
    }

    private String getRecordingFilePath() {
        ContextWrapper contextWrapper =new ContextWrapper(getApplicationContext());
        File music = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(music, "testFile" + "mp3");
        return file.getPath();
    }

    private void requestRecordingPermission() {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_AUDIO_PERMISSION_CODE);
    }
    private boolean checkRecordingPermission() {
      if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED){
          requestRecordingPermission();
          return false;
      }

      return true;
    }


}