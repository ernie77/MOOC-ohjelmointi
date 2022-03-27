/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.sovelluslogiikka;

/**
 *
 * @author ernie77
 */
public class OmaLaskuri implements Laskuri {

    private int arvo;

    @Override
    public int annaArvo() {
        return arvo;
    }

    @Override
    public void kasvata() {
        arvo++;
    }

}
