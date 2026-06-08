package repository;

import model.ItemCardapio;
import exception.ItemNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

// repositorio do cardapio, guarda todos os itens
public class CardapioRepository {

    private List<ItemCardapio> itens;

    public CardapioRepository() {
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemCardapio item) {
        itens.add(item);
    }

    public ItemCardapio buscarPorId(int id) throws ItemNaoEncontradoException {
        for (ItemCardapio item : itens) {
            if (item.getId() == id) {
                return item;
            }
        }
        throw new ItemNaoEncontradoException(id);
    }

    public List<ItemCardapio> listarTodos() {
        return itens;
    }

    public List<ItemCardapio> listarDisponiveis() {
        List<ItemCardapio> disponiveis = new ArrayList<>();
        for (ItemCardapio item : itens) {
            if (item.isDisponivel()) {
                disponiveis.add(item);
            }
        }
        return disponiveis;
    }

    public int totalItens() {
        return itens.size();
    }
}
