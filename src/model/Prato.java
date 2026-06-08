package model;

// prato principal do cardapio
public class Prato extends ItemCardapio {

    private String categoria; // ex: "Carnes", "Massas", "Vegetariano"
    private int tempoPreparo; // em minutos

    public Prato(int id, String nome, double preco, String descricao, String categoria, int tempoPreparo) {
        super(id, nome, preco, descricao);
        this.categoria = categoria;
        this.tempoPreparo = tempoPreparo;
    }

    @Override
    public String getTipo() {
        return "Prato";
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Categoria: " + categoria);
        System.out.println("Tempo de preparo: " + tempoPreparo + " min");
    }

    public String getCategoria() { return categoria; }
    public int getTempoPreparo() { return tempoPreparo; }
}
