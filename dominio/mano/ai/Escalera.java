package dominio.mano.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import dominio.carta.Carta;

public class Escalera {
    
    private List<List<Carta>> jugadas;
    private List<Carta> cartas;

    public Escalera(List<List<Carta>> jugadas, List<Carta> cartas) {
        this.jugadas = jugadas;
        this.cartas = cartas;
    }

    public void buscar() {
        for (int i = 0 ; i < this.cartas.size() ; i++) {
            buscarEscalera(i);
        }
    }

    private void buscarEscalera(int indiceDeCartaEnMano) {
        Carta cartaActual = this.cartas.get(indiceDeCartaEnMano);
        if (!cartaExisteEnJugadas(cartaActual)) {
            boolean agregadaAPosibleJugada = agregarAJugada(cartaActual);
            if (!agregadaAPosibleJugada) {
                // Busco escalera con cartas disponibles (no en jugadas)
                List<Carta> cartasSinJugada = obtenerCartasSinJugadas();
                cartasSinJugada.remove(cartaActual);
                buscarFormarEscalera(cartaActual, cartasSinJugada);
            }
        }
    }

    private void buscarFormarEscalera(Carta cartaActual, List<Carta> cartasSinJugada) {
        List<Carta> cartasMismoPalo = cartasSinJugada.stream().filter(
            e -> e.getPalo() == cartaActual.getPalo()
        ).collect(Collectors.toList());
        List<Carta> posibleEscalera = new ArrayList<>();
        posibleEscalera.addAll(cartasMismoPalo);
        posibleEscalera.add(cartaActual);
        Collections.sort(posibleEscalera);
        int cantidadEnEscalera = 1;
        boolean escaleraRota = false;
        for (int i = 0 ; !escaleraRota && i < posibleEscalera.size() - 1 ; i++) {
            Carta cartaDelIndice = posibleEscalera.get(i);
            Carta cartaSiguiente = posibleEscalera.get(i + 1);
            escaleraRota = (cartaDelIndice.getNumero() + 1 != cartaSiguiente.getNumero());
            if (!escaleraRota) {
                cantidadEnEscalera++;
            }
        }
        if (cantidadEnEscalera >= ManoAI.CANTIDAD_MAXIMA_EN_JUGADA) {
            // Hago jugada de 4
            List<Carta> jugada = new ArrayList<>();
            for (int i = 0 ; i < ManoAI.CANTIDAD_MAXIMA_EN_JUGADA ; i++) {
                jugada.add(posibleEscalera.get(i));
            }
            this.jugadas.add(jugada);
        }
        else if (cantidadEnEscalera >= ManoAI.CANTIDAD_MINIMA_EN_JUGADA) {
            // Hago jugada de 3
            List<Carta> jugada = new ArrayList<>();
            for (int i = 0 ; i < ManoAI.CANTIDAD_MINIMA_EN_JUGADA ; i++) {
                jugada.add(posibleEscalera.get(i));
            }
            this.jugadas.add(jugada);
        }

    }

    private boolean agregarAJugada(Carta carta) {
        // Agregar una posible carta a una jugada en escalera de 3
        boolean agregadaAJugada = false;
        for (int i = 0 ; i < this.jugadas.size() ; i++) {
            List<Carta> jugadaActual = this.jugadas.get(i);
            if (jugadaEsEscaleraDeTres(jugadaActual)) {
                if (coincidePaloConJugada(carta, jugadaActual)) {
                    Carta[] extremosDeEscalera = obtenerExtremosDeEscalera(jugadaActual);
                    if (extremosDeEscalera[0].getNumero() - 1 == carta.getNumero()) {
                        jugadaActual.add(0, carta);
                    }
                    else if (extremosDeEscalera[1].getNumero() + 1 == carta.getNumero()) {
                        jugadaActual.add(jugadaActual.size(), carta);
                    }
                }
            }
        }
        return agregadaAJugada;
    }

    private boolean coincidePaloConJugada(Carta carta, List<Carta> jugada) {
        return carta.getPalo() == jugada.get(0).getPalo();
    }

    private Carta[] obtenerExtremosDeEscalera(List<Carta> cartas) {
        Carta[] extremos = new Carta[2];
        extremos[0] = cartas.get(0);
        extremos[1] = cartas.get(2);
        return extremos;
    }

    private boolean jugadaEsEscaleraDeTres(List<Carta> cartas) {
        boolean diferentesNumeros = cartas.get(0).getNumero() != cartas.get(1).getNumero();
        boolean sonTresCartas = cartas.size() == 3;
        return diferentesNumeros && sonTresCartas;
    }

    private List<Carta> obtenerCartasSinJugadas() {
        List<Carta> cartasSinJugadas = new ArrayList<>();
        Iterator<Carta> todasLasCartas = this.cartas.iterator();
        while (todasLasCartas.hasNext()) {
            Carta cartaActual = todasLasCartas.next();
            if (!cartaExisteEnJugadas(cartaActual)) {
                cartasSinJugadas.add(cartaActual);
            }
        }
        return cartasSinJugadas;
    }

    private boolean cartaExisteEnJugadas(Carta carta) {
        boolean existe = false;
        for (int i = 0 ; !existe && i < this.jugadas.size() ; i++) {
            List<Carta> jugadaActual = this.jugadas.get(i);
            existe = jugadaActual.contains(carta);
        }
        return existe;
    }

}
