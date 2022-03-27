public class Kello {
    private YlhaaltaRajoitettuLaskuri tunnit;
    private YlhaaltaRajoitettuLaskuri minuutit;
    private YlhaaltaRajoitettuLaskuri sekunnit;
   
    public Kello(int tunnitAlussa, int minuutitAlussa, int sekunnitAlussa) {
        // luodaan kello joka asetetaan parametrina annettuun aikaan
        tunnit = new YlhaaltaRajoitettuLaskuri(23);
        minuutit = new YlhaaltaRajoitettuLaskuri(59);
        sekunnit = new YlhaaltaRajoitettuLaskuri(59);  
        tunnit.asetaArvo(tunnitAlussa);
        minuutit.asetaArvo(minuutitAlussa);
        sekunnit.asetaArvo(sekunnitAlussa);
    }
    
    public void etene() {
        // kello etenee sekunnilla
        sekunnit.seuraava();
        if (sekunnit.arvo() == 0) {
            minuutit.seuraava();
            if (minuutit.arvo() == 0) {
                tunnit.seuraava();
            }
        }
        
        
    }
    
    public String toString() {
        // palauttaa kellon merkkijonoesityksen
        return this.tunnit + ":" + this.minuutit + ":" + this.sekunnit;
    }
}
