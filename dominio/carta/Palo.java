package dominio.carta;

public class Palo {

    public static Palo[] PALOS = {
        new Palo("Basto", "🌵", 0),
        new Palo("Oro", "💰", 1),
        new Palo("Copa", "🏆", 2),
        new Palo("Espada", "🗡️ ", 3)
    };

    private String nombre;
    private String emoji;
    private byte ordinal;

    private Palo(String nombre, String emoji, int ordinal) {
        this.nombre = nombre;
        this.emoji = emoji;
        this.ordinal = (byte)ordinal;
    }

    public String getEmoji() {
        return this.emoji;
    }

    public byte getOrdinal() {
        return this.ordinal;
    }

    @Override
    public String toString() {
        return String.valueOf(this.emoji + " (" + this.nombre + ")");
    }

}
