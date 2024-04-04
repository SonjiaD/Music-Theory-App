package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.ClefType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClefTest {

    private Clef trebleClef;
    private Clef bassClef;
    private Clef tenorClef;
    private Clef altoClef;

    @BeforeEach
    public void setUp() {
        trebleClef = new Clef(TREBLE);
        bassClef = new Clef(BASS);
        tenorClef = new Clef(TENOR);
        altoClef = new Clef(ALTO);
    }

    @Test
    public void testClefType() {
        assertEquals(TREBLE, trebleClef.getType());
        assertEquals(BASS, bassClef.getType());
        assertEquals(TENOR, tenorClef.getType());
        assertEquals(ALTO, altoClef.getType());
    }

    @Test
    public void testGetType() {
        assertEquals(TREBLE, trebleClef.getType());
        assertEquals(BASS, bassClef.getType());
        assertEquals(TENOR, tenorClef.getType());
        assertEquals(ALTO, altoClef.getType());
    }

    @Test
    public void testGetTypeBASS() {
        // Create a new Clef object with a different ClefType
        Clef newClef = new Clef(ClefType.BASS);

        // Assert that the getType() method returns the correct ClefType
        assertEquals(BASS, newClef.getType());
    }




}
