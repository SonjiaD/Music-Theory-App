package ui;

public class IntervalKeys {



    // EFFECTS: displays menu of note options of notes to user
    // selecting first note's accidental
    private void accidental1() {
        System.out.println("\nSelect first note's accidental from:");
        System.out.println("\tN -> Natural");
        System.out.println("\tS -> Sharp");
        System.out.println("\tF -> Flat");
        System.out.println("\tQ -> Quit to main menu");
    }

    // EFFECTS: displays menu of options of notes to user
    // enter first note letter
    private void note1() {
        System.out.println("\nSelect first note letter name from:");
        System.out.println("\tC");
        System.out.println("\tD");
        System.out.println("\tE");
        System.out.println("\tF");
        System.out.println("\tG");
        System.out.println("\tA");
        System.out.println("\tB");
    }

//    private void intervalCalculator() {
//        String accidental1 = "";
//        String note1 = "";
//
//        String accidental2 = "";
//        String note2 = "";
//
//
//        if (note1 = "C" && accidental1 = "N" && note2 = "C" && accidental2 = "N") {
//        }

    //EFFECTS: finding the key signature based on the following criteria
        //steps
        // sharps or flats, neither
        // number of sharps or flats
        // major or minor
        // give answer

    private void sharpsFlats() {
        System.out.println("\nSelect from:");
        System.out.println("\ts -> sharp");
        System.out.println("\tf -> flats");
        System.out.println("\tn -> neither");
    }

    // MODIFIES: this
    // EFFECTS: processes user command after selecting sharps or flats
//    private void sfProcessCommand(String command) {
//        if (command.equals("s")) {
//            number();
//            sharpProcessCommands();
//        } else if (command.equals("f")) {
//            number();
//            flatProcessCommands();
//        } else if (command.equals("n")) {
//            majorMinor();
//        } else {
//            System.out.println("Selection not valid...");
//        }
//    }

    private void number() {
        System.out.println("\nSelect a number from 1-7");
    }

    private void majorMinor() {
        System.out.println("\nSelect from:");
        System.out.println("\t+ -> major");
        System.out.println("\t- -> minor");
    }

//    private void sharpProcessCommands(int number) {
//        String number;
//        if (number
//    }
//
//    private void flatProcessCommands() {
//        String command;
//        if (command=="s" &&
//    }

}
