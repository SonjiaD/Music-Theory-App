package model;

import java.util.ArrayList;

public class KeySigCollection {
    private ArrayList<KeySignature> signatures;

    // Constructor
    public KeySigCollection() {
        this.signatures = new ArrayList<>();
    }

    // Add a key signature to the collection
    public void addKeySignature(KeySignature signature) {
        signatures.add(signature);
    }

    // Get all key signatures in the collection
    public ArrayList<KeySignature> getKeySignatures() {
        return signatures;
    }
}
