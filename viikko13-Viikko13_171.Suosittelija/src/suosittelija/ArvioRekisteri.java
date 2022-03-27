/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;

/**
 *
 * @author ernie77
 */
public class ArvioRekisteri {

    private Map<Elokuva, List<Arvio>> elokuvienArviot;
    private List<Arvio> arviot;
    private Map<Henkilo, Map<Elokuva, Arvio>> henkilonArviot;

    public ArvioRekisteri() {
        elokuvienArviot = new HashMap<>();
        arviot = new LinkedList<>();
        henkilonArviot = new HashMap<>();
    }

    public void lisaaArvio(Elokuva elokuva, Arvio arvio) {
        List<Arvio> ar;
        ar = new LinkedList<>();
        if (elokuvienArviot.containsKey(elokuva)) {
            ar = this.annaArviot(elokuva);
        }
        ar.add(arvio);
        elokuvienArviot.put(elokuva, ar);
    }
    
    public void lisaaArvio(Henkilo henkilo, Elokuva elokuva, Arvio arvio) {
        if (henkilonArviot.containsKey(henkilo)) {
            if (!henkilonArviot.get(henkilo).containsKey(elokuva)) {
                henkilonArviot.get(henkilo).put(elokuva, arvio);
                this.lisaaArvio(elokuva, arvio);
            }
        } else {
            Map<Elokuva, Arvio> h = new HashMap<>();
            h.put(elokuva, arvio);
            henkilonArviot.put(henkilo, h);
            this.lisaaArvio(elokuva, arvio);
        }
    }

    public List<Arvio> annaArviot(Elokuva elokuva) {
        if (!elokuvienArviot.isEmpty()) {
            return elokuvienArviot.get(elokuva);
        }
        return new LinkedList<>();
    }

    public Map<Elokuva, List<Arvio>> elokuvienArviot() {
        return elokuvienArviot;
    }

    

    public Arvio haeArvio(Henkilo henkilo, Elokuva elokuva) {
        if (henkilonArviot.get(henkilo).get(elokuva) == null) {
            return Arvio.EI_NAHNYT;
        }
        return henkilonArviot.get(henkilo).get(elokuva);
    }

    public Map<Elokuva, Arvio> annaHenkilonArviot(Henkilo henkilo) {
        if (henkilonArviot.containsKey(henkilo)) {
            return henkilonArviot.get(henkilo);
        }
        return new HashMap<>();
    }

    public List<Henkilo> arvioijat() {
        LinkedList<Henkilo> henkilot = new LinkedList<>();
        for (Henkilo h : henkilonArviot.keySet()) {
            henkilot.add(h);
        }
        return henkilot;
    }
}
