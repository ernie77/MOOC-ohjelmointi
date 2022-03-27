
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Ostoskori {

    private Map<String, Ostos> ostoskori;

    public Ostoskori() {
        ostoskori = new HashMap<>();
    }

    public void lisaa(String tuote, int hinta) {
        if (!ostoskori.containsKey(tuote)) {
            Ostos ostos = new Ostos(tuote, 1, hinta);
            ostoskori.put(tuote, ostos);
        } else {
            Ostos ostos = ostoskori.get(tuote);
            ostos.kasvataMaaraa();
            ostoskori.put(tuote, ostos);
        }
    }

    public int hinta() {
        int hinta = 0;
        for (Ostos tuote : ostoskori.values()) {
            hinta += tuote.hinta();
        }
        return hinta;
    }

    public void tulosta() {
        for (Ostos ostos : ostoskori.values()) {
            System.out.println(ostos + "/n");
        }
    }

}
