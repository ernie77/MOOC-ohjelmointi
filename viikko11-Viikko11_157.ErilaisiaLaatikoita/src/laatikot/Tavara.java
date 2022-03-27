package laatikot;

public class Tavara {

    private String nimi;
    private int paino;

    public Tavara(String nimi, int paino) {

        this.nimi = nimi;
        if (paino < 0) {
            throw new IllegalArgumentException("Paino ei voi olla negatiivinen");
        }
        this.paino = paino;
    }

    public Tavara(String nimi) {
        this(nimi, 0);
    }

    public String getNimi() {
        return nimi;
    }

    public int getPaino() {
        return paino;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tavara verrattava = (Tavara) obj;
        return this.nimi.equals(verrattava.nimi);
    }

    @Override
    public int hashCode() {
        return this.nimi.hashCode();
    }
}
