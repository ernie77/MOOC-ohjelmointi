/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

import java.util.Random;

/**
 *
 * @author ernie77
 */
public class Lehma implements Lypsava, Eleleva {

    private String nimi;
    private double tilavuus;
    private double maara;
    private Random rand;
    private static final String[] NIMIA = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Matti", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Lehma() {
        this.rand = new Random();
        this.nimi = NIMIA[rand.nextInt(NIMIA.length - 1)];
        this.tilavuus = Math.ceil(25 + 5 * rand.nextDouble());
        this.maara = 0;
    }

    public Lehma(String nimi) {
        this.rand = new Random();
        this.nimi = nimi;
        this.tilavuus = Math.ceil(25 + 5 * rand.nextDouble());
        this.maara = 0;
    }

    public String getNimi() {
        return this.nimi;
    }

    public double getTilavuus() {
        return this.tilavuus;
    }

    public double getMaara() {
        return this.maara;
    }

    @Override
    public String toString() {
        return this.nimi + " " + this.maara + "/" + this.tilavuus;
    }

    @Override
    public double lypsa() {
        double maitoa = this.maara;
        this.maara = 0;
        return maitoa;
    }

    @Override
    public void eleleTunti() {
        double lisaa = Math.ceil(0.7 + 1.3 * rand.nextDouble());
        if (lisaa < this.tilavuus - this.maara) {
            this.maara += lisaa;
        } else {
            this.maara = this.tilavuus;
        }
    }

}
