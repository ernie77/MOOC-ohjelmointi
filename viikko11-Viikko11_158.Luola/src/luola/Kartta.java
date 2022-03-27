/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

/**
 *
 * @author ernie77
 */
public class Kartta {

    private int leveys;
    private int korkeus;

    public Kartta(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;

    }

    public void tulosta(Pelaaja pelaaja, Hirviot hirviot) {
        System.out.println("");
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                if (pelaaja.getx() == x && pelaaja.gety() == y) {
                    System.out.print("@");
                } else if (hirviot.onkoHirvio(x, y)) {
                    System.out.print("h");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }
}
