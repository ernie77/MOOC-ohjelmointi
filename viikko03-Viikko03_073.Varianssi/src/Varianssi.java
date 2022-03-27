
import java.util.ArrayList;

public class Varianssi {

    // Kopioi tänne tehtävän 70 metodi summa

    public static int summa(ArrayList<Integer> lista) {
        int sum = 0;
        for (Integer luku : lista) {
            sum += luku;
        }
        return sum;

    }

    // Kopioi tänne tehtävän 71 metodi keskiarvo
    public static double keskiarvo(ArrayList<Integer> lista) {
        // kirjoita koodia tähän
        return 1.0 * summa(lista) / lista.size();

    }

    public static double varianssi(ArrayList<Integer> lista) {
        // kirjoita koodia tähän
        double sum = 0;
        double karvo = keskiarvo(lista);
        for (Integer alkio : lista) {
            sum += Math.pow((alkio - karvo), 2);
            System.out.println(sum);
        }
        
        return sum / (lista.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(2);
        lista.add(7);
        lista.add(2);

        System.out.println("Varianssi: " + varianssi(lista));
    }

}
