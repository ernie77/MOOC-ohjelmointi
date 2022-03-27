
import java.util.Scanner;

public class Desibelimittaukset {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Huom! Tässä tehtävässä ei ole testejä, joten testien ajaminen
        // antaa sinulle viestin "kaikki ok!". Älä kuitenkaan luota viestiin,
        // vaan pyri tekemään ongelmaan ratkaisu askel askeleelta. 
        // Katso askeleittaiseen etenemiseen neuvoja materiaalissa 
        // juuri olleesta esimerkistä.
        // ohjelmoi ongelmaan ratkaisu tähän, lähde liikkeelle pienen
        // toiminnallisuuden kuten yhden luvun lukemisen toteuttamisesta
        int lkm = 0;
        int summa = 0;
        int luku = 0;
        System.out.println("Anna desibelilukuja, lopeta luvulla 9999.");

        while (luku != 9999) {

            System.out.println("Anna desibeliluku: ");
            luku = Integer.parseInt(lukija.nextLine());
            if (luku == 9999) {
                break;
            } else if (luku >= 0) {
                summa += luku;
                lkm++;
            }
        }
        if (summa == 0) {
            System.out.println("Yhtään lukua ei syötetty");
        } else {
            System.out.println("Desibelilukujen keskiarvo on " + ((double) summa / lkm));
        }
    }
}
