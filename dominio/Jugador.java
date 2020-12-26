package dominio;

import dominio.mano.Mano;

public class Jugador {
    
    private String nombre;
    private Mano mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public String getNombre() {
        return this.nombre;
    }

}
