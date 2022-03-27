
import java.util.Arrays;

public class Paaohjelma {

    public static void main(String[] args) {
        // tee testauskoodia tänne
        int[] orig = {1, 2, 3, 4};
        int[] copy = kopioi(orig);
        int[] reverse = kaanna(orig);

        copy[0] = 99;

        System.out.println("orig: " + Arrays.toString(orig));
        System.out.println("copy: " + Arrays.toString(copy));
        System.out.println("reverse: " + Arrays.toString(reverse));
    }

    public static int[] kopioi(int[] taulukko) {
        int[] kopio = new int[taulukko.length];
        for (int i = 0; i < taulukko.length; i++) {
            kopio[i] = taulukko[i];
        }
        return kopio;
    }

    public static int[] kaanna(int[] taulukko) {
        int[] kopio = new int[taulukko.length];
        for (int i = 0; i < taulukko.length; i++) {
            kopio[taulukko.length - i - 1] = taulukko[i];
        }
        return kopio;
    }

}
