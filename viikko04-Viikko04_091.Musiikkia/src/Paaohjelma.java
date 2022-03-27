
import java.util.ArrayList;
import java.util.Scanner;
import tktl.Soitin;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Aani> aanet = new ArrayList<>();
        String nuotti;
        System.out.println("Kirjoita soitettavat äänet");
        nuotti = lukija.nextLine();
        if (nuotti.equals("TKO-ALY")) {
            aanet.add(new Aani(430.000, 0.6));
            aanet.add(new Aani(492.000, 0.6));
            aanet.add(new Aani(444.000, 0.6));
            aanet.add(new Aani(420.000, 0.6));
            aanet.add(new Aani(365.000, 0.6));
            aanet.add(new Aani(396.000, 0.6));
        }
        for (char ch : nuotti.toCharArray()) {
            if (ch == 'C') {
                aanet.add(new Aani(261.626, 0.5));
            }
            if (ch == 'D') {
                aanet.add(new Aani(293.665, 0.5));
            }
            if (ch == 'E') {
                aanet.add(new Aani(329.628, 0.5));
            }
            if (ch == 'F') {
                aanet.add(new Aani(349.228, 0.5));
            }
            if (ch == 'G') {
                aanet.add(new Aani(391.995, 0.5));
            }
            if (ch == 'A') {
                aanet.add(new Aani(440.000, 0.5));
            }
            if (ch == 'H') {
                aanet.add(new Aani(493.883, 0.5));
            }
            if (Character.isWhitespace(ch)) {
                aanet.add(new Aani(0.0, 0.1));
            }
        }
        Soitin soitin = new Soitin();
        soitin.soita(aanet);

    }
}
