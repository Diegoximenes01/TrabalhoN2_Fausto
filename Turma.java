
public class Turma {
    private Persistencia persistencia;

    public Turma() {
        persistencia = new Persistencia();
    }

    public void adicionarAluno(Aluno aluno) {
        persistencia.adicionarAluno(aluno);
    }

    public void listarAlunos() {
        persistencia.listarAlunos();
    }
}
