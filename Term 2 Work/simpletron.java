import java.util.Scanner;

public class simpletron {


    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        int[] TAPE = new int[100];
        System.out.println("INPUT INSTRUCTIONS: ");
        for (int i = 0; i < TAPE.length; i++) {
            int instruction = getValue.nextInt();
            if (instruction == -99999) {
                break; 
            }
            TAPE[i] = instruction;
        }


        //Reading head
        int accumulator, counter, operationCode, operand, instructionRegister;

        counter = 0; 

        while (true) {
            instructionRegister = TAPE[counter];

            operand = instructionRegister % 100;
            operationCode = instructionRegister / 100;

            if (operand == 10) {
                //read 
            } else if (operand == 11) {
                //write
            } else if (operand == 11) {
                //write
            } else if (operand == 20) {
                //load
            } else if (operand == 21) {
                //store
            } else if (operand == 30) {
                //add
            } else if (operand == 31) {
                //subtract
            } else if (operand == 32) {
                //multiply
            } else if (operand == 33) {
                //divide
            } else if (operand == 40) {
                //branch
            } else if (operand == 41) {
                //branchneg
            } else if (operand == 42) {
                //branch zero
            } else if (operand == 43) {
                //HALT
            }

            break;
        }
        



        // testing
        for (int i = 0; i < TAPE.length; i++) {
            System.out.println("OUTPUT INSTRUCTIONS _______");
            System.out.println(TAPE[i]);
        }
    }
}
