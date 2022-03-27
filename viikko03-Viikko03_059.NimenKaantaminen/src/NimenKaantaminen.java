import java.util.Scanner;

public class NimenKaantaminen {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Tee koodisi tänne
        System.out.println("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.print("Väärinpäin: ");
        for (int i = nimi.length() - 1; i >= 0; i--) {
            System.out.print(nimi.charAt(i));
        }
    }
}
