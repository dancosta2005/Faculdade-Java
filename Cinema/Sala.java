package principaldaniel.cinema;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Sala{
    private int numero;
    private int capacidade; 
    private HashMap<String, Bilhete> assento;

    public Sala(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.assento = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public HashMap<String, Bilhete> getAssento() {
        return assento;
    }

    public void setAssento(HashMap<String, Bilhete> assento) {
        this.assento = assento;
    }
    
    public int getAssentosVendidos(){
        return assento.size();
    }
    
    public boolean cabenaSala(int quantidade){
        return capacidade - assento.size() >= quantidade;
    }
    
    public void ocuparAssento(String assentos, Bilhete bilhete){
        assento.put(assentos, bilhete);
    }

}