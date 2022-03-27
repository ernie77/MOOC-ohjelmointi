
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Varasto {

    private Map<String, Integer> hinnat;
    private Map<String, Integer> saldot;

    public Varasto() {
        hinnat = new HashMap<>();
        saldot = new HashMap<>();
    }

    public void lisaaTuote(String tuote, int hinta, int saldo) {
        hinnat.put(tuote, hinta);
        saldot.put(tuote, saldo);
    }

    public int hinta(String tuote) {
        if (hinnat.containsKey(tuote)) {
            return hinnat.get(tuote);
        }
        return -99;
    }

    public int saldo(String tuote) {
        if (saldot.containsKey(tuote)) {
            return saldot.get(tuote);
        }
        return 0;
    }

    public boolean ota(String tuote) {
        if (saldot.containsKey(tuote) && saldot.get(tuote) > 0) {
            saldot.put(tuote, (saldot.get(tuote) - 1));
            return true;
        }
        return false;
    }

    public Set<String> tuotteet() {        
        return hinnat.keySet();
    }
    
    
}
