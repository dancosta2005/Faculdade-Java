package principal_danielcosta.academia;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String horario;
    private String diaDaSemana;
    private List<Aluno> alunos;
    private final int CAPACIDADE_MAXIMA = 10;

    public Turma(String horario, String diaDaSemana) {
        this.horario = horario;
        this.diaDaSemana = diaDaSemana;
        this.alunos = new ArrayList<>();
    }

    public String getHorario() {
        return horario;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }


    public int getVagasDisponiveis() { 
        return CAPACIDADE_MAXIMA - alunos.size();
    }

    public void matricularAluno(Aluno aluno) throws TurmaCompletaException {
        if (alunos.size() >= CAPACIDADE_MAXIMA) {
            throw new TurmaCompletaException("Turma lotada no horario " + horario + " de " + diaDaSemana); 
        }
        alunos.add(aluno);
    }
}
