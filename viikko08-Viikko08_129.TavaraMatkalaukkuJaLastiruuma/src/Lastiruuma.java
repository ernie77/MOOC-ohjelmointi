
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
public class Lastiruuma {

    private final int maxpaino;
    private ArrayList<Matkalaukku> matkalaukut;

    public Lastiruuma(int maxpaino) {
        this.maxpaino = maxpaino;
        matkalaukut = new ArrayList<>();
    }

    public int getPaino() {
        int paino = 0;
        for (Matkalaukku laukku : matkalaukut) {
            paino += laukku.getPaino();
        }
        return paino;
    }

    public void lisaaMatkalaukku(Matkalaukku laukku) {
        if (laukku.getPaino() + this.getPaino() <= maxpaino) {
            this.matkalaukut.add(laukku);
        }

    }

    public String toString() {
        return matkalaukut.size() + " matkalaukkua (" + this.getPaino() + " kg)";
    }

    public void tulostaTavarat() {
        System.out.println("Ruuman matkalaukuissa on seuraavat tavarat:");
        for (Matkalaukku laukku : matkalaukut) {
            laukku.tulostaTavarat();

        }
    }

}


