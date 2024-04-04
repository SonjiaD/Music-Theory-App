package model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClefTypeTest {

    @Test
    public void testTrebleClef() {
        assertEquals("TREBLE", ClefType.TREBLE.toString());
    }

    @Test
    public void testBassClef() {
        assertEquals("BASS", ClefType.BASS.toString());
    }

    @Test
    public void testAltoClef() {
        assertEquals("ALTO", ClefType.ALTO.toString());
    }

    @Test
    public void testTenorClef() {
        assertEquals("TENOR", ClefType.TENOR.toString());
    }
}
