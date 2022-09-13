package com.example.sqlitepoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
//        db.addCliente(new Cliente(3, "Thiago Barbosa", "71 99351-7204", "thsmotog@gmail.com"));
//        Toast.makeText(this, "Salvo com sucesso!", Toast.LENGTH_LONG).show();
//        Cliente cliente = new Cliente();
//        cliente.setCodigo(3);
//        cliente.setNome("Marcos");
//        cliente.setEmail("thsmotog@gmail.com");
//        cliente.setTelefone("71993517204");
////        db.apagarCliente(cliente); delete
//        Toast.makeText(MainActivity.this, "Apagado com sucesso!", Toast.LENGTH_LONG).show();

//        try {

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
////                  + " Telefone: " + cliente.getTelefone() + " E-mail: " + cliente.getEmail());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = editCodigo.getText().toString();

                if(codigo.isEmpty()){
                    Toast.makeText(MainActivity.this, "Nenhum cliente está selecionado!", Toast.LENGTH_SHORT).show();
                }else{
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(Integer.parseInt(codigo));
                    db.apagarCliente(cliente);

                    Toast.makeText(MainActivity.this, "Cliente excluído com sucesso!", Toast.LENGTH_SHORT).show();
                    limparCampos();
                    listarClientes();
                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = editCodigo.getText().toString();
                String nome = editNome.getText().toString();
                String telefone = editTelefone.getText().toString();
                String email = editEmail.getText().toString();

                if(nome.isEmpty()){
                    editNome.setError("Este campo é obrigatório!");
                }else if(codigo.isEmpty()){
                    //insert
                    db.addCliente(new Cliente(nome, telefone, email));
                    Toast.makeText(MainActivity.this, "Cliente adicionado com sucesso!", Toast.LENGTH_SHORT).show();
                    limparCampos();
                    listarClientes();
                }else{
                    //update
                    db.atualizaCliente(new Cliente(nome, telefone, email));
                    Toast.makeText(MainActivity.this, "Cliente editado com sucesso!", Toast.LENGTH_SHORT).show();
                    limparCampos();
                    listarClientes();
                }


            }
        });
        listViewClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String conteudo = (String) listViewClientes.getItemAtPosition(position);
                // Toast.makeText(MainActivity.this, "Selecionado: " + conteudo, Toast.LENGTH_SHORT).show();
                String codigo = conteudo.substring(0, conteudo.indexOf("-"));
                Cliente cliente = db.selecionarCliente(Integer.parseInt(codigo));

                editCodigo.setText("" + cliente.getCodigo());
                editNome.setText(cliente.getNome());
                editTelefone.setText(cliente.getTelefone());
                editEmail.setText(cliente.getEmail());
            }
        });

    }

    public void limparCampos() {

        editCodigo.setText("");
        editNome.setText("");
        editTelefone.setText("");
        editEmail.setText("");

        editNome.requestFocus();

    }

    public void listarClientes() {

        List<Cliente> clientes = db.listaTodosClientes();

        arrayList = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        listViewClientes.setAdapter(adapter);

        for (Cliente c : clientes) {
            arrayList.add(c.getCodigo() + "-" + c.getNome());
            adapter.notifyDataSetChanged();

            // Log.d("lista", "\nID: " + c.getCodigo() + " Nome: " + c.getNome());
        }
    }

}