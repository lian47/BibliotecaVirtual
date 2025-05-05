
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaVirtual biblioteca = new BibliotecaVirtual();
        ListaEspera listaEspera = new ListaEspera();
        HistoricoNavegacao historico = new HistoricoNavegacao();
        ArvoreLivros arvoreLivros = new ArvoreLivros();
        Scanner scanner = new Scanner(System.in);

        Livro[] livrosExemplo = {
                new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954),
                new Livro("1984", "George Orwell", 1949),
                new Livro("Dom Quixote", "Miguel de Cervantes", 1605),
                new Livro("A Revolução dos Bichos", "George Orwell", 1945),
                new Livro("O Hobbit", "J.R.R. Tolkien", 1937),
                new Livro("Cem Anos de Solidão", "Gabriel García Márquez", 1967),
                new Livro("A Odisséia", "Homero", -800),
                new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866),
                new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943),
                new Livro("Orgulho e Preconceito", "Jane Austen", 1813)
        };

        for (Livro livro : livrosExemplo) {
            arvoreLivros.adicionar(livro);
        }

        int opcao;
        do {
            System.out.println("\n--- Menu da Biblioteca Virtual ---");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Listar livros");
            System.out.println("3. Visualizar um livro");
            System.out.println("4. Adicionar usuário na fila de espera");
            System.out.println("5. Atender próximo da fila de espera");
            System.out.println("6. Listar usuários na fila de espera");
            System.out.println("7. Mostrar histórico de navegação");
            System.out.println("8. Listar livros da árvore (em ordem)");
            System.out.println("9. Buscar livro na árvore");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    Livro novoLivro = new Livro(titulo, autor, ano);
                    biblioteca.adicionarLivro(novoLivro);
                    arvoreLivros.adicionar(novoLivro);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Título do livro para visualizar: ");
                    String busca = scanner.nextLine();
                    Livro l = biblioteca.buscarLivroPorTitulo(busca);
                    if (l != null) {
                        System.out.println(l);
                        historico.registrarVisualizacao(l);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do usuário: ");
                    String usuario = scanner.nextLine();
                    listaEspera.adicionarUsuarioNaFila(usuario);
                    break;
                case 5:
                    listaEspera.atenderProximoUsuario();
                    break;
                case 6:
                    listaEspera.listarUsuariosNaFila();
                    break;
                case 7:
                    historico.mostrarHistorico();
                    break;
                case 8:
                    arvoreLivros.listarEmOrdem();
                    break;
                case 9:
                    System.out.print("Título para buscar: ");
                    String buscaArvore = scanner.nextLine();
                    Livro resultado = arvoreLivros.buscarPorTitulo(buscaArvore);
                    if (resultado != null) {
                        System.out.println("Encontrado: " + resultado);
                    } else {
                        System.out.println("Não encontrado na árvore.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
