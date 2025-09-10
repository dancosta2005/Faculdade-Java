package principal_danielcosta.espaco2d;

public class Circulo extends Forma{
    
    public Circulo(Ponto2D[] pontos){
        super(2);
        setPontos(pontos);
    }

    @Override
    public double calcularArea() {
        double area = 0;
        area = (Math.PI * Math.pow(getPontos()[0].calcularDistancia(getPontos()[1]), 2));
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = 0;
        perimetro = ((2 * Math.PI * getPontos()[0].calcularDistancia(getPontos()[1])));
        return perimetro;
    }
    
    
}
