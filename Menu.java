import java.util.Scanner;

public class Menu {
    private Turma turma;
    private Scanner sc;

    public Menu() {
        turma = new Turma();
        sc = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n___ Menu ___");
            System.out.println("1. adicionar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Sair");
            System.out.println("Escolha: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" -> adicionarAluno();
                case "2" -> turma.listarAlunos();
                case "3" -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!!!!!");
            }
        }
    }

    private void adicionarAluno() {
        try {
            System.out.println("Nome: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(sc.nextLine());

            System.out.print("Matrículas: ");
            String matricula = sc.nextLine();

            System.out.print("Nota N1: ");
            double n1 = Double.parseDouble(sc.nextLine());

            System.out.print("Nota N2: ");
            double n2 = Double.parseDouble(sc.nextLine());

            System.out.print("Nota N3: ");
            double n3 = Double.parseDouble(sc.nextLine());

            System.out.print("É um aluno especial? (s/n): ");
            String especial = sc.nextLine();

            if (especial.equalsIgnoreCase("s")) {
                System.out.print("Projeto: ");
                String projeto = sc.nextLine();
                System.out.print("É monitor? (true/false): ");
                boolean monitor = Boolean.parseBoolean(sc.nextLine());
                turma.adicionarAluno(new AlunoEspecial(nome, idade, matricula, n1, n2, n3, projeto, monitor));

            } else {
                turma.adicionarAluno(new Aluno(nome, idade, matricula, n1, n2, n3));
            }

            System.out.println("Aluno adicionado com sucesso!!!");
        } catch (NumberFormatException e) {
            System.out.println("Erro: valor número inválido.");

        } catch (ExceptionPersonalizada e) {
            System.out.println("Erro: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
