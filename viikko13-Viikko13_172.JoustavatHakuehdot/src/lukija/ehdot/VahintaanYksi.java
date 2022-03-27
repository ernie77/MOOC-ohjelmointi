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
public class VahintaanYksi implements Ehto {

    private Ehto ehdot[];
    private int lkm;

    public VahintaanYksi(Ehto... ehdot) {
        this.ehdot = ehdot;
        this.lkm = ehdot.length;
    }

    @Override
    public boolean toteutuu(String rivi) {
        for (Ehto e : ehdot) {
            if (e.toteutuu(rivi)) {
                return true;
            }
        }
        return false;
    }

}
