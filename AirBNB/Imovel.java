package principal_danielcosta;
import java.util.List;
import java.util.ArrayList;

public class Imovel {
    private int id;
    private String descricao;
    private String proprietario;
    private List<Hospedagem> hospedagens;
    
    public Imovel(int id, String descricao, String proprietario){
        this.id = id;
        this.descricao = descricao;
        this.proprietario = proprietario;
        this.hospedagens = new ArrayList<>();
    }
    
        public void addHospedagem(Hospedagem h){
            hospedagens.add(h);
        }
        
        public double calcFaturamentoTOT(){
            double total = 0;
            for (Hospedagem h : hospedagens){
                total =+ h.getValor();
            }
        return total;
        }
        
        public double getValorAdm(){
            return calcFaturamentoTOT() * 0.3;
        }
        
        public double getValorProp(){
            return calcFaturamentoTOT() * 0.7;
        }
        
        public String toString(){
            return descricao + "\n" + "- Proprietário:" + proprietario;
        }
}

    
