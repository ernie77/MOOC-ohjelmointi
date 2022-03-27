
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

@Points("179.1 179.2 179.3 179.4 179.5 179.6 179.7 179.8")
public class TikkupeliTest {

    @Test
    public void eiTesteja() {
        assertTrue(1 + 1 == 2);
    }
}
