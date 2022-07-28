package com.example.aula07;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView AZ, az, numero, novechar;
    Button entrar;
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AZ.findViewById(R.id.AZ);
        az.findViewById(R.id.az);
        numero.findViewById(R.id.numero);
        novechar.findViewById(R.id.novechar);

        senha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String senhaDigitada = senha.getText().toString();
                validar(senhaDigitada);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void validar(String senhaDigitada){
        Pattern maiuscula = Pattern.compile("[A-Z]");
        Pattern minuscula = Pattern.compile("[a-z]");
        Pattern digitos = Pattern.compile("[0-9]");

        if(!maiuscula.matcher(senhaDigitada).find()){
           AZ.setTextColor(Color.RED);
        }else{
            AZ.setTextColor(Color.GREEN);
        }
        if(!minuscula.matcher(senhaDigitada).find()){
            az.setTextColor(Color.RED);
        }else{
            az.setTextColor(Color.GREEN);
        }if(!digitos.matcher(senhaDigitada).find()){
            numero.setTextColor(Color.RED);
        }else{
            numero.setTextColor(Color.GREEN);
        }if (senha.length() < 9){
            novechar.setTextColor(Color.GREEN);
        }
    }
}