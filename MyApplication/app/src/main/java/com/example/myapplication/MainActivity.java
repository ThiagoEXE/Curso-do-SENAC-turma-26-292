package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView saida;
    Button soma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soma = findViewById(R.id.soma);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        saida = findViewById(R.id.saida);

        Calculo calculo = new Calculo();
        soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double val1 = Double.parseDouble(num1.getText().toString());
                double val2 = Double.parseDouble(num2.getText().toString());
                saida.setText(String.valueOf(calculo.somar(val1,val2)));

            }

        });


    }
}