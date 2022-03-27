/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import matopeli.domain.Pala;
import matopeli.peli.Matopeli;

/**
 *
 * @author ernie77
 */
public class Piirtoalusta extends JPanel implements Paivitettava {

    private Matopeli matopeli;
    private int palanSivunPituus;

    public Piirtoalusta(Matopeli matopeli, int palanSivunPituus) {
        this.matopeli = matopeli;
        this.palanSivunPituus = palanSivunPituus;
    }

    @Override
    public void paivita() {
        super.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        for (Pala p : matopeli.getMato().getPalat()) {
            g.fill3DRect(palanSivunPituus * p.getX(), palanSivunPituus * p.getY(), palanSivunPituus, palanSivunPituus, true);
        }
        g.setColor(Color.RED);
        g.fillOval(palanSivunPituus * matopeli.getOmena().getX(), palanSivunPituus * matopeli.getOmena().getY(), palanSivunPituus, palanSivunPituus);
    }
}
