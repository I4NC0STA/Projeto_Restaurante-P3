package exception;

// excecao customizada pra quando a mesa nao esta disponivel
public class MesaIndisponivelException extends Exception {

    private int numeroMesa;

    public MesaIndisponivelException(int numeroMesa) {
        super("Mesa " + numeroMesa + " nao esta disponivel no momento.");
        this.numeroMesa = numeroMesa;
    }

    public MesaIndisponivelException(int numeroMesa, String motivo) {
        super("Mesa " + numeroMesa + " nao esta disponivel: " + motivo);
        this.numeroMesa = numeroMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }
}
