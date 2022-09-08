package com.example.sqlitepoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo, editNome, editEmail, editTelefone;
    Button btnLimpar, btnSalvar, btnExcluir;
    ListView listViewClientes;
    BancoDados db = new BancoDados(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCodigo = findViewById(R.id.editCodigo);
        editNome = findViewById(R.id.editNome);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editEmail);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnExcluir = findViewById(R.id.btnExcluir);
        btnSalvar = findViewById(R.id.btnSalvar);

        listViewClientes = findViewById(R.id.listviewClientes);

        /*TESTE DO CRUD*/

        db.addCliente(new Cliente("Thiago Barbosa","71 99351-7204","thsmotog@gmail.com"));
        Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();
    }
}