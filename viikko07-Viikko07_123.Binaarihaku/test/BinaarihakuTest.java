
import fi.helsinki.cs.tmc.edutestutils.MockInOut;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.timing.CpuStopwatch;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

@Points("123.1 123.2 123.3")
public class BinaarihakuTest {

    @Test(timeout = 10)
    public void noloop() {
        try {
            for (int i = 0; i < 10; i++) {
                int[] taulukko = generoiTaulukko(10, 20);
                BinaariHaku.hae(taulukko, 5);
            }

        } catch (Throwable a) {
            fail("ohjelmasi jää ikuiseen looppiin");
        }
    }

    @Test
    public void poistaTulostukset() {
        MockInOut io = new MockInOut("");
        int[] taulukko = generoiTaulukko(10, 20);
        BinaariHaku.hae(taulukko, 5);
        String o = io.getOutput();
        assertTrue("Poista binäärihaun koodistasi kaikki tulostuslauseet, ne sotkevat ajanoton!", io.getOutput().isEmpty());

    }

    @Test
    public void eiJarjesta() {
      int[] taulukko = {3,2,1};
      BinaariHaku.hae(taulukko, 2);
      assertTrue("Hae-metodille annettava taulukko on valmiiksi järjestetty, ethän järjestä taulukkoa itse!", 3 == taulukko[0]);
    }

    @Test
    public void testaaLukujaJotkaOvatTaulukossa() {
        testaaLuvullaJokaLoytyy(1, 0, 10, true);
        testaaLuvullaJokaLoytyy(2, 100, 10, true);
        testaaLuvullaJokaLoytyy(5, 25, 10, true);
        testaaLuvullaJokaLoytyy(7, 75, 10, true);
        testaaLuvullaJokaLoytyy(10, 50, 20, true);

        testaaLuvullaJokaLoytyy(100, 34, 200, false);
        testaaLuvullaJokaLoytyy(99, 63, 200, false);
        testaaLuvullaJokaLoytyy(23, 100, 50, false);
        testaaLuvullaJokaLoytyy(7461, 0, 10000, false);
        testaaLuvullaJokaLoytyy(234830, 69, 1000000, false);
        testaaLuvullaJokaLoytyy(1000000, 97, 1000000, false);
    }

    @Test
    public void testaaLukujaJotkaEivatOleTaulukossa() {
        testaaLuvullaJotaEiLoydy(1, 10, true);
        testaaLuvullaJotaEiLoydy(2, 10, true);
        testaaLuvullaJotaEiLoydy(5, 10, true);
        testaaLuvullaJotaEiLoydy(7, 10, true);
        testaaLuvullaJotaEiLoydy(10, 20, true);

        testaaLuvullaJotaEiLoydy(9372, 10000, false);
        testaaLuvullaJotaEiLoydy(123870, 200000, false);
        testaaLuvullaJotaEiLoydy(1000000, 1000000, false);
    }

    private void testaaLuvullaJokaLoytyy(int koko,
            float etsittavanLuvunIndeksiProsentteinaTaulukonKoosta,
            int suurinLuku, boolean ilmoitaTaulukonSisalto) {
        int[] taulukko = generoiTaulukko(koko, suurinLuku);
        int indeksi = (int) ((etsittavanLuvunIndeksiProsentteinaTaulukonKoosta / 100) * (float) (taulukko.length - 1));
        int etsittavaLuku = taulukko[indeksi];

        String taulukkoString = null;
        if (ilmoitaTaulukonSisalto) {
            taulukkoString = Arrays.toString(taulukko);
        }

        long raja = 5;
        CpuStopwatch csw = new CpuStopwatch(CpuStopwatch.Mode.USER);

        boolean tulos = false;
        for (int i = 0; i < 10; i++) {
            tulos = BinaariHaku.hae(taulukko, etsittavaLuku);
        }

        double aika = csw.getElapsedTime();
        long aikaMillis = (long) (aika * 1000);
        assertTrue("Kun taulukon koko oli " + koko + " käytit aikaa " + aikaMillis + "ms, joka on yli sallitun rajan: " + raja + "ms. "
                + "Jos binäärihaku toimii oikein, se ei ole näin hidas.",
                aikaMillis <= raja);

        if (!tulos) {
            String virhe = "Binäärihaku ei löytänyt lukua " + etsittavaLuku
                    + " taulukosta, vaikka se oli taulukossa";
            if (ilmoitaTaulukonSisalto) {
                virhe += ": " + taulukkoString;
            } else {
                virhe += ". Taulukon koko oli " + taulukko.length + " alkiota.";
            }

            fail(virhe);
        }
    }

    private void testaaLuvullaJotaEiLoydy(int koko,
            int suurinLuku, boolean ilmoitaTaulukonSisalto) {
        int[] taulukko = generoiTaulukko(koko, suurinLuku);
        int etsittavaLuku = etsiLukuJotaEiOleTaulukossa(taulukko, suurinLuku);

        String taulukkoString = null;
        if (ilmoitaTaulukonSisalto) {
            taulukkoString = Arrays.toString(taulukko);
        }

        long raja = 5;
        CpuStopwatch csw = new CpuStopwatch(CpuStopwatch.Mode.USER);

        boolean tulos = false;
        for (int i = 0; i < 10; i++) {
            tulos = BinaariHaku.hae(taulukko, etsittavaLuku);
        }

        double aika = csw.getElapsedTime();
        long aikaMillis = (long) (aika * 1000);
        assertTrue("Kun taulukon koko oli " + koko + " käytit aikaa " + aikaMillis + "ms, joka on yli sallitun rajan: " + raja + "ms. "
                + "Jos binäärihaku toimii oikein, se ei ole näin hidas.",
                aikaMillis <= raja);

        if (tulos) {
            String virhe = "Binäärihaku löysi luvun " + etsittavaLuku
                    + " taulukosta, vaikka se ei ollut taulukossa";
            if (ilmoitaTaulukonSisalto) {
                virhe += ": " + taulukkoString;
            } else {
                virhe += ". Taulukon koko oli " + taulukko.length + " alkiota.";
            }

            fail(virhe);
        }
    }

    private int[] generoiTaulukko(int koko, int suurinLuku) {
        int[] taulukko = new int[koko];
        Random random = new Random();
        for (int i = 0; i < koko; i++) {
            taulukko[i] = random.nextInt(suurinLuku);
        }
        Arrays.sort(taulukko);
        return taulukko;
    }

    private int etsiLukuJotaEiOleTaulukossa(int[] taulukko, int suurinLuku) {
        Set<Integer> setti = new HashSet<Integer>();
        for (int luku : taulukko) {
            setti.add(luku);
        }

        Random random = new Random();
        int lukuJotaEiOleTaulukossa;
        do {
            lukuJotaEiOleTaulukossa = random.nextInt(suurinLuku);
        } while (setti.contains(lukuJotaEiOleTaulukossa));

        return lukuJotaEiOleTaulukossa;
    }
}
