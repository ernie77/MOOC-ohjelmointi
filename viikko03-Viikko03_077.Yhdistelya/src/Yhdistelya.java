
import java.util.ArrayList;
import java.util.Collections;

public class Yhdistelya {

    public static void main(String[] args) {

        //Alustetaan listat
        //Allaolevia lukuja saa muuttaa testatessa
        ArrayList<Integer> lista1 = new ArrayList<>();
        ArrayList<Integer> lista2 = new ArrayList<>();

        Collections.addAll(lista1, 4, 3);
        // addAll tekee saman kuin komennot:
        // lista1.add(4);
        // lista1.add(3);

        Collections.addAll(lista2, 5, 10, 7, 3);
        // addAll tekee saman kuin komennot:
        // lista2.add(5);
        // lista2.add(10);
        // lista2.add(7);

        //Toteuta metodi yhdista ja testaa sen toimintaa eri listoilla
        //yhdista(lista1, lista2);
        System.out.println(lista1);
        System.out.println(lista2);

        // Toteuta tämän jälkeen metodi joukkoYhdista ja testaa sen toimintaa
        // eri listoilla
        joukkoYhdista(lista1, lista2);
        System.out.println(lista1);
        System.out.println(lista2);
    }

    public static void yhdista(ArrayList<Integer> eka, ArrayList<Integer> toka) {
        eka.addAll(toka);
    }

    public static void joukkoYhdista(ArrayList<Integer> eka, ArrayList<Integer> toka) {
        for (int arvo : toka) {
            if (!eka.contains(arvo)) {
                eka.add(arvo);
            }
        }
    }
}
