
public class Tileja {

    public static void main(String[] args) {
        // Tili.Java:ssa olevaan koodiin ei tule koskea
        // tee ohjelmasi tänne
        Tili a = new Tili("tili a", 100);
        Tili b = new Tili("tili b", 0);
        Tili c = new Tili("tili c", 0);
        tilisiirto(a, b, 50.0);
        tilisiirto(b, c, 25.0);
        
    }
    public static void tilisiirto(Tili mista, Tili mihin, double maara) {
        mista.otto(maara);
        mihin.pano(maara);
    }

}
