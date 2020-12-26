package dominio.carta;

public class Carta implements Comparable<Carta> {

    private Palo palo;
    private byte numero;

    public Carta(Palo palo, int numero) {
        this.palo = palo;
        this.numero = (byte)numero;
    }

    public Carta(int numeroDePalo, int numero) {
        this.palo = Palo.PALOS[numeroDePalo];
        this.numero = (byte)numero;
    }

    public Palo getPalo() {
        return this.palo;
    }

    public byte getNumero() {
        return this.numero;
    }

    public byte getIdentificador() {
        int numeroDePalo = this.getPalo().getOrdinal();
        int numeroDeCarta = this.getNumero();
        int identificador = (numeroDePalo * 12) + numeroDeCarta;
        return (byte)identificador;
    }

    @Override
    public String toString() {
        return this.getIdentificador() + " - " + this.getNumero() + " de " + this.getPalo().toString().toLowerCase();
    }

    @Override
    public int compareTo(Carta otraCarta) {
        int numeroEstaCarta = (int) this.getNumero();
        int numeroOtraCarta = (int) otraCarta.getNumero();
        return numeroEstaCarta - numeroOtraCarta;
    }

}
