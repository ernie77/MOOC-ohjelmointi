
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
public class Sademaara {
    private List<Double> sademaarat;
    
    public Sademaara() {
        sademaarat = new ArrayList<>();
    }
    
    public void keskiarvo() {
        sademaarat.stream().filter(i -> i >= 0).mapToDouble(i -> i).average().ifPresent(System.out::println);
    }
    
    public void lisaa(double maara) {
        sademaarat.add(maara);
    }
}
