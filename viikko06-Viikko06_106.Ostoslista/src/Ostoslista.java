/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ernie77
 */
public class Ostoslista {

    private ArrayList<String> ostoslista;

    public Ostoslista() {
        this.ostoslista = new ArrayList<>();
    }

    public void lisaa(String tuote) {
        this.ostoslista.add(tuote);
    }

    public boolean onkoListalla(String tuote) {
        return this.ostoslista.contains(tuote);
    }

    public int kappalemaara(String tuote) {
        int i = 0;
        for (String t : this.ostoslista) {
            if (t.equals(tuote)) {
                i++;
            }
        }
        return i;
    }

    public void poista(String tuote) {
        this.ostoslista.remove(tuote);
    }

    public String toString() {
        int i = 0;
        ArrayList<String> list = new ArrayList<>();
        Collections.sort(ostoslista);
        String tuloste = "Ostetaan seuraavat tuotteet\n";
        
        for (String t : this.ostoslista) {
            if (!list.contains(t)) {
                list.add(t);
                tuloste +=  "" + t.intern() + " " + kappalemaara(t) + " kpl.\n";
            }

        }
        return tuloste;
    }

}
