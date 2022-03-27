package clicker.kayttoliittyma;

import clicker.sovelluslogiikka.Laskuri;
import clicker.sovelluslogiikka.OmaLaskuri;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Laskuri omalaskuri = new OmaLaskuri();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(omalaskuri);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
