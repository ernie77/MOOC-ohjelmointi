public class YlhaaltaRajoitettuLaskuri {
    // kopioi tähän edellisen viikon tehtävässä Kello laskurin avulla tehdyn YlhaaltaRajoitettuLaskuri-luokan sisältö
    // voit myös käyttää pohjana tehtävän mallivastausta joka on osoitteessa
    // http://tmc.mooc.fi/mooc/ tai http://tmc.mooc.fi/hy/ riippuen suoritettavasta kurssista
    private int arvo;
    private int ylaraja;

    public YlhaaltaRajoitettuLaskuri(int ylarajanAlkuarvo) {
        this.arvo = 0;
        this.ylaraja = ylarajanAlkuarvo;

    }

    public void seuraava() {
        if (this.arvo++ >= this.ylaraja) {

            this.arvo = 0;
        }

    }

    public void asetaArvo(int alkuarvo) {
        if (alkuarvo > 0 && alkuarvo <= this.ylaraja) {
            this.arvo = alkuarvo;
        } else {
            this.arvo = 0;
        }

    }

    public String toString() {
        if (this.arvo < 10) {
            return "0" + this.arvo;
        } else {
            return "" + this.arvo;
        }
    }

    public int arvo() {
        return this.arvo;
    }
}
