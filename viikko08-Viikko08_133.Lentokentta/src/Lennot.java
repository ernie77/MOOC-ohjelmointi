
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
public class Lennot {

    private ArrayList<String> lennot;
    private Scanner lukija;
    private Lentokoneet lentokoneet;

    public Lennot(Scanner lukija, Lentokoneet lentokoneet) {
        this.lennot = new ArrayList<>();
        this.lukija = lukija;
        this.lentokoneet = lentokoneet;
    }

    public void addLento() {
        System.out.print("Anna lentokoneen tunnus:");
        String lento;
        lento = lentokoneet.lentokone(lukija.nextLine());
        System.out.print("Anna lähtöpaikan tunnus: ");
        lento += " (" + lukija.nextLine();
        System.out.print("Anna kohdepaikan tunnus:");
        lento += "-" + lukija.nextLine() + ")";
        lennot.add(lento);

    }

    public void tulosta() {
        for (int i = 0; i < lennot.size(); i++) {
            System.out.println(lennot.toString());
        }

    }

}
