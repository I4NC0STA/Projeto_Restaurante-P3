package model;

// classe base pra todos os itens do cardapio
public abstract class ItemCardapio implements Descricavel {

    private int id;
    private String nome;
    private double preco;
    private String descricao;
    private boolean disponivel;

    public ItemCardapio(int id, String nome, double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.disponivel = true;
    }

    // metodo abstrato, cada tipo de item implementa diferente
    public abstract String getTipo();

    // calcula o preco com possivel adicional (ex: taxa de preparo)
    public double calcularPreco() {
        return this.preco;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + getTipo());
        System.out.println("Preco: R$ " + String.format("%.2f", calcularPreco()));
        System.out.println("Descricao: " + descricao);
        System.out.println("Disponivel: " + (disponivel ? "Sim" : "Nao"));
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    // getters e setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return "[" + getTipo() + "] " + nome + " - R$ " + String.format("%.2f", calcularPreco());
    }
}
