
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Kuuntelija implements ActionListener {

    private Laskin laskin;
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private JTextField tulos;
    private JTextField syote;

    public Kuuntelija(JTextField syote, JTextField tulos, JButton plus, JButton miinus, JButton nollaa) {
        this.tulos = tulos;
        this.syote = syote;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == plus) {
            try {
                laskin = new Laskin(Integer.parseInt(tulos.getText()), Integer.parseInt(syote.getText()));
                tulos.setText(String.valueOf(laskin.plus()));
                nollaa.setEnabled(true);
            } catch (NumberFormatException e) {
                System.out.println("illegal number format");
            }
            syote.setText("");

        } else if (ae.getSource() == miinus) {
            try {
                laskin = new Laskin(Integer.parseInt(tulos.getText()), Integer.parseInt(syote.getText()));

                tulos.setText(String.valueOf(laskin.miinus()));
                nollaa.setEnabled(true);
            } catch (NumberFormatException e) {
                System.out.println("illegal number format");
            }
            syote.setText("");

        } else if (ae.getSource() == nollaa) {
            try {
                tulos.setText("0");
                nollaa.setEnabled(false);

            } catch (NumberFormatException e) {
                System.out.println("illegal number format");
            }
            syote.setText("");

        }
    }

}
