package model;

public class Funcionario extends Pessoa {

    protected String cargo;

    public Funcionario(String nome, String telefone, String cargo) {
        super(nome, telefone);
        this.cargo = cargo;
    }

    @Override
    public void exibirDados() {
        System.out.println("Funcionário: " + nome);
    }
}
