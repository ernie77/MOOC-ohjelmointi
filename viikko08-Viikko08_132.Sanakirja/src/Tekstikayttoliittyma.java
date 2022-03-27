
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
public class Tekstikayttoliittyma {

    private Scanner lukija;
    private Sanakirja sanakirja;

    public Tekstikayttoliittyma(Scanner lukija, Sanakirja sanakirja) {
        this.lukija = lukija;
        this.sanakirja = sanakirja;
    }

    public void kaynnista() {

        while (true) {
            System.out.println("");
            System.out.println("Komennot:");
            System.out.println("    lisaa   -lisää sanaparin sanakirjaan");
            System.out.println("    kaanna  -kysyy sanan ja tulostaa sen käännöksen");
            System.out.println("    lopeta  -postuu käyttöliittymästä");

            String komento = lukija.nextLine();

            if (komento.equals("lopeta")) {
                System.out.println("Hei hei!");
                break;
            }

            hoidaKomento(komento);
        }
    }

    public void hoidaKomento(String komento) {
        if (komento.equals("lisaa")) {
            this.lisaa();
        } else if (komento.equals("kaanna")) {
            this.kaanna();
        } else {
            System.out.println("Tuntematon komento.");
        }
    }

    public void lisaa() {
        System.out.print("Suomeksi: ");
        String sana = lukija.nextLine();
        System.out.print("Käännös: ");
        String kaannos = lukija.nextLine();
        this.sanakirja.lisaa(sana, kaannos);
    }
    
    public void kaanna() {
        System.out.print("Anna sana: ");
        System.out.println("Käännös: " + sanakirja.kaanna(lukija.nextLine()));
    }

}
