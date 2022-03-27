
import java.util.Random;
import java.util.Scanner;

public class Numerovisa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvottuLuku = arvoLuku();

        // OHJELMOI OHJELMASI TÄHÄN, ÄLÄ MUOKKAA YLLÄOLEVIA ASIOITA
        int arvaus = -1;
        int kerta = 0;
        while (arvaus != arvottuLuku) {
            System.out.println("Arvaa luku: ");
            arvaus = Integer.parseInt(lukija.nextLine());
            kerta++;
            if (arvottuLuku < arvaus) {
                System.out.println("Luku on pienempi, tehtyjä arvauksia " + kerta);
            } else if (arvottuLuku > arvaus) {
                System.out.println("Luku on suurempi, tehtyjä arvauksia " + kerta);
            }
        }

        System.out.println("Onnekis olkuun, oikein arvattu!");

    }

    // ÄLÄ MUOKKAA METODIA arvoLuku
    private static int arvoLuku() {
        return new Random().nextInt(101);
    }
}
