package garagemvizinho;

import android.util.Log;
import android.widget.TextView;

import garagem.Carro;

public class BrasiliaAmarela extends Carro{
    private float num1;
    private float num2;
    private float resultado;

    public float getResultado() {
        return resultado;
    }



    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public BrasiliaAmarela(String cor, String modelo, double preco){
      super(cor,modelo,preco);
        this.toString();

    }

    public float soma(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
        this.resultado = this.num1+this.num2;
        return resultado;
    }
}
