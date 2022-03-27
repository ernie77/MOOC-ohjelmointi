
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Sanakirja sanakirja = new Sanakirja();

        Tekstikayttoliittyma t = new Tekstikayttoliittyma(lukija, sanakirja);
        
        t.kaynnista();
    }
}
