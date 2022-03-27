import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import junit.framework.Assert;
import org.junit.Test;

public class SanatulostinTest {

    String klass = "Sanatulostin";

    @Test
    public void luokkaSanatulostin() {
        Assert.assertTrue("Toteuta luokka " + klass + ". Varmista että se on muotoa public " + klass + " {..", Reflex.reflect(klass).isPublic());
    }

    @Test
    public void luokallaParametrillinenKonstruktori() {
        Reflex.reflect(klass).constructor().taking(String.class).requireExists();
    }

    @Points("105.1")
    @Test
    public void metodiSanaporras() {
        Reflex.reflect(klass).method("sanaporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points("105.2")
    @Test
    public void laskevaSanaporras() {
        Reflex.reflect(klass).method("laskevaSanaporras").returningVoid().taking(int.class).requirePublic();
    }

    @Points("105.3")
    @Test
    public void sanapyramidi() {
        Reflex.reflect(klass).method("sanapyramidi").returningVoid().taking(int.class).requirePublic();
    }
}
