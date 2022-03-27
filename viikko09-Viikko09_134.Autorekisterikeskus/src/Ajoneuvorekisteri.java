
import java.util.ArrayList;
import java.util.Collection;
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
public class Ajoneuvorekisteri {

    private HashMap<Rekisterinumero, String> omistajat;

    public Ajoneuvorekisteri() {
        omistajat = new HashMap<>();
    }

    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {
        if (omistajat.containsKey(rekkari)) {
            return false;
        }
        omistajat.put(rekkari, omistaja);
        return true;

    }

    public String hae(Rekisterinumero rekkari) {
        return omistajat.get(rekkari);
    }

    public boolean poista(Rekisterinumero rekkari) {
        return omistajat.remove(rekkari, this.hae(rekkari));
    }

    public void tulostaOmistajat() {
        ArrayList<String> c = new ArrayList<>();
        for (String omistaja : omistajat.values()) {
            if (!c.contains(omistaja)) {
                System.out.println(omistaja);
                c.add(omistaja);                
            }
        }
    }

    public void tulostaRekisterinumerot() {
        for (Rekisterinumero rekNro : omistajat.keySet()) {
            System.out.println(rekNro.toString());
        }
    }
}
