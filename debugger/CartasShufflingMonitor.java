package debugger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dominio.carta.Carta;
import dominio.carta.Palo;

public class CartasShufflingMonitor {

    private List<Carta> cartas;

    private Scanner sc = new Scanner(System.in);

    public CartasShufflingMonitor(List<Carta> cartas) {
        this.setCartas(cartas);
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public void imprimirTabla() {

        String formateoTabla = "| %-2d |";
        for (int i = 0 ; i < Palo.PALOS.length ; i++) {
            formateoTabla += " %-2s |";
        }
        formateoTabla += "%n";

        imprimirEncabezadoTabla();

        for (int i = 1 ; i <= 12 ; i++) {
            String[] indicadorPalo = new String[Palo.PALOS.length];
            for (int j = 0 ; j < Palo.PALOS.length ; j++) {
                boolean paloIncluido = cartaImpresa(this.cartas, Palo.PALOS[j], i);
                if (paloIncluido) {
                    indicadorPalo[j] = "X";
                } 
                else {
                    indicadorPalo[j] = " ";
                }
            }

            System.out.format(formateoTabla, i, indicadorPalo[0], indicadorPalo[1], indicadorPalo[2], indicadorPalo[3]);

        }

        imprimirBordeDeTablaHorizontal();

    }

    public void imprimirTablaPasoAPaso() {

        List<Carta> aImprimir = new ArrayList<>();
        aImprimir.addAll(this.cartas);
        List<Carta> impresas = new ArrayList<>();

        System.out.println("\n\n\n\n\n\n\n\n\n\n");

        String formateoTabla = "| %-2d |";
        for (int i = 0 ; i < Palo.PALOS.length ; i++) {
            formateoTabla += " %-2s |";
        }
        formateoTabla += "%n";

        while (aImprimir.size() > 0) {

            impresas.add(aImprimir.get(0));
            aImprimir.remove(0);

            imprimirEncabezadoTabla();

            for (int i = 1 ; i <= 12 ; i++) {
                String[] indicadorPalo = new String[Palo.PALOS.length];
                for (int j = 0 ; j < Palo.PALOS.length ; j++) {
                    boolean paloIncluido = cartaImpresa(impresas, Palo.PALOS[j], i);
                    if (paloIncluido) {
                        indicadorPalo[j] = "X";
                    } 
                    else {
                        indicadorPalo[j] = " ";
                    }
                }

                System.out.format(formateoTabla, i, indicadorPalo[0], indicadorPalo[1], indicadorPalo[2], indicadorPalo[3]);

            }

            imprimirBordeDeTablaHorizontal();

            this.sc.nextLine();
        }

    }

    private void imprimirEncabezadoTabla() {
        imprimirBordeDeTablaHorizontal();
        String celdas = "|    |";
        for (int i = 0 ; i < Palo.PALOS.length ; i++) {
            celdas += " " + Palo.PALOS[i].getEmoji() + " |";
        }
        celdas += "%n";
        System.out.format(celdas);
        imprimirBordeDeTablaHorizontal();
    }

    private void imprimirBordeDeTablaHorizontal() {
        String borde = "+----+";
        for (int i = 0 ; i < Palo.PALOS.length ; i++) {
            borde += "----+";
        }
        borde += "%n";
        System.out.format(borde);
    }

    private boolean cartaImpresa(List<Carta> impresas, Palo palo, int numero) {

        boolean contenida = false;
        Iterator<Carta> itImpresas = impresas.iterator();
        while (!contenida && itImpresas.hasNext()) {
            Carta actual = itImpresas.next();
            contenida = (
                actual.getPalo() == palo && 
                actual.getNumero() == numero
            );
        }
        return contenida;

    }

    public void imprimirListaDeCartas(List<Carta> cartas) {
        for (Carta carta : cartas) {
            String espacioExtra = "";
            if (carta.getNumero() < 10){
                espacioExtra = " ";
            }
            System.out.println(carta.getNumero() + espacioExtra + " " + carta.getPalo().getEmoji());
        }
    }

}
