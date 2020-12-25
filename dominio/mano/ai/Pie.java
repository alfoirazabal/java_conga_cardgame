package dominio.mano.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import dominio.carta.Carta;

public class Pie {
    
    private List<List<Carta>> jugadas;
    private List<Carta> cartas;

    public Pie(List<List<Carta>> jugadas, List<Carta> cartas) {
        this.jugadas = jugadas;
        this.cartas = cartas;
    }

    public void buscar() {
        List<Carta> cartasNoJugadas = getCartasNoJugadas();
        buscarCrearJugada(cartasNoJugadas);
        cartasNoJugadas = getCartasNoJugadas();
        for (Carta cartaNoJugada : cartasNoJugadas) {
            buscarAgregarAJugadaExistente(cartaNoJugada);
        }
    }

    private void buscarCrearJugada(List<Carta> cartasNoJugadas) {
        for (Carta cartaNoJugada : cartasNoJugadas) {
            buscarCrearJugadaParaCarta(cartaNoJugada, cartasNoJugadas);
        }
    }

    private void buscarCrearJugadaParaCarta(Carta carta, List<Carta> cartasNoJugadas) {
        List<Carta> cartasMismoNumero = cartasNoJugadas.stream().filter(
            e -> e.getNumero() == carta.getNumero()
        ).collect(Collectors.toList());
        if (cartasMismoNumero.size() >= 3) {
            crearJugada(cartasMismoNumero);
        }
    }

    private void crearJugada(List<Carta> cartasAJugada) {
        this.jugadas.add(cartasAJugada);
    }

    private void buscarAgregarAJugadaExistente(Carta cartaNoJugada) {
        List<List<Carta>> jugadasEnPie = getJugadasEnPie();
        Optional<List<Carta>> optJugadaEnPieDeTresDelMismoPalo = jugadasEnPie.stream().filter(
            e -> e.size() >= 2 && e.get(0).getPalo() == cartaNoJugada.getPalo()
        ).findFirst();
        if (optJugadaEnPieDeTresDelMismoPalo.isPresent()) {
            List<Carta> jugadaEnPieDeTresDelMismoPalo = optJugadaEnPieDeTresDelMismoPalo.get();
            jugadaEnPieDeTresDelMismoPalo.add(cartaNoJugada);
        }
    }

    private List<List<Carta>> getJugadasEnPie() {
        List<List<Carta>> jugadasEnPie = new ArrayList<>();
        for (int i = 0 ; i < this.jugadas.size() ; i++) {
            List<Carta> jugadaActual = this.jugadas.get(i);
            if (jugadaEsPie(jugadaActual)) {
                jugadasEnPie.add(jugadaActual);
            }
        }
        return jugadasEnPie;
    }

    private boolean jugadaEsPie(List<Carta> jugada) {
        return jugada.get(0).getNumero() == jugada.get(1).getNumero();
    }

    private List<Carta> getCartasNoJugadas() {
        List<Carta> cartasNoJugadas = new ArrayList<>();
        for (int i = 0 ; i < this.cartas.size() ; i++) {
            Carta cartaActual = this.cartas.get(i);
            boolean cartaActualJugada = false;
            for (int j = 0 ; !cartaActualJugada && j < this.jugadas.size() ; j++) {
                cartaActualJugada = this.jugadas.get(j).contains(cartaActual);
            }
            if (!cartaActualJugada) {
                cartasNoJugadas.add(cartaActual);
            }
        }
        return cartasNoJugadas;
    }
    
}
