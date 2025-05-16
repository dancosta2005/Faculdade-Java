package principaldaniel.cinema;

public class Bilhete {
    private double valor;

    public Bilhete(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String toString(){
        return "O valor e: RS " + valor;
    } 
}

    
