package principal_danielcosta;
import java.util.ArrayList;
import java.util.List;

public class CEFET_AIRBNB {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Ana", "anadoidona@gmail.com");
        Cliente c2 = new Cliente("João Banana", "joaobanana@gmail.com");
        Cliente c3 = new Cliente("Caioba", "caiobinhabirutinha@hotmail.com");
        
        Imovel imovel1 = new Imovel(1, "Casa na Praia", "Sr Epaminondas");
        Imovel imovel2 = new Imovel(2, "Apto em Paris", "Luciana");
        
        imovel1.addHospedagem(new Hospedagem(c1, 1000));
        imovel1.addHospedagem(new Hospedagem(c2, 800));
        imovel1.addHospedagem(new Hospedagem(c3, 700));
        
        imovel2.addHospedagem(new Hospedagem(c1, 4000));
        imovel2.addHospedagem(new Hospedagem(c2, 8000));
        imovel2.addHospedagem(new Hospedagem(c3, 6900));
        
        System.out.println(imovel1);
        System.out.printf("O faturamento total foi: R$ %.2f\n", imovel1.calcFaturamentoTOT());
        System.out.printf("A parcela recebida pelo proprietário foi: R$ %.2f\n", imovel1.getValorProp());
        System.out.printf("A parcela recebida pela administração foi: R$ %.2f\n", imovel1.getValorAdm());
        
        System.out.println(imovel2);
        System.out.printf("O faturamento total foi: R$ %.2f\n", imovel2.calcFaturamentoTOT());
        System.out.printf("A parcela recebida pelo proprietário foi: R$ %.2f\n", imovel2.getValorProp());
        System.out.printf("A parcela recebida pela administração foi: R$ %.2f\n", imovel2.getValorAdm());
   
    }
}
