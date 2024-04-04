package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteTest {

    private String name;
    // Name of the note (e.g., "C", "D#", etc.)
    private Note c;

    @BeforeEach
    void testBefore() {
        c = new Note("C");
    }

    @Test
    // Constructor
    public void testNote() {
        name = "C";
        assertEquals("C", name);
    }

    @Test
    // Getter method
    // get the name of note based on the clef
    public void testGetName() {

        assertEquals("C", c.getName());
    }

}
