package model;

import java.util.ArrayList;
import java.util.List;
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