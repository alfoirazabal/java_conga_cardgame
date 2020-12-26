import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import debugger.BuscadorDeSemillas;
import debugger.BuscadorDeSemillas.ImposibleCortar;
import dominio.Mazo;
import dominio.Mazo.NoHayCartasParaLevantar;
import dominio.carta.Carta;
import dominio.mano.ai.ManoAI;

public class Conga {

    private static Mazo mazo;
    private static ManoAI mano;

    public static void main(String[] args) {

        /*
         * mazo = new Mazo(); mazo.mezclar(4378); mano = new ManoAI(); repartir();
         * debugger.CartasShufflingMonitor monitor = new
         * debugger.CartasShufflingMonitor(mazo.getCartasDescubiertas());
         * System.out.println("CARTAS DESCUBIERTAS:"); monitor.imprimirTabla();
         * System.out.println("CARTAS CUBIERTAS:");
         * monitor.setCartas(mazo.getCartasCubiertas()); monitor.imprimirTabla();
         * System.out.println("CARTAS DEL JUGADOR:");
         * monitor.setCartas(mano.getCartas()); monitor.imprimirTabla();
         * mano.procesarJugadas(); System.out.println("IMPRIMIENDO JUGADAS..."); for
         * (int i = 0 ; i < mano.getJugadas().size() ; i++) {
         * System.out.println("IMPRIMIENDO JUGADA " + (i + 1));
         * monitor.setCartas(mano.getJugadas().get(i)); monitor.imprimirTabla(); }
         * System.out.println("JUGADAS IMPRESAS.");
         */

        /*
         * List<Integer> semillas; try { semillas = buscarSemillas(50000000, 2, true);
         * System.out.println("Semillas encontradas: ");
         * System.out.println(Arrays.toString(semillas.toArray())); } catch
         * (Conga.ImposibleCortar e) { e.printStackTrace(); }
         */

        try {
            debugger.BuscadorDeSemillas buscador = new debugger.BuscadorDeSemillas();
            buscador.setMaximoDeIntentos(40000);
            buscador.imprimirSemillas();
        } catch (ImposibleCortar e) {
            e.printStackTrace();
        }

    }

}