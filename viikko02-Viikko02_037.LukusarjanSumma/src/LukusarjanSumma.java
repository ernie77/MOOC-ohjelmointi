
import java.util.Scanner;

public class LukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mihin asti: ");
        int asti = Integer.parseInt(lukija.nextLine());
        int summa = 0;
        while (asti > 0) {
            summa += asti;
            asti--;
        }
        System.out.println("Summa on " + summa);
    }
}
