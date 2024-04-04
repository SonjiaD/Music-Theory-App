package model;

public class Note {
    // Represents a note on the staff or piano keyboard
    private String name;
    // Name of the note (e.g., "C", "D#", etc.)

    // Constructor
    public Note(String name) {
        this.name = name;
    }

    // Getter method.
    // get the name of note based on the clef
    public String getName() {
        return name;
    }

}
