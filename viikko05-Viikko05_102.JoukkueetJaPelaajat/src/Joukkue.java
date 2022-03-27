/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author ernie77
 */
public class Joukkue {

    private String nimi;
    private ArrayList<Pelaaja> pelaajat;
    private int maksimikoko;


    public Joukkue(String nimi) {
        this.nimi = nimi;
        this.pelaajat = new ArrayList<>();
        this.maksimikoko = 16;

    }

    public String haeNimi() {
        return this.nimi;
    }

    public void lisaaPelaaja(Pelaaja pelaaja) {
        if (this.pelaajat.size() < this.maksimikoko) {
            this.pelaajat.add(pelaaja);
        }

    }

    public void tulostaPelaajat() {
        for (Pelaaja pelaaja : this.pelaajat) {
            System.out.println(pelaaja);
        }
    }

    public void asetaMaksimikoko(int maksimikoko) {
        this.maksimikoko = maksimikoko;
    }
    
    public int maalit() {
        int maalit = 0;
        for (Pelaaja pelaaja : this.pelaajat) {
            maalit += pelaaja.maalit();
        }
        return maalit;
    }

    public int koko() {
        return this.pelaajat.size();
    }
}
