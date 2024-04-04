package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Requires:
// - Java Runtime Environment (JRE) installed on the system.
// - File "keysig.png" located in the same directory as the executable JAR file.
// - File "key_signature_data.txt" located in the working directory for saving key signature data.

public class KeySignatureGUI extends JFrame implements ActionListener {

    private JComboBox<String> noteComboBox;
    private JButton sharpButton;
    private JButton flatButton;
    private JButton addNoteButton;
    private JButton saveButton;
    private JButton loadButton;
    private JTextArea keySignatureTextArea;
    private JLabel imageLabel;
    private JPanel mainPanel; // Main panel to hold components

    private List<String> keySignatureNotes;
    private String selectedAccidental;

    private static final String FILE_NAME = "key_signature_data.txt";

    //EFFECTS: constructor that helps to initialize the different parts of the GUI
    // initalizes the arraylist holding the notes that have been aded to the keysignature and the GUi
    public KeySignatureGUI() {
        keySignatureNotes = new ArrayList<>();
        initializeGUI();
        addWindowListener(new SaveDataListener());
    }

    // MODIFIES: this
    // EFFECTS: Initializes the graphical user interface with buttons, text areas, and an image display.
    //          Loads the "keysig.png" image to display at the left side of the GUI.
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void initializeGUI() {
        setTitle("Key Signature Editor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel();
        sharpButton = new JButton("Sharp");
        sharpButton.addActionListener(this);
        flatButton = new JButton("Flat");
        flatButton.addActionListener(this);
        inputPanel.add(sharpButton);
        inputPanel.add(flatButton);

        JPanel notePanel = new JPanel();
        noteComboBox = new JComboBox<>(new String[]{"C", "D", "E", "F", "G", "A", "B"});
        notePanel.add(noteComboBox);

        addNoteButton = new JButton("Add Note");
        addNoteButton.addActionListener(this);
        notePanel.add(addNoteButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        notePanel.add(saveButton);
        notePanel.add(loadButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        JPanel outputPanel = new JPanel(new BorderLayout());
        keySignatureTextArea = new JTextArea();
        keySignatureTextArea.setEditable(false);
        outputPanel.add(new JLabel("Key Signature:"), BorderLayout.NORTH);
        outputPanel.add(new JScrollPane(keySignatureTextArea), BorderLayout.CENTER);

        mainPanel.add(notePanel, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Initialize image label
        imageLabel = new JLabel();
        mainPanel.add(imageLabel, BorderLayout.WEST); // Position the image label on the left side

        // Create and add the "Show Image" button
        JButton showImageButton = new JButton("Show Image");
        showImageButton.addActionListener(this);
        inputPanel.add(showImageButton); // Add the button to the input panel
    }

    // EFFECTS: Enables the key signature editor components after a delay.
    private void enableKeySignatureEditor() {
        sharpButton.setEnabled(true);
        flatButton.setEnabled(true);
        addNoteButton.setEnabled(true);
        saveButton.setEnabled(true);
        loadButton.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sharpButton || e.getSource() == flatButton) {
            selectedAccidental = (e.getSource() == sharpButton) ? "#" : "b";
            sharpButton.setEnabled(false);
            flatButton.setEnabled(false);
        } else if (e.getSource() == addNoteButton) {
            addNoteToKeySignature();
        } else if (e.getSource() == saveButton) {
            saveKeySignatureData();
        } else if (e.getSource() == loadButton) {
            loadKeySignatureData();
        } else if (e.getActionCommand().equals("Show Image")) {
            showImage();
        }
    }

    // MODIFIES: this
    // EFFECTS: Adds a note to the key signature notes list.
    private void addNoteToKeySignature() {
        String noteName = (String) noteComboBox.getSelectedItem();
        String note = noteName + selectedAccidental;
        keySignatureNotes.add(note);
        updateKeySignatureTextArea();
    }

    // MODIFIES: this
    // EFFECTS: Updates the key signature text area with the current notes.
    private void updateKeySignatureTextArea() {
        StringBuilder sb = new StringBuilder();
        for (String note : keySignatureNotes) {
            sb.append(note).append(" ");
        }
        keySignatureTextArea.setText(sb.toString());
    }

    // MODIFIES: saveKeySignatureData();
    //EFFECTS: helps to save the data of the what has been added to the key signature
    private class SaveDataListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            saveKeySignatureData();
        }
    }

    // MODIFIES: key_signature_data.txt
    // EFFECTS: Saves the key signature data to a file.
    private void saveKeySignatureData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String note : keySignatureNotes) {
                writer.write(note);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // MODIFIES: this
    // EFFECTS: Loads the key signature data from a file.
    private void loadKeySignatureData() {
        keySignatureNotes.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                keySignatureNotes.add(line);
            }
            updateKeySignatureTextArea();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: Shows the "keysig.png" image on the left side of the GUI.
    private void showImage() {
        try {
            Image image = ImageIO.read(new File("keysig.png"));
            ImageIcon icon = new ImageIcon(image);
            imageLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //EFFECTS: main method which allows the whole application's ui to start running
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeySignatureGUI gui = new KeySignatureGUI();
            gui.setVisible(true);
        });
    }
}