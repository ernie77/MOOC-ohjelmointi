/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernie77
 */
public class Keskiarvosensori implements Sensori {

    private ArrayList<Sensori> sensorit;
    private List<Integer> mittaukset;

    public Keskiarvosensori() {
        sensorit = new ArrayList<>();
        mittaukset = new ArrayList<>();
    }

    public void lisaaSensori(Sensori lisattava) {
        if (lisattava.onPaalla()) {
            this.paalle();
        }
        sensorit.add(lisattava);

    }

    @Override
    public boolean onPaalla() {
        for (Sensori s : sensorit) {
            if (!s.onPaalla()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void paalle() {
        for (Sensori s : sensorit) {
            s.paalle();
        }
    }

    @Override
    public void poisPaalta() {
        for (Sensori s : sensorit) {
            s.poisPaalta();
        }
    }

    @Override
    public int mittaa() {
        int sum = 0;
        if (!this.onPaalla() || sensorit.isEmpty()) {
            throw new IllegalArgumentException("");
        }
        for (Sensori s : sensorit) {
            sum += s.mittaa();
        }
        mittaukset.add(sum / sensorit.size());
        return sum / sensorit.size();
    }

    public List<Integer> mittaukset() {
        return mittaukset;

    }
}
