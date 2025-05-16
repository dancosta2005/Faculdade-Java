package principaldaniel.cinema;

public class Filme {
    private String titulo;
    private String genero;
    private String diretor;
    private int ano;
    private Sala sala;

    public Filme(String titulo, String genero, String diretor, int ano, Sala sala) {
        this.titulo = titulo;
        this.genero = genero;
        this.diretor = diretor;
        this.ano = ano;
        this.sala = sala;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    public String toString(){
        return "Titulo do filme " + titulo + "\nGenero: " + genero + "\nDiretor" + diretor + "\nAno de lancamento: " + ano + "\nSala de exibicao: " + sala.getNumero();  
    }
}
