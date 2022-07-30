package com.example.validacaocheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView texto = findViewById(R.id.texto);
        CheckBox caixa = findViewById(R.id.caixa);
        ImageButton botao = findViewById(R.id.botao);

        caixa.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checado) {
                texto.setText(converterTexto(checado));

            }
        });

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, converterTexto(caixa.isChecked()), Toast.LENGTH_LONG).show();
            }
        });

    }
    private String converterTexto(boolean checado){
        return (checado)? "Ligado" : "Desligado";
    }

}