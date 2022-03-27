package validointi;

public class Henkilo {

    private String nimi;
    private int ika;

    public Henkilo(String nimi, int ika) {
        if (nimi == null || nimi.isEmpty() || nimi.length() > 40) {
            throw new IllegalArgumentException("Antamasi nimi ei ole sopiva.");
        }
        this.nimi = nimi;
        if (ika < 0 || ika > 120) {
            throw new IllegalArgumentException("Iän tulee olla välillä 0-120");
        }

        this.ika = ika;
    }

    public String getNimi() {
        return nimi;
    }

    public int getIka() {
        return ika;
    }
}
