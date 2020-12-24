package dominio.algoritmos;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffler {

    private Random random;

    public Shuffler() {
        this.random = new Random();
    }

    public void setSeed(int seed) {
        this.random.setSeed(seed);
    }

    public void shuffle(List<?> objects) {
        Collections.shuffle(objects, this.random);
    }

}
