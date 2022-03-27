
import java.util.Scanner;

public class Paaohjelma {

    // tee ohjelmaasi VAIN YKSI Scanner-olio
    // jos joudut käyttämään Scanneria muualta kuin luontipaikasta, välitä se parametrina
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Lintukanta lintukanta = new Lintukanta();

        while (true) {
            System.out.print("? ");
            String toiminto = lukija.nextLine();

            if (toiminto.contains("Lopeta")) {
                break;
            }

            if (toiminto.contains("Lisaa")) {
                lintukanta.lisaa(lukija);
            }
            if (toiminto.contains("Nayta")) {
                lintukanta.nayta(lukija);
            }
            if (toiminto.contains("Havainto")) {
                lintukanta.havainto(lukija);
            }
            if (toiminto.contains("Tilasto")) {
                lintukanta.tilasto();
            }

        }
    }

}
