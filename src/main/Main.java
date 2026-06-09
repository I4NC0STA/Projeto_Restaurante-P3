package main;

import model.*;
import service.RestauranteService;
import exception.MesaIndisponivelException;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static RestauranteService restaurante = new RestauranteService();

    public static void main(String[] args) {

        popularSistema();

        System.out.println("===========================================");
        System.out.println("   SISTEMA DE RESTAURANTE - POO 2026.1   ");
        System.out.println("===========================================");

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n====== MENU PRINCIPAL ======");
            System.out.println("1. Ver mesas");
            System.out.println("2. Abrir pedido em uma mesa");
            System.out.println("3. Ver cardapio");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int op = lerInt();

            switch (op) {
                case 1 -> restaurante.exibirMesas();
                case 2 -> fluxoPedido();
                case 3 -> restaurante.exibirCardapio();
                case 0 -> {
                    System.out.println("\nAte logo!");
                    rodando = false;
                }
                default -> System.out.println("Opcao invalida, tenta de novo.");
            }
        }
    }

    static void fluxoPedido() {
        // mostra as mesas livres pra o usuario escolher
        restaurante.exibirMesasLivres();
        System.out.print("\nDigite o numero da mesa: ");
        int numMesa = lerInt();

        Pedido pedido;
        try {
            pedido = restaurante.abrirPedido(numMesa);
        } catch (MesaIndisponivelException e) {
            System.out.println("ERRO: " + e.getMessage());
            return;
        }

        // TODO: grupo continua daqui
        // pedido ja foi aberto e a mesa foi ocupada
        // agora falta:
        //   - mostrar o menu do pedido (adicionar item, ver pedido, fechar conta, cancelar)
        //   - chamar restaurante.adicionarItemAoPedido(pedido, id, quantidade)
        //   - chamar restaurante.fecharPedido(pedido, valorPago)
        //   - chamar restaurante.cancelarPedido(pedido)

        System.out.println("Pedido #" + pedido.getNumero() + " aberto na mesa " + numMesa + ".");

boolean pedidoAberto = true;

while (pedidoAberto) {

    System.out.println("\n====== MENU DO PEDIDO ======");
    System.out.println("1. Adicionar item");
    System.out.println("2. Ver pedido");
    System.out.println("3. Fechar conta");
    System.out.println("4. Cancelar pedido");
    System.out.println("0. Voltar");
    System.out.print("Escolha: ");

    int op = lerInt();

    switch (op) {

        case 1:
            restaurante.exibirCardapio();

            System.out.print("Digite o ID do item: ");
            int idItem = lerInt();

            System.out.print("Quantidade: ");
            int quantidade = lerInt();

            restaurante.adicionarItemAoPedido(
                    pedido,
                    idItem,
                    quantidade,
                    ""
            );

            System.out.println("Item adicionado!");
            break;

        case 2:
            pedido.exibirPedido();
            break;

        case 3:
            pedido.exibirPedido();

            System.out.print("Valor pago: R$ ");
            double valorPago = lerDouble();

            restaurante.fecharPedido(
                    pedido,
                    valorPago
            );

            pedidoAberto = false;
            break;

        case 4:
            restaurante.cancelarPedido(pedido);
            System.out.println("Pedido cancelado!");
            pedidoAberto = false;
            break;

        case 0:
            pedidoAberto = false;
            break;

        default:
            System.out.println("Opcao invalida!");
    }
}
    }

    static int lerInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Digite um numero valido: ");
            }
        }
    }

    static double lerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Digite um valor valido: ");
            }
        }
    }

    static void popularSistema() {
        restaurante.adicionarItemCardapio(new Prato(1, "Frango Grelhado", 35.90, "Frango grelhado com arroz e salada", "Carnes", 20));
        restaurante.adicionarItemCardapio(new Prato(2, "Macarrao ao Alho", 28.00, "Macarrao com alho e azeite", "Massas", 15));
        restaurante.adicionarItemCardapio(new Prato(3, "Salada Caesar", 22.50, "Salada com frango e croutons", "Vegetariano", 10));
        restaurante.adicionarItemCardapio(new Bebida(4, "Suco de Laranja", 8.00, "Suco natural", 300, false));
        restaurante.adicionarItemCardapio(new Bebida(5, "Cerveja Artesanal", 14.00, "Cerveja local gelada", 500, true));
        restaurante.adicionarItemCardapio(new Bebida(6, "Agua Mineral", 4.00, "Com ou sem gas", 500, false));
        restaurante.adicionarItemCardapio(new Sobremesa(7, "Pudim", 12.00, "Pudim caseiro", false));
        restaurante.adicionarItemCardapio(new Sobremesa(8, "Sorvete", 10.00, "2 bolas a escolher", true));

        restaurante.adicionarMesa(new Mesa(1, 2));
        restaurante.adicionarMesa(new Mesa(2, 4));
        restaurante.adicionarMesa(new Mesa(3, 4));
        restaurante.adicionarMesa(new Mesa(4, 6));
    }
}

