package model;

// representa uma mesa do restaurante
public class Mesa {

    public enum Situacao {
        LIVRE, OCUPADA, RESERVADA
    }

    private int numero;
    private int capacidade;
    private Situacao situacao;

    public Mesa(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.situacao = Situacao.LIVRE;
    }

    public void ocupar() {
        this.situacao = Situacao.OCUPADA;
    }

    public void liberar() {
        this.situacao = Situacao.LIVRE;
    }

    public void reservar() {
        this.situacao = Situacao.RESERVADA;
    }

    public boolean isLivre() {
        return situacao == Situacao.LIVRE;
    }

    public int getNumero() { return numero; }
    public int getCapacidade() { return capacidade; }
    public Situacao getSituacao() { return situacao; }

    @Override
    public String toString() {
        return "Mesa " + numero + " | Capacidade: " + capacidade + " | Status: " + situacao;
    }
}