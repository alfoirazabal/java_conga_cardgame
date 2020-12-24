package dominio.carta;

public class Palo {

    public static Palo[] PALOS;

    private String nombre;
    private String emoji;
    private byte ordinal;

    static {
        PALOS = new Palo[4];
        PALOS[0] = new Palo("Basto", "🌵", 0);
        PALOS[1] = new Palo("Oro", "💰", 1);
        PALOS[2] = new Palo("Copa", "🏆", 2);
        PALOS[3] = new Palo("Espada", "🗡️", 3);
    }

    private Palo(String nombre, String emoji, int ordinal) {
        this.nombre = nombre;
        this.emoji = emoji;
        this.ordinal = (byte)ordinal;
    }

    public byte getOrdinal() {
        return this.ordinal;
    }

    @Override
    public String toString() {
        return String.valueOf(this.emoji + " (" + this.nombre + ")");
    }

}
