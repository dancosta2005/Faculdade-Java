package com.mycompany.callcenter;

import java.util.Scanner;

public class Callcenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SuporteTecnico suporte = new SuporteTecnico();

        System.out.println("Bem-vindo ao sistema de Suporte Técnico");

        while (true) {
            System.out.println("\nPressione <enter> para continuar ou digite 'sair' para sair do sistema.");
            String entrada = scanner.nextLine().trim().toLowerCase();

            if (entrada.equals("sair")) {
                System.out.println("\nObrigada por utilizar nossos serviços!");
                break;
            }

            System.out.println("Descreva seu problema de maneira sucinta.");
            String problema = scanner.nextLine();

            Interpretador interpretadora = new Interpretador(problema);
            String resposta = suporte.buscarSolucao(interpretadora.getPalavrasChave());

            System.out.println("\n" + resposta);
        }

        scanner.close();
    }
}

