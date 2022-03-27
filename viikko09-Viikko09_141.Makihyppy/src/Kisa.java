
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Kisa {

    private Scanner lukija;
    private ArrayList<Hyppaaja> osallistujat;
    private String nimi;

    public Kisa() {
        osallistujat = new ArrayList<>();
        lukija = new Scanner(System.in);
        nimi = "a";
    }

    public void aloita() {
        System.out.println("Kumpulan mäkiviikot");
        System.out.println("Syötä kilpailun osallistujat yksi kerrallaan, tyhjällä merkkijonolla siirtyy hyppyvaiheeseen.");
        while (!nimi.equals("")) {
            System.out.println("  Osallistujan nimi: ");
            nimi = lukija.nextLine();
            if (!nimi.equals("")) {
                osallistujat.add(new Hyppaaja(nimi));
            }
        }
        System.out.println("Kilpailu alkaa!");
        System.out.println("Kirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
        nimi = lukija.nextLine();
        int kierros = 0;
        while (nimi.equals("hyppaa")) {            
            kierros++;
            System.out.println(kierros + ". kierros");
            System.out.println("Hyppyjärjestys:");
            Collections.sort(osallistujat);
            Collections.reverse(osallistujat);
            for (Hyppaaja hyppaaja : osallistujat) {
                
                int i = 1;
                System.out.println("  " + i + ". " + hyppaaja);
                i++;
            }
            System.out.println("Kierroksen " + kierros + " tulokset");
            for (Hyppaaja hyppaaja : osallistujat) {
                
                hyppaaja.hyppy();
                System.out.println("  " + hyppaaja.getNimi());
                System.out.println(hyppaaja.getPituus(kierros));
                System.out.println("    tuomaripisteet:  " + hyppaaja.getTuomaripisteet(kierros));
            }
            System.out.println("Kirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
            nimi = lukija.nextLine();

        }
        System.out.println("Kiitos!");
        System.out.println("Kilpailun lopputulokset:");
        System.out.println("Sija    Nimi");
        Collections.sort(osallistujat);
        int k = 0;
        for (Hyppaaja hyppaaja : osallistujat) {
            k++;
            System.out.println(k + "       " + hyppaaja);
            System.out.println("          hyppyjen pituudet: " + hyppaaja.getPituudet());
        }
    }
}
