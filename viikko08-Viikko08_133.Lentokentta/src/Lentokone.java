/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Lentokone {
    private String tunnus;
    private int kapasiteetti;
    
    public Lentokone() {
        this.tunnus = "";
        this.kapasiteetti = 0;
    }
    
    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }
    
    public void setKapasiteetti(int kapasiteetti) {
        this.kapasiteetti = kapasiteetti;
    }
    
    public String getTunnus() {
        return this.tunnus;
    }
    
    public int getKapasiteetti() {
        return this.kapasiteetti;
    }
}
