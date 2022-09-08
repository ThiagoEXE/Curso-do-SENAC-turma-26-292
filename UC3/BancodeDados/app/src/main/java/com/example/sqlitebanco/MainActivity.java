package com.example.sqlitebanco;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //criando banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app",MODE_PRIVATE, null);

            //criando tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");

            //inserindo dados na tabela
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Thiago Barbosa', 26)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade)VALUES('Roberto Alves', 42)");

            //recuperar pessoas
            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas", null);

            //indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst(); //Trazer o cursor para o inicio
            while (cursor != null){
                Log.i("Resultado - NOME: ", cursor.getString(indiceNome));
                Log.i("Resultado - IDADE: ", cursor.getString(indiceIdade));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}