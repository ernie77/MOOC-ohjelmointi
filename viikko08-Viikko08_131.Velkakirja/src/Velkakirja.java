
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Velkakirja {

    private HashMap<String, Double> velkakirja;

    public Velkakirja() {
        velkakirja = new HashMap<>();
    }

    public void asetaLaina(String nimi, double maara) {
        this.velkakirja.put(nimi, maara);
    }

    public double paljonkoVelkaa(String kuka) {
        if (this.velkakirja.containsKey(kuka)) {
            return this.velkakirja.get(kuka);
        }
        return 0;
    }
    

}
