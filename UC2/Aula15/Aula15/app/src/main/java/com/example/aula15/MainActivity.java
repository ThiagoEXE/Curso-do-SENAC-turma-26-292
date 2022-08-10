package com.example.aula15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prog();
    }

    private void prog() {

        progressBar = findViewById(R.id.progressBar);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {

                contador++;
                progressBar.setProgress(contador);

                if(contador == 100){
                    timer.cancel();
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }
        };
        Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show();
        timer.schedule(timerTask, 0, 100);

    }
}