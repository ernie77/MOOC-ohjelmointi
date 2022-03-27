
import java.util.ArrayList;
import java.util.Random;

public class LottoRivi {

    private ArrayList<Integer> numerot;
    private Random arpoja;

    public LottoRivi() {
        // Arvo numerot heti LottoRivin luomisen yhteydessä
        this.arvoNumerot();
    }

    public ArrayList<Integer> numerot() {
        return this.numerot;
    }

    public void arvoNumerot() {
        // Alustetaan lista numeroille
        this.numerot = new ArrayList<>();
        this.arpoja = new Random();

        // Kirjoita numeroiden arvonta tänne käyttämällä metodia sisaltaaNumeron()
        while (this.numerot.size() < 7) {
            int numero = this.arpoja.nextInt(39) + 1;
            if (!sisaltaaNumeron(numero)) {
                this.numerot.add(numero);
            }
        }
    }

    public boolean sisaltaaNumeron(int numero) {
        // Testaa tässä onko numero jo arvottujen numeroiden joukossa       
        return this.numerot.contains(numero);
    }
}
