package com.example.aula11activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    ImageView img;
    TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        img = findViewById(R.id.img);
        msg = findViewById(R.id.msg);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.setText("Clima frio na bahia use seu capote...");
            }
        });


    }
}