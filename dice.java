import java.util.Scanner;

public class dice {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("\n\nNumber of Simulations: ");
        int number = getValue.nextInt();
        System.out.print("\nNumber of Rolls: ");
        int rolls = getValue.nextInt();
        System.out.print("\nNumber if Sides: ");
        int sides = getValue.nextInt();
        getValue.close();
        int counter = 0;
        System.out.println((" "));
        for (int j=1; j<=rolls; j++){
            System.out.print("[ Die "+j+" ] ");
        }  
        System.out.print("        Total       Average\n\n");
        while (number > counter) {
 
            int totalDice=0;
            for (int k =0; k<rolls; k++){
                int dice = (int)(Math.random() * sides + 1); 
                totalDice += dice;
                System.out.print(dice+"           ");
            }
            double averageLine = (double)totalDice/(double)rolls;
            System.out.print("    "+totalDice);
            System.out.print("          "+averageLine+"\n");
            counter++;
        }
    }
}