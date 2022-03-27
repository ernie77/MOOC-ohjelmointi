
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SanatAakkosjarjestyksessa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // tee tänne edellisen tehtävän tapaan ArrayList johon laitat sanat
        ArrayList<String> sanat = new ArrayList<>();
        String sana = "a";
        while (!sana.isEmpty()) {
            System.out.println("Anna sana :");
            sana = lukija.nextLine();
            sanat.add(sana);            
        }
        Collections.sort(sanat);
        for (String tulosta : sanat) {
            System.out.println(tulosta);
        }
    }
}
