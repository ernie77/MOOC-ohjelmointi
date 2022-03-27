
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // tee tänne pääohjelma
        Scanner lukija = new Scanner(System.in);
        ArrayList<Opiskelija> lista = new ArrayList<>();
        String nimi = "a";
        String onumero;
        String haku;

        while (!nimi.isEmpty()) {
            System.out.println("Nimi: ");
            nimi = lukija.nextLine();
            if (nimi.isEmpty()) {
                break;
            }

            System.out.println("Opiskelijanumero: ");
            onumero = lukija.nextLine();
            lista.add(new Opiskelija(nimi, onumero));

        }

        for (Opiskelija opiskelija : lista) {
            System.out.println(opiskelija.toString());
        }

        System.out.println("Anna hakusana: ");
        haku = lukija.nextLine();
        System.out.println("Tulokset: ");

        for (Opiskelija opiskelija : lista) {
            if (opiskelija.haeNimi().contains(haku)) {
                System.out.println(opiskelija.toString());
            }
        }
    }

}
