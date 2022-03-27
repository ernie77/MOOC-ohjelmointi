
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // Testaa ohjelmasi toimintaa täällä!
        Kirjasto kirjasto = new Kirjasto();
        Kirja cheese = new Kirja("Chees...", "Woodhead Publishing", 2007);
        Kirja jokunen = new Kirja("Jaska Jokunen", "Otava Publishing", 1999);
        
        kirjasto.lisaaKirja(cheese);
        kirjasto.lisaaKirja(jokunen);
        
        ArrayList<Kirja> hakutulos = kirjasto.haeKirjaNimikkeella("Jaska");
        for (Kirja kirja : hakutulos) {
            System.out.println(kirja);
        }
        
        //System.out.println(cheese.nimike());
        
        
        //System.out.println(cheese);
        
        //kirjasto.tulostaKirjat();
    }
}
