
import java.util.LinkedList;
import java.util.Queue;

public class ListaEspera {
    private Queue<String> filaEspera;

    public ListaEspera() {
        filaEspera = new LinkedList<>();
    }

    public void adicionarUsuarioNaFila(String nomeUsuario) {
        filaEspera.add(nomeUsuario);
        System.out.println(nomeUsuario + " foi adicionado(a) à lista de espera.");
    }

    public void atenderProximoUsuario() {
        if (filaEspera.isEmpty()) {
            System.out.println("Nenhum usuário na lista de espera.");
        } else {
            String usuarioAtendido = filaEspera.poll();
            System.out.println("Atendendo usuário: " + usuarioAtendido);
        }
    }

    public void listarUsuariosNaFila() {
        if (filaEspera.isEmpty()) {
            System.out.println("A lista de espera está vazia.");
        } else {
            System.out.println("Usuários na lista de espera:");
            for (String usuario : filaEspera) {
                System.out.println("- " + usuario);
            }
        }
    }
}
