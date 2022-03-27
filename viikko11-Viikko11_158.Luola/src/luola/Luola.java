/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

import java.util.Scanner;

/**
 *
 * @author ernie77
 */
public class Luola {

    private int leveys;
    private int korkeus;
    private int hirvioita;
    private int valayksia;
    private boolean hirviotliikkuvat;
    private Pelaaja pelaaja;
    private Hirviot hirviot;
    private Kartta kartta;

    public Luola(int leveys, int korkeus, int hirvioita, int valayksia, boolean hirviotLiikkuvat) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.hirvioita = hirvioita;
        this.valayksia = valayksia;
        this.hirviotliikkuvat = hirviotLiikkuvat;
        hirviot = new Hirviot(hirvioita, leveys, korkeus);
        pelaaja = new Pelaaja();
        kartta = new Kartta(leveys, korkeus);
    }

    public void run(Scanner lukija) {
        String syote = "";
        while (valayksia > 0) {
            System.out.println(valayksia + "\n");
            pelaaja.tulosta();
            hirviot.tulosta();
            kartta.tulosta(pelaaja, hirviot);
            syote = lukija.nextLine();
            System.out.println(syote);
            pelaaja.liiku(syote, hirviot);
            valayksia--;
        }
        System.out.println("HÄVISIT");
    }
}
