
import java.util.Scanner;

public class TulostusKolmesti {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän.
        System.out.print("Mitä tulostetaan? ");
        String tuloste = lukija.nextLine();
        
        System.out.println(tuloste + tuloste + tuloste);
    }
}
