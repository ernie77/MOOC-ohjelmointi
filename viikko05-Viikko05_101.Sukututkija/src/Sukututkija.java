/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Sukututkija {

    public Sukututkija() {

    }

    public void kerroHenkilosta(Henkilo henkilo) {
        if (henkilo.getNimi() == null) {
            return;
        } else {
            System.out.print(henkilo.getNimi());
        }
        if (henkilo.getAiti() == null) {
            System.out.print(", äiti tuntematon");
        } else {
            System.out.print(", äiti " + henkilo.getAiti().getNimi());
        }
        if (henkilo.getIsa() == null) {
            System.out.println(", isä tuntematon.");
        } else {
            System.out.println(", isä " + henkilo.getIsa().getNimi());
        }
    }

    public void kerroHenkilonSuvusta(Henkilo henkilo) {
        if (henkilo == null) {
            return;
        }
        this.kerroHenkilosta(henkilo);
         this.kerroHenkilonSuvusta(henkilo.getAiti());
         this.kerroHenkilonSuvusta(henkilo.getIsa());

    }
}
