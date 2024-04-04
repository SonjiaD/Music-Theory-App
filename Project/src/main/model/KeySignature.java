package model;

public class KeySignature {
    private String key;
    private String type; // Major or Minor
    private int numSharpsOrFlats;

    // Constructor
    public KeySignature(String key, String type, int numSharpsOrFlats) {
        this.key = key;
        this.type = type;
        this.numSharpsOrFlats = numSharpsOrFlats;
    }

    // Getters and setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumSharpsOrFlats() {
        return numSharpsOrFlats;
    }

    public void setNumSharpsOrFlats(int numSharpsOrFlats) {
        this.numSharpsOrFlats = numSharpsOrFlats;
    }

    // Method to check if the key signature is a major key
    public boolean isMajor() {
        return type.equals("Major");
    }

    // Method to check if the key signature is a minor key
    public boolean isMinor() {
        return type.equals("Minor");
    }

    // Method to check if the key signature has sharps
    public boolean hasSharps() {
        return numSharpsOrFlats > 0;
    }

    // Method to check if the key signature has flats
    public boolean hasFlats() {
        return numSharpsOrFlats < 0;
    }

}