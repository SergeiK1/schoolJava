import java.util.Scanner;

public class loops1 {
    public static void main(String[] args) { 

        System.out.println(" ");
        System.out.println("[ --  Hailstone Numbers -- ]");
        // System.out.print("Enter Number: ");
        // Scanner getValue = new Scanner(System.in);
        // int number = getValue.nextInt();
        // getValue.close();

        int theNumber = 1;
        double highValue = 0; 
        for (int i=1; i<=300; i++){
            int number = i;
            System.out.print(number);
            int counter = 1;
            while (number != 4) { 
                if (number%2 == 0){
                    number /= 2;
                }
                else {
                    number = number*3 + 1;
                }
                counter++;
                System.out.print(", " + number);
            }
            if (highValue < counter){
                highValue = counter;
                theNumber = i;
            }
            System.out.println("i: " + i);
            System.out.println("highValue: " + highValue);
            System.out.println("\n\n ");
        }

        System.out.println("\n\n[ The NUMBER ]: " + theNumber + "\n\n\n");
    }
} 

