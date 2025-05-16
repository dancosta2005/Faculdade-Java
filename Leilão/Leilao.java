package principaldaniel.leilao;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
    private List<Lote> lotes;

    public Leilao() {
        this.lotes = new ArrayList<>();
    }

    public void adicionarLote(Lote lote) {
        lotes.add(lote);
    }

    public void listarProdutos() {
        for (int i = 0; i < lotes.size(); i++) {
            System.out.println("Lote " + (i + 1) + ":");
            for (Produto p : lotes.get(i).getProdutos()) {
                System.out.println("  " + p);
            }
        }
    }

    public boolean fazerLance(int loteIndex, int produtoIndex, Lance lance) {
        try {
            Produto produto = lotes.get(loteIndex).getProdutos().get(produtoIndex);
            return produto.receberLance(lance);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public void encerrarLeilao() {
        System.out.println("Leilão encerrado. Vendas realizadas:");
        for (Lote lote : lotes) {
            for (Produto produto : lote.getProdutos()) {
                produto.encerrar();
                if (produto.getMaiorLance() != null) {
                    System.out.println(produto.getDescricao() + " - Vendido para " +
                        produto.getMaiorLance().getPessoa().getNome() +
                        " por R$ " + produto.getMaiorLance().getValor());
                } else {
                    System.out.println(produto.getDescricao() + " - Não vendido");
                }
            }
        }
    }
}
