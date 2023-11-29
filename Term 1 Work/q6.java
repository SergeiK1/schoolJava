import java.util.Scanner;

public class q6 {
    public static void main(String[] args) {
        
        Scanner getValue = new Scanner(System.in);

        System.out.print("[Bubber Burgers] :      ");
        int burgers = getValue.nextInt();
        System.out.print("[Blench Blies] :        ");
        int blies = getValue.nextInt();
        System.out.print("[Boba Colas] :          ");
        int colas = getValue.nextInt();
        System.out.print("[Blite Sodas] :         ");
        int sodas = getValue.nextInt();


        double totalPreTax = (burgers*1.69) + (blies*1.09) + (colas*0.99) + (sodas*0.99);

        System.out.printf("Total (pre-tax):        $%.2f%n", totalPreTax);

        double tax = totalPreTax*0.06625;
        totalPreTax*= 1.06625;

        System.out.printf("Tax:                    $%.2f%n", tax);
        System.out.printf("Final Cost:             $%.2f%n",totalPreTax);

        System.out.print("Amount Tendered:  ");
        double tendered = getValue.nextInt();

        System.out.printf("Change:                 $%.2f%n",(tendered-totalPreTax));
 

        getValue.close();











    }
}
        