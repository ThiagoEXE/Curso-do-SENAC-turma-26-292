package com.example.sqlitepoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editCodigo, editNome, editEmail, editTelefone;
    Button btnLimpar, btnSalvar, btnExcluir;
    ListView listViewClientes;
    BancoDados db = new BancoDados(MainActivity.this);

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;

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
        listarClientes();
        /*TESTE DO CRUD*/

        //insert
        db.addCliente(new Cliente(3, "Thiago Barbosa", "71 99351-7204", "thsmotog@gmail.com"));
        Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();
//        Cliente cliente = new Cliente();
//        cliente.setCodigo(3);
//        cliente.setNome("Marcos");
//        cliente.setEmail("thsmotog@gmail.com");
//        cliente.setTelefone("71993517204");
////        db.apagarCliente(cliente); delete
//        Toast.makeText(MainActivity.this, "Apagado com sucesso!", Toast.LENGTH_LONG).show();

        try {

//            Cliente cliente = db.selecionarCliente(3);
//
//            Log.i("Cliente Selecionado", "Código " + cliente.getCodigo() + " Nome: " + cliente.getNome()
//                    + " Telefone: " + cliente.getTelefone() + " E-mail: " + cliente.getEmail());

            //UPDATE
//            Cliente cliente = new Cliente();
//            cliente.setCodigo(3);
//            cliente.setNome("Carlos Pereira da Silva");
//            cliente.setTelefone("71 993521451");
//            cliente.setEmail("carlos@gmail.com");
//            db.atualizaCliente(cliente);
//                     Log.i("Cliente Selecionado", "Código " + cliente.getCodigo() + " Nome: " + cliente.getNome()
//                  + " Telefone: " + cliente.getTelefone() + " E-mail: " + cliente.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void listarClientes() {

        List<Cliente> clientes = db.listaTodosClientes();

        for (Cliente c : clientes) {
            Log.d("lista", "\nID: " + c.getCodigo() + " Nome: " + c.getNome());
        }
    }
}