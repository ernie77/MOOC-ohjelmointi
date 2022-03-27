
public class Lintu {

    private String nimi;
    private String latinankielinenNimi;
    private int rengastusvuosi;

    public Lintu(String nimi, String latinankielinenNimi, int rengastusvuosi) {
        this.nimi = nimi;
        this.latinankielinenNimi = latinankielinenNimi;
        this.rengastusvuosi = rengastusvuosi;
    }

    public boolean equals(Object l) {
        String vertaa = ((Lintu) l).latinankielinenNimi;
        if (String.CASE_INSENSITIVE_ORDER.compare(this.latinankielinenNimi, vertaa) == 0) {
            if (this.rengastusvuosi == ((Lintu) l).rengastusvuosi) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.latinankielinenNimi.hashCode() + this.rengastusvuosi;
    }

    @Override
    public String toString() {
        return this.latinankielinenNimi + " (" + this.rengastusvuosi + ")";
    }
}
