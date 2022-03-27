/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Lintu {

    private String nimi;
    private String latnimi;
    private int havainto;

    public Lintu(String nimi, String latnimi) {
        this.nimi = nimi;
        this.latnimi = latnimi;
        this.havainto = 0;
    }

    public void havainto() {
        this.havainto++;
    }

    public String nimi() {
        return this.nimi;
    }

    public String toString() {
        return this.nimi + " " + this.latnimi + ": " + this.havainto + " havaintoa";
    }
}
