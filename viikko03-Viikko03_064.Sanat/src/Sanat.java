import java.util.ArrayList;
import java.util.Scanner;

public class Sanat {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> sanat = new ArrayList<>();
        String sana = "a";
        while (!sana.isEmpty()) {
            System.out.println("Anna sana :");
            sana = lukija.nextLine();
            sanat.add(sana);
            
        }
        for (String tulos : sanat) {
            System.out.println(tulos);
        }
    }
}
