
import java.util.Scanner;

public class YmpyranKehanPituus {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. 
        System.out.println("Anna ympyrän säde:");
        int r = Integer.parseInt(lukija.nextLine());
        
        
        System.out.println("Ympyrän kehä: " + (2  * Math.PI * r));        
    }
}
