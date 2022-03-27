
import java.util.ArrayList;
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
public class Lintukanta {

    private ArrayList<Lintu> lintukanta;

    public Lintukanta() {
        this.lintukanta = new ArrayList<>();
    }

    public void lisaa(Scanner lukija) {
        String nimi;
        String latnimi;
        System.out.print("Anna nimi: ");
        nimi = lukija.nextLine();
        System.out.print("Anna latinalainen nimi: ");
        latnimi = lukija.nextLine();
        Lintu lintu = new Lintu(nimi, latnimi);

        this.lintukanta.add(lintu);
    }

    public void havainto(Scanner lukija) {
        System.out.print("Mikä? ");
        String nimi = lukija.nextLine();
        for (Lintu lintu : lintukanta) {
            if (lintu.nimi().contains(nimi)) {
                lintu.havainto();
            }
        }

    }

    public void nayta(Scanner lukija) {
        String nimi;
        System.out.print("Mikä? ");
        nimi = lukija.nextLine();
        for (Lintu lintu : lintukanta) {
            if (lintu.nimi().contains(nimi)) {
                System.out.println(lintu.toString());
            }
        }
        //System.out.println(this.lintukanta);        
    }

    public void tilasto() {
        System.out.println(this.lintukanta);
    }

}
