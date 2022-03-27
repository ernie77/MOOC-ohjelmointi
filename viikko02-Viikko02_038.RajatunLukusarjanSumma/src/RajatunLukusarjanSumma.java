
import java.util.Scanner;

public class RajatunLukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Ensimmäinen: ");
        int eka = Integer.parseInt(lukija.nextLine());
        System.out.println("Viimeinen:");
        int vika = Integer.parseInt(lukija.nextLine());
        int summa = 0;
        while (vika >= eka) {
            summa += vika;
            vika--;
        }
        System.out.println("Summa on " + summa);

    }
}
