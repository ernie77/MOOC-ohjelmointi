
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
public class Laatikko implements Talletettava {

    private double maxpaino;
    private ArrayList<Talletettava> tavarat;

    public Laatikko(double maxpaino) {
        this.maxpaino = maxpaino;
        this.tavarat = new ArrayList<>();
    }

    public void lisaa(Talletettava talletettava) {
        if (talletettava.paino() + this.paino() <= maxpaino) {
            tavarat.add(talletettava);
        }
    }

    public double paino() {
        double paino = 0;
        for (Talletettava tavara : tavarat) {
            paino += tavara.paino();
        }
        return paino;
    }

    public String toString() {
        return "Laatikko: " + tavarat.size() + " esinettä, paino yhteensä " + this.paino() + " kiloa";
    }
}
