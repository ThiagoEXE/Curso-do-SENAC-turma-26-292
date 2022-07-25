package com.example.aula03;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img = (ImageView) findViewById(R.id.img01);
        Button btn = (Button)findViewById(R.id.btn);

        while(true){btn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                img.setImageResource(R.drawable.android);
            }

        });
        }
    }
}