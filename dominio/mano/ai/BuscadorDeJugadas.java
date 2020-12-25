package dominio.mano.ai;

import java.util.List;

import dominio.carta.Carta;

public class BuscadorDeJugadas {
    
    private List<List<Carta>> jugadas;
    private List<Carta> cartas;

    public BuscadorDeJugadas(List<List<Carta>> jugadas, List<Carta> cartas) {
        this.jugadas = jugadas;
        this.cartas = cartas;
    }

    public void procesarJugadas() {
        Escalera escalera = new Escalera(jugadas, cartas);
        escalera.buscar();
        
        Pie pie = new Pie(jugadas, cartas);
        pie.buscar();
    }

}
