
public class Hymiot {

    public static void main(String[] args) {
        // Testaa metodisi toimintaa ainakin seuraavilla kutsuilla
        tulostaHymioityna("Metodi");
        tulostaHymioityna("Hajautustaulu");
        tulostaHymioityna("Rajapinta");
    }

    private static void tulostaHymioityna(String merkkijono) {
        if (merkkijono.length() % 2 == 0) {
            tulostaHymioita(merkkijono);
            System.out.println(":) " + merkkijono + " :)");
            tulostaHymioita(merkkijono);
        }

        if (merkkijono.length() % 2 == 1) {
            merkkijono = merkkijono + " ";
            tulostaHymioita(merkkijono);
            System.out.println(":) " + merkkijono + " :)");
            tulostaHymioita(merkkijono);
        }

    }

    private static void tulostaHymioita(String merkkijono) {
        for (int i = (merkkijono.length() / 2) + 3; i > 0; i--) {
            System.out.print(":)");
        }
        System.out.println("");
    }
}
