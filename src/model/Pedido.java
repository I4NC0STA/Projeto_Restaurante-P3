package model;

import java.util.ArrayList;
import java.util.List;

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

