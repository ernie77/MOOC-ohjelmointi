
import robotti.Ohjain;

public class Viivakimara {

    public static void main(String[] args) {
        Ohjain.kaynnista();

        // testaa metodejasi täällä
        viivakimara(10);

        Ohjain.sammuta();
    }

    // toteuta metodisi tänne
    public static void liikuMonta(int montakoAskelta) {
        
        while (montakoAskelta > 0) {
            Ohjain.liiku();
            montakoAskelta--;
        }
    }
    public static void piirraNelio(int sivunPituus) {
        
        liikuMonta(sivunPituus);
        Ohjain.oikea();
        liikuMonta(sivunPituus);
        Ohjain.oikea();
        liikuMonta(sivunPituus);
        Ohjain.oikea();
        liikuMonta(sivunPituus);
        Ohjain.oikea();
        
    }
    public static void sisakkaisetNeliot(int montako) {
        rajatutSisakkaisetNeliot(montako, 1);
    }
    public static void rajatutSisakkaisetNeliot(int suurin, int pienin) {
        while (suurin > pienin - 1) {
            piirraNelio(suurin); 
            suurin--;
        }
    }
    public static void viivakimara(int koko) {
        rajatutSisakkaisetNeliot(koko, koko - 2);
        sisakkaisetNeliot(2);
    }
}
