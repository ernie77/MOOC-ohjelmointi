
import java.util.ArrayList;
import java.util.Scanner;

public class ToistuvaSana {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // tee tänne edellisen tehtävän tapaan ArrayList johon laitat sanat
        ArrayList<String> sanat = new ArrayList<>();
        String sana = "a";
        while (!sana.isEmpty()) {
            System.out.println("Anna sana: ");
            sana = lukija.nextLine();
            
            if (sanat.contains(sana)) {
                System.out.println("Annoit uudestaan sanan " + sana);
                break;
                    
            }
            sanat.add(sana);
        }

    }
}
