
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernie77
 */
public class Matkalaukku {

    private final int maxpaino;
    private ArrayList<Tavara> tavarat;

    public Matkalaukku(int maxpaino) {
        this.maxpaino = maxpaino;
        tavarat = new ArrayList<>();
    }

    public int getPaino() {
        int paino = 0;
        if (this.tavarat.size() > 0) {
            for (Tavara tavara : tavarat) {
                paino += tavara.getPaino();
            }
        }
        return paino;
    }

    public void lisaaTavara(Tavara tavara) {
        if (tavara.getPaino() + this.getPaino() <= maxpaino) {
            this.tavarat.add(tavara);
        }
    }

    public String toString() {
        if (this.tavarat.size() == 0) {
            return "ei tavaroita" + "(" + this.getPaino() + " kg)";
        }
        if (this.tavarat.size() == 1) {
            return "1 tavara" + "(" + this.getPaino() + " kg)";
        }
        return this.tavarat.size() + " tavaraa (" + this.getPaino() + " kg)";
    }

    public void tulostaTavarat() {
        for (Tavara tavara : tavarat) {
            System.out.println(tavara);
        }
    }

    public int yhteispaino() {
        return this.getPaino();
    }

    public Tavara raskainTavara() {
        if (tavarat.isEmpty()) {
            return null;
        }
        Tavara raskain = new Tavara("", 0);
        for (Tavara tavara : tavarat) {
            if (tavara.getPaino() > raskain.getPaino()) {
                raskain = tavara;
            }
        }
        return raskain;
    }
}
