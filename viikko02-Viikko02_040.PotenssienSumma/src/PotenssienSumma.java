
import java.util.Scanner;

public class PotenssienSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna luku: ");
        int potenssi = Integer.parseInt(lukija.nextLine());
        int summa = 0;
        while (potenssi >= 0) {
            summa = summa + (int) Math.pow(2, potenssi);
            potenssi--;
        }
        System.out.println("Summa on " + summa);

    }
}
