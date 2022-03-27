/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class YlhaaltaRajoitettuLaskuri {

    private int arvo;
    private int ylaraja;

    public YlhaaltaRajoitettuLaskuri(int ylarajanAlkuarvo) {
        this.arvo = 0;
        this.ylaraja = ylarajanAlkuarvo;

    }

    public void seuraava() {
        if (this.arvo++ >= this.ylaraja) {

            this.arvo = 0;
        }

    }

    public void asetaArvo(int alkuarvo) {
        if (alkuarvo > 0 && alkuarvo <= this.ylaraja) {
            this.arvo = alkuarvo;
        } else {
            this.arvo = 0;
        }

    }

    public String toString() {
        if (this.arvo < 10) {
            return "0" + this.arvo;
        } else {
            return "" + this.arvo;
        }
    }

    public int arvo() {
        return this.arvo;
    }
}
