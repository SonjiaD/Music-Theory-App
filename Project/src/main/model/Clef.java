package model;

// Represents a clef in music notation
public class Clef {

//    Clef trebleClef = new Clef(ClefType.TREBLE);
//    Clef bassClef = new Clef(ClefType.BASS);
//    Clef tenorClef = new Clef(ClefType.TENOR);
//    Clef altoClef = new Clef(ClefType.ALTO);

    private ClefType type;
    // Type of clef (e.g., Treble, Bass, etc.)

    // Constructor
    public Clef(ClefType type) {

        this.type = type;
    }

    // Getter method
    // getting type of clef from the ClefType class
    public ClefType getType() {

        return type;
    }

}
