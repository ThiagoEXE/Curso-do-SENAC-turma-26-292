package com.example.classesabstratas;

import android.util.Log;

public class Papagaio extends Ave{
    private String penagem= null;
    @Override
    void emitirSom() {
        Log.i("som", "hahahahahah");
    }

    @Override
    void voar() {

    }

    public Papagaio(String nome, String penagem){
        this.setNome(nome);
        this.penagem=penagem;
    }
}
