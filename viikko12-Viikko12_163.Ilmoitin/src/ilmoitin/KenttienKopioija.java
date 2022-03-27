/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilmoitin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ernie77
 */
public class KenttienKopioija implements ActionListener {
    private JTextField lahde;
    private JLabel kohde;
    
    public KenttienKopioija(JTextField lahde, JLabel kohde) {
        this.kohde = kohde;
        this.lahde = lahde;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kohde.setText(this.lahde.getText());
        this.lahde.setText("");
    }
    
    
    
}
