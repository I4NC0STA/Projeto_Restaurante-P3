package exception;

// excecao pra quando tenta pedir algo que nao tem no cardapio
public class ItemNaoEncontradoException extends Exception {

    private int idItem;

    public ItemNaoEncontradoException(int idItem) {
        super("Item com ID " + idItem + " nao foi encontrado no cardapio.");
        this.idItem = idItem;
    }

    public ItemNaoEncontradoException(String nome) {
        super("Item '" + nome + "' nao foi encontrado no cardapio.");
        this.idItem = -1;
    }

    public int getIdItem() {
        return idItem;
    }
}
