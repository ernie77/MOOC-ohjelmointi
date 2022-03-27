/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkuvakuvio;

import java.awt.Graphics;

/**
 *
 * @author ernie77
 */
public class Nelio extends Kuvio {
    private int sivunPituus;

    public Nelio(int x, int y, int sivunPituus) {
        super(x, y);
        this.sivunPituus = sivunPituus;
    }

    @Override
    public void piirra(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), sivunPituus, sivunPituus);
    }

}
