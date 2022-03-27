
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
    private String syote;
    private Numerotiedustelu n;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        this.n = new Numerotiedustelu();
        syote = "";
    }

    public void start() {
        while (true) {
            System.out.println("numerotiedustelu");
            System.out.println("käytettävissä olevat toiminnot");
            System.out.println("1 lisää numero");
            System.out.println("2 hae numerot");
            System.out.println("3 hae puhelinnumeroa vastaava henkilö");
            System.out.println("4 lisää osoite");
            System.out.println("5 hae henkilön tiedot");
            System.out.println("6 poista henkilön tiedot");
            System.out.println("7 filtteröity listaus");

            System.out.println("x lopeta");
            syote = lukija.nextLine();

            if (syote.equals("x")) {
                break;
            }
            if (syote.equals("1")) {
                System.out.print("kenelle: ");
                String nimi = lukija.nextLine();
                System.out.println("numero: ");
                n.lisaaNumero(nimi, lukija.nextLine());
            }
            if (syote.equals("2")) {
                System.out.print("kenen: ");
                n.haeNimella(lukija.nextLine());
            }
            if (syote.equals("3")) {
                System.out.print("numero: ");
                n.haeNumerolla(lukija.nextLine());
            }
            if (syote.equals("4")) {
                System.out.print("kenelle: ");
                String nimi = lukija.nextLine();
                System.out.print("katu: ");
                String katu = lukija.nextLine();
                System.out.print("kaupunki: ");
                String kaupunki = lukija.nextLine();
                n.lisaaOsoite(nimi, katu, kaupunki);
            }
            if (syote.equals("5")) {
                System.out.print("kenen: ");
                n.haeTiedot(lukija.nextLine());
            }
            if (syote.equals("6")) {
                System.out.print("kenet: ");
                n.poista(lukija.nextLine());
            }
            if (syote.equals("7")) {
                System.out.print("hakusana (jos tyhjä, listataan kaikki): ");
                n.haku(lukija.nextLine());
            }
        }
    }

}
