package principal_danielcosta.espaco2d;
import java.util.ArrayList;

public class Espaco2D {
    private ArrayList<Forma> formas;

    public Espaco2D() {
        this.formas = new ArrayList<>();
    }
    
    public boolean adicionarForma(Forma forma){
        return formas.add(forma);
    }
    
    
}
