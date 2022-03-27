
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

@Points("176.1 176.2 176.3")
public class TietokantaTest {

    @Test
    public void eiTesteja() {
        assertTrue(1 + 1 == 2);
    }
}
