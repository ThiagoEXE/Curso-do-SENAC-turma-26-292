package com.example.sistemaempresa;

public class Funcionario extends Pessoa{

    private int id = 100942596;
    private String cargos;

    public Funcionario(){
    }
    public Funcionario(String nome, int idade, String endereco){
        super(nome, idade, endereco);
    }

    public Funcionario(String nome, int idade){
        super(nome, idade);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }


}
