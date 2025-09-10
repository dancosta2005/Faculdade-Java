package principal_danielcosta;

public class Hospedagem {
    private Cliente cliente;
    private double valor;


    public Hospedagem(Cliente cliente, double valor){
        this.cliente = cliente;
        this.valor =  valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String toString(){
        return "Hospedagem de:" + cliente + "\n" + "No valor de R$" + valor;
    }

}
