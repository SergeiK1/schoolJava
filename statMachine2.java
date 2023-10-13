import java.util.Scanner;

public class statMachine2 {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("Starting Color  \n  [o]range \n  [p]urple \n  [g]reen \n  [b]lue \n  [y]ellow \n  [r]ed \n\n   --> ");
        char currentState = getValue.nextLine().toUpperCase().charAt(0);
        System.out.print("Instructions: ");
        String instructions = getValue.nextLine().toUpperCase();
        getValue.close();

        String state = "RyopgOpybrYxbxxGbxrxBxrxyPxbgr"; // Heart of the state machine:  red orange yellow green blue purple 
        String letters = "ABCD"; // for inter-section value (for endSection)


        for (int i =0; i < instructions.length(); i++){

            char instructionState = instructions.charAt(i); // current instruction char
            int section = state.indexOf(currentState); // section color index (red orange yellow...)
            int endSection = (letters.indexOf(instructionState)+1); // for intersection value (a value b value c value within the main state string)
            currentState = (char) ((int) state.charAt(section+endSection)-32); // fancy ascii uppercase conversion for character 
            if (currentState=='X'){ // if error or doesnt exist as a state
                System.out.println("-- Non Existent --");
                break;
            }
        }
        System.out.println("Final State: "+currentState);



    }
}