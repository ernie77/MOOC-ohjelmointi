/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernie77
 */
public class Lukutulostin {

    private int luku;

    public Lukutulostin() {
    }

    public void lukuporras(int luku) {
        int rivi = 1;
        while (rivi <= luku) {
            int sarake = 1;
            while (sarake <= rivi) {
                System.out.print(sarake + " ");
                sarake++;
            }
            System.out.println(" ");
            rivi++;
        }
    }
    
    public void rajattuLukuporras(int alku, int loppu) {
        int rivi = alku;
        while (rivi <= loppu) {
            int sarake = 1;
            while (sarake <= rivi) {
                System.out.print(sarake + " ");
                sarake++;
            }
            System.out.println(" ");
            rivi++;
        }
    }
    
    public void jatkuvaLukuporras(int luku) {
        int rivi = 1;
        int arvo = 1;
        while (rivi <= luku) {
            int sarake = 1;
            while (sarake <= rivi) {
                System.out.print(arvo + " ");
                arvo++;
                sarake++;
            }
            System.out.println(" ");
            rivi++;
        }
    }
    
    public void kertokolmio(int luku) {
        int rivi = 1;
        while (rivi <= luku) {
            int sarake = 1;
            while (sarake <= rivi) {
                System.out.print(sarake * rivi + " ");
                sarake++;
            }
            System.out.println(" ");
            rivi++;
        }
    }

}
