
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Hyppaaja implements Comparable<Hyppaaja> {
    
    private String nimi;
    private int pisteet;
    private ArrayList<Integer> pituudet;
    private ArrayList<Integer> tuomaripisteet;
    
    public Hyppaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = 0;
        pituudet = new ArrayList<>();
        tuomaripisteet = new ArrayList<>();
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public String getPituus(int kierros) {
        return "    pituus: " + pituudet.get(kierros - 1);
    }
    
    public String getTuomaripisteet(int kierros) {
        return tuomaripisteet.toString();
    }
    
    public String getPituudet() {
        return pituudet.toString();
    }
    
    public String toString() {
        return nimi + " (" + pisteet + " pistettä)";
    }
    
    public int compareTo(Hyppaaja hyppaaja) {
        return hyppaaja.pisteet - this.pisteet;
        
    }
    
    void hyppy() {
        Random random = new Random();
        int pituus = random.nextInt(60) + 60;
        this.pituudet.add(pituus);
        this.pisteet += pituus;
        this.tuomaripisteet.clear();
        for (int i = 0; i < 5; i++) {
            this.tuomaripisteet.add(random.nextInt(10) + 10);
            
        }
        Collections.sort(tuomaripisteet);
        for (int i = 1; i < 4; i++) {
            this.pisteet += this.tuomaripisteet.get(i);
        }
    }
}
