package principaldaniel.leilao;

import java.util.ArrayList;
import java.util.List;

public class Lote {
    private List<Produto> produtos;

    public Lote() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Lote:\n");
        for (Produto p : produtos) {
            sb.append("  ").append(p).append("\n");
        }
        return sb.toString();
    }
}
