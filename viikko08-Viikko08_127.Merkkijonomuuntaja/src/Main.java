
public class Main {

    public static void main(String[] args) {
        // Testaa ohjelmaasi täällä
        String sana = "porkkana";
        Muunnos muunnos1 = new Muunnos('a', 'x');
        sana = muunnos1.muunna(sana);
        System.out.println(sana);
    }
}
