package principal_danielcosta.espaco2d;

public class Quadrilatero extends Forma{
    private double lado;
    
    public Quadrilatero(Ponto2D[] pontos){
        super(4);
        this.lado = getPontos()[0].calcularDistancia(getPontos()[1]);
    }

    @Override
    public double calcularArea() {
        double area = 0;
        area = Math.pow(lado, 2);
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro = 0;
        perimetro = lado * 4;
        return perimetro;
        
    }
}
