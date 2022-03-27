
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Lentokoneet {
    private HashMap<String, Lentokone> lentokoneet;
    private Scanner lukija;
    
    public Lentokoneet(Scanner lukija) {
        lentokoneet = new HashMap<>();
        this.lukija = lukija;
    }
    
    public void addLentokone() {
        Lentokone lentokone = new Lentokone();
        System.out.print("Anna lentokoneen tunnus: ");
        
        lentokone.setTunnus(lukija.nextLine());
        System.out.print("Anna lentokoneen kapasiteetti: ");
        lentokone.setKapasiteetti(Integer.parseInt(lukija.nextLine()));
        this.lentokoneet.put(lentokone.getTunnus(), lentokone);
    }
    
    public ArrayList<String> lentokoneetListana() {
        
        ArrayList<String> kaikki = new ArrayList<>();
        for (String avain : lentokoneet.keySet()) {
            kaikki.add(avain + " (" + lentokoneet.get(avain).getKapasiteetti() + " henkilöä)");
        }
        return kaikki;
    }
    
    public String lentokone(String tunnus) {
        return lentokoneet.get(tunnus).getTunnus() + " (" + lentokoneet.get(tunnus).getKapasiteetti() + " henkilöä)";
    }
}
