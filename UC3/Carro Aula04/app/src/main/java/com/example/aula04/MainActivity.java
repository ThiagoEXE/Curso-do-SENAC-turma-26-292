package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import garagem.Carro;
import garagem.Fusca;
import garagemvizinho.BrasiliaAmarela;

public class MainActivity extends AppCompatActivity {
    EditText modelo, valor;
    TextView saida;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        saida = findViewById(R.id.saida);
        modelo = findViewById(R.id.modelo);
        valor = findViewById(R.id.valor);

        Carro carro = new Carro();

        BrasiliaAmarela brasiliaAmarela = new BrasiliaAmarela("ddd","sss",52155);
        saida.setText(String.valueOf(brasiliaAmarela.soma(14,15)));



//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            String modelo1 = modelo.getText().toString();
//            double preco = Double.parseDouble(valor.getText().toString());
////
////            carro.setModelo(modelo1);
////            carro.setPreco(preco);
//                Carro carro2 = new Carro(modelo1, preco);
//                 saida.setText( "Modelo: " +carro2.getModelo() +"\n"+ "Preço: " + carro2.getPreco() +
//                         "\n" +"Cor:"+ carro2.getCor());
//            }
//        });

        //saida.setText(carro.getModelo() + carro.getCor() + carro.getPreco());
//
//
//        Carro civicPreto = new Carro("Novo Civic", 40000);
//        Carro golf = new Carro("Prata", "Golf",3800);
//
//
//        saida.setText("Cor do veículo: " + civicPreto.getCor() +""+ civicPreto.getModelo() + civicPreto.getPreco() +"\n" +
//                "Cor do veículo: " + golf.getCor() +""+ golf.getModelo() + golf.getPreco());





//
    }
}