package principaldaniel.leilao;

public class Produto {
    private String descricao;
    private Lance maiorLance;
    private boolean vendido;

    public Produto(String descricao) {
        this.descricao = descricao;
        this.vendido = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public Lance getMaiorLance() {
        return maiorLance;
    }

    public boolean receberLance(Lance lance) {
        if (vendido) return false;
        if (maiorLance == null || lance.getValor() > maiorLance.getValor()) {
            maiorLance = lance;
            return true;
        }
        return false;
    }

    public void encerrar() {
        vendido = true;
    }

    public boolean isVendido() {
        return vendido;
    }

    @Override
    public String toString() {
        return descricao + (maiorLance != null ? " - Maior lance: " + maiorLance : " - Sem lances");
    }
}
