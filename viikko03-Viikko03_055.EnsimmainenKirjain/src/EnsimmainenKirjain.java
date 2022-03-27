import java.util.Scanner;

public class EnsimmainenKirjain {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.println("Ensimmäinen kirjain: " + ensimmainenKirjain(nimi));
    }
    public static char ensimmainenKirjain(String merkkijono) {
        return merkkijono.charAt(0);
    }
}
