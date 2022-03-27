
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Puhelinmuistio {

    private ArrayList<Henkilo> lista;

    public Puhelinmuistio() {
        this.lista = new ArrayList<>();
    }

    public void lisaa(String nimi, String numero) {
        Henkilo uusi = new Henkilo(nimi, numero);
        lista.add(uusi);
    }

    public void tulostaKaikki() {
        for (Henkilo tuloste : lista) {
            System.out.println(tuloste.toString());
        }
    }

    public String haeNumero(String nimi) {
        for (Henkilo tuloste : lista) {
            if (tuloste.haeNimi().equals(nimi)) {
                return tuloste.haeNumero();
            }     

        }
        return "numero ei ole tiedossa";
    }
}
