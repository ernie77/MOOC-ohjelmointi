/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilosto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ernie77
 */
public class Tyontekijat {
    private List<Henkilo> tyontekijat;
    
    public Tyontekijat() {
        tyontekijat = new ArrayList<>();
    }
    
    public void lisaa(Henkilo henkilo) {
        tyontekijat.add(henkilo);
    }
    
    public void lisaa(List<Henkilo> henkilot) {
        for (Henkilo h : henkilot) {
            tyontekijat.add(h);
        }
    }
    
    public void tulosta() {
        Iterator<Henkilo> iteraattori = tyontekijat.iterator();
        while (iteraattori.hasNext()) {
            System.out.println(iteraattori.next());
        }
    }
    
    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = tyontekijat.iterator();
        while ( iteraattori.hasNext()) {
            Henkilo h = iteraattori.next();
            if (h.getKoulutus().equals(koulutus)) {
                System.out.println(h);
            }
        }
    }
    
    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = tyontekijat.iterator();
        while ( iteraattori.hasNext()) {
            Henkilo h = iteraattori.next();
            if (h.getKoulutus().equals(koulutus)) {
                iteraattori.remove();
            }
        }
    }
}
