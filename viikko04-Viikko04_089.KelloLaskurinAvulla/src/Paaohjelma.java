
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // tee tänne koodia jolla testaat että YlhaaltaRajoitettuLaskuri toimii halutulla tavalla
        // muista kuitenkin pyyhkiä ylimääräinen koodi pois tehtävissä 89.3 ja 89.4 ja käyttää tehtäväannossa
        // ehdotettua koodirunkoa
        YlhaaltaRajoitettuLaskuri sekunnit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri minuutit = new YlhaaltaRajoitettuLaskuri(59);
        YlhaaltaRajoitettuLaskuri tunnit = new YlhaaltaRajoitettuLaskuri(23);

        System.out.println("sekunnit: ");
        sekunnit.asetaArvo(Integer.parseInt(lukija.nextLine()));
        System.out.println("minuutit: ");
        minuutit.asetaArvo(Integer.parseInt(lukija.nextLine()));
        System.out.println("tunnit: ");
        tunnit.asetaArvo(Integer.parseInt(lukija.nextLine()));
        int i = 0;
        while (i < 121) {

            System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
            sekunnit.seuraava();
            if (sekunnit.arvo() == 0) {
                minuutit.seuraava();
                if (minuutit.arvo() == 0) {
                    tunnit.seuraava();
                }
            }
            i++;

        }

    }
}
