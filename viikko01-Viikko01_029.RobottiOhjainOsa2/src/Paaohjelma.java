
import java.util.Scanner;
import robotti.Ohjain;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Ohjain.asetaLaatikkoSatunnaisesti();
        Ohjain.kaynnista();
        while (true) {
            System.out.println("komento (sammuta, vasen ,oikea, liiku liikuMonta, viereen, ratkaise): ");
            String komento = lukija.nextLine();
            if (komento.equals("vasen")) {
                Ohjain.vasen();
            } else if (komento.equals("oikea")) {
                Ohjain.oikea();
            } else if (komento.equals("liiku")) {
                Ohjain.liiku();
            } else if (komento.equals("liikuMonta")) {
                System.out.println("Kuinka monta askelta: ");
                int ask = Integer.parseInt(lukija.nextLine());                     
                Ohjain.liikuMonta(ask);
            } else if (komento.equals("viereen")) {
                Ohjain.vasen();
                Ohjain.liikuMonta(Ohjain.laatikkoY() - Ohjain.robottiY());
                Ohjain.oikea();
                Ohjain.liikuMonta(Ohjain.laatikkoX() - Ohjain.robottiX() - 1);
            } else if (komento.equals("ratkaise")) {
                Ohjain.vasen();
                Ohjain.liikuMonta(Ohjain.laatikkoY() - Ohjain.robottiY());
                Ohjain.oikea();
                Ohjain.liikuMonta(Ohjain.tavoiteX() - Ohjain.robottiX() - 1);
                Ohjain.vasen();
                Ohjain.liiku();
                Ohjain.oikea();
                Ohjain.liiku();
                Ohjain.oikea();
                Ohjain.liikuMonta(Ohjain.laatikkoY() - Ohjain.tavoiteY());
            } else if (komento.equals("sammuta")) {
                Ohjain.sammuta();
                break;
            }
        }
        // toteuta ohjelma tänne
    }
}
