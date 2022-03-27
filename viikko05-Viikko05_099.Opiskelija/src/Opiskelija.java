/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Opiskelija {

    private String nimi;
    private String opiskelijanumero;

    public Opiskelija(String nimi, String onumero) {
        this.nimi = nimi;
        this.opiskelijanumero = onumero;
    }

    public String haeNimi() {
        return this.nimi;
    }

    public String haeOpiskelijanumero() {
        return this.opiskelijanumero;
    }

    @Override
    public String toString() {
        return "" + this.haeNimi() + " (" + this.haeOpiskelijanumero() + ")";
    }

}
