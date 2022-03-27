
import java.util.Scanner;

public class MihinJaMista {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // KIRJOITA OHJELMASI TÄNNE
        //int luku = 1;
        System.out.println("Mihin asti: ");
        int asti = Integer.parseInt(lukija.nextLine());
        System.out.println("Mistä lähtien: ");
        int luku = Integer.parseInt(lukija.nextLine());
        while (luku <= asti) {
            System.out.println(luku);
            luku++;
        }
    }
}
