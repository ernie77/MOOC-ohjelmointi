
public class BinaariHaku {

    public static boolean hae(int[] taulukko, int etsittavaLuku) {
        int alku = 0;
        int loppu = taulukko.length - 1;

        // tarvitset ainakin toistolauseen, missä katsotaan aina taulukon
        // keskimmäistä alkiota, sekä jonkinlaisen toiminnallisuuden
        // hakualueen jatkuvaan pienentämiseen
        while (alku != loppu) {
            if (etsittavaLuku > taulukko[(alku + loppu) / 2]) {
                alku = (alku + loppu) / 2 + 1;
            } else {
                loppu = (alku + loppu) / 2;
            }            
        }
        

        return etsittavaLuku == taulukko[alku];
    }
}
