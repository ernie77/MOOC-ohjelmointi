
import java.util.ArrayList;
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
public class Sanakirja {

    private HashMap<String, String> sanakirja;

    public Sanakirja() {
        sanakirja = new HashMap<>();
    }

    public void lisaa(String sana, String kaannos) {
        this.sanakirja.put(sana, kaannos);
    }

    public String kaanna(String sana) {
        return sanakirja.get(sana);
    }

    public int sanojenLukumaara() {
        return sanakirja.size();
    }
    
    public ArrayList<String> kaannoksetListana() {
        ArrayList<String> kaannokset = new ArrayList<>();
        for (String avain : sanakirja.keySet()) {
            kaannokset.add(avain + " = " + sanakirja.get(avain));
            
        }
        return kaannokset;
    }
}
