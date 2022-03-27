//import java.util.ArrayList;
//import java.util.Collections;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Testaa ohjelmasi toimintaa täällä!
        double sademaara = 0;
        Sademaarat sademaarat = new Sademaarat();
        System.out.println("Anna sademääriä, lopeta luvulla 999999");
        while (sademaara != 999999) {
            sademaara = Double.parseDouble(lukija.nextLine());
            if (sademaara == 999999) {
                System.out.println("Sademäärien keskiarvo on " + sademaarat.keskiarvo());
                return;
            }
            sademaarat.lisaa(sademaara);
        }
        
    }
}
