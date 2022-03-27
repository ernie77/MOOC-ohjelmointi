import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;

public class OstoslistaTest {
    
    String klass = "Ostoslista";
    
    @Test
    public void luokkaSanatulostin() {
        junit.framework.Assert.assertTrue("Toteuta luokka " + klass + ". Varmista että se on muotoa public " + klass + " {..", Reflex.reflect(klass).isPublic());
    }
    
    @Test
    public void luokallaParametritonKonstruktori() {
        Reflex.reflect(klass).constructor().takingNoParams().requireExists();
    }
    
    @Points("106.1")
    @Test
    public void metodiLisaa() {
        Reflex.reflect(klass).method("lisaa").returningVoid().taking(String.class).requirePublic();
    }
    
    @Points("106.1")
    @Test
    public void metodiOnkolistalla() {
        Reflex.reflect(klass).method("onkoListalla").returning(boolean.class).taking(String.class).requirePublic();
    }
    
    @Points("106.2")
    @Test
    public void metodiKappalemaara() {
        Reflex.reflect(klass).method("kappalemaara").returning(int.class).taking(String.class).requirePublic();
    }
    
    @Points("106.3")
    @Test
    public void metodiPoista() {
        Reflex.reflect(klass).method("poista").returningVoid().taking(String.class).requirePublic();
    }
    
    @Points("106.4")
    @Test
    public void metodiToString() throws Throwable {
        Reflex.reflect(klass).method("toString").returning(String.class).takingNoParams().requirePublic();
        
        Object lista = Reflex.reflect(klass).ctor().takingNoParams().invoke();
        String tulostus = lista.toString();
        assertTrue("Tarkasta toString-metodin palauttaman merkkijonon muoto.", tulostus.contains("uot"));
    }
}
