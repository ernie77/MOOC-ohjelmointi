/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muuttaminen.logiikka;

import java.util.ArrayList;
import java.util.List;
import muuttaminen.domain.Muuttolaatikko;
import muuttaminen.domain.Tavara;

/**
 *
 * @author ernie77
 */
public class Pakkaaja {

    private int laatikonTilavuus;
    private List<Muuttolaatikko> laatikot;

    public Pakkaaja(int laatikoidenTilavuus) {
        this.laatikonTilavuus = laatikoidenTilavuus;
        this.laatikot = new ArrayList<>();
    }

    public List<Muuttolaatikko> pakkaaTavarat(List<Tavara> tavarat) {
        Muuttolaatikko muuttolaatikko = new Muuttolaatikko(laatikonTilavuus);
        for (Tavara t : tavarat) {
            if (!muuttolaatikko.lisaaTavara(t)) {
                laatikot.add(muuttolaatikko);
                muuttolaatikko = new Muuttolaatikko(laatikonTilavuus);
            }
            muuttolaatikko.lisaaTavara(t);
            
        }
        laatikot.add(muuttolaatikko);
        return laatikot;
    }
}
