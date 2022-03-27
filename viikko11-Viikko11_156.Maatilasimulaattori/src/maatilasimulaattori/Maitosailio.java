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
public class Maitosailio {

    private double tilavuus;
    private double saldo;

    public Maitosailio() {
        this.tilavuus = 2000;
    }

    public Maitosailio(double tilavuus) {
        this.tilavuus = tilavuus;
    }

    public double getTilavuus() {
        return this.tilavuus;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public double paljonkoTilaaJaljella() {
        return this.tilavuus - this.saldo;
    }

    public void lisaaSailioon(double maara) {
        if (this.paljonkoTilaaJaljella() >= maara) {
            this.saldo += maara;
        } else {
            this.saldo = this.tilavuus;
        }        
    }
    
    public double otaSailiosta(double maara) {
        if (this.saldo >= maara) {
            this.saldo -= maara;
            return maara;
        } else {
            this.saldo = 0;
            return this.saldo;
        }
    }
    
    public String toString() {
        return Math.ceil(this.saldo) + "/" + Math.ceil(this.tilavuus);
    }
}
