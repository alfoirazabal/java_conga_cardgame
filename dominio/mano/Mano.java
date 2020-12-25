package dominio.mano;

import java.util.ArrayList;
import java.util.List;

import dominio.carta.Carta;

public class Mano {
    
    protected List<Carta> cartas;

    public Mano() {
        this.cartas = new ArrayList<>();
    }
    
    public Mano(List<Carta> cartas) {
        this.cartas = cartas;
    }

	public List<Carta> getCartas() {
        return this.cartas;
    }

    public void setCartas(List<Carta> cartasNuevas) {
        this.cartas.clear();
        this.cartas.addAll(cartasNuevas);
    }

    public void levantar(Carta carta) {
        this.cartas.add(carta);
    }

    public void tirar(Carta carta) {
        this.cartas.remove(carta);
    }

}
