/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import matopeli.Suunta;
import matopeli.domain.Mato;

/**
 *
 * @author ernie77
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Mato mato;

    public Nappaimistonkuuntelija(Mato mato) {
        this.mato = mato;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        if (ke.getKeyCode() == KeyEvent.VK_UP) {
            mato.setSuunta(Suunta.YLOS);
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
            mato.setSuunta(Suunta.ALAS);
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            mato.setSuunta(Suunta.OIKEA);
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            mato.setSuunta(Suunta.VASEN);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
}
