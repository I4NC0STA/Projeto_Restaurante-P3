package main;


import model.Pedido;
import model.Produto;

public class Main {

    public static void main(String[] args) {

        // Cria dois produtos do cardápio
        Produto coca = new Produto(1, "Coca-Cola", 8.0);
        Produto batata = new Produto(2, "Batata Frita", 20.0);

        // Cria um pedido com ID 1
        Pedido pedido = new Pedido(1);

        // Adiciona os produtos ao pedido
        pedido.adicionarProduto(coca);
        pedido.adicionarProduto(batata);

        // Calcula e exibe o valor total do pedido
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());

        // Executa o método pagar()
        // Esse método existe porque Pedido implementa a interface Pagavel
        pedido.pagar();
    }
}