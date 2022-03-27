
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Arvosanat arvosanat = new Arvosanat();
        System.out.println("Syötä koepisteet, -1 lopettaa:");
        while (true) {
            int koepisteet = lukija.nextInt();

            if (koepisteet > 0 && koepisteet < 61) {
                arvosanat.lisaa(koepisteet);
            }

            if (koepisteet == -1) {
                break;
            }
        }
        
        arvosanat.tulosta();

        // tee ohjelmasi tänne
        // älä kuitenkaan tee kaikkea koodia mainiin, vaan suunnittele ohjelmalle järkevä rakenne
        // ÄLÄ tee ohjelmaasi muita Scannereita kuin tässä luotu
        // jos joudut käyttämään Scanneria muusta metodista, välitä se parametrina tehtävän 73 tapaan
    }
}
