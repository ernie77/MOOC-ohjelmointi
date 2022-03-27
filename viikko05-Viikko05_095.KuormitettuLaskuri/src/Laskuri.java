/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Laskuri {

    private int arvo;
    private boolean tarkistus;

    public Laskuri(int alkuarvo, boolean tarkistus) {
        this.arvo = alkuarvo;
        this.tarkistus = tarkistus;
    }

    public Laskuri(int alkuarvo) {
        this(alkuarvo, false);
    }

    public Laskuri(boolean tarkistus) {
        this(0, tarkistus);
    }

    public Laskuri() {
        this(0, false);
    }

    public int arvo() {
        return this.arvo;
    }

    public void lisaa() {
        this.arvo++;
    }

    public void vahenna() {
        if (this.tarkistus) {
            if (this.arvo == 0) {
                return;
            }
        }
        this.arvo--;
    }

    public void lisaa(int lisays) {
        if (lisays < 0) {
            return;
        }
        this.arvo += lisays;
    }

    public void vahenna(int vahennys) {
        if (vahennys < 0) {
            return;
        }
        if (this.tarkistus) {
            if (this.arvo - vahennys < 0) {
                this.arvo = 0;
                return;
            }
        }
        this.arvo -= vahennys;
    }
}
