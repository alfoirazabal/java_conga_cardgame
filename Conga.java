import dominio.carta.Carta;
import dominio.carta.Palo;

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

        debugger.ManoInteligenteMonitor monitor = new debugger.ManoInteligenteMonitor();
        Carta[] cartasNuevas = {
            new Carta(0, 6),
            new Carta(1, 8),
            new Carta(2, 8),
            new Carta(0, 4),
            new Carta(0, 8),
            new Carta(3, 8),
            new Carta(0, 7),
            new Carta(0, 5)
        };
        monitor.agregarCartas(cartasNuevas);
        monitor.imprimirJugadas();

    }

}