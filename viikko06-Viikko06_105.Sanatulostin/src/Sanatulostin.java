/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Sanatulostin {

    private String merkkijono;
    private int merkki;

    public Sanatulostin(String merkkijono) {
        this.merkkijono = merkkijono;
        this.merkki = 0;
    }

    public void sanaporras(int luku) {
        int rivi = 0;
        while (rivi < luku) {
            int sarake = 0;
            while (sarake <= rivi) {
                System.out.print(merkkijono.charAt(merkki));
                sarake++;
                merkki++;
                if (merkki > merkkijono.length() - 1) {
                    merkki = 0;
                }
            }
            System.out.println(" ");
            rivi++;
        }
    }

    public void laskevaSanaporras(int luku) {
        int rivi = luku;
        while (rivi > 0) {
            int sarake = 0;
            while (sarake < rivi) {
                System.out.print(merkkijono.charAt(merkki));
                sarake++;
                merkki++;
                if (merkki > merkkijono.length() - 1) {
                    merkki = 0;
                }
            }
            System.out.println(" ");
            rivi--;
        }
    }

    public void sanapyramidi(int luku) {
        merkki = 0;
        sanaporras(luku);
        laskevaSanaporras(luku - 1);
    }
}
