/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanatutkimus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ernie77
 */
public class Sanatutkimus {

    private File tiedosto;

    public Sanatutkimus(File tiedosto) {
        this.tiedosto = tiedosto;
    }

    public int sanojenMaara() throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        int laskuri = 0;
        while (lukija.hasNext()) {
            lukija.next();
            laskuri++;
        }
        return laskuri;
    }

    public List<String> kirjaimenZSisaltavatSanat() throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        ArrayList<String> sanat = new ArrayList<>();
        String sana;
        while (lukija.hasNext()) {
            sana = lukija.next();
            if (sana.contains("z")) {
                sanat.add(sana);
            }
        }
        return sanat;
    }

    public List<String> kirjaimeenLPaattyvatSanat() throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        ArrayList<String> sanat = new ArrayList<>();
        String sana;
        while (lukija.hasNext()) {
            sana = lukija.next();
            if (sana.endsWith("l")) {
                sanat.add(sana);
            }
        }
        return sanat;
    }

    public List<String> palindromit() throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        ArrayList<String> sanat = new ArrayList<>();
        String sana = "";
        
        while (lukija.hasNext()) {
            String anas = "";
            sana = lukija.next();
            for (int i = sana.length() - 1; i >= 0; i--) {
                anas += sana.charAt(i);
                System.out.println(anas);
            }
            if (sana.equals(anas)) {
                sanat.add(sana);
            }
        }
        return sanat;

    }
    
    public List<String> kaikkiVokaalitSisaltavatSanat() throws Exception {
        Scanner lukija = new Scanner(tiedosto);
        ArrayList<String> sanat = new ArrayList<>();
        String sana;
        while (lukija.hasNext()) {
            sana = lukija.next();
            if (sana.contains("a") && sana.contains("e") && sana.contains("i") && sana.contains("o") && sana.contains("u") && sana.contains("y") && sana.contains("ä") && sana.contains("ö")) {
                sanat.add(sana);
               
            }
        
        }
        return sanat;
    }
}
