package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero,numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis,
            numeroSete, numeroOito, numeroNove, ponto,soma,subtracao,multiplicacao,divisao, igual, botao_limpar;

    private ImageView backspace;
    private TextView txtExpressao, txtResultado;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        getSupportActionBar().hide();
    }

    public void iniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete  = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        divisao = findViewById(R.id.divisao);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void acrescentarUmaExpressao(String expressao, boolean limpar_dados){

        if(txtResultado.getText().equals("")){
        txtExpressao.setText(" ");
        }
        if(limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(expressao);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(expressao);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.numero_zero:
                acrescentarUmaExpressao("0", true);
                break;
            case R.id.numero_um:
                acrescentarUmaExpressao("1", true);
                break;
            case R.id.numero_dois:
                acrescentarUmaExpressao("2", true);
                break;
            case R.id.numero_tres:
                acrescentarUmaExpressao("3", true);
                break;
            case R.id.numero_quatro:
                acrescentarUmaExpressao("4", true);
                break;
            case R.id.numero_cinco:
                acrescentarUmaExpressao("5", true);
                break;
            case R.id.numero_seis:
                acrescentarUmaExpressao("6", true);
                break;
            case R.id.numero_sete:
                acrescentarUmaExpressao("7", true);
                break;
            case R.id.numero_oito:
                acrescentarUmaExpressao("8", true);
                break;
            case R.id.numero_nove:
                acrescentarUmaExpressao("9", true);
                break;
            case R.id.ponto:
                acrescentarUmaExpressao(".", true);
                break;
            case R.id.soma:
                acrescentarUmaExpressao("+", true);
                break;
            case R.id.divisao:
                acrescentarUmaExpressao("/", true);
                break;
            case R.id.subtracao:
                acrescentarUmaExpressao("-", true);
                break;
            case R.id.multiplicacao:
                acrescentarUmaExpressao("X", true);
                break;



        }
    }
}