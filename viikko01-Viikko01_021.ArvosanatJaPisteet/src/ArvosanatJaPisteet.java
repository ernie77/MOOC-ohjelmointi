
import java.util.Scanner;

public class ArvosanatJaPisteet {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Anna pisteet [0-60]: ");
        int p = Integer.parseInt(lukija.nextLine());
        
        if (p < 30) {
            System.out.println("Arvosana: hylätty");
        } else if (p < 35) {
            System.out.println("Arvosana: 1");
        } else if (p < 40) {
            System.out.println("Arvosana: 2");
        } else if (p < 45) {
            System.out.println("Arvosana: 3");
        } else if (p < 50) {
            System.out.println("Arvosana: 4");
        } else if (p < 60) {
            System.out.println("Arvosana: 5");
        }

    }
}
