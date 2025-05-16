package principaldaniel.leilao;

public class Pessoa {
    private String nome;
    private String contato;

    public Pessoa(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    @Override
    public String toString() {
        return nome + " (" + contato + ")";
    }
}
