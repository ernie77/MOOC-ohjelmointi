
import java.util.Scanner;

public class SilmukatLopetusMuistaminen {

    public static void main(String[] args) {
        // tee tähän projektiin tehtävät 36.1-36.5
        // kyseessä on oikeastaan yksi iso tehtävä jota koko ajan laajennetaan

        // voit myös lähettää osittain tehdyn tehtäväsarjan tarkastettavaksi palvelimelle
        // palvelin valittaa tällöin niistä testeistä joita vastaava koodi ei ole vielä
        // kirjoitettu. jo tehdyt osat kuitenkin kirjautuvat tehdyiksi
        Scanner lukija = new Scanner(System.in);
        System.out.println("Syötä luvut: ");
        int luku = 0;
        int summa = 0;
        int lukuja = -1;
        int parillinen = 0;
        while (luku != -1) {
            summa += luku;
            lukuja++;
            luku = Integer.parseInt(lukija.nextLine());
            if (luku % 2 == 0) {
                parillinen++;
            }
            
        }
        System.out.println("Kiitos ja näkemiin!");
        System.out.println("Summa on : " + summa);
        System.out.println("Lukuja: " + lukuja);
        System.out.println("Keskiarvo: " + (double) summa / lukuja);
        System.out.println("Parillisia: " + parillinen);
        System.out.println("Parittomia: " + (lukuja - parillinen));
    }
}
