/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernie77
 */
public class MuistavaSanakirja {

    private Map<String, String> sanakirja;
    private String tiedosto;

    public MuistavaSanakirja() {
        sanakirja = new HashMap<>();
    }

    public MuistavaSanakirja(String tiedosto) {
        sanakirja = new HashMap<>();
        this.tiedosto = tiedosto;
    }

    public void lisaa(String sana, String kaannos) {
        if (!sanakirja.containsKey(sana)) {
            sanakirja.put(sana, kaannos);
        }
    }

    public String kaanna(String sana) {
        if (sanakirja.containsKey(sana)) {
            return sanakirja.get(sana);
        } else {
            for (Entry<String, String> entry : sanakirja.entrySet()) {
                if (entry.getValue().equals(sana)) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public void poista(String sana) {
        if (sanakirja.containsKey(sana)) {
            sanakirja.remove(sana);
        } else {
            String poistettava = null;
            for (Entry<String, String> entry : sanakirja.entrySet()) {
                if (entry.getValue().equals(sana)) {
                    poistettava = entry.getKey();
                }
            }
            sanakirja.remove(poistettava);
        }
    }

    public boolean lataa() {
        try {
            File data = new File(tiedosto);
            Scanner lukija = new Scanner(data);
            while (lukija.hasNextLine()) {
                String rivi = lukija.nextLine();
                String[] osat = rivi.split(":");
                this.lisaa(osat[0], osat[1]);
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }

    }

    public boolean tallenna() {
        try {
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            for (String s : sanakirja.keySet()) {
                kirjoittaja.write(s + ":" + sanakirja.get(s) + "\n");
            }
            kirjoittaja.close();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}
