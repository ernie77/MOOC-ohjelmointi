
public class Raha {

    private final int euroa;
    private final int senttia;

    public Raha(int euroa, int senttia) {

        if (senttia > 99) {
            euroa += senttia / 100;
            senttia %= 100;
        }

        this.euroa = euroa;
        this.senttia = senttia;
    }

    public int eurot() {
        return euroa;
    }

    public int sentit() {
        return senttia;
    }

    public String toString() {
        String nolla = "";
        if (senttia < 10) {
            nolla = "0";
        }

        return euroa + "." + nolla + senttia + "e";
    }

    public Raha plus(Raha lisattava) {
        Raha uusi = new Raha(this.euroa + lisattava.euroa, this.senttia + lisattava.senttia);
        return uusi;
    }

    public boolean vahemman(Raha verrattava) {
        if (this.euroa > verrattava.euroa) {
            return false;
        }
        if (this.euroa >= verrattava.euroa && this.senttia > verrattava.senttia) {
            return false;
        }
        return true;
    }

    public Raha miinus(Raha vahennettava) {
        int e = this.euroa;
        int s = this.senttia;
        if (this.vahemman(vahennettava)) {
            e = 0;
            s = 0;
        } else if (this.senttia < vahennettava.senttia) {
            s -= vahennettava.senttia - 100;
            e--;
            e -= vahennettava.euroa;
        } else {
            s -= vahennettava.senttia;
            e -= vahennettava.euroa;
        }

        Raha uusi = new Raha(e, s);
        return uusi;
    }
}
