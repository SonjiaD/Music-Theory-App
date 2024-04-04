package persistence;


import model.KeySignature;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    // Checks if the given key signature matches the expected values
    protected void checkKeySignature(String expectedKey, String expectedType, int expectedNum, KeySignature keySignature) {
        assertEquals(expectedKey, keySignature.getKey());
        assertEquals(expectedType, keySignature.getType());
        assertEquals(expectedNum, keySignature.getNumSharpsOrFlats());
    }
}
