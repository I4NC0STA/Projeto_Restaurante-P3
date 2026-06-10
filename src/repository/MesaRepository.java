package repository;

import model.Mesa;
import exception.MesaIndisponivelException;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// repositorio das mesas do restaurante
public class MesaRepository {

    // uso Map pra acessar mesa pelo numero rapidinho
    private Map<Integer, Mesa> mesas;

    public MesaRepository() {
        this.mesas = new HashMap<>();
    }

    public void adicionar(Mesa mesa) {
        mesas.put(mesa.getNumero(), mesa);
    }

    public Mesa buscarPorNumero(int numero) throws MesaIndisponivelException {
        Mesa mesa = mesas.get(numero);
        if (mesa == null) {
            throw new MesaIndisponivelException(numero, "mesa nao existe");
        }
        return mesa;
    }

    public Mesa ocuparMesa(int numero) throws MesaIndisponivelException {
        Mesa mesa = buscarPorNumero(numero);
        if (!mesa.isLivre()) {
            throw new MesaIndisponivelException(numero);
        }
        mesa.ocupar();
        return mesa;
    }

    public void liberarMesa(int numero) throws MesaIndisponivelException {
        Mesa mesa = buscarPorNumero(numero);
        mesa.liberar();
    }

    public List<Mesa> listarTodas() {
        return new ArrayList<>(mesas.values());
    }

    public List<Mesa> listarLivres() {
        List<Mesa> livres = new ArrayList<>();
        for (Mesa mesa : mesas.values()) {
            if (mesa.isLivre()) {
                livres.add(mesa);
            }
        }
        return livres;
    }
}
