
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraafinenLaskin implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Laskin");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        JTextField tulos = new JTextField("0");
        tulos.setEnabled(false);
        JTextField syote = new JTextField("0");
        container.setLayout(layout);
        container.add(tulos);
        container.add(syote);
        container.add(luoValikko(syote, tulos));
    }

    private JPanel luoValikko(JTextField syote, JTextField tulos) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        JButton miinus = new JButton("-");
        JButton nollaa = new JButton("Z");
        panel.add(plus);
        panel.add(miinus);
        panel.add(nollaa);

        Kuuntelija kuuntelija = new Kuuntelija(syote, tulos, plus, miinus, nollaa);
        plus.addActionListener(kuuntelija);
        miinus.addActionListener(kuuntelija);
        nollaa.addActionListener(kuuntelija);
        nollaa.setEnabled(false);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
