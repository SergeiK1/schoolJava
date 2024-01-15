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
        accumulator = 0000;

        counter = 0; 

        while (true) {
            instructionRegister = TAPE[counter];

            operand = instructionRegister % 100;
            operationCode = instructionRegister / 100;

            if (operationCode == 10) {
                //read 
                TAPE[operand] = getValue.nextInt();
                
            } else if (operationCode == 11) {
                //write
                System.out.println("[OUT]  "+TAPE[operand]);
            } else if (operationCode == 20) {
                //load
                accumulator = TAPE[operand];
            } else if (operationCode == 21) {
                //store
                TAPE[operand] = accumulator;
            } else if (operationCode == 30) {
                //add
                accumulator += TAPE[operand];
            } else if (operationCode == 31) {
                //subtract
                accumulator -= TAPE[operand];
            } else if (operationCode == 32) {
                //multiply
                accumulator *= TAPE[operand];
            } else if (operationCode == 33) {
                //divide
                accumulator /= TAPE[operand];
            } else if (operationCode == 40) {
                //branch
                counter = operand;
                continue;

            } else if (operationCode == 41) {
                //branchneg
                if (accumulator < 0) {
                    counter = operand;
                }
                continue;
            } else if (operationCode == 42) {
                //branch zero
                if (accumulator == 0) {
                    counter = operand;
                }
                continue;
            } else if (operationCode == 43) {
                //HALT
                System.out.println("[   BREAK   ]");
                break;
            }
        }
        



        // testing
        for (int i = 0; i < TAPE.length; i++) {
            System.out.println("OUTPUT INSTRUCTIONS _______");
            System.out.println(TAPE[i]);
        }
    }
}
