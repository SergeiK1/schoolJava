import java.util.Scanner;

public class fractionCheck { 
    public static void main(String[] args) {
        System.out.print("Input Fraction: ");
        Scanner getValue = new Scanner(System.in);
        String fraction = getValue.nextLine();
        int slash = fraction.indexOf("/", 0);
        double a = Double.parseDouble(fraction.substring(0, slash));
        double b = Double.parseDouble(fraction.substring(slash+1));
        System.out.print("Input Fraction 2: ");
        String fraction2 = getValue.nextLine();
        int slash2 = fraction2.indexOf("/", 0);
        double a2 = Double.parseDouble(fraction2.substring(0, slash2));
        double b2 = Double.parseDouble(fraction2.substring(slash2+1)); 

        getValue.close();
        if (a/b == a2/b2) {
            System.out.println("Equivalent");
        } else {
            System.out.println("Not Equivalent ");
        }
    }
}