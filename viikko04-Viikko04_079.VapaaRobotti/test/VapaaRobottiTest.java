
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.*;
import robotti.Ohjain;

public class VapaaRobottiTest {

    @Test
    @Points("79.1")
    public void piirraNelioMetodiSivunPituudellaKaksikymmenta() throws Throwable {
        try {
            Reflex.reflect("VapaaRobotti").staticMethod("piirraNelio").returningVoid().taking(int.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle VapaaRobotti metodin public static void piirraNelio(int sivunPituus)?");
        }

        ReflectionUtils.newInstanceOfClass(VapaaRobotti.class);
        ReflectionUtils.newInstanceOfClass(Ohjain.class);
        testMode();

        Reflex.reflect("VapaaRobotti").staticMethod("piirraNelio").returningVoid().taking(int.class).requirePublic();

        Ohjain.kaynnista();
        Reflex.reflect("VapaaRobotti").staticMethod("piirraNelio").returningVoid().taking(int.class).invoke(20);
        Ohjain.sammuta();

        List<String> komennot = getKomennot();
        tarkistaLiikkumisKomentojenMaara("neliö", komennot, 20, 4);
        tarkistaKaantymisKomentojenMaara(komennot, 90, 4, "neliö");
    }

    @Test
    @Points("79.1")
    public void piirraNelioMetodiSivunPituudellaSata() throws Throwable {
        try {
            Reflex.reflect("VapaaRobotti").staticMethod("piirraNelio").returningVoid().taking(int.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle VapaaRobotti metodin public static void piirraNelio(int sivunPituus)?");
        }

        ReflectionUtils.newInstanceOfClass(VapaaRobotti.class);
        ReflectionUtils.newInstanceOfClass(Ohjain.class);
        testMode();

        Reflex.reflect("VapaaRobotti").staticMethod("piirraNelio").returningVoid().taking(int.class).requirePublic();

        Ohjain.kaynnista();
        Reflex.reflect("VapaaRobotti").staticMethod("piirraNelio").returningVoid().taking(int.class).invoke(100);
        Ohjain.sammuta();

        List<String> komennot = getKomennot();
        tarkistaLiikkumisKomentojenMaara("neliö", komennot, 100, 4);
        tarkistaKaantymisKomentojenMaara(komennot, 90, 4, "neliö");
    }

    @Test
    @Points("79.2")
    public void piirraKolmioMetodiSivunPituudellaKaksikymmenta() throws Throwable {
        try {
            ReflectionUtils.findClass("VapaaRobotti").getMethod("piirraKolmio", int.class);
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle VapaaRobotti metodin public static void piirraKolmio(int sivunPituus)?");
        }

        ReflectionUtils.newInstanceOfClass(VapaaRobotti.class);
        ReflectionUtils.newInstanceOfClass(Ohjain.class);
        testMode();

        Reflex.reflect("VapaaRobotti").staticMethod("piirraKolmio").returningVoid().taking(int.class).requirePublic();

        Ohjain.kaynnista();
        Reflex.reflect("VapaaRobotti").staticMethod("piirraKolmio").returningVoid().taking(int.class).invoke(20);
        Ohjain.sammuta();

        List<String> komennot = getKomennot();
        tarkistaLiikkumisKomentojenMaara("kolmio", komennot, 20, 3);
        tarkistaKaantymisKomentojenMaara(komennot, 120, 3, "kolmio");
    }

    @Test
    @Points("79.2")
    public void piirraKolmioMetodiSivunPituudellaSata() throws Throwable {
        try {
            ReflectionUtils.findClass("VapaaRobotti").getMethod("piirraKolmio", int.class);
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle VapaaRobotti metodin public static void piirraKolmio(int sivunPituus)?");
        }

        ReflectionUtils.newInstanceOfClass(VapaaRobotti.class);
        ReflectionUtils.newInstanceOfClass(Ohjain.class);
        testMode();

        Reflex.reflect("VapaaRobotti").staticMethod("piirraKolmio").returningVoid().taking(int.class).requirePublic();

        Ohjain.kaynnista();
        Reflex.reflect("VapaaRobotti").staticMethod("piirraKolmio").returningVoid().taking(int.class).invoke(100);
        Ohjain.sammuta();

        List<String> komennot = getKomennot();
        tarkistaLiikkumisKomentojenMaara("kolmio", komennot, 100, 3);
        tarkistaKaantymisKomentojenMaara(komennot, 120, 3, "kolmio");
    }

    @Test
    @Points("79.3")
    public void piirraYmpyraKolmellaKulmallaJaSivunPituudellaKaksikymmenta() throws Throwable {
        try {
            ReflectionUtils.findClass("VapaaRobotti").getMethod("piirraYmpyra", int.class, int.class);
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle VapaaRobotti metodin public static void public static void piirraYmpyra(int sivunPituus, int kulmia)?");
        }

        ReflectionUtils.newInstanceOfClass(VapaaRobotti.class);
        ReflectionUtils.newInstanceOfClass(Ohjain.class);
        testMode();

        Reflex.reflect("VapaaRobotti").staticMethod("piirraYmpyra").returningVoid().taking(int.class, int.class).requirePublic();

        Ohjain.kaynnista();
        Reflex.reflect("VapaaRobotti").staticMethod("piirraYmpyra").returningVoid().taking(int.class, int.class).invoke(20, 3);
        Ohjain.sammuta();

        List<String> komennot = getKomennot();
        tarkistaLiikkumisKomentojenMaara("ympyrä kolmella kulmalla", komennot, 20, 3);
        tarkistaKaantymisKomentojenMaara(komennot, 120, 3, "ympyrä kolmella kulmalla");
    }

    @Test
    @Points("79.3")
    public void piirraYmpyraViidellaKulmallaJaSivunPituudellaNeljallakymmenta() throws Throwable {
        try {
            ReflectionUtils.findClass("VapaaRobotti").getMethod("piirraYmpyra", int.class, int.class);
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle VapaaRobotti metodin public static void public static void piirraYmpyra(int sivunPituus, int kulmia)?");
        }

        ReflectionUtils.newInstanceOfClass(VapaaRobotti.class);
        ReflectionUtils.newInstanceOfClass(Ohjain.class);
        testMode();

        Reflex.reflect("VapaaRobotti").staticMethod("piirraYmpyra").returningVoid().taking(int.class, int.class).requirePublic();

        Ohjain.kaynnista();
        Reflex.reflect("VapaaRobotti").staticMethod("piirraYmpyra").returningVoid().taking(int.class, int.class).invoke(40, 6);
        Ohjain.sammuta();

        List<String> komennot = getKomennot();
        tarkistaLiikkumisKomentojenMaara("ympyrä kuudella kulmalla", komennot, 40, 6);
        tarkistaKaantymisKomentojenMaara(komennot, 360 / 6, 6, "ympyrä kuudella kulmalla");
    }

    private void tarkistaLiikkumisKomentojenMaara(String kuvio, List<String> komennot, int sivunpituus, int montako) {

        int liikkumisiaNahty = 0;
        for (String komento : komennot) {
            if (komento.equals("liiku " + sivunpituus)) {
                liikkumisiaNahty++;
            }

            if (komento.startsWith("liiku") && !komento.equals("liiku " + sivunpituus)) {
                Assert.fail("Kun metodia piirraNelio kutsutaan arvolla " + sivunpituus + ", liikkeen pitäisi olla aina " + sivunpituus + " askelta. Nyt tehtiin " + komento);
            }
        }

        Assert.assertTrue("Kun piirrät kuviota " + kuvio + ", tarvitset täsmälleen " + montako + " liikkumiskomentoa.", liikkumisiaNahty == montako);
    }

    private void tarkistaKaantymisKomentojenMaara(List<String> komennot, int astetta, int montako, String kuvio) {
        int vasemmalleNahty = 0;
        int oikealleNahty = 0;

        for (String komento : komennot) {
            if (!komento.startsWith("oikea") && !komento.startsWith("vasen")) {
                continue;
            }

            if (komento.equals("vasen " + astetta)) {
                vasemmalleNahty++;
            }

            if (komento.equals("oikea " + astetta)) {
                oikealleNahty++;
            }

            if (!komento.endsWith("" + astetta)) {
                Assert.fail("Käännös oli \"" + komento + "\" astetta kun " + kuvio + " n tapauksessa käännöksen pitäisi olla " + astetta);
            }
        }

        Assert.assertFalse("Kun piirrät kuviota " + kuvio + ", tarvitset täsmälleen " + montako + " kääntymiskomentoa samaan suuntaan.", vasemmalleNahty != montako && oikealleNahty != montako);
        Assert.assertFalse("Kun piirrät kuviota " + kuvio + ", tarvitset täsmälleen " + montako + " kääntymiskomentoa samaan suuntaan. Älä käytä kumpaakin suuntaa.", vasemmalleNahty == montako && oikealleNahty == montako);

    }

    private List<String> getKomennot() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("getKomennot");
            m.setAccessible(true);
            return (List<String>) m.invoke(null);
        } catch (Throwable e) {
        }
        return null;
    }

    private void testMode() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("testMode");
            m.setAccessible(true);
            m.invoke(null);
        } catch (Throwable e) {
            throw new Error("Jotain meni pieleen!", e);
        }
    }
}
