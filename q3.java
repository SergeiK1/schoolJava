import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        System.out.println("Please enter three-digit number: ");
        Scanner getNumber = new Scanner(System.in);
        String number;
    
        number = getNumber.nextLine();
        getNumber.close();

        System.out.println("Hundreds: " + number.charAt(0));
        System.out.println("Tens: " + number.charAt(1));
        System.out.println("Ones: " + number.charAt(2));

    }
}