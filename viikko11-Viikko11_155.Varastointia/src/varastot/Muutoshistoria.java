/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernie77
 */
public class Muutoshistoria {

    private List<Double> historia;

    public Muutoshistoria() {
        historia = new ArrayList<>();
    }

    public void lisaa(double tilanne) {
        historia.add(tilanne);
    }

    public void nollaa() {
        historia.clear();
    }

    public String toString() {
        return historia.toString();
    }

    public double maxArvo() {
        double suurin = 0;
        for (double arvo : historia) {
            if (arvo > suurin) {
                suurin = arvo;
            }
        }
        return suurin;
    }

    public double minArvo() {
        double pienin = historia.get(0);
        for (double arvo : historia) {
            if (arvo < pienin) {
                pienin = arvo;
            }
        }
        return pienin;
    }

    public double keskiarvo() {
        double sum = 0;
        int lkm = 0;
        for (double arvo : historia) {
            sum += arvo;
            lkm++;
        }
        return sum / lkm;
    }

    public double suurinMuutos() {
        double edellinen = historia.get(0);
        double muutos = 0;
        double suurinmuutos = 0;
        for (double arvo : historia) {
            muutos = Math.abs(edellinen - arvo);
            edellinen = arvo;
            if (muutos > suurinmuutos) {
                suurinmuutos = muutos;
            }
        }
        return suurinmuutos;
    }

    public double varianssi() {
        double sum = 0;
        int lkm = 0;
        for (double arvo : historia) {
            sum += Math.pow(arvo - this.keskiarvo(), 2);
            lkm++;
        }
        return sum / (lkm - 1);
    }
}
