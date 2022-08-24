package garagem;



public class Carro {

    //Modificadores de acesso
    private String cor;
    private double preco;
    private String modelo;
    private Motor motor;

    public String getCor() {
        return cor;
    }

    public double getPreco() {
        return preco;
    }

    public String getModelo() {
        return modelo;
    }


    public Carro() {
    }

    public Carro(String modelo, double preco){
        this.cor = "PRETO";
        this.modelo = modelo;
        this.preco = preco;
    }

    public Carro(String cor, String modelo, double preco){
        this.cor = cor;
        this.modelo = modelo;
        this.preco = preco;
    }

    public void ligar(){
        this.motor.darPartida();
//        if(motor.darPartida() == true){
//            Log.i("motor", "ligado");
//        };
    }
}
