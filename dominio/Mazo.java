package dominio;

import java.util.ArrayList;
import java.util.List;

import dominio.algoritmos.Shuffler;
import dominio.carta.*;

public class Mazo {
    
    private List<Carta> cartasCubiertas;
    private List<Carta> cartasDescubiertas;

    public Mazo() {
        this.cartasCubiertas = new ArrayList<>();
        this.cartasDescubiertas = new ArrayList<>();
        for(int i = 0 ; i < Palo.PALOS.length ; i++) {
            for(int j = 1 ; j <= 12 ; j++) {
                Carta nuevaCarta = new Carta(Palo.PALOS[i], j);
                this.cartasCubiertas.add(nuevaCarta);
            }
        }
    }

    public void mezclar() {
        Shuffler shuffler = new Shuffler();
        shuffler.shuffle(this.cartasCubiertas);
    }

    public void cubrirTodas() {
        this.cartasCubiertas.addAll(this.cartasDescubiertas);
        this.cartasDescubiertas.clear();
    }

    public Carta levantar() throws NoHayCartasParaLevantar {
        if (this.cartasCubiertas.size() == 0) {
            throw new NoHayCartasParaLevantar();
        }
        else {
            Carta cartaCubierta =
                this.cartasCubiertas.get(0);
            this.cartasCubiertas.remove(cartaCubierta);
            return cartaCubierta;
        }
    }

    public Carta sacar() throws NoHayCartasParaSacar {
        if (this.cartasDescubiertas.size() == 0) {
            throw new NoHayCartasParaSacar();
        }
        else {
            Carta cartaDescubierta = 
                this.cartasDescubiertas.get(0);
            this.cartasDescubiertas.remove(cartaDescubierta);
            return cartaDescubierta;
        }
    }

    public void Tirar(Carta carta) {
        this.cartasDescubiertas.add(0, carta);
    }

    public List<Carta> getCartasCubiertas() {
        return this.cartasCubiertas;
    }

    public List<Carta> getCartasDescubiertas() {
        return this.cartasDescubiertas;
    }

    public class NoHayCartasParaLevantar extends Exception {
        
        private static final long serialVersionUID = 891586948757381012L;

        @Override
        public String getMessage() {
            return "No hay cartas descubiertas para levantar.";
        }

    }

    public class NoHayCartasParaSacar extends Exception {

        private static final long serialVersionUID = 7738547119491160080L;

        @Override
        public String getMessage() {
            return "No hay cartas cubiertas para sacar.";
        }

    }
    
}
