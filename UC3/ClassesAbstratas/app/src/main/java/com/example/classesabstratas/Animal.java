package com.example.classesabstratas;

public abstract class Animal {

    private String nome = null;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    abstract void emitirSom();
}
