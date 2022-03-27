
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KaikkiEri {

    public static boolean onkoListallaUseasti(ArrayList<Integer> lista, int luku) {
        // kirjoita koodia tähän
        int count = 0;
        for (int arvo : lista) {
            if (arvo == luku) {
                count++;
            }
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean kaikkiEri(ArrayList<Integer> luvut) {
        // kirjoita koodia tähän
        //ArrayList<Integer> kopio = new ArrayList<>(luvut);
        //int count = 0;
        for (int arvo : luvut) {
            if (onkoListallaUseasti(luvut, arvo)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Integer> luvut = new ArrayList<>();

        System.out.println("Anna lukuja, -99 lopettaa:");

        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == -99) {
                break;
            }
            luvut.add(luku);
        }

        if (kaikkiEri(luvut)) {
            System.out.println("Kaikki syöttämäsi luvut olivat erisuuruisia");
        } else {
            System.out.println("Syöttämiesi lukujen joukossa oli samansuuruisia");
        }
    }
}
