package com.example.atividaderadiobtn;

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

        EditText idade  = findViewById(R.id.idade);
        EditText nome = findViewById(R.id.nome);
        //RadioButton masculino = findViewById(R.id.masculino);
       // RadioButton feminino = findViewById(R.id.feminino);
        Button btn = findViewById(R.id.btn);
        TextView textView2 = findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pessoa = nome.getText().toString();
                String valor = idade.getText().toString();
                int id = Integer.valueOf(valor);
                if (id < 18){
                   textView2.setText("Olá " + pessoa + " você tem " + id + " anos, NÃO PODE ENTRAR, FESTA PARA MAIORES DE IDADE!" );
                }else{
                    textView2.setText("Olá " + pessoa + " você tem " + id + " anos, PODE PASSAR, BOA FESTA!");
                }
            }
        });

    }
}