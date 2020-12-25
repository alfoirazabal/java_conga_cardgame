package debugger;

import java.util.Arrays;
import java.util.List;

import dominio.carta.Carta;
import dominio.mano.ai.ManoAI;

public class ManoInteligenteMonitor {
    
    private ManoAI manoInteligente;

    public ManoInteligenteMonitor() {
        this.manoInteligente = new ManoAI();
    }

    public void agregarCarta(Carta carta) {
        this.manoInteligente.levantar(carta);
    }

    public void agregarCartas(List<Carta> cartasNuevas) {
        this.manoInteligente.setCartas(cartasNuevas);
    }

    public void agregarCartas(Carta[] cartasNuevas) {
        this.manoInteligente.setCartas(Arrays.asList(cartasNuevas));
    }

    public void limpiarCartas() {
        this.manoInteligente.getCartas().clear();
        this.manoInteligente.getJugadas().clear();
    }

    public void imprimirJugadas() {
        System.out.println("--------------");
        List<Carta> cartas = this.manoInteligente.getCartas();
        System.out.println("CARTAS");
        for (Carta carta : cartas) {
            System.out.println(carta.getPalo().getEmoji() + carta.getNumero());
        }
        this.manoInteligente.procesarJugadas();
        List<List<Carta>> jugadas = this.manoInteligente.getJugadas();
        for (List<Carta> jugada : jugadas) {
            System.out.println("JUGADA");
            for (Carta carta : jugada) {
                System.out.println(carta.getPalo().getEmoji() + carta.getNumero());
            }
        }
    }

}
