
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Henkilo implements Comparable {

    private String nimi;
    private String katu;
    private String kaupunki;
    private List<String> puhno;

    public Henkilo(String nimi) {
        this.nimi = nimi;
        this.puhno = new ArrayList<>();
        this.katu = "";
        this.kaupunki = "osoite ei tiedossa";
    }

    public void setNumero(String numero) {
        this.puhno.add(numero);
    }

    public void setKatu(String katu) {
        this.katu = katu;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    public String getNimi() {
        return this.nimi;
    }

    public String getKatu() {
        return this.katu;
    }

    public String getKaupunki() {
        return this.kaupunki;
    }

    public String getPuhno() {

        return this.puhno.toString();
    }

    public String toString() {
        return this.getNimi() + " " + this.getKatu() + " " + this.getKaupunki() + " " + this.getPuhno();
    }

    @Override
    public int compareTo(Object t) {
        String vertaa = ((Henkilo) t).getNimi();
        return String.CASE_INSENSITIVE_ORDER.compare(this.getNimi(), vertaa);
    }

}
