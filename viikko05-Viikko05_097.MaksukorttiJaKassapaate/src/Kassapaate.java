
public class Kassapaate {

    private double rahaa;  // kassassa olevan käteisen määrä
    private int edulliset; // myytyjen edullisten lounaiden määrä
    private int maukkaat;  // myytyjen maukkaiden lounaiden määrä

    public Kassapaate() {
        this.rahaa = 1000;
        // kassassa on aluksi 1000 euroa rahaa
    }

    public double syoEdullisesti(double maksu) {
        double edullinen = 2.5;
        // edullinen lounas maksaa 2.50 euroa.

        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        if (maksu >= edullinen) {
            this.rahaa += edullinen;
            edulliset++;
            return maksu - edullinen;
        }
        return maksu;
    }

    public double syoMaukkaasti(double maksu) {
        double maukas = 4.3;
        // edullinen lounas maksaa 4.30 euroa.
        // päivitetään kassan rahamäärää lounaan hinnalla ja palautetaan vaihtorahat
        // jos parametrina annettu maksu ei ole riittävän suuri, ei lounasta myydä ja metodi palauttaa koko summan
        if (maksu >= maukas) {
            this.rahaa += maukas;
            maukkaat++;
            return maksu - maukas;
        }
        return maksu;
    }

    public boolean syoEdullisesti(Maksukortti kortti) {
        double edullinen = 2.5;

        if (kortti.otaRahaa(edullinen)) {
            edulliset++;
            return true;
        }
        return false;
    }

    public boolean syoMaukkaasti(Maksukortti kortti) {
        double maukas = 4.3;

        if (kortti.otaRahaa(maukas)) {
            maukkaat++;
            return true;
        }
        return false;
    }

    public void lataaRahaaKortille(Maksukortti kortti, double summa) {
        if (summa > 0) {
            this.rahaa += summa;
            kortti.lataaRahaa(summa);
        }
    }

    @Override
    public String toString() {
        return "kassassa rahaa " + rahaa + " edullisia lounaita myyty " + edulliset + " maukkaita lounaita myyty " + maukkaat;
    }
}
