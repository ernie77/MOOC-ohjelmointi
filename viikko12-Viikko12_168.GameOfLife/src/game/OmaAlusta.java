/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeAlusta;
import java.util.Random;

/**
 *
 * @author ernie77
 */
public class OmaAlusta extends GameOfLifeAlusta {

    public OmaAlusta(int leveys, int korkeus) {
        super(leveys, korkeus);

    }

    @Override
    public void alustaSatunnaisetPisteet(double d) {
        boolean[][] arvot = getAlusta();
        Random rand = new Random();
        for (int i = 0; i < arvot.length; i++) {
            for (int j = 0; j < arvot[i].length; j++) {
                if (d > rand.nextDouble()) {
                    arvot[i][j] = true;
                } else {
                    arvot[i][j] = false;
                }
            }
        }
    }

    @Override
    public boolean onElossa(int x, int y) {
        boolean[][] arvot = getAlusta();
        if (x >= 0 && y >= 0 && y < arvot.length && x < arvot.length) {
            return arvot[x][y];
        }
        return false;
    }

    @Override
    public void muutaElavaksi(int x, int y) {
        boolean[][] arvot = getAlusta();
        if (x >= 0 && y >= 0 && y <= arvot.length && x <= arvot.length) {
            arvot[x][y] = true;
        }
    }

    @Override
    public void muutaKuolleeksi(int x, int y) {
        boolean[][] arvot = getAlusta();
        if (x >= 0 && y >= 0 && y <= arvot.length && x <= arvot.length) {
            arvot[x][y] = false;
        }
    }

    @Override
    public int getElossaOlevienNaapurienLukumaara(int x, int y) {
        boolean[][] arvot = getAlusta();
        int lkm = 0;
        if (x == 0) {
            for (int i = x; i <= x + 1; i++) {
                if (y == 0) {
                    for (int j = y; j <= y + 1; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                } else if (y == arvot[i].length - 1) {
                    for (int j = y - 1; j <= y; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                } else {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                }
            }
        } else if (x == arvot.length - 1) {
            for (int i = x - 1; i <= x; i++) {
                if (y == 0) {
                    for (int j = y; j <= y + 1; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                } else if (y == arvot[i].length - 1) {
                    for (int j = y - 1; j <= y; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                } else {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                }
            }
        } else {
            for (int i = x - 1; i <= x + 1; i++) {
                if (y == 0) {
                    for (int j = y; j <= y + 1; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                } else if (y == arvot[i].length - 1) {
                    for (int j = y - 1; j <= y; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                } else {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (arvot[i][j] == true) {
                            lkm++;
                        }
                    }
                }
            }
        }

        if (arvot[x][y] == true) {
            lkm--;
        }
        return lkm;
    }

    @Override
    public void hoidaSolu(int x, int y, int naapurit) {
        //boolean[][] arvot = getAlusta();
        if (naapurit < 2) {
            this.muutaKuolleeksi(x, y);
        }
        if (naapurit > 3) {
            this.muutaKuolleeksi(x, y);
        }
        if (naapurit == 3) {
            this.muutaElavaksi(x, y);
        }
    }

}
