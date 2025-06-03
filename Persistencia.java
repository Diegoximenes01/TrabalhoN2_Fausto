import java.util.*;

public class Persistencia {
    private Object armazenamento;
    private int tipoPersistencia;

    public Persistencia() {
        tipoPersistencia = new java.util.Random().nextInt(3); // Aleatório ou fixa
        switch (tipoPersistencia) {
            case 0 -> armazenamento = new ArrayList<Aluno>();
            case 1 -> armazenamento = new HashSet<Aluno>();
            case 2 -> armazenamento = new HashMap<String, Aluno>();
        }
    }

    public void adicionarAluno(Aluno a) {
        switch (tipoPersistencia) {
            case 0 -> ((List<Aluno>) armazenamento).add(a);
            case 1 -> ((Set<Aluno>) armazenamento).add(a);
            case 2 -> ((Map<String, Aluno>) armazenamento).put(a.getMatricula(), a);
        }
    }

    public void listarAlunos() {
        System.out.println("\n--- Lista de Alunos ---");
        switch (tipoPersistencia) {
            case 0 -> ((List<Aluno>) armazenamento).forEach(System.out::println);
            case 1 -> ((Set<Aluno>) armazenamento).forEach(System.out::println);
            case 2 -> ((Map<String, Aluno>) armazenamento).values().forEach(System.out::println);
        }
    }
}
