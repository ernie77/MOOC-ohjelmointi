
import java.util.Scanner;

public class MerkkijononKaantaminen {

    public static String kaanna(String merkkijono) {
        // Kirjoita koodia tähän.
        String apu = "";
        for (int i = merkkijono.length() - 1; i >= 0; i--) {
            apu = apu + merkkijono.charAt(i);
        }
        // Metodin on siis palautettava käännetty merkkijono returnilla!
        return apu;
    }

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Anna merkkijono: ");
        String merkkijono = lukija.nextLine();
        System.out.println("Väärinpäin: " + kaanna(merkkijono));
    }
}
