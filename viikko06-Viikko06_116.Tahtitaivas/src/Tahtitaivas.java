/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author ernie77
 */
public class Tahtitaivas {

    private double tiheys;
    private int leveys;
    private int korkeus;
    private int lkm;

    public Tahtitaivas(double tiheys) {
        this.tiheys = tiheys;
        this.leveys = 20;
        this.korkeus = 10;
        this.lkm = 0;
    }

    public Tahtitaivas(int leveys, int korkeus) {
        this.tiheys = 0.1;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lkm = 0;
    }

    public Tahtitaivas(double tiheys, int leveys, int korkeus) {
        this.tiheys = tiheys;
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.lkm = 0;
    }

    public void tulostaRivi() {
        Random r = new Random();
        for (int i = 0; i < this.leveys; i++) {
            if (r.nextDouble() <= this.tiheys) {
                System.out.print("*");
                this.lkm++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
    
    public void tulosta() {
        this.lkm = 0;
        for (int i = 0; i < this.korkeus; i++) {
            this.tulostaRivi();
        }
    }
    
    public int tahtiaViimeTulostuksessa() {
        return this.lkm;
    }
}
