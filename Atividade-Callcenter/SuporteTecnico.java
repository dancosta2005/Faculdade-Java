package com.mycompany.callcenter;

import java.util.*;

public class SuporteTecnico {
    private HashMap<String, String> bancoSolucao;
    private ArrayList<String> respostaPadrao;
    private Random random;

    public SuporteTecnico() {
        bancoSolucao = new HashMap<>();
        respostaPadrao = new ArrayList<>();
        random = new Random();
        inicializarBanco();
    }

    private void inicializarBanco() {
        bancoSolucao.put("windows", "Este é um problema do sistema operacional Windows. Por favor, entre em contato com a Microsoft. Não há nada que possamos fazer neste caso.");
        bancoSolucao.put("tela azul", "A famosa 'tela azul da morte' pode indicar falha de hardware ou driver. Tente reiniciar e atualizar os drivers.");
        bancoSolucao.put("travando", "Seu computador pode estar com pouca memória. Tente fechar programas em segundo plano ou reiniciar.");
        bancoSolucao.put("virus", "Recomendamos escanear seu sistema com um antivírus confiável.");

        respostaPadrao.add("Por favor, tente reiniciar o computador e verifique se o problema persiste.");
        respostaPadrao.add("Nos desculpe, não temos uma solução específica para esse problema.");
        respostaPadrao.add("Entre em contato com um técnico especializado.");
    }

    public String buscarSolucao(Set<String> palavras) {
        for (String palavra : palavras) {
            if (bancoSolucao.containsKey(palavra.toLowerCase())) {
                return bancoSolucao.get(palavra.toLowerCase());
            }
        }
        return buscarRespostaPadrao();
    }

    public String buscarRespostaPadrao() {
        int index = random.nextInt(respostaPadrao.size());
        return respostaPadrao.get(index);
    }
}
