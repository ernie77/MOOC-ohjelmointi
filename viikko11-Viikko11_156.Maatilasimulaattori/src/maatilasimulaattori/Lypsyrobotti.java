/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

/**
 *
 * @author ernie77
 */
public class Lypsyrobotti {

    private Maitosailio sailio;

    public Lypsyrobotti() {
        this.sailio = null;
    }

    public void setMaitosailio(Maitosailio maitosailio) {
        this.sailio = maitosailio;
    }

    public Maitosailio getMaitosailio() {
        return this.sailio;
    }

    public void lypsa(Lypsava lypsava) {
        //this.sailio.lisaaSailioon(lypsava.lypsa());
        if (this.getMaitosailio() == null) {
            throw new IllegalStateException("Maitosäiliötä ei ole asetettu");
        }
        this.getMaitosailio().lisaaSailioon(lypsava.lypsa());
    }
}
