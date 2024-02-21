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
            getValue.close();
        } else {
            System.out.println("Please fill out to start your dealership: ");
            System.out.print("\n[Cash]  ");
            cash = getValue.nextDouble();
            System.out.print("\n[Number of Cars]  ");
            numberOfCars = getValue.nextInt(); 
            System.out.print("\n[Dealership Name]  ");
            name = getValue.nextLine();
            getValue.close();
            dealership = new Dealership(name, cash, numberOfCars);
        }

        System.out.println(dealership);


        







    }
}
