/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkuvakuvio;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author ernie77
 */
public class Koostekuvio extends Kuvio {

    ArrayList<Kuvio> kuviot;
    
    public Koostekuvio() {
        super(0, 0);
        kuviot = new ArrayList<>();
    }
    
    public void liita(Kuvio k) {
        kuviot.add(k);
    }

    @Override
    public void piirra(Graphics graphics) {
        for (Kuvio k : kuviot) {
            k.piirra(graphics);
        }
    }
    
    @Override
    public void siirra(int x, int y) {
        for (Kuvio k : kuviot) {
            k.siirra(x, y);
        }
    }
    
}
