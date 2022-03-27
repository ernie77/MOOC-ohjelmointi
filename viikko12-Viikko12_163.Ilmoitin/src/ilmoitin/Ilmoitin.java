package ilmoitin;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Ilmoitin implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Frame");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        
        JTextField textAreaUp = new JTextField("kopioitava teksti");
        JLabel textAreaDown = new JLabel();
        JButton copyButton = new JButton("Päivitä");
        
        KenttienKopioija kopioija = new KenttienKopioija(textAreaUp, textAreaDown);
        
        copyButton.addActionListener(kopioija);
        
        container.add(textAreaUp);
        container.add(copyButton);
        container.add(textAreaDown);
    }
}
