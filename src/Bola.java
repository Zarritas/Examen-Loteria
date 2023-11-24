public class Bola {
    private int numero;

    public Bola(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "("+ numero +")";
    }
}
