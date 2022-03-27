
import java.util.Scanner;

public class ViimeinenKirjain {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.println("Ensimmäinen kirjain: " + viimeinenKirjain(nimi));
    }

    public static char viimeinenKirjain(String merkkijono) {
        return merkkijono.charAt(merkkijono.length() - 1);
    }
}

