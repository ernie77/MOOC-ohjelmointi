/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import suosittelija.comparator.ElokuvaComparator;
import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;

/**
 *
 * @author ernie77
 */
public class Suosittelija {

    private ArvioRekisteri arviorekisteri;
    private ElokuvaComparator vertailija;

    public Suosittelija(ArvioRekisteri arviorekisteri) {
        this.arviorekisteri = arviorekisteri;
        vertailija = new ElokuvaComparator(arviorekisteri.elokuvienArviot());
    }

    public Elokuva suositteleElokuva(Henkilo henkilo) {
        if (!arviorekisteri.arvioijat().contains(henkilo)) {
            List<Elokuva> elokuvat = new ArrayList<>(arviorekisteri.elokuvienArviot().keySet());
            Collections.sort(elokuvat, new ElokuvaComparator(arviorekisteri.elokuvienArviot()));
            return elokuvat.get(0);
        } else {
            Henkilo suosittelija = new Henkilo("");
            for (Henkilo h : arviorekisteri.arvioijat()) {
                if (!h.equals(henkilo)) {
                    int samuus = 0;
                    int samuuse = 0;
                    for (Elokuva e : arviorekisteri.annaHenkilonArviot(h).keySet()) {
                        for (Elokuva oe : arviorekisteri.annaHenkilonArviot(henkilo).keySet()) {
                            if (e.equals(oe)) {
                                samuus += arviorekisteri.annaHenkilonArviot(h).get(e).getArvo() * arviorekisteri.annaHenkilonArviot(henkilo).get(oe).getArvo();
                            }
                            if (samuuse < samuus) {
                                samuuse = samuus;
                                suosittelija = new Henkilo(h.getNimi());
                            }
                        }
                    }
                }
            }
            List<Elokuva> suosittelijanLista = new ArrayList<>(arviorekisteri.annaHenkilonArviot(suosittelija).keySet());
            if (!suosittelijanLista.isEmpty()) {
                /**/
                Collections.sort(suosittelijanLista, new ElokuvaComparator(arviorekisteri.elokuvienArviot()));
                /* Koodi näyttäisi toimivan oikein ilman yllä olevaa riviä. Pisteitä niin ei saa.*/
                for (Elokuva suositus : suosittelijanLista) {
                    for (Elokuva e : arviorekisteri.annaHenkilonArviot(henkilo).keySet()) {
                        if (!e.equals(suositus)) {
                            return suositus;
                        }
                    }
                }
            }
        }
        return null;
    }
}
