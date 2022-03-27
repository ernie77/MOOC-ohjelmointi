/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

import java.util.List;
import java.util.ArrayList;
import matopeli.Suunta;

/**
 *
 * @author ernie77
 */
public class Mato {

    private Suunta suunta;
    private List<Pala> palat;
    private int pituus;

    public Mato(int alkuX, int alkuY, Suunta alkusuunta) {
        this.suunta = alkusuunta;
        palat = new ArrayList<>();
        palat.add(new Pala(alkuX, alkuY));
        pituus = 3;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getPituus() {
        return getPalat().size();
    }

    public List<Pala> getPalat() {
        return this.palat;
    }

    public void liiku() {
        if (getSuunta() == suunta.ALAS) {
            palat.add(new Pala(palat.get(palat.size() - 1).getX(), palat.get(palat.size() - 1).getY() + 1));
            if (palat.size() > pituus) {
                palat.remove(0);
            }

        }

        if (getSuunta() == suunta.VASEN) {
            palat.add(new Pala(palat.get(palat.size() - 1).getX() - 1, palat.get(palat.size() - 1).getY()));
            if (palat.size() > pituus) {
                palat.remove(0);
            }

        }
        if (getSuunta() == suunta.YLOS) {
            palat.add(new Pala(palat.get(palat.size() - 1).getX(), palat.get(palat.size() - 1).getY() - 1));
            if (palat.size() > pituus) {
                palat.remove(0);
            }

        }
        if (getSuunta() == suunta.OIKEA) {
            palat.add(new Pala(palat.get(palat.size() - 1).getX() + 1, palat.get(palat.size() - 1).getY()));
            if (palat.size() > pituus) {
                palat.remove(0);
            }
        }
    }

    public void kasva() {
        if (palat.size() < 3) {
            return;
        }
        this.pituus++;
    }

    public boolean osuu(Pala pala) {
        for (Pala p : palat) {
            if (p.getX() == pala.getX() && p.getY() == pala.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean osuuItseensa() {
        for (int i = 0; i < palat.size(); i++) {
            for (int j = i + 1; j < palat.size(); j++) {
                if (palat.get(i).getX() == palat.get(j).getX() && palat.get(i).getY() == palat.get(j).getY()) {
                    return true;
                }
            }
        }
        return false;
    }

}
