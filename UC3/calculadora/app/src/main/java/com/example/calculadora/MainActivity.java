package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button soma, divide, multiplica, subtrai, compara;
    EditText valor1;
    EditText valor2;
    TextView saida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soma = findViewById(R.id.soma);
        divide = findViewById(R.id.divide);
        subtrai = findViewById(R.id.subtrai);
        multiplica = findViewById(R.id.multiplica);
        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        saida = findViewById(R.id.saida);
        compara = findViewById(R.id.compara);

        compara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome1 = (valor1.getText().toString());
                String nome2 = (valor2.getText().toString());
                if (nome1.equals(nome2)) {
                    saida.setText("O nome: " + nome1.toUpperCase(Locale.ROOT) + " é igual ao nome: " + nome2.toUpperCase(Locale.ROOT));
                }else{
                    saida.setText("O nome: " + nome1.toUpperCase(Locale.ROOT) + " é diferente do nome: " + nome2.toUpperCase(Locale.ROOT));
                }
            }
        });

        soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                somar();

            }
            public void somar(){

                int num1 = Integer.parseInt(valor1.getText().toString());
                int num2 = Integer.parseInt(valor2.getText().toString());
                int res = num1 + num2;
                saida.setText(String.valueOf(res));
            }

        });

        subtrai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtrair();
            }
            public void subtrair(){

                int num1 = Integer.parseInt(valor1.getText().toString());
                int num2 = Integer.parseInt(valor2.getText().toString());
                int res = num1 - num2;
                saida.setText(String.valueOf(res));
            }
        });

        multiplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplicar();
            }
            public void multiplicar(){

                int num1 = Integer.parseInt(valor1.getText().toString());
                int num2 = Integer.parseInt(valor2.getText().toString());
                int res = num1 * num2;
                saida.setText(String.valueOf(res));
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dividir();
            }
            public void dividir(){

                double num1 = Double.parseDouble(valor1.getText().toString());
                double num2 = Double.parseDouble(valor2.getText().toString());
                double res = num1 / num2;
                //saida.setText(String.valueOf(res));

                //operador ternário
//                String s = (res<10)? "O valor é menor que 10" : "O valor é maior ou igual a 10";
//                saida.setText("Resultado: " + s);

                //if..else()
//                if(res > 10){
//                    saida.setText("O valor " + res + " é maior que 10");
//                }else
//                    saida.setText("O valor " + res + " é menor que 10");
//

            }
        });

    }
}