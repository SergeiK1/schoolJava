import java.util.Scanner;

public class rounding {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);

        System.out.print("[ Enter Number ]:   ");
        double number = getValue.nextDouble();
        if (number%1 >= 0.5) {
            System.out.printf("Rounding UP: %.0f%n", number );
            System.out.println(number%1);
            
        } else {
            System.out.printf("Roundin Down: %.0f%n", number);
            System.out.println(number%1);
        }

    }
}