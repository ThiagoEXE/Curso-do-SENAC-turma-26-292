
package com.example.aula02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt1 = (Button) findViewById(R.id.btn);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView edit = (TextView) findViewById(R.id.textview);
                final EditText txtNome = (EditText) findViewById(R.id.texto);
                String nome = txtNome.getText().toString();
                edit.setText("Olá mundo." + nome + " Tudo bem?");
            }
        });
    }
}