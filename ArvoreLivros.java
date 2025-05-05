
public class ArvoreLivros {
    private No raiz;

    private class No {
        Livro livro;
        No esquerda, direita;

        No(Livro livro) {
            this.livro = livro;
        }
    }

    public void adicionar(Livro livro) {
        raiz = adicionarRecursivo(raiz, livro);
    }

    private No adicionarRecursivo(No atual, Livro livro) {
        if (atual == null) {
            return new No(livro);
        }

        if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, livro);
        } else if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) > 0) {
            atual.direita = adicionarRecursivo(atual.direita, livro);
        }
        return atual;
    }

    public void listarEmOrdem() {
        listarEmOrdemRecursivo(raiz);
    }

    private void listarEmOrdemRecursivo(No atual) {
        if (atual != null) {
            listarEmOrdemRecursivo(atual.esquerda);
            System.out.println(atual.livro);
            listarEmOrdemRecursivo(atual.direita);
        }
    }

    public Livro buscarPorTitulo(String titulo) {
        return buscarRecursivo(raiz, titulo);
    }

    private Livro buscarRecursivo(No atual, String titulo) {
        if (atual == null) {
            return null;
        }
        if (titulo.equalsIgnoreCase(atual.livro.getTitulo())) {
            return atual.livro;
        }
        if (titulo.compareToIgnoreCase(atual.livro.getTitulo()) < 0) {
            return buscarRecursivo(atual.esquerda, titulo);
        } else {
            return buscarRecursivo(atual.direita, titulo);
        }
    }
}
