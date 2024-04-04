package persistence;

import model.KeySigCollection;
import model.KeySignature;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    private String source;


    // REQUIRES: source must be a valid path to a JSON file
    // EFFECTS: constructs a JsonReader with the given source file path
    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads JSON data from the source file and returns a KeySigCollection
    //          representing the key signatures stored in the JSON data
    //          throws IOException if an error occurs while reading the file
    public KeySigCollection read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseKeySigCollection(jsonObject);
    }

    // EFFECTS: reads the content of the file specified by source and returns it as a String
    //          throws IOException if an error occurs while reading the file
    private String readFile(String source) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(source));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    // EFFECTS: parses the given JSONObject and returns a KeySigCollection representing
    //          the key signatures contained within the JSONObject
    private KeySigCollection parseKeySigCollection(JSONObject jsonObject) {
        KeySigCollection collection = new KeySigCollection();
        JSONArray jsonArray = jsonObject.getJSONArray("keySignatures");
        for (Object json : jsonArray) {
            JSONObject nextKeySig = (JSONObject) json;
            addKeySignature(collection, nextKeySig);
        }
        return collection;
    }

    // EFFECTS
    // Parses key, type, and numSharpsOrFlats from the JSONObject.
    //Creates a new KeySignature instance with the parsed information.
    //Adds the new KeySignature to the provided KeySigCollection.
    private void addKeySignature(KeySigCollection collection, JSONObject jsonObject) {
        String key = jsonObject.getString("key");
        String type = jsonObject.getString("type");
        int numSharpsOrFlats = jsonObject.getInt("numSharpsOrFlats");
        KeySignature signature = new KeySignature(key, type, numSharpsOrFlats);
        collection.addKeySignature(signature);
    }


}
