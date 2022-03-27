/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Maksukortti {

    private double saldo;

    public Maksukortti(double alkusaldo) {
        this.saldo = alkusaldo;
    }

    public String toString() {
        return "Kortilla on rahaa " + this.saldo + " euroa";
    }

    public void syoEdullisesti() {
        if (this.saldo >= 2.5) {
            this.saldo -= 2.5;
        }
    }

    public void syoMaukkaasti() {
        if (this.saldo >= 4.3) {
            this.saldo -= 4.3;
        }
    }

    public void lataaRahaa(double rahamaara) {
        if (rahamaara < 0) {
            return;
        }
        if ((this.saldo += rahamaara) >= 150) {
            this.saldo = 150;
        }
    }
}
