/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Laskin {

    private int syote;
    private int tulos;

    public Laskin(int tulos, int syote) {
        this.syote = syote;
        this.tulos = tulos;
    }

    public int plus() {
        return tulos + syote;
    }
    
    public int miinus() {
        return tulos - syote;
    }
    
    public int nollaa() {
        return 0;
    }

}
