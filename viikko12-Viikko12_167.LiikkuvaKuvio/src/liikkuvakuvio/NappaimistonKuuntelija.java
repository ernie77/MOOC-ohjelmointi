/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkuvakuvio;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ernie77
 */
public class NappaimistonKuuntelija implements KeyListener {

    private Kuvio kuvio;
    private Component component;

    public NappaimistonKuuntelija(Component component, Kuvio kuvio) {
        this.kuvio = kuvio;
        this.component = component;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            kuvio.siirra(-5, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kuvio.siirra(5, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            kuvio.siirra(0, -5);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            kuvio.siirra(0, 5);
        }
        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke
    ) {
    }

}
