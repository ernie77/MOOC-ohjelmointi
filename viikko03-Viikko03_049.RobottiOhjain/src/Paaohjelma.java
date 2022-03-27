
import java.util.Scanner;
import robotti.Ohjain;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Ohjain.kaynnista();

        // ohjelmoi liikkeet tänne
        ylanurkka(5);
        nelio(5, 7);
        nelio(2, 3);
        Ohjain.sammuta();
    }
    public static void ylanurkka (int korkeus) {
        for (int k = 0; k < korkeus; k++) {
            Ohjain.ylos();
        }
    }
    public static void nelio(int korkeus, int leveys) {
        int k = 0;
        int l = 0;
        for (k = 0; k < korkeus; k++) {
            Ohjain.alas();
        }
        for (l = 0; l < leveys; l++) {
            Ohjain.oikealle();
        }
        for (k = 0; k < korkeus; k++) {
            Ohjain.ylos();
        }
        for (l = 0; l < leveys; l++) {
            Ohjain.vasemmalle();
        }
    }

}
