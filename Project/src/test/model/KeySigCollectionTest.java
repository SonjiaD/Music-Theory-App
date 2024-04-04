package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeySigCollectionTest {
    private KeySigCollection keySigCollection;

    @BeforeEach
    public void setUp() {
        // Initialize a KeySigCollection object before each test
        keySigCollection = new KeySigCollection();
    }

    @Test
    public void testAddKeySignature() {
        // Test adding a key signature to the collection
        KeySignature signature = new KeySignature("C", "Major", 0);
        keySigCollection.addKeySignature(signature);
        ArrayList<KeySignature> signatures = keySigCollection.getKeySignatures();
        assertEquals(1, signatures.size());
        assertEquals(signature, signatures.get(0));
    }

    @Test
    public void testGetKeySignatures() {
        // Test getting all key signatures from the collection
        KeySignature signature1 = new KeySignature("C", "Major", 0);
        KeySignature signature2 = new KeySignature("G", "Major", 1);
        keySigCollection.addKeySignature(signature1);
        keySigCollection.addKeySignature(signature2);
        ArrayList<KeySignature> signatures = keySigCollection.getKeySignatures();
        assertEquals(2, signatures.size());
        assertEquals(signature1, signatures.get(0));
        assertEquals(signature2, signatures.get(1));
    }
}

