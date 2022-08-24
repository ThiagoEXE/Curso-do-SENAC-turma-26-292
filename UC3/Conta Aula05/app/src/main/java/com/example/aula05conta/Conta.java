package com.example.aula05conta;

import android.util.Log;

public class Conta {

    private int numero;
    private double saldo = 1000;
    private double limite = 700;
    private static int totalContas;

    public static int getTotalContas() {
        return Conta.totalContas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return this.saldo + this.limite;
    }


    public void depositar(double valor) {
        if(valor > 0){
            this.saldo += valor;
        }else
            Log.i("erro", " AÇAO NEGADA --> saldo atual: " + this.saldo);
    }
    public void sacar(double valor){
        if(valor > this.saldo){
            Log.i("erro", "Valor inferior ao saldo em conta");
        }else {
            this.saldo -= valor;
        }
    }

    public Conta(){
        Conta.totalContas += 1;

    }
}
