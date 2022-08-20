package com.example.switchcase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView saida;
    RadioButton rb1, rb2, rb3 ,rb4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4= findViewById(R.id.rb4);
        saida = findViewById(R.id.saida);

        rb1.setOnClickListener(new Click());
        rb2.setOnClickListener(new Click());
        rb3.setOnClickListener(new Click());
        rb4.setOnClickListener(new Click());
    }
    public class Click implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.rb1:
                    saida.setText("Opção 1 escolhida");
                    break;
                case R.id.rb2:
                    saida.setText("Opção 2 escolhida");
                    break;
                case R.id.rb3:
                    saida.setText("Opção 3 escolhida");
                    break;
                case R.id.rb4:
                    saida.setText("Opção 4 escolhida");
                    break;
            }
        }
    }
}