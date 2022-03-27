/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernie77
 */
public class Lauma implements Siirrettava {
    private List<Siirrettava> lauma;
    
    public Lauma() {
        lauma = new ArrayList<>();
    }
    
    public void lisaaLaumaan(Siirrettava siirrettava) {
        lauma.add(siirrettava);
    }
    
    @Override
    public void siirra(int dx, int dy) {
        for (Siirrettava s : lauma) {
            s.siirra(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String t = "";
        for (Siirrettava s : lauma) {
            t += s.toString() + "\n";
        }
        return t;
    }
    
}
