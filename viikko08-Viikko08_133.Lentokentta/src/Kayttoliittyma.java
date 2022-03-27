
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
public class Kayttoliittyma {

    private Scanner lukija;
    private Lentokoneet lentokoneet;
    private Lennot lennot;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        this.lentokoneet = new Lentokoneet(lukija);
        this.lennot = new Lennot(lukija, lentokoneet);
    }

    public void kaynnista() {
        System.out.println("Lentokentän hallinta");
        System.out.println("--------------------");
        while (true) {
            System.out.println("Valitse toiminto:");
            System.out.println("[1] Lisää lentokone");
            System.out.println("[2] Lisää lento");
            System.out.println("[x] Poistu hallintamoodista");
            System.out.print("> ");
            String komento = lukija.nextLine();
            hallintakomento(komento);
            if (komento.equals("x")) {
                System.out.println("Lentopalvelu");
                System.out.println("------------");
                while (true) {
                    System.out.println("Valitse toiminto:");
                    System.out.println("[1] Tulosta lentokoneet");
                    System.out.println("[2] Tulosta lennot");
                    System.out.println("[3] Tulosta lentokoneen tiedot");
                    System.out.println("[x] Lopeta");
                    System.out.print("> ");
                    komento = lukija.nextLine();
                    lentopalvelukomento(komento);
                    if (komento.equals("x")) {
                        return;
                    }
                }
                //hoidaKomento(komento);

            }
        }
    }

    public void hallintakomento(String komento) {
        if (komento.equals("1")) {
            lentokoneet.addLentokone();
        }
        if (komento.equals("2")) {
            lennot.addLento();
        }
    }

    public void lentopalvelukomento(String komento) {
        if (komento.equals("1")) {
            System.out.println(lentokoneet.lentokoneetListana());
        }
        if (komento.equals("2")) {
            lennot.tulosta();
        }
        if (komento.equals("3")) {
            System.out.println("Mikä kone:");
            System.out.println(lentokoneet.lentokone(lukija.nextLine()));
        }
    }
}
