
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class Numerotiedustelu {

    private List<Henkilo> henkilot;
    private Map<String, Henkilo> henkiloNimella;
    private Map<String, Henkilo> henkiloNumerolla;

    public Numerotiedustelu() {
        henkilot = new ArrayList<>();
        henkiloNimella = new HashMap<>();
        henkiloNumerolla = new HashMap<>();
    }

    public void lisaa(String nimi) {
        Henkilo henkilo = new Henkilo(nimi);
        this.henkiloNimella.put(nimi, henkilo);

        this.henkilot.add(henkilo);
    }

    public void lisaaNumero(String nimi, String numero) {
        if (!this.henkiloNimella.containsKey(nimi)) {
            this.lisaa(nimi);
        }
        henkiloNimella.get(nimi).setNumero(numero);
        this.henkiloNumerolla.put(numero, henkiloNimella.get(nimi));
    }

    public void haeNimella(String nimi) {
        if (henkiloNimella.containsKey(nimi)) {
            System.out.println(henkiloNimella.get(nimi).getPuhno());
        } else {
            System.out.println("ei löytynyt");
        }
    }

    public void haeNumerolla(String numero) {
        System.out.println(henkiloNumerolla.get(numero).getNimi());
    }

    public void lisaaOsoite(String nimi, String katu, String kaupunki) {
        if (!henkiloNimella.containsKey(nimi)) {
            this.lisaa(nimi);
        }
        henkiloNimella.get(nimi).setKatu(katu);
        henkiloNimella.get(nimi).setKaupunki(kaupunki);

    }

    public void haeTiedot(String nimi) {

        if (henkiloNimella.containsKey(nimi)) {
            Henkilo h = henkiloNimella.get(nimi);

            if (h.getKatu().isEmpty()) {
                System.out.println("osoite ei tiedossa");
            } else {
                System.out.println("  osoite: " + henkiloNimella.get(nimi).getKatu() + " " + henkiloNimella.get(nimi).getKaupunki());
            }

            if (h.getPuhno() == "[]") {
                System.out.println("ei puhelinta");
            } else {
                System.out.println("  puhelinnumerot:");
                System.out.println("    " + henkiloNimella.get(nimi).getPuhno());
            }
        } else {
            System.out.println("ei löytynyt");
        }
    }

    public void poista(String nimi) {
        if (henkiloNimella.containsKey(nimi)) {
            henkilot.remove(henkiloNimella.get(nimi));
            henkiloNumerolla.remove(henkiloNimella.get(nimi).getPuhno());
            henkiloNimella.remove(nimi);
        }
    }

    public void haku(String syote) {
        Collections.sort(henkilot);
        int loytyi = 0;
        for (Henkilo h : henkilot) {
            if (h.getKaupunki().contains(syote)) {
                System.out.println(h);
                loytyi++;
            } else if (h.getNimi().contains(syote)) {
                System.out.println(h);
                loytyi++;
            } else if (h.getKatu().equals(syote)) {
                System.out.println(h);
                loytyi++;
            }
        }
        if (loytyi == 0) {
            System.out.println("ei löytynyt");
        }
    }
}
