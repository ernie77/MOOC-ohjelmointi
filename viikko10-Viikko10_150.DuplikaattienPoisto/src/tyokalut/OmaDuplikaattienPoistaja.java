/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalut;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ernie77
 */
public class OmaDuplikaattienPoistaja implements DuplikaattienPoistaja {

    private Set<String> lista;
    private int tuplat;

    public OmaDuplikaattienPoistaja() {
        lista = new HashSet<>();
        tuplat = 0;
    }

    @Override
    public void lisaa(String merkkijono) {
        if (!lista.contains(merkkijono)) {
            lista.add(merkkijono);
        } else {
            tuplat++;
        }
    }

    @Override
    public int getHavaittujenDuplikaattienMaara() {
        return tuplat;
    }

    @Override
    public Set<String> getUniikitMerkkijonot() {
        return lista;
    }

    @Override
    public void tyhjenna() {
        lista.clear();
        tuplat = 0;
    }

}
