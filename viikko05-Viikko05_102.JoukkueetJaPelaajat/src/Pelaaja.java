/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Pelaaja {

    private String nimi;
    private int maalit;

    public Pelaaja(String nimi, int maalit) {
        this.nimi = nimi;
        this.maalit = maalit;
    }

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.maalit = 0;
    }

    public String haeNimi() {
        return this.nimi;
    }

    public int maalit() {
        return this.maalit;
    }

    public String toString() {
        return "" + this.nimi + ", " + this.maalit;
    }
}
