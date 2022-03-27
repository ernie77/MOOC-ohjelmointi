/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

/**
 *
 * @author ernie77
 */
public class YhdenTavaranLaatikko extends Laatikko {

    private Tavara t;

    public YhdenTavaranLaatikko() {
        t = new Tavara("null", 0);
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (t.getNimi().equals("null")) {
            t = tavara;
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return t.equals(tavara);
    }

}
