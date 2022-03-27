
public class Tileja {

    public static void main(String[] args) {
        // Tili.Java:ssa olevaan koodiin ei tule koskea
        // tee ohjelmasi tänne
        Tili matintili = new Tili("Matin tili", 1000);
        Tili omatili = new Tili("Oma tili", 0);
        matintili.otto(100.0);
        omatili.pano(100.0);
        System.out.println(matintili);
        System.out.println(omatili);
    }
}
