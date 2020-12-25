import dominio.carta.Carta;
import dominio.carta.Palo;
import dominio.mano.ai.ManoAI;

import java.util.ArrayList;
import java.util.List;

public class Conga {

    public static void main(String[] args) {
        /*Mazo mazo = new Mazo();
        mazo.mezclar();
        
        try {
            Carta levantada = mazo.levantar();
            System.out.println(levantada.getNumero() + levantada.getPalo().getEmoji());
        } catch (NoHayCartasParaLevantar e) {
            e.printStackTrace();
        }

        debugger.CartasShufflingMonitor monitor = new debugger.CartasShufflingMonitor(mazo.getCartasCubiertas());
        monitor.imprimirTabla();*/

        List<Carta> cartas = new ArrayList<>();
        ManoAI manoInteligente = new ManoAI(cartas);
        cartas.add(new Carta(Palo.PALOS[1], 8));
        cartas.add(new Carta(Palo.PALOS[2], 8));
        cartas.add(new Carta(Palo.PALOS[0], 7));
        cartas.add(new Carta(Palo.PALOS[0], 4));
        cartas.add(new Carta(Palo.PALOS[0], 6));
        cartas.add(new Carta(Palo.PALOS[0], 5));
        cartas.add(new Carta(Palo.PALOS[3], 8));
        manoInteligente.procesarJugadas();
    }

}