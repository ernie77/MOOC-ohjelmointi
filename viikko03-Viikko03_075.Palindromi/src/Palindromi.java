
import java.util.Scanner;

public class Palindromi {

    public static String kaanna(String merkkijono) {
        // Kirjoita koodia tähän.
        String apu = "";
        for (int i = merkkijono.length() - 1; i >= 0; i--) {
            apu = apu + merkkijono.charAt(i);
        }
        // Metodin on siis palautettava käännetty merkkijono returnilla!
        return apu;
    }

    public static boolean palindromi(String merkkijono) {
        // kirjoita koodia tähän
        return merkkijono.equals(kaanna(merkkijono));
    }

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Anna merkkijono: ");
        String merkkijono = lukija.nextLine();
        if (palindromi(merkkijono)) {
            System.out.println("Merkkijono on palindromi!");
        } else {
            System.out.println("Merkkijono ei ole palindromi!");
        }
    }
}
