package dominio.mano.ai;

import java.util.ArrayList;
import java.util.List;

import dominio.carta.Carta;
import dominio.mano.Mano;

public class ManoAI extends Mano {

    public static int CANTIDAD_MAXIMA_EN_JUGADA = 4;
    public static int CANTIDAD_MINIMA_EN_JUGADA = 3;
    
    private List<List<Carta>> jugadas;

    public ManoAI() {
        super();
        this.jugadas = new ArrayList<>();
    }

    public ManoAI(List<Carta> cartas) {
        super(cartas);
        this.jugadas = new ArrayList<>();
    }

	public void procesarJugadas() {
        BuscadorDeJugadas buscadorDeJugadas = 
            new BuscadorDeJugadas(this.jugadas, this.cartas);
        buscadorDeJugadas.procesarJugadas();
    }

    public List<List<Carta>> getJugadas() {
        return this.jugadas;
    }

    @Override
    public void setCartas(List<Carta> cartasNuevas) {
        super.setCartas(cartasNuevas);
        this.jugadas.clear();
    }

}
