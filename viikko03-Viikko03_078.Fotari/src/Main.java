
import java.util.ArrayList;
import java.util.Scanner;
import kuva.Fotari;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner lukija = new Scanner(System.in);

        // käytössä ilta.jpg, puu.jpg, kukka.jpg ja fluffy.jpg
        System.out.print("Mikä kuva avataan? ");
        String kuva = lukija.nextLine();

        Fotari.avaa(kuva);

        while (true) {
            System.out.print("komento (lopeta, vaalenna, tummenna, negatiivi, peilaa, andywarhol)? ");
            String komento = lukija.nextLine();

            if (komento.equals("lopeta")) {
                Fotari.sulje();
                break;
            }

            if (komento.equals("vaalenna")) {
                vaalenna();
            }
            if (komento.equals("tummenna")) {
                tummenna();

            }
            if (komento.equals("negatiivi")) {
                negatiivi();

            }
            if (komento.equals("peilaa")) {
                peilaa();

            }
            if (komento.equals("andywarhol")) {
                andywarhol();

            }

        }

    }

    public static void vaalenna() {
        int x = 0;
        while (x < Fotari.kuvanLeveys()) {
            int y = 0;
            while (y < Fotari.kuvanKorkeus()) {
                int punainen = Fotari.punainen(x, y);
                int vihrea = Fotari.vihrea(x, y);
                int sininen = Fotari.sininen(x, y);

                Fotari.asetaVari(x, y,
                        Math.min(255, punainen + 30),
                        Math.min(255, vihrea + 30),
                        Math.min(255, sininen + 30));

                y++;
            }
            x++;
        }
    }

    public static void tummenna() {
        int x = 0;
        while (x < Fotari.kuvanLeveys()) {
            int y = 0;
            while (y < Fotari.kuvanKorkeus()) {
                int punainen = Fotari.punainen(x, y);
                int vihrea = Fotari.vihrea(x, y);
                int sininen = Fotari.sininen(x, y);

                Fotari.asetaVari(x, y,
                        Math.max(0, punainen - 30),
                        Math.max(0, vihrea - 30),
                        Math.max(0, sininen - 30));

                y++;
            }
            x++;
        }
    }

    public static void negatiivi() {
        int x = 0;
        while (x < Fotari.kuvanLeveys()) {
            int y = 0;
            while (y < Fotari.kuvanKorkeus()) {
                int punainen = Fotari.punainen(x, y);
                int vihrea = Fotari.vihrea(x, y);
                int sininen = Fotari.sininen(x, y);

                Fotari.asetaVari(x, y,
                        Math.max(0, 255 - punainen),
                        Math.max(0, 255 - vihrea),
                        Math.max(0, 255 - sininen));

                y++;
            }
            x++;
        }
    }

    public static void peilaa() {
        int x = 0;
        while (x < Fotari.kuvanLeveys() / 2) {
            int y = 0;
            while (y < Fotari.kuvanKorkeus()) {
                int punainen = Fotari.punainen(x, y);
                int vihrea = Fotari.vihrea(x, y);
                int sininen = Fotari.sininen(x, y);

                Fotari.asetaVari(Fotari.kuvanLeveys() - x - 1, y,
                        Math.max(0, Fotari.punainen(x, y)),
                        Math.max(0, Fotari.vihrea(x, y)),
                        Math.max(0, Fotari.sininen(x, y)));

                y++;
            }
            x++;
        }
    }
    
    public static void andywarhol() {
        int x = 0;
        while (x < Fotari.kuvanLeveys()) {
            int y = 0;
            while (y < Fotari.kuvanKorkeus()) {
                int punainen = Fotari.punainen(x, y);
                int vihrea = Fotari.vihrea(x, y);
                int sininen = Fotari.sininen(x, y);
                peilaa();
                Fotari.asetaVari(x, y,
                        Math.max(0, Fotari.punainen(x, y)),
                        Math.max(0, Fotari.vihrea(x, y)),
                        Math.max(0, Fotari.sininen(x, y)));

                y++;
            }
            x++;
        }
    }
}
