/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ernie77
 */
public class OmaUseanKaannoksenSanakirja implements UseanKaannoksenSanakirja {

    private Map<String, Set<String>> sanakirja;

    public OmaUseanKaannoksenSanakirja() {
        this.sanakirja = new HashMap<>();
    }

    @Override
    public void lisaa(String sana, String kaannos) {
        if (!sanakirja.containsKey(sana)) {
            sanakirja.put(sana, new HashSet<>());
        }
        this.sanakirja.get(sana).add(kaannos);
    }

    @Override
    public Set<String> kaanna(String sana) {
        return this.sanakirja.get(sana);
    }

    @Override
    public void poista(String sana) {
        if (sanakirja.containsKey(sana)) {
            sanakirja.remove(sana);
        }
    }

}
