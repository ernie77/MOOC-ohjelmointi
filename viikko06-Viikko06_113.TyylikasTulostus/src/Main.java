
public class Main {

    public static void main(String[] args) {
        // Tässä voit testata metodia
        int[] taulukko = {5, 1, 3, 4, 2};
        tulostaTyylikkaasti(taulukko);
    }

    public static void tulostaTyylikkaasti(int[] taulukko) {
        // Kirjoita koodia tänne
        System.out.print(taulukko[0]);
        for (int i = 1; i < taulukko.length; i++) {
            System.out.print(", " + taulukko[i]);
        }
    }
}
