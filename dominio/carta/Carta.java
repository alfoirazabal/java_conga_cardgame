package dominio.carta;

import java.util.Comparator;

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

    public static class Comparators {

        public static Comparator<Carta> IDENTIFICADOR = new Comparator<>() {

            @Override
            public int compare(Carta carta1, Carta carta2) {
                return carta1.getIdentificador() - carta2.getIdentificador();
            }

        };

        public static Comparator<Carta> NUMERO = new Comparator<>() {

            @Override
            public int compare(Carta carta1, Carta carta2) {
                int numeroDeCarta1 = (int) carta1.getNumero();
                int numeroDeCarta2 = (int) carta2.getNumero();
                return numeroDeCarta1 - numeroDeCarta2;
            }

        };

        public static Comparator<Carta> PALO = new Comparator<>() {

            @Override
            public int compare(Carta carta1, Carta carta2) {
                Palo paloCarta1 = carta1.getPalo();
                Palo paloCarta2 = carta2.getPalo();
                return paloCarta1.getOrdinal() - paloCarta2.getOrdinal();
            }

        };

    }

}
