public class Aluno {
    private String nome;
    private int idade;
    private String matricula;
    private double n1, n2, n3;

    public Aluno(String nome, int idade, String matricula, double n1, double n2, double n3)
            throws ExceptionPersonalizada {
        if (nome == null || nome.trim().isEmpty())
            throw new ExceptionPersonalizada("O nome não pode ficar em branco.");
        if (matricula == null || matricula.trim().isEmpty())
            throw new ExceptionPersonalizada("A matrícula é obrigatória.");
        if (idade < 18)
            throw new ExceptionPersonalizada("A idade deve ser maior que 17.");
        if (!notaValida(n1) || !notaValida(n2) || !notaValida(n3))
            throw new ExceptionPersonalizada("As notas precisam estar entre 0 e 10.");

        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public boolean notaValida(double nota) {
        return nota >= 0 && nota <= 10;
    }

    public double calcularMedia() {
        double[] notas = { n1, n2, n3 };
        java.util.Arrays.sort(notas);
        return (notas[1] + notas[2]) / 2;
    }

    public String getSituacao() {
        return calcularMedia() >= 6 ? "Aprovado" : "Reprovado";
    }

    @Override
    public String toString() {
        return String.format(
                "Nome: %s | Idade: %d | Matrícula: %s | N1: %.1f | N2: %.1f | N3: %.1f | Média: %.2f | Situacao: %s",
                nome, idade, matricula, n1, n2, n3, calcularMedia(), getSituacao());
    }
}
