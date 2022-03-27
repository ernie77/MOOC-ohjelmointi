/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author ernie77
 */
public class Tuotevarasto extends Varasto {
    private String tuotenimi;
    
    public Tuotevarasto(String tuotenimi, double tilavuus) {
        super(tilavuus);
        this.tuotenimi = tuotenimi;
    }
    
    public String getNimi() {
        return this.tuotenimi;
    }
    
    public void setNimi(String uusinimi) {
        this.tuotenimi = uusinimi;
    }
    
    public String toString() {
        return this.tuotenimi + ": " + super.toString();
    }
}
