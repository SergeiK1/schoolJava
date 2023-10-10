import java.util.Scanner;

public class statMachine2 {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("Starting Color  \n  [o]range \n  [p]urple \n  [g]reen \n  [b]lue \n  [y]ellow \n  [r]ed \n\n   --> ");
        char currentState = getValue.nextLine().charAt(0);
        System.out.print("Instructions: ");
        String instructions = getValue.nextLine().toUpperCase();
        getValue.close();

        String states = "RyopgOpybrYxbxxGbxrxBxrxyPxbgr"; // red orange yellow green blue purple 
        String letters = "ABCD";


        for (int i =0; i < instructions.length(); i++){
            char instructionState = instructions.charAt(i);
            int section = states.indexOf(currentState);
            int endSection = (letters.indexOf(instructionState)+1);
            currentState = (char) ((int) states.charAt(section+endSection)-32); // uppercase conversion 
            System.out.println("Current: "+currentState);
            if (currentState=='X'){
                System.out.println("Non Existent");
                break;
            }
        }
        System.out.println("Final State: "+currentState);



    }
}