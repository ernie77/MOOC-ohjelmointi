import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import junit.framework.Assert;
import org.junit.Test;

public class LukutulostinTest {

    String klass = "Lukutulostin";

    @Test
    public void luokkaLukutulostin() {
        Assert.assertTrue("Toteuta luokka Lukutulostin. Varmista että se on muotoa public " + klass + " {..", Reflex.reflect(klass).isPublic());
    }
    
    @Test
    public void luokallaOnParametritonKonstruktori() {
        Reflex.reflect(klass).constructor().takingNoParams().requirePublic();
    }

    @Points("104.1")
    @Test
    public void metodiLukuporras() {
        Reflex.reflect(klass).method("lukuporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points("104.2")
    @Test
    public void metodiRajattuLukuporras() {
        Reflex.reflect(klass).method("rajattuLukuporras").returningVoid().taking(int.class, int.class).requirePublic();
    }

    @Points("104.3")
    @Test
    public void metodiJatkuvaLukuporras() {
        Reflex.reflect(klass).method("jatkuvaLukuporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points("104.4")
    @Test
    public void metodiKertokolmio() {
        Reflex.reflect(klass).method("kertokolmio").returningVoid().taking(int.class).requirePublic();
    }

}
