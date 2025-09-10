package principal_danielcosta.prova3.backend;
/**
 *
 * @author Dan Costa
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Tabuleiro {
    private final int LINHAS = 4;
    private final int COLUNAS = 3;
    private final int POSICAO_TOTAL = LINHAS * COLUNAS;
    private final int N_DE_MINAS = 6; 
    private boolean[][] tabuleiro;
    private boolean[][] revelado;
    private int passosTomados;

    public Tabuleiro() {
        iniciarTabuleiro();
    }

    private void iniciarTabuleiro() {
        tabuleiro = new boolean[LINHAS][COLUNAS];
        revelado = new boolean[LINHAS][COLUNAS];
        passosTomados = 0;
        colocarMinas();
    }

    private void colocarMinas() {
        List<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < POSICAO_TOTAL; i++) {
            posicoes.add(i);
        }

        Collections.shuffle(posicoes);

        for (int i = 0; i < N_DE_MINAS; i++) {
            int pos = posicoes.get(i);
            int linha = pos / COLUNAS;
            int coluna = pos % COLUNAS;
            tabuleiro[linha][coluna] = true; 
        }
    }

    public boolean jogue(int linha, int coluna) throws MinaEncontradaException {
        if (linha < 0 || linha >= LINHAS || coluna < 0 || coluna >= COLUNAS) {
            throw new IllegalArgumentException("Coordenada do tabuleiro invalida");
        }
        if (revelado[linha][coluna]) {
            return true;
        }

        revelado[linha][coluna] = true;

        if (tabuleiro[linha][coluna]) {
            throw new MinaEncontradaException("KABOOOOOM! GAMEOVER COLEGA!"); 
        } else {
            passosTomados++; 
            return true;
        }
    }

    public int getPassosTomados() {
        return passosTomados;
    }

    public void reset() {
        iniciarTabuleiro();
    }

    public boolean ganhou() {
        return passosTomados == 6; 
    }

    public void imprimaTabuleiro() {
        System.out.println("Tabuleiro (M = Mina, O = Vazio):");
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                System.out.print((tabuleiro[i][j] ? "M" : "O") + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
}
