package principal_danielcosta.pizzaria;
/**
 *
 * @author Daniel Costa
 */
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<ItemPedido> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        boolean itemExistente = false;
        for (ItemPedido i : itens) {
            if (i.getDescricao().equals(item.getDescricao()) && i.getPreco() == item.getPreco()) {
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                itemExistente = true;
                break;
            }
        }
        if (!itemExistente) {
            itens.add(item);
        }
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getTotalItem();
        }
        return total;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens);
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }
}

