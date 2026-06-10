package model;

// interface pra coisas que podem ser pagas
public interface Pagavel {
    double calcularTotal();
    void pagar(double valor);
    boolean isPago();
}
