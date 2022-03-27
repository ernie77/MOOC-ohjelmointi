/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedosto;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ernie77
 */
public class Analyysi {

    private File tiedosto;

    public Analyysi(File tiedosto) {
        this.tiedosto = tiedosto;
    }

    public int rivimaara() throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        int rivi = 0;
        while (lukija.hasNextLine()) {
            lukija.nextLine();
            rivi++;
        }
        return rivi;
    }

    public int merkkeja() throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        int merkit = 0;
        while (lukija.hasNextLine()) {
            merkit += lukija.nextLine().length() + 1;
            
        }
        return merkit;
    }
}
