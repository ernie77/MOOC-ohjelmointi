
import java.util.ArrayList;
import java.util.Collections;

public class Ohjelma {

    public static void main(String[] args) {
        LottoRivi lottoRivi = new LottoRivi();
        ArrayList<Integer> lottonumerot = lottoRivi.numerot();
        Collections.sort(lottonumerot);

        System.out.println("Lottonumerot:");
        for (int numero : lottonumerot) {
            System.out.print(numero + " ");
        }
        System.out.println("");
    }
}
