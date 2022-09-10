package com.example.sqlitepoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CLIENTE = "bd_clientes";
    private static final String TABELA_CLIENTE = "tb_clientes";

    private static final String COLUNA_CODIGO = "codigo";
    private static final String COLUNA_NOME = "nome";
    private static final String COLUNA_TELEFONE = "telefone";
    private static final String COLUNA_EMAIL = "email";
    private static Cliente cliente;


    public BancoDados(@Nullable Context context) {
        super(context, BANCO_CLIENTE, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_COLUNA = "CREATE TABLE " + TABELA_CLIENTE + "("
                + COLUNA_CODIGO + " INTEGER PRIMARY KEY, " + COLUNA_NOME + " TEXT, " +
                COLUNA_TELEFONE + " TEXT ," + COLUNA_EMAIL + " TEXT)";
        db.execSQL(QUERY_COLUNA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*CRUD ABAIXO*/

    public void addCliente(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUNA_NOME, cliente.getNome());
        values.put(COLUNA_TELEFONE, cliente.getTelefone());
        values.put(COLUNA_EMAIL, cliente.getEmail());

        db.insert(TABELA_CLIENTE, null, values);
        db.close();
    }

    public void apagarCliente(Cliente cliente) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            db.delete(TABELA_CLIENTE, COLUNA_CODIGO + " = ?", new String[]{String.valueOf(cliente.getCodigo())});
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente selecionarCliente(int codigo) {
        try {
            SQLiteDatabase db = this.getReadableDatabase(); //ler database

            Cursor cursor = db.query(TABELA_CLIENTE, new String[]{COLUNA_CODIGO, COLUNA_NOME,
                            COLUNA_TELEFONE, COLUNA_EMAIL}, COLUNA_CODIGO + " = ?",
                    new String[]{String.valueOf(codigo)}, null, null, null, null);

            if (cursor != null) {
                cursor.moveToNext();
            }

            cliente = new Cliente(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                    cursor.getString(2), cursor.getString(3));
            db.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return cliente;
    }

    public void atualizaCliente(Cliente cliente) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(COLUNA_NOME, cliente.getNome());
            values.put(COLUNA_TELEFONE, cliente.getTelefone());
            values.put(COLUNA_EMAIL, cliente.getEmail());

            db.update(TABELA_CLIENTE, values, COLUNA_CODIGO + " = ?",
                    new String[]{String.valueOf(cliente.getCodigo())}); //atualizando a tabela

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listaTodosClientes() {
        List<Cliente> listaClientes = new ArrayList<Cliente>();

        try {
            String query = "SELECT * FROM " + TABELA_CLIENTE;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(Integer.parseInt(cursor.getString(0)));
                    cliente.setNome(cursor.getString(1));
                    cliente.setTelefone(cursor.getString(2));
                    cliente.setEmail(cursor.getString(3));

                    listaClientes.add(cliente);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;


    }
}
