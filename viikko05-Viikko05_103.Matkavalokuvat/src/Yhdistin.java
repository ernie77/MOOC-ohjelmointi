/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import kuva.Fotari;
import kuva.Kuva;

/**
 *
 * @author ernie77
 */
public class Yhdistin {
    
    private String tapa;
    private ArrayList<Kuva> kuvat;
    
    public Yhdistin(String tapa) {
        this.tapa = tapa;
        this.kuvat = new ArrayList<>();
    }
    
    public ArrayList<Kuva> lataaKuvat(ArrayList<String> tiedostot) {
        for (String tiedosto : tiedostot) {
            this.kuvat.add(Fotari.lataa(tiedosto));
        }
        return this.kuvat;
        
    }
    
    public Kuva yhdistaKuvat(ArrayList<Kuva> kuvat) {
        this.kuvat = kuvat;
        Kuva uusikuva = new Kuva(kuvat.get(0).getLeveys(), kuvat.get(0).getKorkeus());
        
        if (this.tapa.equals("vaalein")) {
            int x = 0;
            while (x < uusikuva.getLeveys()) {
                int y = 0;
                while (y < uusikuva.getKorkeus()) {
                    ArrayList<Integer> punainen = new ArrayList<>();
                    ArrayList<Integer> vihrea = new ArrayList<>();
                    ArrayList<Integer> sininen = new ArrayList<>();
                    for (Kuva kuva : kuvat) {
                        punainen.add(kuva.punainen(x, y));
                        vihrea.add(kuva.vihrea(x, y));
                        sininen.add(kuva.sininen(x, y));
                    }
                    Collections.sort(punainen);
                    Collections.sort(vihrea);
                    Collections.sort(sininen);
                    uusikuva.asetaVari(x, y,
                            punainen.get(punainen.size() - 1),
                            vihrea.get(vihrea.size() - 1),
                            sininen.get(sininen.size() - 1));
                    y++;
                }
                x++;
            }
        }
        if (this.tapa.equals("tummin")) {
            int x = 0;
            while (x < uusikuva.getLeveys()) {
                int y = 0;
                while (y < uusikuva.getKorkeus()) {
                    ArrayList<Integer> punainen = new ArrayList<>();
                    ArrayList<Integer> vihrea = new ArrayList<>();
                    ArrayList<Integer> sininen = new ArrayList<>();
                    for (Kuva kuva : kuvat) {
                        punainen.add(kuva.punainen(x, y));
                        vihrea.add(kuva.vihrea(x, y));
                        sininen.add(kuva.sininen(x, y));
                    }
                    Collections.sort(punainen);
                    Collections.sort(vihrea);
                    Collections.sort(sininen);
                    uusikuva.asetaVari(x, y,
                            punainen.get(0),
                            vihrea.get(0),
                            sininen.get(0));
                    y++;
                }
                x++;
            }
        }        
        if (this.tapa.equals("mediaani")) {
            int x = 0;
            while (x < uusikuva.getLeveys()) {
                int y = 0;
                while (y < uusikuva.getKorkeus()) {
                    
                    ArrayList<Integer> punainen = new ArrayList<>();
                    ArrayList<Integer> vihrea = new ArrayList<>();
                    ArrayList<Integer> sininen = new ArrayList<>();
                    for (Kuva kuva : kuvat) {
                        punainen.add(kuva.punainen(x, y));
                        vihrea.add(kuva.vihrea(x, y));
                        sininen.add(kuva.sininen(x, y));
                    }
                    Collections.sort(punainen);
                    Collections.sort(vihrea);
                    Collections.sort(sininen);
                    uusikuva.asetaVari(x, y,
                            punainen.get(punainen.size() / 2),
                            vihrea.get(vihrea.size() / 2),
                            sininen.get(sininen.size() / 2));
                    y++;
                }
                x++;
            }
        }
        return uusikuva;
    }
}
