/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernie77
 */
public class Pelaaja {
    private int x;
    private int y;
    private List<Hirvio> poistettavat;

    public Pelaaja() {
        this.x = 0;
        this.y = 0;
        poistettavat = new ArrayList<>();
    }
    

    public void tulosta() {
        System.out.println("@ " + x + " " + y);
    }
    
    public int getx() {
        return this.x;
    }
    
    public int gety() {
        return this.y;
    }
    
    public void liiku(String syote, Hirviot hirviot){
        for (int i = 0; i < syote.length(); i++) {
            if (syote.charAt(i) == 'w'){
                this.y--;
                if (hirviot.onkoHirvio(x, y)){
                    hirviot.poista(x,y);
                }
            }
            if (syote.charAt(i) == 's'){
                this.y++;
                if (hirviot.onkoHirvio(x, y)){
                    hirviot.poista(x,y);
                }
            }
            if (syote.charAt(i) == 'a'){
                this.x--;
                if (hirviot.onkoHirvio(x, y)){
                    hirviot.poista(x,y);
                }
            }
            if (syote.charAt(i) == 'd'){
                this.x++;
                if (hirviot.onkoHirvio(x, y)){
                    hirviot.poista(x,y);
                }
            }
            
        }
    }

}
