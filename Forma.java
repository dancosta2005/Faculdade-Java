package principal_danielcosta.espaco2d;

public abstract class Forma {
    private Ponto2D[] pontos;

    public Forma(int tamanho){
        this.pontos = new Ponto2D[tamanho];
    }
    
    public abstract double calcularArea();
    
    public abstract double calcularPerimetro();
    
    public static Forma gerarForma(Ponto2D[] pontos){
        int tamanho = pontos.length;
        switch (tamanho){
            case 2:
                 if(pontos[0].calcularDistancia(pontos[1]) > 0){
                     return new Circulo(pontos);
            }
            break;
                
            case 3:
                
            break;
            
            case 4:
                
            break;    
        }
        return null;    
       
    }

    public Ponto2D[] getPontos() {
        return pontos;
    }

    public void setPontos(Ponto2D[] pontos) {
        this.pontos = pontos;
    }
    
    
        
    
    
    
}
