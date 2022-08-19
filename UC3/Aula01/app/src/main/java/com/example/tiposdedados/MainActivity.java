package com.example.tiposdedados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText nome = findViewById(R.id.nome);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView resultado = findViewById(R.id.resultado);
                String nome1 = nome.getText().toString();
                resultado.setText("Olá " + nome1 + " Seja bem vindo!");
            }
        });

    }
}