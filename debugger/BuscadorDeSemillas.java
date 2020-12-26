package debugger;

import java.util.ArrayList;
import java.util.List;

import dominio.Mazo;
import dominio.Mazo.NoHayCartasParaLevantar;
import dominio.carta.Carta;
import dominio.mano.ai.ManoAI;

public class BuscadorDeSemillas {

    private int maximoDeIntentos;
    private int numeroDeJugadas;
    private boolean listoParaCortar;
    private boolean outputDelProceso;

    public BuscadorDeSemillas() {
        this.maximoDeIntentos = 10000;
        this.numeroDeJugadas = 2;
        this.listoParaCortar = false;
        this.outputDelProceso = true;
    }

    public void imprimirSemillas() throws ImposibleCortar {
        List<Integer> semillas = getSemillas();
        System.out.println("IMPRIMIENDO SEMILLAS ENCONTRADAS");
        for (int semilla : semillas) {
            System.out.println("Semilla: " + semilla);
        }
        System.out.println("--------------------------------");
    }
    
    public List<Integer> getSemillas()
            throws ImposibleCortar {

        if (this.numeroDeJugadas == 1 && this.listoParaCortar == true) {
            throw new ImposibleCortar();
        }

        int semillaActual = 0;
        int intentosActuales = 0;
        
        int ultimoMarcador = 0;
        int cantidadMarcable = this.maximoDeIntentos / 100;
        int porcentajeActualCompleto = 0;
        int marcador = 0;

        List<Integer> semillas = new ArrayList<>();

        while (intentosActuales < this.maximoDeIntentos) {
            Mazo mazo = new Mazo();
            mazo.mezclar(semillaActual);
            ManoAI mano = new ManoAI();
            repartir(mano, mazo);
            mano.procesarJugadas();
            List<List<Carta>> jugadas = mano.getJugadas();
            int jugadasEncontradas = jugadas.size();
            if (jugadasEncontradas == this.numeroDeJugadas) {
                if (this.listoParaCortar) {
                    int cartasEnJugada = 0;
                    for (int i = 0 ; i < jugadas.size() ; i++)
                    if (cartasEnJugada == mano.getCartas().size()) {
                        semillas.add(semillaActual);
                    }
                }
                else {
                    semillas.add(semillaActual);
                }
            }

            semillaActual++;
            intentosActuales++;
            
            if (this.outputDelProceso) {
                if (marcador == ultimoMarcador + cantidadMarcable) {
                    ultimoMarcador = marcador;
                    System.out.println(marcador + " semillas buscadas... (" + 
                        porcentajeActualCompleto + "%)");
                    porcentajeActualCompleto++;
                }
                marcador++;
            }

        }

        return semillas;
    }

    private void repartir(ManoAI mano, Mazo mazo) {
        for (int i = 0; i < 7; i++) {
            try {
                mano.levantar(mazo.levantar());
            } catch (NoHayCartasParaLevantar e) {
                e.printStackTrace();
            }
        }
    }

    public void setMaximoDeIntentos(int maximoDeIntentos) {
        this.maximoDeIntentos = maximoDeIntentos;
    }

    public void setNumeroDeJugadas(int numeroDeJugadas) {
        this.numeroDeJugadas = numeroDeJugadas;
    }

    public void setListoParaCortar(boolean listoParaCortar) {
        this.listoParaCortar = listoParaCortar;
    }

    public void setOutputDelProceso(boolean outputDelProceso) {
        this.outputDelProceso = outputDelProceso;
    }

    public class ImposibleCortar extends Exception {

        private static final long serialVersionUID = -1739054224835571003L;

        @Override
        public String getMessage() {
            return "Imposible cortar si se busca 1 sola jugada";
        }

    }

}
