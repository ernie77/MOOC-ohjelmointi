
import java.util.Scanner;
import robotti.Ohjain;

public class Portaikko {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Ohjain.kaynnista();
        // KIRJOITA OHJELMASI TÄNNE
        System.out.print("Montako ylös: ");
        int porras = Integer.parseInt(lukija.nextLine());
        while (porras > 0) {
            Ohjain.vasen();
            Ohjain.liiku();
            Ohjain.oikea();
            Ohjain.liiku();
            porras--;
        }
        System.out.print("Montako alas: ");
        porras = Integer.parseInt(lukija.nextLine());
        while (porras > 0) {
            Ohjain.oikea();
            Ohjain.liiku();
            Ohjain.vasen();
            Ohjain.liiku();
            porras--;
        }

        Ohjain.sammuta();
    }
}
