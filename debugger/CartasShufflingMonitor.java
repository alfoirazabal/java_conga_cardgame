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
        this.cartas = cartas;
    }

    public void imprimirTabla() {

        List<Carta> aImprimir = new ArrayList<>();
        aImprimir.addAll(this.cartas);
        List<Carta> impresas = new ArrayList<>();

        System.out.println("\n\n\n\n\n\n\n\n\n\n");

        String formateoTabla = "| %-2d | %-1s | %-1s | %-1s | %-1s |%n";

        while (aImprimir.size() > 0) {

            impresas.add(aImprimir.get(0));
            aImprimir.remove(0);

            System.out.format("+----+---+---+---+---+%n");
            System.out.format("|    | b | o | c | e |%n");
            System.out.format("+----+---+---+---+---+%n");

            for (int i = 1 ; i <= 12 ; i++) {
                String[] indicadorPalo = new String[4];
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

            System.out.format("+----+---+---+---+---+%n");

            this.sc.nextLine();
        }

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

}
