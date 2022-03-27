
import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Tulostaja {

    private File tiedosto;
    private Scanner lukija;

    public Tulostaja(String tiedostonNimi) throws Exception {
        this.tiedosto = new File(tiedostonNimi);
        lukija = new Scanner(tiedosto);
    }

    public void tulostaRivitJoilla(String sana) {
        
        while (lukija.hasNext()) {
            String rivi = lukija.nextLine();
            if (rivi.contains(sana)) {
                System.out.println(rivi);
            }

        }
        lukija.close();
    }
}
