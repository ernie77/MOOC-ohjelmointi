
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Rengastustoimisto {

    private Map<Lintu, List<String>> toimisto;

    public Rengastustoimisto() {
        this.toimisto = new HashMap<>();
    }

    public void havaitse(Lintu lintu, String paikka) {
        if (!toimisto.containsKey(lintu)) {
            List<String> p = new ArrayList<>();
            p.add(paikka);
            this.toimisto.put(lintu, p);
        } else {
            this.toimisto.get(lintu).add(paikka);

        }
    }

    public void havainnot(Lintu lintu) {
        if (toimisto.containsKey(lintu)) {
            System.out.println(lintu + " havaintoja: " + toimisto.get(lintu).size());
            System.out.println(toimisto.get(lintu).toString());
        }
        System.out.println(lintu + " havaintoja: 0");
    }
}
