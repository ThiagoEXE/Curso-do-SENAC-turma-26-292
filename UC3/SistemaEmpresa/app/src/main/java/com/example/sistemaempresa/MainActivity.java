package com.example.sistemaempresa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.saida);

        //Pessoa pessoa = new Pessoa();
       // pessoa.setNome("Thiago");


        Funcionario funcionario = new Funcionario("Thiago", 26,"Rua das Araras 2002" );
        textView.setText("Nome: " + funcionario.getNome() + "\n" + "Idade: " + funcionario.getIdade()+ "\n" + "Endereço: " + funcionario.getEndereco());

    }
}