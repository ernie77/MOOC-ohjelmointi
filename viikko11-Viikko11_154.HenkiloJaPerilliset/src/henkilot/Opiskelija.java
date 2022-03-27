/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilot;

/**
 *
 * @author ernie77
 */
public class Opiskelija extends Henkilo {

    private int opintopisteet;

    public Opiskelija(String nimi, String osoite) {
        super(nimi, osoite);
        opintopisteet = 0;
    }

    public void opiskele() {
        opintopisteet++;
    }

    public int opintopisteita() {
        return this.opintopisteet;
    }

    public String toString() {
        return super.toString() + "\n  opintopisteitä " + this.opintopisteita();
    }
}
