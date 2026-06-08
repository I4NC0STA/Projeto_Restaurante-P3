package model;

// bebidas do cardapio
public class Bebida extends ItemCardapio {

    private double volume; // em ml
    private boolean alcoolica;

    public Bebida(int id, String nome, double preco, String descricao, double volume, boolean alcoolica) {
        super(id, nome, preco, descricao);
        this.volume = volume;
        this.alcoolica = alcoolica;
    }

    @Override
    public String getTipo() {
        return "Bebida";
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Volume: " + volume + "ml");
        System.out.println("Alcoolica: " + (alcoolica ? "Sim" : "Nao"));
    }

    public double getVolume() { return volume; }
    public boolean isAlcoolica() { return alcoolica; }
}

