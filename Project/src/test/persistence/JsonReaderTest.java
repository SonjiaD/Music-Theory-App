package persistence;
import model.KeySigCollection;
import model.KeySignature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            KeySigCollection collection = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyKeySigCollection() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyKeySigCollection.json");
        try {
            KeySigCollection collection = reader.read();
            assertEquals(0, collection.getKeySignatures().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralKeySigCollection() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralKeySigCollection.json");
        try {
            KeySigCollection collection = reader.read();
            assertEquals(3, collection.getKeySignatures().size());
            checkKeySignature("C", "sharp", 0, collection.getKeySignatures().get(0));
            checkKeySignature("F", "flat", 1, collection.getKeySignatures().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
