package liikkuvakuvio;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LiikkuvaKuvioTest {

    Class kuvioClass;
    Method kuvioSiirraMethod;
    Method kuvioPiirraMethod;
    Constructor kuvioConstructor;
    Method kuvioGetXMethod;
    Method kuvioGetYMethod;
    Class ympyraClass;
    Constructor ympyraConstructor;
    Class piirtoalustaClass;
    Constructor piirtoalustaConstructor;
    Method piirtoalustaPaintComponentMethod;
    Field piirtoalustaKuvioField;
    Constructor kayttoliittymaKuvioConstructor;
    Method kayttoliittymaLuoKomponentitMethod;
    Method kayttoliittymaLisaaKuuntelijatMethod;
    Class nappaimistonKuuntelijaClass;
    Constructor nappaimistonKuuntelijaConstructor;
    Class nelioClass;
    Constructor nelioConstructor;
    Class laatikkoClass;
    Constructor laatikkoConstructor;
    Class koostekuvioClass;
    Constructor koostekuvioConstructor;
    Method koostekuvioLiitaMethod;

    @Before
    public void setUp() {
        try {
            kuvioClass = ReflectionUtils.findClass("liikkuvakuvio.Kuvio");
            kuvioSiirraMethod = ReflectionUtils.requireMethod(kuvioClass, "siirra", int.class, int.class);
            kuvioConstructor = ReflectionUtils.requireConstructor(kuvioClass, int.class, int.class);
            kuvioGetXMethod = ReflectionUtils.requireMethod(kuvioClass, "getX");
            kuvioGetYMethod = ReflectionUtils.requireMethod(kuvioClass, "getY");
            kuvioPiirraMethod = ReflectionUtils.requireMethod(kuvioClass, "piirra", Graphics.class);
        } catch (Throwable t) {
        }

        try {
            ympyraClass = ReflectionUtils.findClass("liikkuvakuvio.Ympyra");
            ympyraConstructor = ReflectionUtils.requireConstructor(ympyraClass, int.class, int.class, int.class);
        } catch (Throwable t) {
        }


        try {
            kayttoliittymaKuvioConstructor = ReflectionUtils.requireConstructor(Kayttoliittyma.class, kuvioClass);

            for (Method m : Kayttoliittyma.class.getDeclaredMethods()) {
                if (m.getName().equals("luoKomponentit")) {
                    kayttoliittymaLuoKomponentitMethod = m;
                    break;
                }
            }

            kayttoliittymaLuoKomponentitMethod.setAccessible(true);

            for (Method m : Kayttoliittyma.class.getDeclaredMethods()) {
                if (m.getName().equals("lisaaKuuntelijat")) {
                    kayttoliittymaLisaaKuuntelijatMethod = m;
                    break;
                }
            }
            kayttoliittymaLisaaKuuntelijatMethod.setAccessible(true);
        } catch (Throwable t) {
        }


        try {
            piirtoalustaClass = ReflectionUtils.findClass("liikkuvakuvio.Piirtoalusta");
            piirtoalustaConstructor = ReflectionUtils.requireConstructor(piirtoalustaClass, kuvioClass);

            for (Method m : piirtoalustaClass.getDeclaredMethods()) {
                if (m.getName().equals("paintComponent")) {
                    piirtoalustaPaintComponentMethod = m;
                    break;
                }
            }

            piirtoalustaPaintComponentMethod.setAccessible(true);

            for (Field f : piirtoalustaClass.getDeclaredFields()) {
                if (f.getType().equals(kuvioClass)) {
                    piirtoalustaKuvioField = f;
                    break;
                }
            }
            piirtoalustaKuvioField.setAccessible(true);

        } catch (Throwable t) {
        }

        try {
            nappaimistonKuuntelijaClass = ReflectionUtils.findClass("liikkuvakuvio.NappaimistonKuuntelija");
            nappaimistonKuuntelijaConstructor = ReflectionUtils.requireConstructor(nappaimistonKuuntelijaClass, Component.class, kuvioClass);
        } catch (Throwable t) {
        }


        try {
            nelioClass = ReflectionUtils.findClass("liikkuvakuvio.Nelio");
            nelioConstructor = ReflectionUtils.requireConstructor(nelioClass, int.class, int.class, int.class);
        } catch (Throwable t) {
        }



        try {
            laatikkoClass = ReflectionUtils.findClass("liikkuvakuvio.Laatikko");
            laatikkoConstructor = ReflectionUtils.requireConstructor(laatikkoClass, int.class, int.class, int.class, int.class);
        } catch (Throwable t) {
        }

        try {
            koostekuvioClass = ReflectionUtils.findClass("liikkuvakuvio.Koostekuvio");
            koostekuvioConstructor = ReflectionUtils.requireConstructor(koostekuvioClass);
            koostekuvioLiitaMethod = ReflectionUtils.requireMethod(koostekuvioClass, "liita", kuvioClass);
        } catch (Throwable t) {
        }

    }

    @Test
    @Points("167.1")
    public void kuvio() {
        Reflex.ClassRef<Object> ref;
        String luokanNimi = "liikkuvakuvio.Kuvio";
        ref = Reflex.reflect(luokanNimi);
        assertTrue("tee pakkauseen liikkuvakuvio julkinen abstrakti luokka Kuvio:\n"
                + "public abstract class Kuvio {", ref.isPublic());

        if (kuvioClass == null || !Modifier.isAbstract(kuvioClass.getModifiers())) {
            fail("Olethan toteuttanut abstraktin luokan Kuvio pakkaukseen liikkuvakuvio, ja onhan luokalla Kuvio m????re public?");
        }

        if (kuvioClass.getDeclaredFields().length != 2) {
            fail("Onhan luokalla Kuvio vain oliomuuttujat private int x ja private int y? Et tarvitse muita oliomuuttujia.");
        }

        if (kuvioSiirraMethod == null || Modifier.isAbstract(kuvioSiirraMethod.getModifiers())) {
            fail("Onhan luokalla Kuvio ei abstrakti metodi public void siirra(int dx, int dy), jonka avulla kuvion sijainti siirtyy parametrina olevien koordinaattisiirtymien verran?");
        }

        if (kuvioConstructor == null) {
            fail("Onhan luokalla Kuvio konstruktori public Kuvio(int x, int y)?");
        }

        if (kuvioGetXMethod == null || !kuvioGetXMethod.getReturnType().equals(int.class)) {
            fail("Onhan luokalla Kuvio metodi public int getX()?");
        }

        if (kuvioGetYMethod == null || !kuvioGetYMethod.getReturnType().equals(int.class)) {
            fail("Onhan luokalla Kuvio metodi public int getY()?");
        }

        if (kuvioPiirraMethod == null || !Modifier.isAbstract(kuvioPiirraMethod.getModifiers())) {
            fail("Onhan luokalla Kuvio abstrakti metodi public abstract void piirra(Graphics graphics)?");
        }
    }

    @Test
    @Points("167.2")
    public void ympyra() {
        if (ympyraClass == null || Modifier.isAbstract(ympyraClass.getModifiers())) {
            fail("Olethan toteuttanut luokan Ympyra pakkaukseen liikkuvakuvio, ja onhan luokalla Ympyra m????re public?");
        }

        if (ympyraClass.getDeclaredFields().length != 1) {
            fail("Onhan luokalla Ympyra vain oliomuuttuja private int halkaisija? Et tarvitse muita oliomuuttujia.");
        }

        if (ympyraConstructor == null) {
            fail("Onhan luokalla Ympyra konstruktori public Ympyra(int x, int y, int halkaisija)?");
        }

        if (!kuvioClass.isAssignableFrom(ympyraClass)) {
            fail("Periih??n luokka Ympyra luokan Kuvio?");
        }

        Object ympyra = luoYmpyra(5, 50, 500);
    }

    @Test
    @Points("167.3")
    public void piirtoalusta() {
        if (piirtoalustaClass == null || Modifier.isAbstract(piirtoalustaClass.getModifiers())) {
            fail("Olethan toteuttanut luokan Piirtoalusta pakkaukseen liikkuvakuvio, ja onhan luokalla Piirtoalusta m????re public?");
        }

        if (piirtoalustaClass.getDeclaredFields().length != 1) {
            fail("Onhan luokalla Piirtoalusta vain oliomuuttuja private Kuvio kuvio? Et tarvitse muita oliomuuttujia.");
        }

        if (piirtoalustaConstructor == null) {
            fail("Onhan luokalla Piirtoalusta konstruktori public Piirtoalusta(Kuvio kuvio)?");
        }

        if (!JPanel.class.isAssignableFrom(piirtoalustaClass)) {
            fail("Periih??n luokka Piirtoalusta luokan JPanel?");
        }

        if (piirtoalustaPaintComponentMethod == null) {
            fail("Korvaahan luokka Piirtoalusta luokan JPanel metodin protected void paintComponent(Graphics graphics)?");
        }

        Object piirtoAlustaYmpyralla = luoPiirtoalusta(luoYmpyra(10, 20, 3));
        LiikkuvaKuvioTest.MockGraphics mc = new LiikkuvaKuvioTest.MockGraphics();
        try {
            ReflectionUtils.invokeMethod(void.class, piirtoalustaPaintComponentMethod, piirtoAlustaYmpyralla, mc);
        } catch (Throwable ex) {
            fail("Piirtoalustan metodin paintComponent kutsuminen ep??onnistui: " + ex.getMessage());
        }

        assertTrue("Luokan Piirtoalustan metodia paintComponent kutsuttaessa pit??isi kutsua yl??luokan paintComponent-metodia. \n"
                + "Tarkista ett?? luokassa Piirtoalusta olevan metodim????rittelyn protected void paintComponent(Graphics graphics) alussa on kutsu super.paintComponent(graphics);", mc.getKutsut().size() > 1);
        assertTrue("Luokan Piirtoalustan metodia paintComponent kutsuttaessa pit??isi kutsua "
                + "sille konstruktorin parametrina annetun kuvion piirra-metodia. Nyt ei kutsuttu.", mc.getKutsut().contains("fillOval(10, 20, 3, 3)"));

        if (piirtoalustaKuvioField == null) {
            fail("Onhan luokalla Piirtoalusta oliomuuttuja private Kuvio kuvio?");
        }
    }

    @Test
    @Points("167.3")
    public void piirtoalustaKayttoliittymaan() throws IllegalArgumentException, IllegalAccessException {
        if (kayttoliittymaKuvioConstructor == null) {
            fail("Muokkasithan luokkaa Kayttoliittyma siten, ett?? sill?? on Kuvio-luokan ilmentym??n parametrina saava konstruktori?");
        }

        if (kayttoliittymaLuoKomponentitMethod == null
                || kayttoliittymaLuoKomponentitMethod.getParameterTypes().length != 1
                || kayttoliittymaLuoKomponentitMethod.getParameterTypes()[0].equals(Component.class)) {
            fail("Onhan luokassa Kayttoliittyma metodi private void luoKomponentit(Container container), jossa lis??t????n k??ytt??liittym????n komponentit?");
        }

        Object ympyra = luoYmpyra(10, 10, 50);
        Kayttoliittyma kali = null;
        try {
            kali = (Kayttoliittyma) ReflectionUtils.invokeConstructor(kayttoliittymaKuvioConstructor, ympyra);
        } catch (Throwable ex) {
            fail("Onhan k??ytt??liittym??n konstruktorilla public Kayttoliittyma(Kuvio kuvio) m????re public ja onhan luokalla Kayttoliittyma m????re public?");
        }

        for( Field f: Kayttoliittyma.class.getDeclaredFields() ){
            String mj = f.toString();
            if ( mj.contains("JFrame")) {
                f.setAccessible(true);
                f.set(kali, new LiikkuvaKuvioTest.JFrameMock());
            }
        }

        LiikkuvaKuvioTest.MockContainer container = new LiikkuvaKuvioTest.MockContainer();
        try {
            ReflectionUtils.invokeMethod(void.class, kayttoliittymaLuoKomponentitMethod, kali, container);
        } catch (Throwable ex) {
            fail("Metodin luoKomponentit kutsu ep??onnistui\n"
                    + "lis??tietoja" + ex.getMessage());
        }

        assertNotNull("Lis????th??n piirtoalustan k??ytt??liittym????n Kayttoliittyma-luokan metodissa luoKomponentit?", container.lisatty);
        Object piirtoalusta = container.lisatty;
        Object ympyraPiirtoalustasta = null;

        try {
            ympyraPiirtoalustasta = piirtoalustaKuvioField.get(piirtoalusta);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(LiikkuvaKuvioTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LiikkuvaKuvioTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertEquals("Asetathan k??ytt??liittym??n saaman kuvion piirtoalustalle piirrett??v??ksi?", ympyra, ympyraPiirtoalustasta);
    }

    @Test
    @Points("167.4")
    public void nappaimistonkuuntelija() {
        if (nappaimistonKuuntelijaClass == null) {
            fail("Olethan toteuttanut luokan NappaimistonKuuntelija pakkaukseen liikkuvakuvio, ja onhan luokalla NappaimistonKuuntelija m????re public?");
        }

        if (nappaimistonKuuntelijaConstructor == null) {
            fail("Onhan luokalla NappaimistonKuuntelija konstruktori public NappaimistonKuuntelija(Component component, Kuvio kuvio)?");
        }

        if (!KeyListener.class.isAssignableFrom(nappaimistonKuuntelijaClass)) {
            fail("Toteuttaahan luokka NappaimistonKuuntelija rajapinnan KeyListener?");
        }

        boolean loytyi = false;
        for (Method m : nappaimistonKuuntelijaClass.getDeclaredMethods()) {
            if (m.getName().equals("keyPressed")) {
                loytyi = true;
                break;
            }
        }

        assertTrue("Toteutathan luokassa NappaimistonKuuntelija metodin public void keyPressed(KeyEvent e)?", loytyi);

        LiikkuvaKuvioTest.MockComponent mockComponent = new LiikkuvaKuvioTest.MockComponent();
        Object ympyra = luoYmpyra(40, 20, 10);

        KeyListener kuuntelija = null;
        try {
            kuuntelija = (KeyListener) ReflectionUtils.invokeConstructor(nappaimistonKuuntelijaConstructor, mockComponent, ympyra);
        } catch (Throwable ex) {
            fail("Nappaimistonkuuntelijan luonti ep??onnistui, virhe: " + ex.getMessage() + ". Onhan luokalla NappaimistonKuuntelija konstruktori public NappaimistonKuuntelija(Component component, Kuvio kuvio)?");
        }

        kuuntelija.keyPressed(new LiikkuvaKuvioTest.MockKeyEvent(KeyEvent.VK_LEFT));
        assertTrue("Kutsuthan piirtoalustan repaint-metodia jokaisen n??pp??imist??npainalluksen j??lkeen?", mockComponent.repaintKutsuttu);


        int palautettuX = -1, palautettuY = -1;
        try {
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, ympyra);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, ympyra);
        } catch (Throwable t) {
            fail("Toimiihan Ympyra-luokan luokasta Kuvio perim??t metodit getX ja getY. Virhe: " + t.getMessage());
        }

        assertTrue("Kun n??pp??imist??lt?? painetaan vasemmalle, kuvion x-koordinaatin pit??isi pienenty??. Koordinaatin y tulee pysy?? samana.", palautettuX < 40 && palautettuY == 20);


        kuuntelija.keyPressed(new LiikkuvaKuvioTest.MockKeyEvent(KeyEvent.VK_RIGHT));
        try {
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, ympyra);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, ympyra);
        } catch (Throwable t) {
            fail("Toimiihan Ympyra-luokan luokasta Kuvio perim??t metodit getX ja getY. Virhe: " + t.getMessage());
        }

        assertTrue("Kun n??pp??imist??lt?? painetaan oikealle, kuvion x-koordinaatin pit??isi kasvaa. Koordinaatin y tulee pysy?? samana. Huomaa ett?? koordinaattien muutosten tulee olla samat\n"
                + " jos vasemmalle liikuttaessa v??hennet????n 1, oikealle liikuttaessa pit???? lis??t?? 1.", palautettuX == 40 && palautettuY == 20);

        kuuntelija.keyPressed(new LiikkuvaKuvioTest.MockKeyEvent(KeyEvent.VK_UP));
        try {
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, ympyra);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, ympyra);
        } catch (Throwable t) {
            fail("Toimiihan Ympyra-luokan luokasta Kuvio perim??t metodit getX ja getY. Virhe: " + t.getMessage());
        }

        assertTrue("Kun n??pp??imist??lt?? painetaan yl??s, kuvion y-koordinaatin pit??isi pienenty??. \n"
                + "Pienentyminen johtuu siit??, ett?? piirt??misess?? y-koordinaatti kasvaa alasp??in. Kuvion x-koordinaatin tulee pysy?? samana.", palautettuX == 40 && palautettuY < 20);

        kuuntelija.keyPressed(new LiikkuvaKuvioTest.MockKeyEvent(KeyEvent.VK_DOWN));
        try {
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, ympyra);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, ympyra);
        } catch (Throwable t) {
            fail("Toimiihan Ympyra-luokan luokasta Kuvio perim??t metodit getX ja getY. Virhe: " + t.getMessage());
        }

        assertTrue("Kun n??pp??imist??lt?? painetaan alas, kuvion y-koordinaatin pit??isi kasvaa. \n"
                + "Kasvaminen johtuu siit??, ett?? piirt??misess?? y-koordinaatti kasvaa alasp??in. \n"
                + "Kuvion x-koordinaatin tulee pysy?? samana. Varmista my??s ett?? pienennys ja kasvatus on aina sama.", palautettuX == 40 && palautettuY == 20);
    }

    @Test
    @Points("167.4")
    public void nappaimistonKuuntelijaKayttoliittymaan() throws IllegalArgumentException, IllegalAccessException {
        if (kayttoliittymaKuvioConstructor == null) {
            fail("Muokkasithan luokkaa Kayttoliittyma siten, ett?? sill?? on Kuvio-luokan ilmentym??n parametrina saava konstruktori?");
        }

        if (kayttoliittymaLisaaKuuntelijatMethod == null
                || kayttoliittymaLisaaKuuntelijatMethod.getParameterTypes().length != 0) {
            fail("Onhan luokassa Kayttoliittyma metodi private void lisaaKuuntelijat(), jossa lis??t????n k??ytt??liittym????n tapahtumankuuntelijat?");
        }

        Object ympyra = luoYmpyra(40, 20, 10);
        Kayttoliittyma kali = null;
        try {
            kali = (Kayttoliittyma) ReflectionUtils.invokeConstructor(kayttoliittymaKuvioConstructor, ympyra);
        } catch (Throwable ex) {
            fail("Onhan k??ytt??liittym??n konstruktorilla public Kayttoliittyma(Kuvio kuvio) m????re public ja onhan luokalla Kayttoliittyma m????re public?");
        }

        for (Field f : Kayttoliittyma.class.getDeclaredFields()) {
            if (f.toString().contains("JFrame")) {
                f.setAccessible(true);
                f.set(kali, new JFrame());
            }
        }

        try {
            ReflectionUtils.invokeMethod(void.class, kayttoliittymaLuoKomponentitMethod, kali, new Container());
        } catch (Throwable ex) {
            fail("Metodin luoKomponentit kutsu ep??onnistui: " + ex.getMessage());
        }

        try {
            ReflectionUtils.invokeMethod(void.class, kayttoliittymaLisaaKuuntelijatMethod, kali);
        } catch (Throwable ex) {
            fail("Metodin lisaaKuuntelijat kutsu ep??onnistui: " + ex.getMessage());
        }
        int nappaintenKuuntelijoita = kali.getFrame().getKeyListeners().length;

        assertTrue("Lis????th??n k??ytt??liittym????n n??pp??intenkuuntelijan metodissa lisaaKuuntelijat()",  nappaintenKuuntelijoita>0);



    }

    @Test
    @Points("167.5")
    public void nelio() {
        if (nelioClass == null || Modifier.isAbstract(nelioClass.getModifiers())) {
            fail("Olethan toteuttanut luokan Nelio pakkaukseen liikkuvakuvio, ja onhan luokalla Nelio m????re public?");
        }

        if (nelioClass.getDeclaredFields().length != 1) {
            fail("Onhan luokalla Nelio vain oliomuuttuja private int sivunPituus? Et tarvitse muita oliomuuttujia.");
        }

        if (nelioConstructor == null) {
            fail("Onhan luokalla Nelio konstruktori public Nelio(int x, int y, int sivunPituus)?");
        }

        if (!kuvioClass.isAssignableFrom(nelioClass)) {
            fail("Periih??n luokka Nelio luokan Kuvio?");
        }

        Object nelio = luoNelio(50, 75, 100);
    }

    @Test
    @Points("167.5")
    public void laatikko() {
        if (laatikkoClass == null || Modifier.isAbstract(laatikkoClass.getModifiers())) {
            fail("Olethan toteuttanut luokan Laatikko pakkaukseen liikkuvakuvio, ja onhan luokalla Laatikko m????re public?");
        }

        if (laatikkoClass.getDeclaredFields().length != 2) {
            fail("Onhan luokalla Laatikko vain oliomuuttujat private int leveys ja private int korkeus? Et tarvitse muita oliomuuttujia.");
        }

        if (laatikkoConstructor == null) {
            fail("Onhan luokalla Laatikko konstruktori public Laatikko(int x, int y, int leveys, int korkeus)?");
        }

        if (!kuvioClass.isAssignableFrom(laatikkoClass)) {
            fail("Periih??n luokka Laatikko luokan Kuvio?");
        }

        Object laatikko = luoLaatikko(50, 75, 100, 125);
    }

    @Test
    @Points("167.6")
    public void koostekuvio() {
        if (koostekuvioClass == null || Modifier.isAbstract(koostekuvioClass.getModifiers())) {
            fail("Olethan toteuttanut luokan Koostekuvio pakkaukseen liikkuvakuvio, ja onhan luokalla Koostekuvio m????re public?");
        }

        if (koostekuvioClass.getDeclaredFields().length != 1) {
            fail("Onhan luokalla Koostekuvio vain yksi oliomuuttuja, lista kuvioista joista koostekuvio koostuu.");
        }

        if (koostekuvioConstructor == null) {
            fail("Onhan luokalla Koostekuvio konstruktori public Koostekuvio() ja onhan luokalla m????re public?");
        }

        if (!kuvioClass.isAssignableFrom(koostekuvioClass)) {
            fail("Periih??n luokka Koostekuvio luokan Kuvio?");
        }


        Object laatikko = luoLaatikko(50, 75, 100, 125);
        Object ympyra = luoYmpyra(10, 20, 30);

        metodiLisaa(ympyra);
        Object koostekuvio = luoKoostekuvio(laatikko, ympyra);
        LiikkuvaKuvioTest.MockGraphics mc = new LiikkuvaKuvioTest.MockGraphics();

        try {
            ReflectionUtils.invokeMethod(void.class, kuvioPiirraMethod, koostekuvio, mc);
        } catch (Throwable ex) {
            fail("Metodin " + kuvioPiirraMethod.getName() + " kutsuminen ep??onnistui: " + ex.getMessage());
        }

        String kutsut = "";
        for (String k : mc.kutsut) {
            kutsut += " "+k;
        }

        assertTrue("Koostekuvio kk = new Koostekuvio();\n"
                + "kk.lisaa(new Laatikko(50, 75, 100, 125));\n"
                + "kk.lisaa(new Ympyra(10, 20, 30));\n"
                + "kk.piirra();\n"
                + "Koostekuviota piirrett??ess?? tulee piirt???? kaikki sen sis??lt??m??t kuviot. \n"
                + "Voit kutsua kullekin kuviolle kuvion omaa piirra-metodia. \n"
                + "kutsuit: \n"+kutsut, mc.kutsut.contains("fillRect(50, 75, 100, 125)"));
        assertTrue("Koostekuvio kk = new Koostekuvio();\n"
                + "kk.lisaa(new Laatikko(50, 75, 100, 125));\n"
                + "kk.lisaa(new Ympyra(10, 20, 30));\n"
                + "kk.piirra();\n"
                + "Koostekuviota piirrett??ess?? tulee piirt???? kaikki sen sis??lt??m??t kuviot. \n"
                + "Voit kutsua kullekin kuviolle kuvion omaa piirra-metodia. \n"
                + "kutsuit: \n"+kutsut, mc.kutsut.contains("fillOval(10, 20, 30, 30)"));

        int laatikkoX = -1, ympyraX = -1;
        try {
            ReflectionUtils.invokeMethod(void.class, kuvioSiirraMethod, koostekuvio, 1, 0);
            laatikkoX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, laatikko);
            ympyraX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, ympyra);
        } catch (Throwable t) {
            fail("Virhe koodilla"+"Koostekuvio kk = new Koostekuvio();\n"
                + "kk.lisaa(new Laatikko(50, 75, 100, 125));\n"
                + "kk.lisaa(new Ympyra(10, 20, 30));\n"
                + "kk.siirra(1,0)\n"+
                    "Lis??tietoja: " + t.getMessage());
        }

        assertEquals("Koostekuviota siirrett??ess?? tulee siirt???? kaikkia sen sis??lt??mi?? kuvioita. \n"
                + "Joudut siis ylikirjoittamaan perityn siirra-metodin\n"+
                "Koodin\n"
                + "Koostekuvio kk = new Koostekuvio();\n"
                + "kk.lisaa(new Laatikko(50, 75, 100, 125));\n"
                + "kk.lisaa(new Ympyra(10, 20, 30));\n"
                + "kk.siirra(1,0)\n"
                + "suorituksen j??lkeen laatikon x-kordinaatin arvo", 51, laatikkoX );
        assertEquals("Koostekuviota siirrett??ess?? tulee siirt???? kaikkia sen sis??lt??mi?? kuvioita. \n"
                + "Joudut siis ylikirjoittamaan perityn siirra-metodin\n"+
                "Koodin\n"
                + "Koostekuvio kk = new Koostekuvio();\n"
                + "kk.lisaa(new Laatikko(50, 75, 100, 125));\n"
                + "kk.lisaa(new Ympyra(10, 20, 30));\n"
                + "kk.siirra(1,0)\n"
                + "suorituksen j??lkeen laatikon x-kordinaatin arvo", 11, ympyraX );


    }

    private Object luoPiirtoalusta(Object kuvio) {
        try {
            return ReflectionUtils.invokeConstructor(piirtoalustaConstructor, kuvio);
        } catch (Throwable ex) {
            Logger.getLogger(LiikkuvaKuvioTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private Object luoYmpyra(int x, int y, int halkaisija) {
        Object ympyra = null;

        try {
            ympyra = ReflectionUtils.invokeConstructor(ympyraConstructor, x, y, halkaisija);
        } catch (Throwable ex) {
            fail("Onhan luokalla Ympyra m????re public, ja onhan sen konstruktorilla m????re public?");
        }

        tarkistaSijainti("Ympyra", ympyra, x, y);
        tarkistaSiirtyminen("Ympyra", ympyra, x, y);
        tarkistaKuvionPiirtaminen("new Ympyra(" + x + "," + y + "," + halkaisija + ")", "Ympyra", ympyra, "fillOval(" + x + ", " + y + ", " + halkaisija + ", " + halkaisija + ")");

        return ympyra;
    }

    private Object luoNelio(int x, int y, int sivunPituus) {
        Object nelio = null;

        try {
            nelio = ReflectionUtils.invokeConstructor(nelioConstructor, x, y, sivunPituus);
        } catch (Throwable ex) {
            fail("Onhan luokalla Nelio m????re public, ja onhan sen konstruktorilla m????re public?");
        }

        tarkistaSijainti("Nelio", nelio, x, y);
        tarkistaSiirtyminen("Nelio", nelio, x, y);
        tarkistaKuvionPiirtaminen("new Nelio(", +x + ", " + y + ", " + sivunPituus + ")", nelio, "fillRect(" + x + ", " + y + ", " + sivunPituus + ", " + sivunPituus + ")");

        return nelio;
    }

    private Object luoLaatikko(int x, int y, int leveys, int korkeus) {
        Object laatikko = null;

        try {
            laatikko = ReflectionUtils.invokeConstructor(laatikkoConstructor, x, y, leveys, korkeus);
        } catch (Throwable ex) {
            fail("Onhan luokalla Laatikko m????re public, ja onhan sen konstruktorilla m????re public?");
        }

        tarkistaSijainti("Laatikko", laatikko, x, y);
        tarkistaSiirtyminen("Laatikko", laatikko, x, y);
        tarkistaKuvionPiirtaminen("new Laatikko(" + x + ", " + y + ", " + leveys + ", " + korkeus + ")", "Laatikko", laatikko, "fillRect(" + x + ", " + y + ", " + leveys + ", " + korkeus + ")");

        return laatikko;
    }

    private void metodiLisaa(Object kuvio) {
        Object koostekuvio = null;

        try {
            koostekuvio = ReflectionUtils.invokeConstructor(koostekuvioConstructor);
        } catch (Throwable ex) {
            fail("Onhan luokalla Koostekuvio m????re public, ja onhan sen konstruktorilla m????re public?");
        }

        try {
            ReflectionUtils.invokeMethod(koostekuvioClass, koostekuvioLiitaMethod, koostekuvio, kuvio);
        } catch (Throwable ex) {
            fail("Onko luokalla Koostekuvio metodi public void liita(Kuvio kuvio)?\n"
                    + "\n"
                    + "jos on, tarkista koodi\n"
                    + "Koostekuvio kk = new Koostekuvio();\n"
                    + "kk.liita( new Ympyra(10, 20, 30) );\n\nlis??tietoa"+ex);
        }

    }

    private Object luoKoostekuvio(Object... kuviot) {
        Object koostekuvio = null;

        try {
            koostekuvio = ReflectionUtils.invokeConstructor(koostekuvioConstructor);
        } catch (Throwable ex) {
            fail("Onhan luokalla Koostekuvio m????re public, ja onhan sen konstruktorilla m????re public?");
        }

        for (Object kuvio : kuviot) {
            try {
                ReflectionUtils.invokeMethod(koostekuvioClass, koostekuvioLiitaMethod, koostekuvio, kuvio);
            } catch (Throwable ex) {
                fail("Kuvion liitt??minen koostekuvioon ep??onnistui. ");
            }
        }

        return koostekuvio;
    }

    private void tarkistaSijainti(String luokka, Object kuvio, int x, int y) {

        int palautettuX = -1, palautettuY = -1;
        try {
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, kuvio);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, kuvio);
        } catch (Throwable t) {
            fail("Toimiihan " + luokka + "-luokan luokasta Kuvio perim??t metodit getX ja getY?");
        }

        assertEquals("Luokan Kuvio konstruktorin tai getX metodin toiminnallisuus ei ole kunnossa!\n"
                + "Kun luokalle " + luokka + " annettiin konstruktorissa x:n arvoksi " + x + ", luodun olion metodi getX() palautti arvon " + palautettuX, x, palautettuX);
        assertEquals("Luokan Kuvio konstruktorin tai getY metodin toiminnallisuus ei ole kunnossa!\n"
                + "Kun luokalle " + luokka + " annettiin konstruktorissa y:n arvoksi " + y + ", luodun olion metodi getY() palautti arvon " + palautettuY, y, palautettuY);

    }

    private void tarkistaSiirtyminen(String luokka, Object kuvio, int x, int y) {
        int palautettuX = -1, palautettuY = -1;
        try {
            ReflectionUtils.invokeMethod(void.class, kuvioSiirraMethod, kuvio, 0, 1);
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, kuvio);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, kuvio);
        } catch (Throwable t) {
        }

        assertEquals("Luokan Kuvio metodin siirra toiminnallisuus ei ole kunnossa!\n"
                + "Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (0, 1), tulisi x-koordinaatin pysy?? samana.", x, palautettuX);
        assertEquals("Luokan Kuvio metodin siirra toiminnallisuus ei ole kunnossa!\n"
                + "Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (0, 1), tulisi y-koordinaatin arvon kasvaa yhdell??.", y + 1, palautettuY);

        try {
            ReflectionUtils.invokeMethod(void.class, kuvioSiirraMethod, kuvio, 0, -1);
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, kuvio);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, kuvio);
        } catch (Throwable t) {
        }

        assertEquals("Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (0, -1), tulisi x-koordinaatin pysy?? samana.", x, palautettuX);
        assertEquals("Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (0, -1), tulisi y-koordinaatin arvon pienenty?? yhdell??.", y, palautettuY);

        try {
            ReflectionUtils.invokeMethod(void.class, kuvioSiirraMethod, kuvio, 1, 0);
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, kuvio);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, kuvio);
        } catch (Throwable t) {
        }


        assertEquals("Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (1, 0), tulisi x-koordinaatin arvon kasvaa yhdell??.", x + 1, palautettuX);
        assertEquals("Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (1, 0), tulisi y-koordinaatin arvon pysy?? samana.", y, palautettuY);

        try {
            ReflectionUtils.invokeMethod(void.class, kuvioSiirraMethod, kuvio, -1, 0);
            palautettuX = ReflectionUtils.invokeMethod(int.class, kuvioGetXMethod, kuvio);
            palautettuY = ReflectionUtils.invokeMethod(int.class, kuvioGetYMethod, kuvio);
        } catch (Throwable t) {
        }


        assertEquals("Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (-1, 0), tulisi x-koordinaatin arvon pienenty?? yhdell??.", x, palautettuX);
        assertEquals("Kun luokan " + luokka + " ilmentym??lle kutsutaan metodia siirra arvoilla (-1, 0), tulisi y-koordinaatin arvon pysy?? samana.", y, palautettuY);
    }

    private void tarkistaKuvionPiirtaminen(String luokka, Object kuvio, String... kutsut) {
        LiikkuvaKuvioTest.MockGraphics mc = new LiikkuvaKuvioTest.MockGraphics();
        try {
            ReflectionUtils.invokeMethod(void.class, kuvioPiirraMethod, kuvio, mc);
        } catch (Throwable ex) {
            fail("Metodin " + kuvioPiirraMethod.getName() + " kutsuminen ep??onnistui: " + ex.getMessage());
        }

        for (String kutsu : kutsut) {
            assertTrue("Luokan " + luokka + " ilmentym???? piirrett??ess?? olisi pit??nyt tapahtua kutsu " + kutsu + " annetuilla arvoilla, nyt ei tapahtunut. \n"
                    + "Tarkista ett?? k??yt??t oikeaa metodia ja ett?? annat parametrit oikein.", mc.getKutsut().contains(kutsu));
        }
    }

    private void tarkistaKuvionPiirtaminen(String ilm, String luokka, Object kuvio, String... kutsut) {
        LiikkuvaKuvioTest.MockGraphics mc = new LiikkuvaKuvioTest.MockGraphics();
        try {
            ReflectionUtils.invokeMethod(void.class, kuvioPiirraMethod, kuvio, mc);
        } catch (Throwable ex) {
            fail("Metodin " + kuvioPiirraMethod.getName() + " kutsuminen ep??onnistui: " + ex.getMessage());
        }

        String k = "";
        for (String string : mc.getKutsut()) {
            k += " " + string;
        }

        for (String kutsu : kutsut) {
            assertTrue("Olioa " + ilm + " piirrett??ess?? olisi pit??nyt tapahtua kutsu " + kutsu + " annetuilla arvoilla, nyt ei tapahtunut. \n"
                    + "Kutsuit:\n"
                    + k, mc.getKutsut().contains(kutsu));
        }
    }

    private void superi(Class clas) {
        String file = clas.getName().replaceAll("\\.", "/");

        boolean ok = false;
        try {
            Scanner lukija = new Scanner(new File(file));

            while (lukija.hasNextLine()) {

                String rivi = lukija.nextLine();

                if (rivi.contains("super.paintComponent")) {
                    ok = true;
                }

            }

        } catch (Exception e) {
        }

        String f = clas.getName();
        f = f.substring(f.lastIndexOf('.') + 1);

        Assert.assertTrue("Lis???? luokan " + f + " metodin paintComponent alkuun metodikutsu super.paintComponent(graphics);", ok);

    }

    private class MockGraphics extends Graphics {

        private java.util.List<String> kutsut = new ArrayList();

        @Override
        public Graphics create() {
            kutsut.add("create()");
            return this;
        }

        @Override
        public void translate(int i, int i1) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Color getColor() {
            return Color.BLACK;
        }

        @Override
        public void setColor(Color color) {
        }

        @Override
        public void setPaintMode() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setXORMode(Color color) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Font getFont() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setFont(Font font) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public FontMetrics getFontMetrics(Font font) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Rectangle getClipBounds() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void clipRect(int i, int i1, int i2, int i3) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setClip(int i, int i1, int i2, int i3) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Shape getClip() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setClip(Shape shape) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void copyArea(int i, int i1, int i2, int i3, int i4, int i5) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void drawLine(int i, int i1, int i2, int i3) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void fillRect(int i, int i1, int i2, int i3) {
            kutsut.add("fillRect(" + i + ", " + i1 + ", " + i2 + ", " + i3 + ")");
        }

        @Override
        public void clearRect(int i, int i1, int i2, int i3) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void drawRoundRect(int i, int i1, int i2, int i3, int i4, int i5) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void fillRoundRect(int i, int i1, int i2, int i3, int i4, int i5) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void drawOval(int i, int i1, int i2, int i3) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void fillOval(int i, int i1, int i2, int i3) {
            kutsut.add("fillOval(" + i + ", " + i1 + ", " + i2 + ", " + i3 + ")");
        }

        @Override
        public void drawArc(int i, int i1, int i2, int i3, int i4, int i5) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void fillArc(int i, int i1, int i2, int i3, int i4, int i5) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void drawPolyline(int[] ints, int[] ints1, int i) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void drawPolygon(int[] ints, int[] ints1, int i) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void fillPolygon(int[] ints, int[] ints1, int i) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void drawString(String string, int i, int i1) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void drawString(AttributedCharacterIterator aci, int i, int i1) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean drawImage(Image image, int i, int i1, ImageObserver io) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean drawImage(Image image, int i, int i1, int i2, int i3, ImageObserver io) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean drawImage(Image image, int i, int i1, Color color, ImageObserver io) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean drawImage(Image image, int i, int i1, int i2, int i3, Color color, ImageObserver io) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean drawImage(Image image, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, ImageObserver io) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean drawImage(Image image, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, Color color, ImageObserver io) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void dispose() {
        }

        public java.util.List<String> getKutsut() {
            return kutsut;
        }
    }

    private class MockContainer extends Container {

        private Component lisatty;

        public MockContainer() {
        }

        @Override
        public Component add(Component comp) {
            this.lisatty = comp;
            return this.lisatty;
        }

        @Override
        public void add(Component comp, Object constraints) {
            this.lisatty = comp;
        }

        @Override
        public Component add(Component comp, int index) {
            this.lisatty = comp;
            return this.lisatty;
        }

        @Override
        public Component add(String name, Component comp) {
            this.lisatty = comp;
            return this.lisatty;
        }

        @Override
        public void add(Component comp, Object constraints, int index) {
            this.lisatty = comp;
        }

        public Component getLisatty() {
            return lisatty;
        }
    }

    private class MockComponent extends Component {

        boolean repaintKutsuttu;

        @Override
        public void repaint() {
            repaintKutsuttu = true;
        }
    }

    private class MockKeyEvent extends KeyEvent {

        public MockKeyEvent(int keyCode) {
            super(new LiikkuvaKuvioTest.MockComponent(), keyCode, 1, 1, keyCode);
        }
    }

    public class JFrameMock extends JFrame{

        @Override
        public synchronized void addKeyListener(KeyListener kl) {

        }

    }
}
