/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Aani {
    private double taajuus;
    private double kesto;
    
    public Aani(double taajuus, double kesto) {
        this.taajuus = taajuus;
        this.kesto = kesto;
    }
    
    public double getTaajuus() {
        return this.taajuus;
    }
    
    public double getKesto() {
        return this.kesto;
    }
    
    public String toString() {
        return this.taajuus + ", " + this.kesto;
    }
}
