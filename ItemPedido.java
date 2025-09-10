package principal_danielcosta.pizzaria;
/**
 *
 * @author Daniel Costa, Gabriel Massenssini, Iury Simon, Rafael Eustáquio
 */
public class ItemPedido {
    private String descricao;
    private double preco;
    private int quantidade;

    public ItemPedido(String descricao, double preco, int quantidade) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotalItem() {
        return preco * quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s (x%d) - R$ %.2f", descricao, quantidade, getTotalItem());
    }
}
