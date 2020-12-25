package dominio.mano;

import java.util.List;

import dominio.carta.Carta;

public class Mano {
    
    protected List<Carta> cartas;

    public Mano(List<Carta> cartas) {
        this.cartas = cartas;
    }

}
