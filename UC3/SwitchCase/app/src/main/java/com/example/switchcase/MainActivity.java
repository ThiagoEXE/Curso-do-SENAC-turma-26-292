package com.example.switchcase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button op1, op2, op3 ,op4, enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        op1 = findViewById(R.id.button);
        op2 = findViewById(R.id.button2);
        op3 = findViewById(R.id.button3);
        op4 = findViewById(R.id.button4);
        textView = findViewById(R.id.textView);
        enviar = findViewById(R.id.enviar);



        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (enviar.){
                    case op1:
                        textView.setText("Opção 1 escolhida");
                        break;
                    case op2:
                        textView.setText("Opção 2 escolhida");
                        break;
                    case op3:
                        textView.setText("Opção 3 escolhida");
                        break;
                    case op4:
                        textView.setText("Opção 4 escolhida");
                        break;
                }

            }
        });




    }
}