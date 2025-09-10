package principal_danielcosta.prova3.frontend;
/**
 * author Daniel Costa
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import principal_danielcosta.prova3.backend.MinaEncontradaException;
import principal_danielcosta.prova3.backend.Tabuleiro;

public class JogoGUI extends JFrame {

    private JToggleButton[][] botoes;
    private JLabel passos;
    private JButton resetBotao;
    private Tabuleiro tabuleiro; 
    
    public JogoGUI() {
        setTitle("JOGO DOS PASSOS (POR DANIEL COSTA)"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null); 

        tabuleiro = new Tabuleiro();
       
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel gridPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        botoes = new JToggleButton[4][3];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                JToggleButton button = new JToggleButton("O"); 
                button.setFont(new Font("Arial", Font.BOLD, 36)); 
                button.setPreferredSize(new Dimension(80, 80));
                button.setFocusPainted(false);
                button.setBackground(Color.LIGHT_GRAY); 

                final int linha = i; 
                final int coluna = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       lideBotaoClicado(linha, coluna);
                    }
                });
                botoes[i][j] = button;
                gridPanel.add(button);
            }
        }
        mainPanel.add(gridPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        resetBotao = new JButton("Reiniciar"); 
        resetBotao.setFont(new Font("Arial", Font.PLAIN, 18));
        resetBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetJogo();
            }
        });
        southPanel.add(resetBotao);

        passos = new JLabel("Voce andou 0 passos");
        passos.setFont(new Font("Arial", Font.PLAIN, 18));
        southPanel.add(passos);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void lideBotaoClicado(int row, int col) {
        JToggleButton clickedButton = botoes[row][col];

        if (!clickedButton.isEnabled()) {
            return;
        }

        try {
            tabuleiro.jogue(row, col); 
            passos.setText("Voce andou " + tabuleiro.getPassosTomados() + " passos"); 
            clickedButton.setEnabled(false); 
            clickedButton.setSelected(true); 
            clickedButton.setText("");
            clickedButton.setBackground(new Color(200, 255, 200));

            if (tabuleiro.ganhou()) {
                JOptionPane.showMessageDialog(this, "Parabens Padawan, deu 6 passos e ganhou o jogo!", "Vitoria!", JOptionPane.INFORMATION_MESSAGE);
                desativeTodosBotoes();
            }

        } catch (MinaEncontradaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fim de Jogo", JOptionPane.ERROR_MESSAGE);
            clickedButton.setText("X"); 
            clickedButton.setBackground(new Color(255, 150, 150)); 
            desativeTodosBotoes(); 
            reveleMinas(); 
        }
    }

    private void resetJogo() {
        tabuleiro.reset(); 
        passos.setText("Voce andou 0 passos");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setEnabled(true);
                botoes[i][j].setSelected(false);
                botoes[i][j].setText("O");
                botoes[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    private void desativeTodosBotoes() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setEnabled(false);
            }
        }
    }

    private void reveleMinas() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (botoes[i][j].isEnabled() && !botoes[i][j].isSelected()) { 
                    botoes[i][j].setText("");
                    botoes[i][j].setBackground(new Color(220, 220, 220));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JogoGUI();
            }
        });
    }
}
