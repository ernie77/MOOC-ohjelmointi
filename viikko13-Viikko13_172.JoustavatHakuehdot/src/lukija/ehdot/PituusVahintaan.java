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
public class PituusVahintaan implements Ehto {
    private int ehto;
    
    public PituusVahintaan(int ehto) {
        this.ehto = ehto;
    }
    @Override
    public boolean toteutuu(String rivi) {
        return rivi.length() >= ehto;
    }
    
    
}
