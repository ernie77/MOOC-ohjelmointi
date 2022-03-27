/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ernie77
 */
public class Hirviot {

    private List<Hirvio> hirviot;
    private Random rand;

    public Hirviot(int lkm, int x, int y) {
        rand = new Random();
        hirviot = new ArrayList<>();
        for (int i = 0; i < lkm; i++) {
            hirviot.add(new Hirvio(1 + rand.nextInt(x - 1), 1 + rand.nextInt(y - 1)));
        }
    }

    public void tulosta() {
        for (Hirvio h : hirviot) {
            h.tulosta();
        }
    }

    public boolean onkoHirvio(int x, int y) {
        for (Hirvio h : hirviot) {
            if (h.getx() == x && h.gety() == y) {
                return true;
            }
        }
        return false;
    }
    
    public void poista(int x, int y) {
        for (Hirvio h : hirviot) {
            if (h.getx() == x && h.gety() == y) {
                hirviot.remove(h);
                if (hirviot.isEmpty()) {
                    System.out.println("VOITIT!");
                }
                break;
            }
        }
    }
}
