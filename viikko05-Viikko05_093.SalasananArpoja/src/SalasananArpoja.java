
import java.util.Random;

public class SalasananArpoja {

    // Määrittele muuttuja tässä
    private Random arpoja;
    private int luku;
    private String salasana;
    private int i;
    public SalasananArpoja(int salasananPituus) {
        // Alusta muuttujat tässä
        this.arpoja = new Random();
        this.luku = salasananPituus;
        this.salasana = "";
        this.i = 0;
        
    }

    public String luoSalasana() {
        // Kirjoita tähän koodi, joka palauttaa uuden salasanan
        this.salasana = "";
        this.i = 0;

        while (i < this.luku) {
            char merkki = "abcdefghijklmnopqrstuvwxyz".charAt(this.arpoja.nextInt(26));
            salasana = salasana + merkki;
            i++;
        }
        return salasana;
    }
}
