package principal_danielcosta.pizzaria;
/**
 *
 * @author Daniel Costa, Gabriel Massenssini, Iury Simon, Rafael Eustáquio
 */
import java.util.HashMap;
import java.util.Map;

public class Pizza{
    private String massa;
    private Map<String, Double> ingredientesSelecionados;
    private static final double PRECO_BASE_MASSA = 15.00;
    private static final Map<String, Double> PRECOS_INGREDIENTES;

    static{
        PRECOS_INGREDIENTES = new HashMap<>();
        PRECOS_INGREDIENTES.put("Queijo", 3.00);
        PRECOS_INGREDIENTES.put("Pepperoni", 5.00);
        PRECOS_INGREDIENTES.put("Calabresa", 4.00);
        PRECOS_INGREDIENTES.put("Cebola", 1.50);
        PRECOS_INGREDIENTES.put("Tomate", 1.00);
        PRECOS_INGREDIENTES.put("Azeitona", 2.00);
        PRECOS_INGREDIENTES.put("Champignon", 3.50);
    }

    public Pizza(String massa) {
        this.massa = massa;
        this.ingredientesSelecionados = new HashMap<>();
    }

    public void adicionarIngrediente(String ingrediente) {
        if (PRECOS_INGREDIENTES.containsKey(ingrediente)) {
            ingredientesSelecionados.put(ingrediente, PRECOS_INGREDIENTES.get(ingrediente));
        }
    }

    public void removerIngrediente(String ingrediente) {
        ingredientesSelecionados.remove(ingrediente);
    }

    public double calcularPrecoTotal() {
        double precoTotal = PRECO_BASE_MASSA;
        for (double precoIngrediente : ingredientesSelecionados.values()) {
            precoTotal += precoIngrediente;
        }
        return precoTotal;
    }

    public String getMassa() {
        return massa;
    }

    public Map<String, Double> getIngredientesSelecionados() {
        return ingredientesSelecionados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pizza Personalizada (Massa: " + massa + ")");
        if (!ingredientesSelecionados.isEmpty()) {
            sb.append(", Ingredientes: ");
            ingredientesSelecionados.keySet().forEach(ing -> sb.append(ing).append(", "));
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
