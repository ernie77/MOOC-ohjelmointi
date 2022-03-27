import java.util.Scanner;

public class Kertoma {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        int kertoma = 1;
        while (luku > 0) {
            kertoma = kertoma * luku;
            luku--;
        }
        System.out.println("Summa on " + kertoma);

    }
}
