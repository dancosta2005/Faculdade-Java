package principal_danielcosta.pizzaria;
/**
 *
 * @author Daniel Costa, Gabriel Massenssini, Iury Simon, Rafael Eustáquio
 */
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class PizzaPainel extends JPanel {
    private Pizza pizzaAtual;
    private Carrinho carrinho;

    private JLabel precoTotalCarrinhoLabel;
    private JLabel precoPizzaPersonalizadaLabel;
    private JComboBox<String> massaComboBox;
    private Map<String, JCheckBox> ingredientesCheckBoxes;
    private JList<ItemPedido> carrinhoList;
    private DefaultListModel<ItemPedido> carrinhoListModel;

    private PizzaPronta[] pizzasProntas = {
            new PizzaPronta("Margherita", 30.00),
            new PizzaPronta("Calabresa", 35.00),
            new PizzaPronta("Frango com Catupiry", 40.00),
            new PizzaPronta("Portuguesa", 38.00)
    };

    private Bebida[] bebidas = {
            new Bebida("Coca-Cola (Lata)", 6.00),
            new Bebida("Guaraná (Lata)", 5.50),
            new Bebida("Água Mineral", 3.00),
            new Bebida("Suco de Laranja (Copo)", 8.00)
    };

    public PizzaPainel() {
        carrinho = new Carrinho();
        pizzaAtual = new Pizza("Tradicional");

        setLayout(new BorderLayout(10, 10));

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel monteSuaPizzaPanel = criarMonteSuaPizzaPanel();
        tabbedPane.addTab("Monte sua Pizza", monteSuaPizzaPanel);

        JPanel pizzasProntasPanel = criarPizzasProntasPanel();
        tabbedPane.addTab("Pizzas Prontas", pizzasProntasPanel);

        JPanel bebidasPanel = criarBebidasPanel();
        tabbedPane.addTab("Bebidas", bebidasPanel);

        add(tabbedPane, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBorder(BorderFactory.createTitledBorder("Seu Pedido"));
        rightPanel.setPreferredSize(new Dimension(250, rightPanel.getPreferredSize().height));

        carrinhoListModel = new DefaultListModel<>();
        carrinhoList = new JList<>(carrinhoListModel);
        carrinhoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        carrinhoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            }
        });
        JScrollPane scrollPane = new JScrollPane(carrinhoList);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomRightPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        precoTotalCarrinhoLabel = new JLabel("Total: R$ 0.00");
        precoTotalCarrinhoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bottomRightPanel.add(precoTotalCarrinhoLabel);

        JButton btnFazerPedido = new JButton("Fazer Pedido");
        btnFazerPedido.addActionListener(e -> {
            if (carrinho.estaVazio()) {
                JOptionPane.showMessageDialog(this, "Seu carrinho está vazio. Adicione itens antes de fazer o pedido.", "Carrinho Vazio", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        String.format("Pedido Realizado!\nTotal: R$ %.2f\nObrigado!", carrinho.calcularTotal()),
                        "Pedido Confirmado", JOptionPane.INFORMATION_MESSAGE);
                limparPedido();
            }
        });
        bottomRightPanel.add(btnFazerPedido);

        JButton btnCancelarPedido = new JButton("Cancelar Pedido");
        btnCancelarPedido.addActionListener(e -> {
            if (carrinho.estaVazio()) {
                JOptionPane.showMessageDialog(this, "Seu carrinho já está vazio.", "Carrinho Vazio", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar o pedido?", "Confirmar Cancelamento", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    limparPedido();
                    JOptionPane.showMessageDialog(this, "Pedido cancelado com sucesso!", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        bottomRightPanel.add(btnCancelarPedido);

        rightPanel.add(bottomRightPanel, BorderLayout.SOUTH);

        add(rightPanel, BorderLayout.EAST);

        atualizarCarrinhoGUI();
    }

    private JPanel criarMonteSuaPizzaPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Monte sua Pizza Personalizada"));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JLabel massaLabel = new JLabel("Massa:");
        String[] massas = {"Tradicional", "Fina", "Integral"};
        massaComboBox = new JComboBox<>(massas);
        massaComboBox.addActionListener(e -> {
            pizzaAtual = new Pizza((String) massaComboBox.getSelectedItem());
            resetIngredientesCheckBoxes();
            atualizarPrecoPizzaPersonalizada();
        });
        topPanel.add(massaLabel);
        topPanel.add(massaComboBox);
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel ingredientesPanel = new JPanel();
        ingredientesPanel.setLayout(new GridLayout(0, 2, 5, 5));
        ingredientesPanel.setBorder(BorderFactory.createTitledBorder("Escolha seus Ingredientes"));

        ingredientesCheckBoxes = new LinkedHashMap<>();
        String[] nomesIngredientes = {"Queijo", "Pepperoni", "Calabresa", "Cebola", "Tomate", "Azeitona", "Champignon"};

        for (String ingrediente : nomesIngredientes) {
            JCheckBox checkBox = new JCheckBox(ingrediente);
            checkBox.addActionListener(e -> {
                if (checkBox.isSelected()) {
                    pizzaAtual.adicionarIngrediente(ingrediente);
                } else {
                    pizzaAtual.removerIngrediente(ingrediente);
                }
                atualizarPrecoPizzaPersonalizada();
            });
            ingredientesCheckBoxes.put(ingrediente, checkBox);
            ingredientesPanel.add(checkBox);
        }
        panel.add(ingredientesPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        precoPizzaPersonalizadaLabel = new JLabel("Preço Atual: R$ 0.00");
        precoPizzaPersonalizadaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bottomPanel.add(precoPizzaPersonalizadaLabel);

        JButton btnAdicionarPizzaPersonalizada = new JButton("Adicionar ao Carrinho");
        btnAdicionarPizzaPersonalizada.addActionListener(e -> {
            if (pizzaAtual.getIngredientesSelecionados().isEmpty()) {
                int confirm = JOptionPane.showConfirmDialog(this, "Sua pizza não tem ingredientes adicionais. Deseja adicioná-la assim mesmo?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            carrinho.adicionarItem(new ItemPedido(pizzaAtual.toString(), pizzaAtual.calcularPrecoTotal(), 1));
            atualizarCarrinhoGUI();
            pizzaAtual = new Pizza((String) massaComboBox.getSelectedItem());
            resetIngredientesCheckBoxes();
            atualizarPrecoPizzaPersonalizada();
        });
        bottomPanel.add(btnAdicionarPizzaPersonalizada);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        atualizarPrecoPizzaPersonalizada();

        return panel;
    }

    private void atualizarPrecoPizzaPersonalizada() {
        precoPizzaPersonalizadaLabel.setText(String.format("Preço Atual: R$ %.2f", pizzaAtual.calcularPrecoTotal()));
    }

    private void resetIngredientesCheckBoxes() {
        for (JCheckBox checkBox : ingredientesCheckBoxes.values()) {
            checkBox.setSelected(false);
        }
    }

    private JPanel criarPizzasProntasPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Pizzas Prontas"));

        for (PizzaPronta pp : pizzasProntas) {
            JPanel pizzaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(String.format("%s - R$ %.2f", pp.getNome(), pp.getPreco()));
            JButton btnAdicionar = new JButton("Adicionar");
            btnAdicionar.addActionListener(e -> {
                carrinho.adicionarItem(new ItemPedido(pp.getNome(), pp.getPreco(), 1));
                atualizarCarrinhoGUI();
            });
            pizzaPanel.add(label);
            pizzaPanel.add(btnAdicionar);
            panel.add(pizzaPanel);
        }
        return panel;
    }

    private JPanel criarBebidasPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Bebidas"));

        for (Bebida b : bebidas) {
            JPanel bebidaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel label = new JLabel(String.format("%s - R$ %.2f", b.getNome(), b.getPreco()));
            JButton btnAdicionar = new JButton("Adicionar");
            btnAdicionar.addActionListener(e -> {
                carrinho.adicionarItem(new ItemPedido(b.getNome(), b.getPreco(), 1));
                atualizarCarrinhoGUI();
            });
            bebidaPanel.add(label);
            bebidaPanel.add(btnAdicionar);
            panel.add(bebidaPanel);
        }
        return panel;
    }

    private void atualizarCarrinhoGUI() {
        carrinhoListModel.clear();
        for (ItemPedido item : carrinho.getItens()) {
            carrinhoListModel.addElement(item);
        }
        precoTotalCarrinhoLabel.setText(String.format("Total: R$ %.2f", carrinho.calcularTotal()));
    }

    private void limparPedido() {
        carrinho.limparCarrinho();
        atualizarCarrinhoGUI();
        pizzaAtual = new Pizza((String) massaComboBox.getSelectedItem());
        resetIngredientesCheckBoxes();
        atualizarPrecoPizzaPersonalizada();
    }
}
