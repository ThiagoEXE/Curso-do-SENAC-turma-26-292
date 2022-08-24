package com.example.aula05conta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView saida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saida = findViewById(R.id.saida);

        Conta minhaConta = new Conta();
        //minhaConta.sacar(5000);
        minhaConta.depositar(200);
        saida.setText("Saldo atual: "+minhaConta.getSaldo());
        minhaConta.getTotalContas();
        Conta.getTotalContas();

    }
}