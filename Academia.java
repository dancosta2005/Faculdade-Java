package principal_danielcosta.academia;

import java.util.List;
import principal_danielcosta.academia.TurmaCompletaException;

public class Academia{
   public static void main(String[] args) {
        Acadimia cefetAcademia = new Acadimia(); 

        System.out.println("Verificando turmas com vagas disponiveis inicialmente:");
        List<Turma> turmasComVagasIniciais = cefetAcademia.getTurmasComVagas();
        for (Turma turma : turmasComVagasIniciais) {
            System.out.println("  Dia: " + turma.getDiaDaSemana() + ", Horario: " + turma.getHorario() + ", Vagas: " + turma.getVagasDisponiveis());
        }

        System.out.println("\nMatriculando alunos na turma de Segunda/Quarta as 08:00:");
        Turma turmaSegundaQuarta0800 = cefetAcademia.getTurma("Segunda", "08:00");
        if (turmaSegundaQuarta0800 != null) {
            for (int i = 1; i <= 10; i++) { 
                try {
                    Aluno aluno = new Aluno("Aluno " + i);
                    turmaSegundaQuarta0800.matricularAluno(aluno);
                    System.out.println("  " + aluno.getNome() + " matriculado na turma de " + turmaSegundaQuarta0800.getDiaDaSemana() + " as " + turmaSegundaQuarta0800.getHorario());
                } catch (TurmaCompletaException e) { 
                    System.out.println("  Erro: " + e.getMessage());
                }
            }

            try {
                Aluno alunoExtra = new Aluno("Aluno Extra");
                turmaSegundaQuarta0800.matricularAluno(alunoExtra);
                System.out.println("  " + alunoExtra.getNome() + " matriculado (ISSO NAO DEVE ACONTECER)");
            } catch (TurmaCompletaException e) { 
                System.out.println("  Sucesso na captura da excecao " + e.getMessage());
            }
        } else {
            System.out.println("  Turma de Segunda/Quarta as 08:00 nao encontrada.");
        }

        System.out.println("\nVerificando turmas com vagas disponiveis apos as matriculas:");
        List<Turma> turmasComVagasFinais = cefetAcademia.getTurmasComVagas(); 
        if (turmasComVagasFinais.isEmpty()) {
            System.out.println("  Nao ha mais turmas com vagas disponiveis.");
        } else {
            for (Turma turma : turmasComVagasFinais) {
                System.out.println("  Dia: " + turma.getDiaDaSemana() + ", Horario: " + turma.getHorario() + ", Vagas: " + turma.getVagasDisponiveis());
            }
        }
    }
}