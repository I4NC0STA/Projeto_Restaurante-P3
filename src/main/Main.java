package main;

import exception.MesaIndisponivelException;
import java.util.Scanner;
import model.*;
import service.RestauranteService;

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
            System.out.println("4. Gerenciar comanda");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            int op = lerInt();

            switch (op) {

                case 1 -> restaurante.exibirMesas();

                case 2 -> fluxoPedido();

                case 3 -> restaurante.exibirCardapio();

                case 4 -> gerenciarComanda();

                case 0 -> {
                    System.out.println("\nAte logo!");
                    rodando = false;
                }

                default -> System.out.println("Opcao invalida, tenta de novo.");
            }
        }
    }

    static void fluxoPedido() {

        restaurante.exibirMesasLivres();

        System.out.print("\nDigite o numero da mesa: ");
        int numMesa = lerInt();

        try {

            Pedido pedido = restaurante.abrirPedido(numMesa);

            System.out.println(
                    "Pedido #" +
                    pedido.getNumero() +
                    " aberto na mesa " +
                    numMesa
            );

        } catch (MesaIndisponivelException e) {

            System.out.println("ERRO: " + e.getMessage());

        }
    }

    static void gerenciarComanda() {

        restaurante.exibirMesasOcupadas();

        System.out.print("Digite o numero da mesa: ");
        int numeroMesa = lerInt();

        Pedido pedido = restaurante.buscarPedidoPorMesa(numeroMesa);

        if (pedido == null) {
            System.out.println("Nenhuma comanda encontrada.");
            return;
        }

        boolean aberto = true;

        while (aberto) {

            System.out.println("\n====== COMANDA MESA " + numeroMesa + " ======");
            System.out.println("1. Adicionar item");
            System.out.println("2. Ver pedido");
            System.out.println("3. Fechar conta");
            System.out.println("4. Cancelar pedido");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");

            int op = lerInt();

            switch (op) {

                case 1 -> {

                    restaurante.exibirCardapio();

                    System.out.print("ID do item: ");
                    int id = lerInt();

                    System.out.print("Quantidade: ");
                    int qtd = lerInt();

                    try {

                        restaurante.adicionarItemAoPedido(
                                pedido,
                                id,
                                qtd
                        );

                    } catch (Exception e) {

                        System.out.println(
                                "ERRO: " +
                                e.getMessage()
                        );

                    }
                }

                case 2 -> {

                    pedido.exibirPedido();

                    System.out.printf(
                            "\nTOTAL ATUAL: R$ %.2f\n",
                            pedido.calcularTotal()
                    );
                }

                case 3 -> {

                    pedido.exibirPedido();

                    System.out.printf(
                            "\nTOTAL A PAGAR: R$ %.2f\n",
                            pedido.calcularTotal()
                    );

                    System.out.print("Valor pago: R$ ");
                    double valorPago = lerDouble();

                    try {

                        restaurante.fecharPedido(
                                pedido,
                                valorPago
                        );

                        aberto = false;

                    } catch (Exception e) {

                        System.out.println(
                                "ERRO: " +
                                e.getMessage()
                        );

                    }
                }

                case 4 -> {

                    try {

                        restaurante.cancelarPedido(
                                pedido
                        );

                        System.out.println(
                                "Pedido cancelado."
                        );

                        aberto = false;

                    } catch (Exception e) {

                        System.out.println(
                                "ERRO: " +
                                e.getMessage()
                        );

                    }
                }

                case 0 -> aberto = false;

                default -> System.out.println("Opcao invalida.");
            }
        }
    }

    static int lerInt() {

        while (true) {

            try {

                return Integer.parseInt(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Digite um numero valido: "
                );
            }
        }
    }

    static double lerDouble() {

        while (true) {

            try {

                return Double.parseDouble(
                        sc.nextLine()
                                .trim()
                                .replace(",", ".")
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Digite um valor valido: "
                );
            }
        }
    }

    static void popularSistema() {

        restaurante.adicionarItemCardapio(
                new Prato(
                        1,
                        "Frango Grelhado",
                        35.90,
                        "Frango grelhado com arroz e salada",
                        "Carnes",
                        20
                )
        );

        restaurante.adicionarItemCardapio(
                new Prato(
                        2,
                        "Macarrao ao Alho",
                        28.00,
                        "Macarrao com alho e azeite",
                        "Massas",
                        15
                )
        );

        restaurante.adicionarItemCardapio(
                new Prato(
                        3,
                        "Salada Caesar",
                        22.50,
                        "Salada com frango e croutons",
                        "Vegetariano",
                        10
                )
        );

        restaurante.adicionarItemCardapio(
                new Bebida(
                        4,
                        "Suco de Laranja",
                        8.00,
                        "Suco natural",
                        300,
                        false
                )
        );

        restaurante.adicionarItemCardapio(
                new Bebida(
                        5,
                        "Cerveja Artesanal",
                        14.00,
                        "Cerveja local gelada",
                        500,
                        true
                )
        );

        restaurante.adicionarItemCardapio(
                new Bebida(
                        6,
                        "Agua Mineral",
                        4.00,
                        "Com ou sem gas",
                        500,
                        false
                )
        );

        restaurante.adicionarItemCardapio(
                new Sobremesa(
                        7,
                        "Pudim",
                        12.00,
                        "Pudim caseiro",
                        false
                )
        );

        restaurante.adicionarItemCardapio(
                new Sobremesa(
                        8,
                        "Sorvete",
                        10.00,
                        "2 bolas a escolher",
                        true
                )
        );

        restaurante.adicionarMesa(new Mesa(1, 2));
        restaurante.adicionarMesa(new Mesa(2, 4));
        restaurante.adicionarMesa(new Mesa(3, 4));
        restaurante.adicionarMesa(new Mesa(4, 6));
    }
}