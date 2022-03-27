import java.util.ArrayList;

public class LukujenSumma {
    public static int summa(ArrayList<Integer> lista) {
        // Kirjoita koodia tänne
        int sum = 0;
        for (Integer luku : lista) {
            sum += luku;
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(2);
        lista.add(7);
        lista.add(2);
        
        System.out.println("Summa: " + summa(lista));

        lista.add(10);
        
        System.out.println("Summa: " + summa(lista));
    }

}