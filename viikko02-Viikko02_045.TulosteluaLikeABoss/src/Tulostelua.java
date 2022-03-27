
public class Tulostelua {

    public static void tulostaTahtia(int maara) {
        // 40.1
        int i = 0;
        while (i < maara) {
            System.out.print("*");
            i++;
        }
        System.out.println("");
    }

    public static void tulostaTyhjaa(int maara) {
        // 40.1
        int i = 0;
        while (i < maara) {
            System.out.print(" ");
            i++;
        }
    }

    public static void tulostaKolmio(int koko) {
        // 40.2
        int i = 1;
        while (i <= koko) {
            tulostaTyhjaa(koko - i);           
            tulostaTahtia(i);
            i++;
        }        
    }

    public static void jouluKuusi(int korkeus) {
        // 40.3
        int i = 0;
        int j = 1;
        while (i < korkeus) {
            
            tulostaTyhjaa(korkeus - i - 1);           
            tulostaTahtia(i + j);
            i++;
            j++;
        }    
        tulostaTyhjaa(korkeus - 2);           
        tulostaTahtia(3);
        tulostaTyhjaa(korkeus - 2);           
        tulostaTahtia(3);
    }

    public static void main(String[] args) {
        // Testit eivät katso main-metodia, voit muutella tätä vapaasti.

        tulostaKolmio(5);
        System.out.println("---");
        jouluKuusi(4);
        System.out.println("---");
        jouluKuusi(10);
    }
}
