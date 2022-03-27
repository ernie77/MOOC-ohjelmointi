/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.kayttoliittyma;

import clicker.sovelluslogiikka.Laskuri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author ernie77
 */
public class KlikkaustenKuuntelija implements ActionListener {
    private Laskuri laskuri;
    private JLabel arvo;
    public KlikkaustenKuuntelija(Laskuri laskuri, JLabel arvo) {
        this.laskuri = laskuri;
        this.arvo = arvo;
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {
        laskuri.kasvata();
        arvo.setText("" + laskuri.annaArvo());
    }
    
}
