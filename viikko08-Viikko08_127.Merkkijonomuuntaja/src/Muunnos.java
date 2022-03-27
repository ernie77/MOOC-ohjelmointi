/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Muunnos {

    private char muunnettava;
    private char muunnettu;

    public Muunnos(char muunnettava, char muunnettu) {
        this.muunnettava = muunnettava;
        this.muunnettu = muunnettu;
    }

    public String muunna(String merkkijono) {
        return merkkijono.replace(muunnettava, muunnettu);
    }
}
