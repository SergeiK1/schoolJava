
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class q2 {
    public static void main(String[] args) {
        Scanner getChange = new Scanner(System.in);
        System.out.print("Please enter change amount: ");
        int change = getChange.nextInt();

        while (change > 500){
            System.out.println("Please re-enter a new amount under 500");
            System.out.print("Please enter new change amount: ");
            change = getChange.nextInt();
        }

        getChange.close();

        int quarters, dimes, nickles, pennies, remainder;

        quarters = change/25;
        remainder = change%25;

        dimes = remainder/10;
        remainder %= 10;

        nickles = remainder/5;
        remainder %= 5;

        pennies = remainder;


        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickles: " + nickles);
        System.out.println("Pennies: " + pennies);

    }
}