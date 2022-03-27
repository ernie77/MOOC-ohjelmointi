
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
public class Kirjasto {

    private ArrayList<Kirja> kirjasto;

    public Kirjasto() {
        this.kirjasto = new ArrayList<>();
    }

    public void lisaaKirja(Kirja uusiKirja) {
        this.kirjasto.add(uusiKirja);
    }

    public void tulostaKirjat() {
        for (Kirja kirja : kirjasto) {
            System.out.println(kirja);
        }
    }

    public ArrayList<Kirja> haeKirjaNimikkeella(String nimike) {
        ArrayList<Kirja> loydot = new ArrayList<>();

        for (Kirja kirja : kirjasto) {
            if (StringUtils.sisaltaa(kirja.nimike(), nimike)) {
                loydot.add(kirja);
            }
        }
        return loydot;
    }

    public ArrayList<Kirja> haeKirjaJulkaisijalla(String julkaisija) {
        ArrayList<Kirja> loydot = new ArrayList<>();

        for (Kirja kirja : kirjasto) {
            if (StringUtils.sisaltaa(kirja.julkaisija(), julkaisija)) {
                loydot.add(kirja);
            }
        }
        return loydot;
    }

    public ArrayList<Kirja> haeKirjaJulkaisuvuodella(int julkaisuvuosi) {
        ArrayList<Kirja> loydot = new ArrayList<>();

        for (Kirja kirja : kirjasto) {
            if (kirja.julkaisuvuosi() == julkaisuvuosi) {
                loydot.add(kirja);
            }
        }
        return loydot;
    }
}
