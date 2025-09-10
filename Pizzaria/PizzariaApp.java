package principal_danielcosta.pizzaria;
/**
 *
 * @author Daniel Costa, Gabriel Massenssini, Iury Simon, Rafael Eustáquio
 */
import javax.swing.*;
import java.awt.*;

public class PizzariaApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Minha Pizzaria");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(850, 600);
                frame.setLocationRelativeTo(null);

                PizzaPainel pizzaPanel = new PizzaPainel();
                frame.add(pizzaPanel);

                frame.setVisible(true);
            }
        });
    }
}
