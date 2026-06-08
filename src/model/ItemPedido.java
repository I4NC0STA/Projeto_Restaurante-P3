package model;

// representa um item dentro de um pedido
public class ItemPedido {

    private ItemCardapio item;
    private int quantidade;
    private String observacao;

    public ItemPedido(ItemCardapio item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
        this.observacao = "";
    }

    public ItemPedido(ItemCardapio item, int quantidade, String observacao) {
        this.item = item;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    public double getSubtotal() {
        return item.calcularPreco() * quantidade;
    }

    public ItemCardapio getItem() { return item; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String obs) { this.observacao = obs; }

    @Override
    public String toString() {
        String linha = quantidade + "x " + item.getNome() +
                " - R$ " + String.format("%.2f", getSubtotal());
        if (!observacao.isEmpty()) {
            linha += " (obs: " + observacao + ")";
        }
        return linha;
    }
}

