import java.util.Scanner;

public class quadratic {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.println("ax^2 + bx + c = 0");
        System.out.print("Enter Value for a: ");
        double a = getValue.nextDouble();
        System.out.print("Enter Value for b: ");
        double b = getValue.nextDouble();
        System.out.print("Enter Value for c: ");
        double c = getValue.nextDouble();

        getValue.close();

        double root1 = (-1*b + (Math.sqrt(Math.pow(b, 2)-(4*a*c))))/(2*a);
        double root2 = (-1*b - (Math.sqrt(Math.pow(b, 2)-(4*a*c))))/(2*a);

        System.out.println("The roots are x = " + root1 + " and x = " + root2);
    }
}