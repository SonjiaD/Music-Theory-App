package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KeySignatureTest {
    private KeySignature keySignature;

    @BeforeEach
    public void setUp() {
        // Initialize a KeySignature object before each test
        keySignature = new KeySignature("C", "Major", 0);
    }

    @Test
    public void testKeyGetterAndSetter() {
        // Test the getKey() and setKey() methods
        keySignature.setKey("D");
        assertEquals("D", keySignature.getKey());
    }

    @Test
    public void testTypeGetterAndSetter() {
        // Test the getType() and setType() methods
        keySignature.setType("Minor");
        assertEquals("Minor", keySignature.getType());
    }

    @Test
    public void testNumSharpsOrFlatsGetterAndSetter() {
        // Test the getNumSharpsOrFlats() and setNumSharpsOrFlats() methods
        keySignature.setNumSharpsOrFlats(2);
        assertEquals(2, keySignature.getNumSharpsOrFlats());
    }

    @Test
    public void testIsMajor() {
        KeySignature majorKey = new KeySignature("C", "Major", 0);
        assertTrue(majorKey.isMajor());

        KeySignature minorKey = new KeySignature("A", "Minor", 0);
        assertFalse(minorKey.isMajor());
    }

    @Test
    public void testIsMinor() {
        KeySignature majorKey = new KeySignature("C", "Major", 0);
        assertFalse(majorKey.isMinor());

        KeySignature minorKey = new KeySignature("A", "Minor", 0);
        assertTrue(minorKey.isMinor());
    }

    @Test
    public void testHasSharps() {
        KeySignature keyWithSharps = new KeySignature("G", "Major", 2);
        assertTrue(keyWithSharps.hasSharps());

        KeySignature keyWithoutSharps = new KeySignature("F", "Major", 0);
        assertFalse(keyWithoutSharps.hasSharps());
    }

    @Test
    public void testHasFlats() {
        KeySignature keyWithFlats = new KeySignature("F", "Major", -1);
        assertTrue(keyWithFlats.hasFlats());

        KeySignature keyWithoutFlats = new KeySignature("G", "Major", 0);
        assertFalse(keyWithoutFlats.hasFlats());
    }
}

