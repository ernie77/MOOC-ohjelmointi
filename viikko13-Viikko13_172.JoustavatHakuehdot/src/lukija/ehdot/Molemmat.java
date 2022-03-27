/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukija.ehdot;

/**
 *
 * @author ernie77
 */
public class Molemmat implements Ehto {

    private Ehto ehto1;
    private Ehto ehto2;

    public Molemmat(Ehto ehto1, Ehto ehto2) {
        this.ehto1 = ehto1;
        this.ehto2 = ehto2;
    }

    @Override
    public boolean toteutuu(String rivi) {
        if (ehto1.toteutuu(rivi) && ehto2.toteutuu(rivi)) {
            return true;
        }
        return false;
    }

}
