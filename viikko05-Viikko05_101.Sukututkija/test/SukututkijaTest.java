import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

public class SukututkijaTest {

    @Rule
    public MockStdio io = new MockStdio();

    String sukututkijaKlassName = "Sukututkija";
    Reflex.ClassRef<Object> sukututkijaKlass;

    String kerroHenkilostaMethodName = "kerroHenkilosta";
    Reflex.MethodRef1<Object, Void, Henkilo> kerroHenkilostaMethod;

    String kerroHenkilonSuvustaMethodName = "kerroHenkilonSuvusta";
    Reflex.MethodRef1<Object, Void, Henkilo> kerroHenkilonSuvustaMethod;

    @Before
    public void setUp() {
        sukututkijaKlass = Reflex.reflect(sukututkijaKlassName);
    }

    @Test
    @Points("101.1")
    public void luokkaSukututkija() {
        assertNotNull("Onhan luokka " + sukututkijaKlassName + " olemassa ja onhan se muotoa \"public class " + sukututkijaKlassName + " { ..\".", sukututkijaKlass);
    }

    @Test
    @Points("101.1")
    public void sukututkijallaParametritonKonstruktori() {
        luokkaSukututkija();
        try {
            assertTrue(sukututkijaKlass.ctor().takingNoParams().isPublic());
        } catch (Throwable t) {
            fail("Onhan luokalla " + sukututkijaKlassName + " konstruktori, joka ei ota parametreja. Konstruktorin pitäisi olla muotoa:\npublic " + sukututkijaKlassName + "() {..");
        }

    }

    @Test
    @Points("101.1")
    public void metodiKerroHenkilostaOlemassa() {
        sukututkijallaParametritonKonstruktori();

        try {
            kerroHenkilostaMethod = Reflex.reflect(sukututkijaKlassName).method(kerroHenkilostaMethodName).returningVoid().taking(Henkilo.class);
            assertTrue(kerroHenkilostaMethod.isPublic());
        } catch (Throwable t) {
            fail("Onhan luokalla " + sukututkijaKlassName + " metodi public void " + kerroHenkilostaMethodName + "(Henkilo henkilo) { ..");
        }
    }

    @Test
    @Points("101.2")
    public void kerroHenkilostaTulostaaNimet() {
        metodiKerroHenkilostaOlemassa();

        tarkistaHenkilo("Harry Potter", "James Potter", "Lily Potter");

        tarkistaHenkilo("Bart", "Homer", "Marge");
    }

    @Test
    @Points("101.2")
    public void kerroHenkilostaTulostaaLapsenJaIsanJosEiAitia() {
        metodiKerroHenkilostaOlemassa();

        tarkistaHenkilo("Harry Potter", "James Potter", null);
        tarkistaHenkilo("Bart", "Homer", null);

    }

    @Test
    @Points("101.2")
    public void kerroHenkilostaTulostaaLapsenJaAidinJosEiIsaa() {
        metodiKerroHenkilostaOlemassa();

        tarkistaHenkilo("Harry Potter", null, "Lily Potter");
        tarkistaHenkilo("Bart", null, "Marge");
    }

    @Test
    @Points("101.2")
    public void kerroHenkilostaTulostaaVainLapsenJosOrpo() {
        metodiKerroHenkilostaOlemassa();

        tarkistaHenkilo("Harry Potter", null, null);
        tarkistaHenkilo("Bart", null, null);
    }

    @Test
    @Points("101.3 101.4")
    public void metodiKerroHenkilonSuvustaOlemassa() {
        sukututkijallaParametritonKonstruktori();

        try {
            kerroHenkilonSuvustaMethod = Reflex.reflect(sukututkijaKlassName).method(kerroHenkilonSuvustaMethodName).returningVoid().taking(Henkilo.class);
            assertTrue(kerroHenkilonSuvustaMethod.isPublic());
        } catch (Throwable t) {
            fail("Onhan luokalla " + sukututkijaKlassName + " metodi public void " + kerroHenkilonSuvustaMethodName + "(Henkilo henkilo) { ..");
        }
    }

    @Test
    @Points("101.3 101.4")
    public void kerroHenkilonSuvustaKertooHenkilosta() {
        metodiKerroHenkilonSuvustaOlemassa();
        Henkilo h = luoHenkilo("Bart", "Homer", "Marge");

        int oldOut = io.getSysOut().length();
        kutsuMetodiaKerroHenkilonSuvusta(h);

        String out = io.getSysOut().substring(oldOut);
        rivillaHenkilot(out, "Bart", "Homer", "Marge");
        rivillaHenkilot(out, "Homer", "untemato", "untemato");
        rivillaHenkilot(out, "Marge", "untemato", "untemato");
    }

    @Test
    @Points("101.3 101.4")
    public void kerroHenkilonSuvustaKertooHenkilostaJaIsovanhemmista() {
        metodiKerroHenkilonSuvustaOlemassa();
        Henkilo h = luoHenkilo("Bart", "Homer", "Marge");

        h.getIsa().setIsa(luoHenkilo("Abraham", null, null));
        h.getIsa().setAiti(luoHenkilo("Mona", null, null));

        int oldOut = io.getSysOut().length();
        kutsuMetodiaKerroHenkilonSuvusta(h);

        String out = io.getSysOut().substring(oldOut);
        rivillaHenkilot(out, "Bart", "Homer", "Marge");
        rivillaHenkilot(out, "Homer", "Abraham", "Mona");
        rivillaHenkilot(out, "Abraham", "untemato", "untemato");
        rivillaHenkilot(out, "Mona", "untemato", "untemato");
        rivillaHenkilot(out, "Marge", "untemato", "untemato");
    }

    private void kutsuMetodiaKerroHenkilonSuvusta(Henkilo henkilolle) {
        metodiKerroHenkilonSuvustaOlemassa();
        Object tutkija = luoTutkija();

        try {
            kerroHenkilonSuvustaMethod.invokeOn(tutkija, henkilolle);
        } catch (Throwable ex) {
            if (ex.getMessage() == null || "null".equals(ex.getMessage().trim())) {
                fail("Tapahtui virhe kun metodille " + kerroHenkilonSuvustaMethodName + " annettiin henkilo-viite.\n"
                        + "Tarkistathan ettet tee null-oliolle metodikutsua. Esimerkiksi seuraava koodi ei toimi:\n\n"
                        + "Henkilo bart = new Henkilo(\"Bart\");\n"
                        + "bart.getIsa().getNimi();\n\n//tai\nbart.getAiti().getNimi();\n");
            }

            fail("Tapahtui virhe kun kutsuttiin sukututkijaan liittyviä metodia " + kerroHenkilonSuvustaMethodName + " \n"
                    + "Virhe oli: " + ex.getMessage());
        }
    }

    private void rivillaHenkilot(String tulostus, String lapsi, String isa, String aiti) {
        boolean found = false;
        for (String rivi : tulostus.split("\n")) {
            if (!rivi.contains(lapsi)) {
                continue;
            }

            if (!rivi.contains(isa)) {
                continue;
            }

            if (!rivi.contains(aiti)) {
                continue;
            }

            found = true;
            break;
        }

        assertTrue("Kun on luotu henkilö, jonka nimi on " + lapsi + ", ja jonka isä" + (isa.equals("untemato") ? "" : "n nimi") + " on " + (isa.equals("untemato") ? "tuntematon" : isa) + " ja " + (aiti.equals("untemato") ? "äiti" : "äidin nimi") + " on " + (aiti.equals("untemato") ? "tuntematon" : aiti) + ", tulostuksen tulee sisältää rivi, jossa kaikki kolme esiintyvät.", found);
    }

    private void tarkistaHenkilonSuku(Henkilo henkilo) {
        List<Henkilo> henkilot = new ArrayList<Henkilo>();
        lisaaListalle(henkilo, henkilot);

    }

    private void lisaaListalle(Henkilo henkilo, List<Henkilo> henkilot) {
        if (henkilo == null) {
            return;
        }

        henkilot.add(henkilo);
        lisaaListalle(henkilo.getAiti(), henkilot);
        lisaaListalle(henkilo.getIsa(), henkilot);
    }

    private void tarkistaHenkilo(String nimi, String isa, String aiti) {

        Henkilo h = luoHenkilo(nimi, isa, aiti);

        Object tutkija = luoTutkija();

        int oldOut = io.getSysOut().length();

        String koodi = "\nHenkilo lapsi = new Henkilo(\"" + nimi + "\");\n"
                + (aiti == null ? "" : "Henkilo aiti = new Henkilo(\"" + aiti + "\");\n")
                + (isa == null ? "" : "Henkilo isa = new Henkilo(\"" + isa + "\");\n")
                + (aiti == null ? "" : "lapsi.setAiti(aiti);\n")
                + (isa == null ? "" : "lapsi.setIsa(isa);\n")
                + "\n"
                + "Sukututkija tutkija = new Sukututkija();\n"
                + "tutkija.kerroHenkilosta(lapsi);\n";

        try {
            kerroHenkilostaMethod.invokeOn(tutkija, h);
        } catch (Throwable ex) {
            if (ex.getMessage() == null || "null".equals(ex.getMessage().trim())) {
                fail("Tapahtui virhe kun kutsuttiin\n"
                        + koodi
                        + "Tarkistathan tulostusvaiheessa ettet kutsu metodia olemattomalle henkilölle. Esimerkiksi seuraava koodi ei toimi:\n\n"
                        + "Henkilo bart = new Henkilo(\"Bart\");\n"
                        + "bart.getIsa().getNimi();\n\n//tai\nbart.getAiti().getNimi();\n");
            } else {
                fail("Tapahtui virhe kun kutsuttiin\n"
                        + koodi
                        + "Virhe oli: " + ex.getMessage());
            }

        }

        String out = io.getSysOut().substring(oldOut);
        assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää lapsen nimi, eli tässä tapauksessa " + nimi + ". Nyt tulostus oli " + out, out.contains(nimi));
        assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää lapsen nimi, eli tässä tapauksessa " + nimi + ", vain kerran. Nyt tulostus oli " + out, osumia(out, nimi) == 1);

        if (aiti != null) {
            assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää äidin nimi, eli tässä tapauksessa " + aiti + ". Nyt tulostus oli " + out, out.contains(aiti));
            assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää äidin nimi, eli tässä tapauksessa " + aiti + ", vain kerran. Nyt tulostus oli " + out, osumia(out, aiti) == 1);
        } else {
            assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää teksti tuntematon äidin kohdalla. Nyt tulostus oli " + out, out.contains("untemato"));
        }

        if (isa != null) {
            assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää isän nimi, eli tässä tapauksessa " + isa + ". Nyt tulostus oli " + out, out.contains(isa));
            assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää isän nimi, eli tässä tapauksessa " + isa + ", vain kerran. Nyt tulostus oli " + out, osumia(out, isa) == 1);
        } else {
            assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää teksti tuntematon isän kohdalla. Nyt tulostus oli " + out, out.contains("untemato"));
        }

        if (aiti != null && isa != null) {
            assertFalse("Kun suoritetaan koodi " + koodi + ", tulostuksen ei pitäisi sisältää tekstiä tuntematon. Nyt tulostus oli " + out, out.contains("untemato"));
        }

        if (aiti == null && isa == null) {
            assertTrue("Kun suoritetaan koodi " + koodi + ", tulostuksen pitäisi sisältää teksti tuntematon sekä isän että äidin kohdalla. Nyt tulostus oli " + out, osumia(out, "untemato") == 2);
        }

        assertTrue("Tarkista että koodin " + koodi + " tulostus on yhdellä rivillä Nyt tulostus oli " + out, out.split("\n").length == 1);
    }

    private Henkilo luoHenkilo(String nimi, String isanNimi, String aidinNimi) {
        Henkilo lapsi = new Henkilo(nimi);
        if (isanNimi != null) {
            Henkilo isa = new Henkilo(isanNimi);
            lapsi.setIsa(isa);
        }

        if (aidinNimi != null) {
            Henkilo aiti = new Henkilo(aidinNimi);
            lapsi.setAiti(aiti);
        }

        return lapsi;
    }

    private Object luoTutkija() {
        try {
            return sukututkijaKlass.ctor().takingNoParams().invoke();
        } catch (Throwable ex) {
            fail("Konstruktorikutsu:\n" + sukututkijaKlassName + " tutkija = new " + sukututkijaKlassName + "();\nepäonnistui.");
        }

        return null;
    }

    private int osumia(String teksti, String etsittava) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {

            lastIndex = teksti.indexOf(etsittava, lastIndex);

            if (lastIndex != -1) {
                count++;
                lastIndex += etsittava.length();
            }
        }

        return count;
    }

}
