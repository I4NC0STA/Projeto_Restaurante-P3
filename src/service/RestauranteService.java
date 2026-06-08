package service;

import model.*;
import repository.CardapioRepository;
import repository.MesaRepository;
import exception.ItemNaoEncontradoException;
import exception.MesaIndisponivelException;

import java.util.ArrayList;
import java.util.List;

// servico principal do restaurante, junta tudo
public class RestauranteService {

    private CardapioRepository cardapio;
    private MesaRepository mesas;
    private List<Pedido> pedidos;
    private int proximoNumeroPedido;

    public RestauranteService() {
        this.cardapio = new CardapioRepository();
        this.mesas = new MesaRepository();
        this.pedidos = new ArrayList<>();
        this.proximoNumeroPedido = 1;
    }

    // =========== CARDAPIO ===========

    public void adicionarItemCardapio(ItemCardapio item) {
        cardapio.adicionar(item);
        System.out.println("Item adicionado ao cardapio: " + item.getNome());
    }

    public void exibirCardapio() {
        List<ItemCardapio> itens = cardapio.listarDisponiveis();
        if (itens.isEmpty()) {
            System.out.println("Cardapio vazio.");
            return;
        }
        System.out.println("\n====== CARDAPIO ======");
        for (ItemCardapio item : itens) {
            System.out.println(item); // usa o toString de cada subclasse
        }
        System.out.println("======================\n");
    }

    // =========== MESAS ===========

    public void adicionarMesa(Mesa mesa) {
        mesas.adicionar(mesa);
    }

    public void exibirMesas() {
        System.out.println("\n====== MESAS ======");
        for (Mesa mesa : mesas.listarTodas()) {
            System.out.println(mesa);
        }
        System.out.println("===================\n");
    }

    public void exibirMesasLivres() {
        List<Mesa> livres = mesas.listarLivres();
        System.out.println("\n--- Mesas Livres: " + livres.size() + " ---");
        for (Mesa m : livres) {
            System.out.println(m);
        }
    }

    // =========== PEDIDOS ===========

    public Pedido abrirPedido(int numeroMesa) throws MesaIndisponivelException {
        mesas.ocuparMesa(numeroMesa); // lanca excecao se nao estiver livre
        Pedido pedido = new Pedido(proximoNumeroPedido++, numeroMesa);
        pedidos.add(pedido);
        System.out.println("Pedido #" + pedido.getNumero() + " aberto para mesa " + numeroMesa);
        return pedido;
    }

    public void adicionarItemAoPedido(Pedido pedido, int idItem, int quantidade)
            throws ItemNaoEncontradoException {

        ItemCardapio item = cardapio.buscarPorId(idItem); // lanca excecao se nao achar
        if (!item.isDisponivel()) {
            throw new ItemNaoEncontradoException("Item " + item.getNome() + " esta indisponivel");
        }
        ItemPedido itemPedido = new ItemPedido(item, quantidade);
        pedido.adicionarItem(itemPedido);
        System.out.println("Adicionado: " + quantidade + "x " + item.getNome());
    }

    public void adicionarItemAoPedido(Pedido pedido, int idItem, int quantidade, String obs)
            throws ItemNaoEncontradoException {

        ItemCardapio item = cardapio.buscarPorId(idItem);
        ItemPedido itemPedido = new ItemPedido(item, quantidade, obs);
        pedido.adicionarItem(itemPedido);
        System.out.println("Adicionado: " + quantidade + "x " + item.getNome() + " (obs: " + obs + ")");
    }

    public void fecharPedido(Pedido pedido, double valorPago) throws MesaIndisponivelException {
        double total = pedido.calcularTotal();
        if (valorPago < total) {
            System.out.println("Valor insuficiente! Total: R$ " + String.format("%.2f", total));
            return;
        }
        pedido.pagar(valorPago);
        mesas.liberarMesa(pedido.getNumeroMesa());
        System.out.println("Pagamento realizado! Troco: R$ " + String.format("%.2f", pedido.getTroco()));
        System.out.println("Mesa " + pedido.getNumeroMesa() + " liberada.");
    }

    public void cancelarPedido(Pedido pedido) throws MesaIndisponivelException {
        pedido.setStatus(Pedido.Status.CANCELADO);
        mesas.liberarMesa(pedido.getNumeroMesa());
    }

    public List<Pedido> getPedidos() { return pedidos; }
    public CardapioRepository getCardapio() { return cardapio; }
}
