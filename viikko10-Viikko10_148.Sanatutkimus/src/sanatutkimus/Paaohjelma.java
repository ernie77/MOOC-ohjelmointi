package sanatutkimus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Paaohjelma {

    public static void main(String[] args) throws Exception {
        // testaa luokkasi toimintaa täällä

        File tiedosto = new File("src/pienilista.txt");
        // kaikki sanat tiedostossa src/sanalista.txt
       Sanatutkimus s = new Sanatutkimus(tiedosto);
       
        List<String> l = s.kaikkiVokaalitSisaltavatSanat();
        System.out.println(l);
    }
}
