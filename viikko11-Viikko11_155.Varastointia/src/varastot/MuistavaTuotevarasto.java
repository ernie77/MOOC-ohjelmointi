/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

/**
 *
 * @author ernie77
 */
public class MuistavaTuotevarasto extends Tuotevarasto {

    private Muutoshistoria historia;

    public MuistavaTuotevarasto(String tuotenimi, double tilavuus, double alkusaldo) {
        super(tuotenimi, tilavuus);
        historia = new Muutoshistoria();
        historia.lisaa(alkusaldo);
        super.lisaaVarastoon(alkusaldo);
    }

    public String historia() {
        return historia.toString();
    }

    public void lisaaVarastoon(double maara) {
        super.lisaaVarastoon(maara);
        historia.lisaa(super.getSaldo());
    }

    public double otaVarastosta(double maara) {
        if (super.getSaldo() >= maara) {
            super.otaVarastosta(maara);
            historia.lisaa(super.getSaldo());
            return maara;
        }
        return super.getSaldo();
    }
    
    public void tulostaAnalyysi() {
        System.out.println("Tuote: " + super.getNimi());
        System.out.println("Historia: " + historia.toString());
        System.out.println("Suurin tuotemäärä: " + historia.maxArvo());
        System.out.println("Pienin tuotemäärä: " + historia.minArvo());
        System.out.println("Keskiarvo: " + historia.keskiarvo());
        System.out.println("Suurin muutos: " + historia.suurinMuutos());
        System.out.println("Varianssi: " + historia.varianssi());
    }
}
