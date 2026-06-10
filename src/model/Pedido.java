package model;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
import interfaces.Pagavel;

//a classe Pedido representa um pedido feito no restaurante.
// implementa a interface Pagavel, ou seja, é obrigada a ter o método pagar().
public class Pedido implements Pagavel {

    private int id;
    private List<Produto> produtos;

    //Construtor do pedido
    public Pedido(int id) {
        this.id = id;

        //Cria uma lista vazia para armazenar os produtos do pedido
        this.produtos = new ArrayList<>();
    }

    //Adiciona um produto dentro do pedido
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    //Calcula o valor total do pedido somando o preço de todos os produtos
    public double calcularTotal() {
        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getPreco();
        }

        return total;
    }

    //Método obrigatório por causa da interface Pagavel
    @Override
    public void pagar() {
        System.out.println("Pedido pago com sucesso!");
    }
}
=======

// pedido de uma mesa, implementa Pagavel
public class Pedido implements Pagavel {

    // status possiveis do pedido
    public enum Status {
        ABERTO, EM_PREPARO, PRONTO, ENTREGUE, PAGO, CANCELADO
    }

    private int numero;
    private int numeroMesa;
    private List<ItemPedido> itens;
    private Status status;
    private boolean pago;
    private double valorPago;

    public Pedido(int numero, int numeroMesa) {
        this.numero = numero;
        this.numeroMesa = numeroMesa;
        this.itens = new ArrayList<>();
        this.status = Status.ABERTO;
        this.pago = false;
        this.valorPago = 0;
    }

    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }

    public void removerItem(int index) {
        if (index >= 0 && index < itens.size()) {
            itens.remove(index);
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido ip : itens) {
            total += ip.getSubtotal();
        }
        return total;
    }

    @Override
    public void pagar(double valor) {
        this.valorPago = valor;
        this.pago = true;
        this.status = Status.PAGO;
    }

    @Override
    public boolean isPago() {
        return pago;
    }

    public double getTroco() {
        return valorPago - calcularTotal();
    }

    public void exibirPedido() {
        System.out.println("========================================");
        System.out.println("PEDIDO #" + numero + " | MESA " + numeroMesa);
        System.out.println("Status: " + status);
        System.out.println("----------------------------------------");
        if (itens.isEmpty()) {
            System.out.println("Nenhum item no pedido.");
        } else {
            for (ItemPedido ip : itens) {
                System.out.println(ip);
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("TOTAL: R$ " + String.format("%.2f", calcularTotal()));
        System.out.println("========================================");
    }

    // getters e setters
    public int getNumero() { return numero; }
    public int getNumeroMesa() { return numeroMesa; }
    public List<ItemPedido> getItens() { return itens; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}

>>>>>>> 029ab46923407a50790130a711724c22c25fe2d6
