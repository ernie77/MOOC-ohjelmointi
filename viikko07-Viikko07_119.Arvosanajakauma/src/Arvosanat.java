
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Arvosanat {

    // private ArrayList<Integer> arvosanat;

    private int[] arvosanat;

    public Arvosanat() {
        this.arvosanat = new int[6];
    }

    public void lisaa(int koepisteet) {
        if (koepisteet < 30) {
            this.arvosanat[0]++;
        }
        if (koepisteet > 29 && koepisteet < 35) {
            this.arvosanat[1]++;
        }
        if (koepisteet > 34 && koepisteet < 40) {
            this.arvosanat[2]++;
        }
        if (koepisteet > 39 && koepisteet < 45) {
            this.arvosanat[3]++;
        }
        if (koepisteet > 44 && koepisteet < 50) {
            this.arvosanat[4]++;
        }
        if (koepisteet > 49 && koepisteet < 61) {
            this.arvosanat[5]++;
        }
    }

    public double hyvaksymisprosentti() {
        int hyvaksytyt = 0;
        for (int i = 1; i < 6; i++) {
            hyvaksytyt += this.arvosanat[i];
        }
        return 100.0 * hyvaksytyt / (hyvaksytyt + this.arvosanat[0]);
    }

    public void tulosta() {
        System.out.println("Arvosanajakauma:");
        System.out.println("5: " + this.tulostaTahtia(this.arvosanat[5]));
        System.out.println("4: " + this.tulostaTahtia(this.arvosanat[4]));
        System.out.println("3: " + this.tulostaTahtia(this.arvosanat[3]));
        System.out.println("2: " + this.tulostaTahtia(this.arvosanat[2]));
        System.out.println("1: " + this.tulostaTahtia(this.arvosanat[1]));
        System.out.println("0: " + this.tulostaTahtia(this.arvosanat[0]));
        System.out.println("Hyväksymisprosentti: " + this.hyvaksymisprosentti());

    }
    
    public int tulostaTahtia(int lkm) {
        while (lkm > 0) {
            System.out.print("*");
            lkm--;
        }
        return 0;
    }
}
