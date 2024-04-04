package persistence;

import model.KeySigCollection;
import model.KeySignature;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {
    private JsonWriter writer;
    private KeySigCollection collection;

    @BeforeEach
    void runBefore() {
        writer = new JsonWriter("./data/testKeySignatures.json");
        collection = new KeySigCollection();
        collection.addKeySignature(new KeySignature("C", "sharp", 0));
        collection.addKeySignature(new KeySignature("G", "sharp", 1));
        collection.addKeySignature(new KeySignature("D", "sharp", 2));
    }

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my/illegal:fileName.json");
            writer.open();
            fail("FileNotFoundException was expected");
        } catch (FileNotFoundException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyKeySigCollection() {
        try {
            writer.open();
            writer.write(new KeySigCollection());
            writer.close();

            JsonReader reader = new JsonReader("./data/testKeySignatures.json");
            KeySigCollection readCollection = reader.read();
            //assertEquals(0, readCollection.getSize());
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralKeySigCollection() {
        try {
            writer.open();
            writer.write(collection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testKeySignatures.json");
            KeySigCollection readCollection = reader.read();
            List<KeySignature> keySignatures = readCollection.getKeySignatures();
            assertEquals(3, keySignatures.size());
            checkKeySignature("C", "sharp", 0, keySignatures.get(0));
            checkKeySignature("G", "sharp", 1, keySignatures.get(1));
            checkKeySignature("D", "sharp", 2, keySignatures.get(2));
        } catch (Exception e) {
            fail("Exception should not have been thrown");
        }
    }
}