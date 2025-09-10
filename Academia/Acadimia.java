package principal_danielcosta.academia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Acadimia {
    private Map<String, Map<String, Turma>> turmasPorDiaHorario;
    private final String[] HORARIOS = {"08:00", "10:00", "15:00", "19:00"};

    public Acadimia() {
        turmasPorDiaHorario = new HashMap<>();
        inicializarTurmas();
    }

    private void inicializarTurmas() {
        Map<String, Turma> turmasSegundaQuarta = new HashMap<>();
        
        for (String horario : HORARIOS) {
            turmasSegundaQuarta.put(horario, new Turma(horario, "Segunda/Quarta"));
        }
        turmasPorDiaHorario.put("Segunda", turmasSegundaQuarta);
        turmasPorDiaHorario.put("Quarta", turmasSegundaQuarta);
        Map<String, Turma> turmasTercaQuinta = new HashMap<>();
        
        for (String horario : HORARIOS) {
            turmasTercaQuinta.put(horario, new Turma(horario, "Terca/Quinta"));
        }
        turmasPorDiaHorario.put("Terca", turmasTercaQuinta);
        turmasPorDiaHorario.put("Quinta", turmasTercaQuinta);
    }

    public Turma getTurma(String diaDaSemana, String horario) {
        Map<String, Turma> turmasDoDia = turmasPorDiaHorario.get(diaDaSemana);
        if (turmasDoDia != null) {
            return turmasDoDia.get(horario);
        }
        return null;
    }

    public List<Turma> getTurmasComVagas() { 
        List<Turma> turmasComVagas = new ArrayList<>();
        for (Map<String, Turma> turmasDoDia : turmasPorDiaHorario.values()) {
            for (Turma turma : turmasDoDia.values()) {
                if (turma.getVagasDisponiveis() > 0 && !turmasComVagas.contains(turma)) {
                    turmasComVagas.add(turma);
                }
            }
        }
        return turmasComVagas;
    }
}
