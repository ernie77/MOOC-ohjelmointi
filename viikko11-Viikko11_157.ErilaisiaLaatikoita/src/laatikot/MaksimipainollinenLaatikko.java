/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernie77
 */
public class MaksimipainollinenLaatikko extends Laatikko {

    private int maksimipaino;
    private List<Tavara> tavarat;

    public MaksimipainollinenLaatikko(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        tavarat = new ArrayList<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        int paino = 0;
        for (Tavara t : tavarat) {
            paino += t.getPaino();
        }
        if (paino + tavara.getPaino() <= this.maksimipaino) {
            tavarat.add(tavara);
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        for (Tavara t : tavarat) {
            if (t.equals(tavara)) {
                return true;
            }
        }
        return false;
    }

}
