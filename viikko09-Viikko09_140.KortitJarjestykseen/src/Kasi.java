
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Kasi implements Comparable<Kasi> {

    private ArrayList<Kortti> kasi;

    public Kasi() {
        kasi = new ArrayList<>();

    }

    public void lisaa(Kortti kortti) {
        kasi.add(kortti);
    }

    public void tulosta() {
        for (int i = 0; i < kasi.size(); i++) {
            System.out.println(kasi.get(i));
        }

    }

    public void jarjesta() {
        Collections.sort(kasi);
    }

    public int compareTo(Kasi kasi) {
        int arvo1 = 0;
        int arvo2 = 0;
        for (Kortti kortti : this.kasi) {
            arvo1 += kortti.getArvo();

        }
        for (Kortti kortti : kasi.kasi) {
            arvo2 += kortti.getArvo();
        }
        return arvo1 - arvo2;
    }
    
    public void jarjestaMaittain() {
        Collections.sort(kasi, new SamatMaatVierekkainArvojarjestykseen());
    }

}
