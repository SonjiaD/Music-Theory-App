package ui;

import model.KeySigCollection;
import model.KeySignature;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class KeySignatureFinder {

    private int num;
    private String type;
    private KeySigCollection signatureCollection;
    private String key;
    private static final String JSON_STORE = "./data/keysignatures.json"; // Path to JSON file
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public KeySignatureFinder() {
        this.signatureCollection = new KeySigCollection();
        this.key = new String();
        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: finding the key signature based on the provided criteria
    public void findKeySignature() {
        System.out.println("Welcome to the key signature finder!");
        sharpsFlats();
    }

    // EFFECTS: prompts the user to select either sharps or flats
    private void sharpsFlats() {
        System.out.println("\nFirst select from:");
        System.out.println("\ts -> sharps");
        System.out.println("\tf -> flats");
        System.out.println("\tn -> neither");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().trim();
        sfProcessCommand(command);
    }

    // EFFECTS: processes user command after selecting sharps or flats
    private void sfProcessCommand(String command) {
        if (command.equals("s") || command.equals("f")) {
            type = command.equals("s") ? "sharp" : "flat";
            number(type);
        } else if (command.equals("n")) {
            majorMinorDif();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: prompts the user to select a number from 1-7
    private void number(String type) {
        System.out.println("\nSelect a number from 1-7 for the number of " + type + ":");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        majorMinor();
    }

    private void majorMinorDif() {
        System.out.println("\nSelect from:");
        System.out.println("\t+ -> major");
        System.out.println("\t- -> minor");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().trim();

        if (command.equals("+")) {
            System.out.println("The key signature is C+.");
        } else if (command.equals("-")) {
            System.out.println("The key signature is A minor.");
        } else {
            System.out.println("Selection not valid...");
        }
        promptNextAction();
    }

    // EFFECTS: prompts the user to select major or minor
    private void majorMinor() {
        System.out.println("\nSelect from:");
        System.out.println("\t+ -> major");
        System.out.println("\t- -> minor");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine().trim();
        processKeySignature(command, type);
    }

    // EFFECTS: processes the selected key signature and displays the result
    private void processKeySignature(String command, String type) {
        if (command.equals("+")) {
            if (type.equals("sharp")) {
                majorSharpKeySig(num);
            } else if (type.equals("flat")) {
                majorFlatKeySig(num);
            }
        } else if (command.equals("-")) {
            if (type.equals("sharp")) {
                minorSharpKeySig(num);
            } else if (type.equals("flat")) {
                minorFlatKeySig(num);
            }
        } else {
            System.out.println("Selection not valid...");

        }
        // After determining the key signature, add it to the collection
        promptToAddToCollection();
    }

    private void promptToAddToCollection() {
        System.out.println("Would you like to add this key signature to your collection?");
        System.out.println("\ty -> Yes");
        System.out.println("\tn -> No");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().trim();

        if (response.equals("y")) {
            addKeySignatureToCollection();
        } else if (response.equals("n")) {
            System.out.println("Key signature not added to collection.");
            promptNextAction();
        } else {
            System.out.println("Invalid response...");
        }
    }





    // EFFECTS: prints the key signature for major sharp keys
    private void majorSharpKeySig(int num) {
        String[] keySignatures = {"G", "D", "A", "E", "B", "F#", "C#"};

        if (num >= 1 && num <= keySignatures.length) {
            String keySignature = keySignatures[num - 1];
            System.out.println("The key signature is " + keySignature + " major");
        } else {
            System.out.println("Invalid number selected.");
        }
    }

    // EFFECTS: prints the key signature for minor sharp keys
    private void minorSharpKeySig(int num) {
        ArrayList<String> keySignatures = new ArrayList<>();
        keySignatures.add("e");
        keySignatures.add("b");
        keySignatures.add("f#");
        keySignatures.add("c#");
        keySignatures.add("g#");
        keySignatures.add("d#");
        keySignatures.add("a#");

        if (num >= 1 && num <= keySignatures.size()) {
            String keySignature = keySignatures.get(num - 1);
            System.out.println("The key signature is " + keySignature + " minor");
        } else {
            System.out.println("Invalid number selected.");
        }
    }

    // EFFECTS: prints the key signature for major flat keys
    private void majorFlatKeySig(int num) {
        String[] keySignatures = {"F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb"};

        if (num >= 1 && num <= keySignatures.length) {
            String keySignature = keySignatures[num - 1];
            System.out.println("The key signature is " + keySignature + " major");
        } else {
            System.out.println("Invalid number selected.");
        }
        // could add a condition where if there is
        // b in the string, then add the extra line of saying b = flat
    }

    // EFFECTS: prints the key signature for minor flat keys
    private void minorFlatKeySig(int num) {
        String[] keySignatures = {"d", "g", "c", "f", "b flat", "e flat", "a flat"};

        if (num >= 1 && num <= keySignatures.length) {
            String keySignature = keySignatures[num - 1];
            System.out.println("The key signature is " + keySignature + " minor");
        } else {
            System.out.println("Invalid number selected.");
        }
    }


    // major minor for the C+ and a-
    // issue with selecting the major flat vs major sharp
    // or minor flat vs minor sharp
    // need the input from before


    //EFFECTS
    // adds key signature to collection
    private void addKeySignatureToCollection() {
        KeySignature signature = new KeySignature(key, type, num);
        signatureCollection.addKeySignature(signature);
        System.out.println("Key signature added to collection.");
        promptNextAction();
    }

    //EFFECTS
    // helper method that helps to prompt the next action
    // that the user can select to take
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void promptNextAction() {
        System.out.println("What would you like to do next?");
        System.out.println("\tf -> Find another key signature");
        System.out.println("\ta -> Access key signature collection");
        System.out.println("\ts -> Save key signature collection");
        System.out.println("\tl -> Load key signature collection");
        System.out.println("\tq -> Quit");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().trim();

        switch (response) {
            case "f":
                findKeySignature();
                break;
            case "a":
                accessKeySignatureCollection();
                break;
            case "s":
                saveKeySignatures();
                break;
            case "l":
                loadKeySignatures();
                break;
            case "q":
                System.out.println("Quitting...");
                break;
            default:
                System.out.println("Invalid response...");
                break;
        }
    }

    // EFFECTS
    //user chooses to access the key signature collection, so they can see what are the key signatures
    // they have searched up so far
    private void accessKeySignatureCollection() {
        ArrayList<KeySignature> keySignatures = signatureCollection.getKeySignatures();

        if (keySignatures.isEmpty()) {
            System.out.println("The key signature collection is empty.");
        } else {
            System.out.println("Key Signatures in Collection:");
            for (KeySignature signature : keySignatures) {
                String key = signature.getKey();
                String type = signature.getType();
                int numSharpsOrFlats = signature.getNumSharpsOrFlats();
//                String accidentals = numSharpsOrFlats == 0 ? "no accidentals" :
//                        (numSharpsOrFlats > 0 ? numSharpsOrFlats + " sharps" : -numSharpsOrFlats + " flats");
                String accidentals = numSharpsOrFlats == 0 ? "no accidentals" :
                        (numSharpsOrFlats > 0 ? numSharpsOrFlats + " " : -numSharpsOrFlats + " ");
                System.out.println("\tKey info: " + "Accidental Type: " + type + ", # of Accidentals: " + accidentals);

            }
        }
// key not printing properly, just recording it's info
// System.out.println("\tKey: " + key + ", Accidental Type: " + type + ", Number of Accidentals: " + accidentals)
        System.out.println("Press 'b' to go back to the main menu.");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine().trim();

        if (response.equals("b")) {
            findKeySignature();
        } else {
            System.out.println("Invalid response. Going back to the main menu.");
            findKeySignature();
        }
    }

    // EFFECTS: saves the key signatures to file
    private void saveKeySignatures() {
        try {
            jsonWriter.open();
            jsonWriter.write(signatureCollection);
            jsonWriter.close();
            System.out.println("Saved key signatures to " + JSON_STORE);
            promptNextAction();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: loads the key signatures from file
    private void loadKeySignatures() {
        try {
            signatureCollection = jsonReader.read();
            System.out.println("Loaded key signatures from " + JSON_STORE);
            promptNextAction();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    public static void main(String[] args) {
        KeySignatureFinder keySignatureFinder = new KeySignatureFinder();
        keySignatureFinder.findKeySignature();
    }



}
