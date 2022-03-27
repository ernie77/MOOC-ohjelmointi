
import java.util.Scanner;
import robotti.Ohjain;

public class VapaaRobotti {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Ohjain.kaynnista();
        // kokeile metodejasi täällä
        piirraNelio(100);
        piirraKolmio(100);
        piirraYmpyra(20, 18);
        Ohjain.sammuta();
    }

    public static void piirraNelio(int sivunPituus) {
        for (int i = 0; i < 4; i++) {
            Ohjain.liiku(sivunPituus);
            Ohjain.oikea(90);
        }
    }

    public static void piirraKolmio(int sivunPituus) {
        for (int i = 0; i < 3; i++) {
            Ohjain.liiku(sivunPituus);
            Ohjain.vasen(120);
        }
    }

    public static void piirraYmpyra(int sivunPituus, int kulma) {
        for (int i = 0; i < kulma; i++) {
            Ohjain.liiku(sivunPituus);
            Ohjain.vasen(360 / kulma);
        }
    }
    // ohjelmoi metodit tänne
}
