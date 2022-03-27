
public class Paivays {

    private int paiva;
    private int kuukausi;
    private int vuosi;

    public Paivays(int pv, int kk, int vv) {
        this.paiva = pv;
        this.kuukausi = kk;
        this.vuosi = vv;
    }

    @Override
    public String toString() {
        return this.paiva + "." + this.kuukausi + "." + this.vuosi;
    }

    public boolean aiemmin(Paivays verrattava) {
        // ensin verrataan vuosia
        if (this.vuosi < verrattava.vuosi) {
            return true;
        }

        // jos vuodet ovat samat, verrataan kuukausia
        if (this.vuosi == verrattava.vuosi && this.kuukausi < verrattava.kuukausi) {
            return true;
        }

        // vuodet ja kuukaudet samoja, verrataan päivää
        if (this.vuosi == verrattava.vuosi && this.kuukausi == verrattava.kuukausi &&
                 this.paiva < verrattava.paiva) {
            return true;
        }

        return false;
    }
/*
     * Aiemmassa tehtävässä lisättiin luokalle metodi erotusVuosissa
     * Kannattaa kopioida metodi tänne, se helpottaa tehtävän tekemistä oleellisesti!
     */
    public int erotusVuosissa(Paivays verrattava) {
        if (this.vuosi > verrattava.vuosi) {
            if (this.kuukausi >= verrattava.kuukausi) {
                if (this.paiva >= verrattava.paiva) {
                    return this.vuosi - verrattava.vuosi;
                }
                return this.vuosi - verrattava.vuosi - 1;
            }
            return this.vuosi - verrattava.vuosi - 1;
        }
        if (this.vuosi < verrattava.vuosi) {
            if (this.kuukausi <= verrattava.kuukausi) {
                if (this.paiva <= verrattava.paiva) {
                    return verrattava.vuosi - this.vuosi;
                }
                return verrattava.vuosi - this.vuosi - 1;
            }
            return verrattava.vuosi - this.vuosi - 1;
        }
        return verrattava.vuosi - this.vuosi;
    }
    
    
}
