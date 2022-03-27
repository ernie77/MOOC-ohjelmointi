package game;

import gameoflife.Simulaattori;

public class Main {

    public static void main(String[] args) {
        // testaa ohjelmaasi täällä
        OmaAlusta alusta = new OmaAlusta(100, 100);
        alusta.alustaSatunnaisetPisteet(0.7);

        Simulaattori simulaattori = new Simulaattori(alusta);
        simulaattori.simuloi();
    }
}
