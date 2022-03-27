/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;

/**
 *
 * @author ernie77
 */
public class ElokuvaComparator implements Comparator<Elokuva> {

    private Map<Elokuva, List<Arvio>> arviot;

    public ElokuvaComparator(Map<Elokuva, List<Arvio>> arviot) {
        this.arviot = arviot;
    }

    @Override
    public int compare(Elokuva t, Elokuva t1) {
        double tk = 0;
        int lkm = 0;
        double t1k = 0;
        for (int i = 0; i < arviot.get(t).size(); i++) {
            tk += arviot.get(t).get(i).getArvo();
            lkm++;
        }
        tk = tk / lkm;
        lkm = 0;
        for (int i = 0; i < arviot.get(t1).size(); i++) {
            t1k += arviot.get(t1).get(i).getArvo();
            lkm++;
        }
        t1k = t1k / lkm;
        if (t1k - tk > 0) {
            return 1;
        }
        return -1;
    }
}
