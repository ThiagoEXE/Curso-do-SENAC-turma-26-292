package com.example.voicerecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.PlaybackParams;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
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
        getSupportActionBar().hide();

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
                                path = getRecordingFilePath();
                                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                                try {
                                    mediaRecorder.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                mediaRecorder.start();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ivSimpleBg.setVisibility(View.VISIBLE);
                                        tvRecordingPath.setText(getRecordingFilePath());
                                        playAbleSeconds = 0;
                                        seconds = 0;
                                        dummySecond = 0;
                                        ibRecord.setImageDrawable(ContextCompat.getDrawable(MainActivity.this
                                        , R.drawable.ic_baseline_keyboard_voice_24));
                                        runTimer();
                                    }
                                });
                            }
                        });
                    }else{
                        executorService.execute(new Runnable() {
                            @Override
                            public void run() {
                                mediaRecorder.stop();
                                mediaRecorder.release();
                                mediaRecorder=null;
                                playAbleSeconds=seconds;
                                dummySecond=seconds;
                                seconds =0;
                                isRecording=false;


                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        ivSimpleBg.setVisibility(View.VISIBLE);
                                        handler.removeCallbacksAndMessages(null);
                                        ibRecord.setImageDrawable(ContextCompat.getDrawable(MainActivity.this
                                                , R.drawable.desativado));


                                    }
                                });
                            }
                        });
                    }
                }else{
                    requestRecordingPermission();
                }
            }
        });

        ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPlaying = true;
                if(isPlaying){
                    if(path !=null){
                        try {
                            mediaPlayer.setDataSource(getRecordingFilePath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Sem Gravação", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.start();

                    isPlaying=true;
                    ibPlay.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_baseline_pause_circle_outline_24));
                    runTimer();
                }
                else{
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer=null;
                    mediaPlayer= new MediaPlayer();
                    isPlaying=false;
                    seconds=0;
                    handler.removeCallbacksAndMessages(null);
                    ibPlay.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_baseline_play_circle_filled_24));


                }
            }
        });

    }

    private void runTimer(){
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int minutes=(seconds%3600)/60;
                int secs= seconds%60;
                String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, secs);
                tvTime.setText(time);

                if(isRecording || (isPlaying && playAbleSeconds != -1)){
                    seconds++;
                    playAbleSeconds--;

                    if(playAbleSeconds == -1 && isPlaying){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer=null;
                        mediaPlayer = new MediaPlayer();
                        playAbleSeconds=dummySecond;
                        seconds=0;
                        handler.removeCallbacksAndMessages(null);
                        ibPlay.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_baseline_play_circle_filled_24));
                        return;
                    }
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
    private void requestRecordingPermission(){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO},REQUEST_AUDIO_PERMISSION_CODE);
    }
    public boolean checkRecordingPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)== PackageManager.PERMISSION_DENIED)
        {
            requestRecordingPermission();
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_AUDIO_PERMISSION_CODE){
            if(grantResults.length>0){
                boolean permissionToRecord = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                if(permissionToRecord){
                    Toast.makeText(getApplicationContext(), "Permissão consedida", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Permissão negada", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private String getRecordingFilePath(){
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File music = contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file = new File(music, "testFile" + "mp3");
        return file.getPath();
    }
}