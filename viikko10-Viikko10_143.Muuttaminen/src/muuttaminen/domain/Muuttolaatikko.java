/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muuttaminen.domain;

import java.util.ArrayList;

/**
 *
 * @author ernie77
 */
public class Muuttolaatikko implements Tavara{

    private int maksimitilavuus;
    private ArrayList<Tavara> tavarat;

    public Muuttolaatikko(int maksimitilavuus) {
        this.maksimitilavuus = maksimitilavuus;
        tavarat = new ArrayList<>();
    }

    public boolean lisaaTavara(Tavara tavara) {
        if (tavara.getTilavuus() <= this.maksimitilavuus - this.getTilavuus()) {
            tavarat.add(tavara);
            return true;
        }
        return false;
    }

    @Override
    public int getTilavuus() {
        int tilavuudet = 0;
        for (Tavara t : tavarat){
            tilavuudet += t.getTilavuus();
        }
        return tilavuudet;
    }

}
