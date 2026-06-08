package model;

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