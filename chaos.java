import java.util.Scanner;

public class chaos{
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("[ Input Decimal ]:   ");
        double valueTrue = getValue.nextDouble();
        getValue.close();
        for (double coeficient = 1; coeficient < 5; coeficient+=0.25){
            System.out.println("Coeficient: "+coeficient+"\n");
            double value=valueTrue;
            for(int i =0; i<50; i++){
                System.out.print(value+"   ");
                value = coeficient*value*(1-value);
            }
            System.out.println("\n\n");
        }
   }
}