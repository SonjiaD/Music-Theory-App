package persistence;

import model.KeySigCollection;
import model.KeySignature;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // EFFECTS: Opens the PrintWriter for writing to the file.
    //          Throws FileNotFoundException if the file cannot be found.
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // EFFECTS: Writes the provided KeySigCollection to the JSON file.
    public void write(KeySigCollection collection) {
        JSONObject json = collectionToJson(collection);
        saveToFile(json.toString(TAB));
    }

    // EFFECTS: Converts a KeySigCollection to a JSONObject.
    private JSONObject collectionToJson(KeySigCollection collection) {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (KeySignature signature : collection.getKeySignatures()) {
            jsonArray.put(signatureToJson(signature));
        }
        json.put("keySignatures", jsonArray);
        return json;
    }

    // EFFECTS: Converts a KeySignature to a JSONObject.
    private JSONObject signatureToJson(KeySignature signature) {
        JSONObject json = new JSONObject();
        json.put("key", signature.getKey());
        json.put("type", signature.getType());
        json.put("numSharpsOrFlats", signature.getNumSharpsOrFlats());
        return json;
    }

    // EFFECTS: Closes the PrintWriter.
    public void close() {
        writer.close();
    }

    // EFFECTS: Saves the JSON string to the file.
    private void saveToFile(String json) {
        writer.print(json);
    }
}
