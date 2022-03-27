/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

/**
 *
 * @author ernie77
 */
public class Hirvio {

    private int x, y;

    public Hirvio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void tulosta() {
        System.out.println("h " + x + " " + y);

    }
    
    public int getx() {
        return this.x;        
    }
    
    public int gety() {
        return this.y;
    }
}
