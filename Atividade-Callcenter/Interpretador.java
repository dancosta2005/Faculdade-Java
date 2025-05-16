package com.mycompany.callcenter;

import java.util.*;

public class Interpretador {
    private HashSet<String> palavraChave;

    public Interpretador(String descricaoProblema) {
        palavraChave = new HashSet<>();
        interpretar(descricaoProblema);
    }

    private void interpretar(String problema) {
        String[] palavras = problema.toLowerCase().split("[\\s,.!?]+");
        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                palavraChave.add(palavra);
            }
        }
    }

    public Set<String> getPalavrasChave() {
        return palavraChave;
    }
}
