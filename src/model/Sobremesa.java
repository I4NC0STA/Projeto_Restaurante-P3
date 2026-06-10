package model;

// sobremesas tem um preparo especial entao tem taxa
public class Sobremesa extends ItemCardapio {

    private boolean gelada;
    private static final double TAXA_PREPARO = 2.00; // taxa fixa de R$2 por ser artesanal

    public Sobremesa(int id, String nome, double preco, String descricao, boolean gelada) {
        super(id, nome, preco, descricao);
        this.gelada = gelada;
    }

    @Override
    public String getTipo() {
        return "Sobremesa";
    }

    // sobremesa tem taxa de preparo
    @Override
    public double calcularPreco() {
        return super.calcularPreco() + TAXA_PREPARO;
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Gelada: " + (gelada ? "Sim" : "Nao"));
        System.out.println("(inclui taxa de preparo artesanal: R$ " + String.format("%.2f", TAXA_PREPARO) + ")");
    }

    public boolean isGelada() { return gelada; }
}
