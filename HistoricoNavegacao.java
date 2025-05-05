
import java.util.Stack;

public class HistoricoNavegacao {
    private Stack<Livro> historico;

    public HistoricoNavegacao() {
        historico = new Stack<>();
    }

    public void registrarVisualizacao(Livro livro) {
        historico.push(livro);
        System.out.println("Visualização registrada no histórico.");
    }

    public void mostrarHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Histórico vazio.");
            return;
        }

        System.out.println("Histórico de livros visualizados (mais recente primeiro):");
        for (int i = historico.size() - 1; i >= 0; i--) {
            System.out.println(historico.get(i));
        }
    }
}
