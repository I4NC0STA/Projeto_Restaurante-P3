package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private List<Produto> produtos;

    public Pedido(int id) {
        this.id = id;

        //aqui cria uma lista vazia para armazenar os produtos
        this.produtos = new ArrayList<>();
    }

    // aqui adiciona um produto ao pedido
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // calcula o valor total do pedido
    public double calcularTotal() {

        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getPreco();
        }

        return total;
    }
}