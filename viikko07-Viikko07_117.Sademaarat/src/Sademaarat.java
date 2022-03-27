
import java.util.ArrayList;
import java.util.Collections;
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
public class Sademaarat {
    
    
    private final ArrayList<Double> sademaarat;
    
    public Sademaarat() {
        this.sademaarat = new ArrayList<>();
    }
    
    public void lisaa(double sademaara) {
        this.sademaarat.add(sademaara);
    }
    
    public double keskiarvo() {
        double sum = 0;
        int i = 0;
        for (double sademaara : sademaarat) {
            sum += sademaara;
            i++;
        }
        return sum / i;
    }
}

