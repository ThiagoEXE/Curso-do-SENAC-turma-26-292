package com.example.aula10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        RadioButton somar = findViewById(R.id.somar);
        RadioButton concatenar = findViewById(R.id.concatenar);
        Button btn = findViewById(R.id.btn);
        TextView resultado = findViewById(R.id.resultado);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             String valor1 = num1.getText().toString();
             String valor2 = num2.getText().toString();

             int v1 = Integer.parseInt(valor1);
             int v2 = Integer.parseInt(valor2);

             if(somar.isChecked() == true){
               int soma = v1+v2;
               //String result = String.valueOf(soma);
                 resultado.setText("A soma é : " + soma);
             }else if (concatenar.isChecked() == true){
               String concatenacao = valor1+valor2;
                 resultado.setText(concatenacao);
             }
            }
        });

    }
}