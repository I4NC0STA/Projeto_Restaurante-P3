package model;

public class Cliente extends Pessoa {

    public Cliente(String nome, String telefone) {
        super(nome, telefone);
    }

    @Override
    public void exibirDados() {
        System.out.println("Cliente: " + nome);
    }
}
