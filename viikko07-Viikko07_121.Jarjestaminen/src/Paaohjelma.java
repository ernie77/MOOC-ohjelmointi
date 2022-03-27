
public class Paaohjelma {

    public static void main(String[] args) {
        // tee testikoodia tänne
        int[] taulukko = {3, 1, 5, 99, 3, 12};
        System.out.println("Pienin: " + pienin(taulukko) + " Peinin Indeksi: " + pienimmanIndeksiAlkaen(taulukko, 2));
    }

    public static int pienin(int[] taulukko) {
      
        int pienin = taulukko[0];
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
            }
        }
        return pienin;
    }
        
    public static int pienimmanIndeksi(int[] taulukko) {
      
        int pieninIndeksi = 0;
        int pienin = taulukko[0];
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
                pieninIndeksi = i;
            }
        }
        return pieninIndeksi;
    }
    
    public static int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusindeksi) {
        
        int pieninIndeksi = aloitusindeksi;
        int pienin = taulukko[aloitusindeksi];
        for (int i = aloitusindeksi; i < taulukko.length; i++) {
            if (taulukko[i] < pienin) {
                pienin = taulukko[i];
                pieninIndeksi = i;
            }
        }
        return pieninIndeksi;
    }
    
    public static void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        int apu;
        apu = taulukko[indeksi1];
        taulukko[indeksi1] = taulukko[indeksi2];
        taulukko[indeksi2] = apu;
    }
    
    public static void jarjesta(int[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            vaihda(taulukko, i, pienimmanIndeksiAlkaen(taulukko, i));
        }
    }
}