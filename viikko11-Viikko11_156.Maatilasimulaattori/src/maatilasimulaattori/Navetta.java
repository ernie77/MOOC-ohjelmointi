/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

import java.util.Collection;

/**
 *
 * @author ernie77
 */
public class Navetta {

    private Maitosailio sailio;
    private Lypsyrobotti robotti;

    public Navetta(Maitosailio sailio) {
        this.sailio = sailio;
    }

    public Maitosailio getMaitosailio() {
        return this.sailio;
    }

    public void asennaLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        this.robotti = lypsyrobotti;
        this.robotti.setMaitosailio(sailio);
    }

    public void hoida(Lehma lehma) {
        if (robotti == null) {
            throw new IllegalStateException("Already connected");
        }
        robotti.lypsa(lehma);
    }
    
    public void hoida(Collection<Lehma> lehma) {
        for (Lehma l : lehma) {
            this.hoida(l);
        }
    }
    public String toString() {
        return this.sailio.toString();
    }
}
