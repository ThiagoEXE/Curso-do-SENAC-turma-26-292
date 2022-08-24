package com.example.aula04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import garagem.Carro;
import garagem.Fusca;
import garagemvizinho.BrasiliaAmarela;

public class MainActivity extends AppCompatActivity {

    TextView saida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saida = findViewById(R.id.saida);

//        Carro carro = new Carro("Prata", "Onix", 80000);
//
//        saida.setText(carro.getModelo() + carro.getCor() + carro.getPreco());
//
//
//        Carro civicPreto = new Carro("Novo Civic", 40000);
//        Carro golf = new Carro("Prata", "Golf",3800);
//
//
//        saida.setText("Cor do veículo: " + civicPreto.getCor() +""+ civicPreto.getModelo() + civicPreto.getPreco() +"\n" +
//                "Cor do veículo: " + golf.getCor() +""+ golf.getModelo() + golf.getPreco());





        Fusca fusca = new Fusca("Branco", "Fusca", 40000);
        BrasiliaAmarela ba = new BrasiliaAmarela("Amarela", "Brasilia", 40000);

        saida.setText(" Modelo: " + fusca.getModelo() + "\n" + "Cor do carro: " + fusca.getCor()
                + "\n" + "Preço: " + fusca.getPreco() + "\n"+ "\n"+
                " Modelo: " + ba.getModelo() + "\n" +"Cor do carro: "
                + ba.getCor() +  "\n" + "Preço: " + ba.getPreco());
    }
}