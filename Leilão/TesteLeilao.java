package principaldaniel.leilao;

import java.util.Scanner;

public class TesteLeilao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Leilao leilao = new Leilao();

        Lote lote1 = new Lote();
        lote1.adicionarProduto(new Produto("TV 42\""));
        lote1.adicionarProduto(new Produto("Notebook Dell"));
        leilao.adicionarLote(lote1);

        Lote lote2 = new Lote();
        lote2.adicionarProduto(new Produto("iPhone 14"));
        leilao.adicionarLote(lote2);

        int opcao;
        do {
            System.out.println("\n1 - Listar Produtos\n2 - Fazer Lance\n3 - Encerrar Leilão\n0 - Sair");
            opcao = entrada.nextInt();
            entrada.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    leilao.listarProdutos();
                    break;
                case 2:
                    System.out.print("Nome da pessoa: ");
                    String nome = entrada.nextLine();
                    System.out.print("Contato: ");
                    String contato = entrada.nextLine();
                    Pessoa pessoa = new Pessoa(nome, contato);

                    System.out.print("Número do lote (1-n): ");
                    int lote = entrada.nextInt() - 1;
                    System.out.print("Número do produto no lote (1-n): ");
                    int produto = entrada.nextInt() - 1;
                    System.out.print("Valor do lance: ");
                    double valor = entrada.nextDouble();

                    boolean sucesso = leilao.fazerLance(lote, produto, new Lance(pessoa, valor));
                    if (sucesso)
                        System.out.println("Lance aceito.");
                    else
                        System.out.println("Lance recusado.");
                    break;
                case 3:
                    leilao.encerrarLeilao();
                    break;
            }
        } while (opcao != 0);

        entrada.close();
    }
}
