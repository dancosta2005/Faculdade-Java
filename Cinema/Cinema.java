package principaldaniel.cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Sala> salas = new ArrayList<>();
        ArrayList<Filme> filmes = new ArrayList<>();

        System.out.print("Informe o valor do ingresso: R$");
        double valorIngresso = scanner.nextDouble();

        Sala sala1 = new Sala(1, 5);
        Sala sala2 = new Sala(2, 3);
        salas.add(sala1);
        salas.add(sala2);

        Filme filme1 = new Filme("Matrix", "Ficção", "Wachowski", 1999,  sala1);
        Filme filme2 = new Filme("O Rei Leão", "Animação", "Roger Allers", 1994, sala2);
        filmes.add(filme1);
        filmes.add(filme2);

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Listar filmes");
            System.out.println("2. Comprar ingresso");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < filmes.size(); i++) {
                        System.out.println((i + 1) + ". " + filmes.get(i));
                    }
                    break;

                case 2:
                    System.out.print("Escolha o número do filme: ");
                    int escolha = scanner.nextInt() - 1;
                    if (escolha < 0 || escolha >= filmes.size()) {
                        System.out.println("Filme inválido.");
                        break;
                    }

                    Filme filmeEscolhido = filmes.get(escolha);
                    Sala sala = filmeEscolhido.getSala();

                    System.out.print("Quantos ingressos deseja? ");
                    int quantidade = scanner.nextInt();

                    if (!sala.cabenaSala(quantidade)) {
                        System.out.println("Assentos insuficientes.");
                        break;
                    }

                    for (int i = 0; i < quantidade; i++) {
                        String assento = "A" + (sala.getAssentosVendidos() + 1);
                        Bilhete bilhete = new Bilhete(valorIngresso);
                        sala.ocuparAssento(assento, bilhete);
                        System.out.println("Bilhete vendido: Assento " + assento + " | R$" + valorIngresso);
                    }

                    System.out.println("Total: R$" + (quantidade * valorIngresso));
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
