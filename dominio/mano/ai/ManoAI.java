package dominio.mano.ai;

import java.util.ArrayList;
import java.util.List;

import dominio.carta.Carta;
import dominio.mano.Mano;

public class ManoAI extends Mano {
    
    private List<List<Carta>> jugadas;

    public ManoAI(List<Carta> cartas) {
        super(cartas);
        this.jugadas = new ArrayList<>();
    }

    public void procesarJugadas() {
        BuscadorDeJugadas buscadorDeJugadas = 
            new BuscadorDeJugadas(this.jugadas, this.cartas);
        buscadorDeJugadas.procesarJugadas();
    }

}
