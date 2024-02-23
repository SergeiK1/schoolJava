import java.util.Scanner;

public class Overall {
    
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        int numberOfCars;
        double cash;
        String name;
        Dealership dealership;

        System.out.print("Welcome!!\nWould you like to create your own dealership??\n\t[Y/N]: ");
        String answer = getValue.nextLine().toLowerCase();

        if (answer.equals("n")) {
            System.out.println("\nalr ff we generate random... go brrrr\n\n");
            dealership = new Dealership(); 
        } else {
            System.out.println("Please fill out to start your dealership: ");
            System.out.print("\n[Cash]  ");
            cash = getValue.nextDouble();
            System.out.print("\n[Number of Cars]  ");
            numberOfCars = getValue.nextInt(); 
            getValue.nextLine();//buffer for \n
            System.out.print("\n[Dealership Name]  ");
            name = getValue.nextLine();
            dealership = new Dealership(name, cash, numberOfCars);
        }


        System.out.print("Open Your Dealership!!! [enter]");
        getValue.nextLine();
        dealership.openDealership();

 

        while (true) {

            System.out.print("\n\nNEXT ACTION: \n\t[V]iew Dealership \n\t[B]uy a car \n\t[S]ell a car \n\t[E]xit \n\n\t: ");
            String action = getValue.nextLine().toLowerCase();

            if (action.equals("e")) {
                break;
            }
            else if (action.equals("v")) {
                System.out.println(dealership);
            } else if (action.equals("b")) {
                // buy car 
                System.out.print("[T]ruck   [S]edan   [SP]ort:  ");
                String answerType = getValue.nextLine().toLowerCase();
                dealership.buy(answerType);


            } else if (action.equals("s")) {
                // sell car 
                System.out.print("No. Car: ");
                int num = getValue.nextInt();
                dealership.sell(num); 

            } else {
                System.out.println("Please stick to the letters");
                continue;
            }
        }








    }
}
