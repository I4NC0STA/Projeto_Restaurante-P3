# Sistema de Restaurante - POO 2026.1

Projeto da disciplina de Programação Orientada a Objetos. Sistema em Java para gerenciar mesas, pedidos e pagamento de um restaurante, rodando pelo terminal.

## Equipe

- Ian Costa
- Adalberto Lucena
- Abraão Franco
- João Pedro

## Tecnologias

- Java 17
- Coleções (ArrayList, HashMap)

## Como rodar

1. Clona o repositório
2. Abre a pasta no IntelliJ (ou outra IDE)
3. Marca a pasta src como Sources Root
4. Roda o arquivo Main.java

## Funcionalidades

- Ver mesas (livres e ocupadas)
- Abrir pedido em uma mesa
- Ver cardápio (pratos, bebidas e sobremesas)
- Adicionar itens ao pedido com quantidade
- Ver comanda com o total
- Fechar conta com cálculo de troco
- Cancelar pedido e liberar mesa

## Estrutura do projeto

src/
├── model/        -> classes do dominio (ItemCardapio, Prato, Bebida, Sobremesa, Pedido, Mesa, ItemPedido)
├── repository/    -> armazenamento dos dados (CardapioRepository, MesaRepository)
├── service/      -> regras de negocio (RestauranteService)
├── exception/    -> excecoes customizadas
└── main/         -> menu e classe principal

## Conceitos de POO aplicados

- **Herança**: `ItemCardapio` (classe abstrata) -> `Prato`, `Bebida`, `Sobremesa`
- **Polimorfismo**: cada subclasse implementa `getTipo()` de forma diferente, e `Sobremesa` sobrescreve `calcularPreco()`
- **Interfaces**: `Pagavel` (Pedido) e `Descricavel` (ItemCardapio)
- **Coleções**: `ArrayList` para itens do cardápio e pedidos, `HashMap` para as mesas
- **Exceções customizadas**: `MesaIndisponivelException` e `ItemNaoEncontradoException`
- **Try-catch**: tratamento de erros ao abrir pedido, adicionar item e fechar conta

## Exemplo de uso


====== MENU PRINCIPAL ======
1. Ver mesas
2. Abrir pedido em uma mesa
3. Ver cardapio
4. Gerenciar comanda
0. Sair

## Documentação completa

Site da equipe: (link do Google Sites)
