
import java.util.Scanner;

public class IkienSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän.
        System.out.println("Anna nimi:");
        String ekan = lukija.nextLine();
        System.out.println("Anna ikä:");
        int ekai = Integer.parseInt(lukija.nextLine());
        
        System.out.println("Anna nimi:");
        String tokan = lukija.nextLine();
        System.out.println("Anna ikä:");
        int tokai = Integer.parseInt(lukija.nextLine());
        System.out.println(ekan + " ja " + tokan + " ovat yhteensä " + (ekai + tokai) + " vuotta vanhoja.");        
    }
}
