/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ernie77
 */
public class Maatila implements Eleleva {
    private String omistaja;
    private Navetta navetta;
    private List<Lehma> lehmat;
    
    public Maatila(String omistaja, Navetta navetta) {
        this.omistaja = omistaja;
        this.navetta = navetta;
        this.lehmat = new LinkedList<>();
    }
    
    public void lisaaLehma(Lehma lehma) {
        lehmat.add(lehma);
    }

    @Override
    public void eleleTunti() {
        for (Lehma lehma : lehmat) {
            lehma.eleleTunti();
        }
    }
    
    public void hoidaLehmat() {
        navetta.hoida(lehmat);
    }
    
    public String getOmistaja() {
        return this.omistaja;
    }
    
    public void asennaNavettaanLypsyrobotti(Lypsyrobotti robo) {
        navetta.asennaLypsyrobotti(robo);
    }
}
