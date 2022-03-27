public class Henkilo {

    private String nimi;
    private Henkilo isa;
    private Henkilo aiti;

    public Henkilo(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Henkilo getIsa() {
        return isa;
    }

    public void setIsa(Henkilo isa) {
        this.isa = isa;
    }

    public Henkilo getAiti() {
        return aiti;
    }

    public void setAiti(Henkilo aiti) {
        this.aiti = aiti;
    }
}
