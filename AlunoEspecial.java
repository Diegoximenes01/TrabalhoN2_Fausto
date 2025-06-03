public class AlunoEspecial extends Aluno {
    private String projeto;
    private boolean isMonitor;

    public AlunoEspecial(String nome, int idade, String matricula, double n1, double n2, double n3, String projeto,
            boolean isMonitor) throws ExceptionPersonalizada {
        super(nome, idade, matricula, n1, n2, n3);
        this.projeto = projeto;
        this.isMonitor = isMonitor;
    }

    public String descreverProjeto() {
        return "Projeto Atual: " + projeto + (isMonitor ? "É monitor da disciplina" : "");
    }

    @Override
    public String toString() {
        return super.toString() + " | Informação Extra: " + descreverProjeto();
    }
}
