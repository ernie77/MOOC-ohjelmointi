package clicker.kayttoliittyma;

import clicker.sovelluslogiikka.Laskuri;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Laskuri laskuri;

    public Kayttoliittyma(Laskuri laskuri) {
        this.laskuri = laskuri;
    }

    @Override
    public void run() {
        frame = new JFrame("The Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        
        JLabel arvo = new JLabel("0");
        JButton nappi = new JButton("Click!");
        
        KlikkaustenKuuntelija kuuntelija = new KlikkaustenKuuntelija(laskuri, arvo);
        nappi.addActionListener(kuuntelija);
        
        container.add(arvo, BorderLayout.NORTH);
        container.add(nappi);
    }

    public JFrame getFrame() {
        return frame;
    }
}
