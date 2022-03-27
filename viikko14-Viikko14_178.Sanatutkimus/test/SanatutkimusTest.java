
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

@Points("178.1 178.2 178.3 178.4 178.5 178.6 178.7 178.8 178.9")
public class SanatutkimusTest {

    @Test
    public void eiTesteja() {
        assertTrue(1 + 1 == 2);
    }
}
