package com.example.aula08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    Button btn;
//    EditText data, cep, endereco;
//    TextView saida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText data = findViewById(R.id.data);
        EditText cep = findViewById(R.id.cep);
        EditText endereco = findViewById(R.id.endereco);

        TextView saida = findViewById(R.id.saida);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btn){
                    String data1 = data.getText().toString().trim();
                    String cep1 = cep.getText().toString().trim();
                    String endereco1 = endereco.getText().toString().trim();

                    boolean cadastro = false;
                    if(TextUtils.isEmpty(data1)){
                        data.setError("Digite uma data válida!");
                    }
                    if(TextUtils.isEmpty(cep1)){
                        cep.setError("Digite um CEP");
                    }
                    if(TextUtils.isEmpty(endereco1)){
                        endereco.setError("Digite um endereço!");
                    }
                    if(!cadastro){
                        StringBuilder sb = new StringBuilder();
                        sb.append("Cep: " + cep1 + "\n")
                                .append("Endereço: " + endereco1 + "\n")
                                .append("Data de Nascimento:" + data1 + "\n");
                        saida.setText(sb.toString().trim());
                    }
                }
            }
        });
    }
}