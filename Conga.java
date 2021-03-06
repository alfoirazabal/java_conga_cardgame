import dominio.carta.Carta;
import dominio.Mazo;
import dominio.Mazo.NoHayCartasParaLevantar;

public class Conga {

    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        mazo.mezclar();
        
        try {
            Carta levantada = mazo.levantar();
            System.out.println(levantada.getNumero() + levantada.getPalo().getEmoji());
        } catch (NoHayCartasParaLevantar e) {
            e.printStackTrace();
        }

        debugger.CartasShufflingMonitor monitor = new debugger.CartasShufflingMonitor(mazo.getCartasCubiertas());
        monitor.imprimirListaDeCartas(mazo.getCartasCubiertas());
    }

}