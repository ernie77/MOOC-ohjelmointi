
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // voit tehdä testikoodia tänne
        // poista kaikki ylimääräinen koodi kuitenkin tehtäviä 90.3 ja 90.4 tehdessäsi

        // Jotta testi toimisi, on oliot luotava pääohjelmassa oikeassa järjestyksessä 
        //  eli ensin kaikkien summan laskeva olio, toisena parillisten summan laskeva 
        //  ja viimeisenä parittomien summan laskeva olio)!
        int luku = 0;
        Lukutilasto tilasto = new Lukutilasto();
        Lukutilasto parilliset = new Lukutilasto();
        Lukutilasto parittomat = new Lukutilasto();
        System.out.println("Anna lukuja, -1 lopettaa: ");
        while (luku != -1) {
            luku = Integer.parseInt(lukija.nextLine());
            if (luku != -1) {
                tilasto.lisaaLuku(luku);

                if (luku % 2 == 0) {
                    parilliset.lisaaLuku(luku);

                } else {
                    parittomat.lisaaLuku(luku);
                }
            }
        }

        System.out.println("Summa: " + tilasto.summa());
        System.out.println("parillisten Summa: " + parilliset.summa());
        System.out.println("Parittomien Summa: " + parittomat.summa());
    }
}
