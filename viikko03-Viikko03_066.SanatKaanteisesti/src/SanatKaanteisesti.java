import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SanatKaanteisesti {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Tee tänne edellisen tehtävän tapaan ArrayList, johon laitat sanat
        ArrayList<String> sanat = new ArrayList<>();
        String sana = "a";
        int paikka = 0;
        while (!sana.isEmpty()) {
            System.out.println("Anna sana :");
            sana = lukija.nextLine();
            sanat.add(sana);
            paikka++;
        }
        while (paikka > 0) {
            System.out.println(sanat.get(paikka - 1));
            paikka--;
        }
    }
}
