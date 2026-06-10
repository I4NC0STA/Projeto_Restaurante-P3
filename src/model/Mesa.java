package model;

<<<<<<< HEAD
public class Mesa {

    private int numero;
    private boolean ocupada;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    // retorna o numero da mesa
    public int getNumero() {
        return numero;
    }

    // verifica se a mesa esta ocupada
    public boolean isOcupada() {
        return ocupada;
    }

    // marca a mesa como ocupada
    public void ocuparMesa() {
        ocupada = true;
    }

    // libera a mesa se ela tiver desocupada
    public void liberarMesa() {
        ocupada = false;
    }
}
=======
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

>>>>>>> 029ab46923407a50790130a711724c22c25fe2d6
