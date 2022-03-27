
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Testaa ohjelmasi toimintaa täällä!
        Scanner lukija = new Scanner(System.in);
        Sademaara vedet = new Sademaara();
        while (true) {
            double luku = lukija.nextDouble();
            if (luku == 99999) {
                break;
            }
            vedet.lisaa(luku);
        }
        vedet.keskiarvo();
    }
}
