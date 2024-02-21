import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {


    private int numberOfCars;
    private double cash; 
    private boolean open; 
    private String name;
    private ArrayList<Cars> lot = new ArrayList<Cars>();



    // overloading constructors so that if not specified it makes random 
    public Dealership() {
        cash = ((int) (Math.random()*20000000)) / 100.00;
        numberOfCars = (int) (Math.random()*50);
        name = "Chevroletti [" + (int) (Math.random()*1000) + "]";
        fillLot(numberOfCars);
    }

    public Dealership(String name, double cash, int numberOfCars) {
        this.numberOfCars = numberOfCars;
        this.cash = cash;
        this.name = name;
        open = false; 
        fillLot(numberOfCars);
    }


    public void openDealership() { 
        if (!open) {
            if (cash < 10000) {
                System.out.println("Need more money to open dealership");
                return;
            }
            if (lot.isEmpty()) {
                System.out.println("Need Cars in your Dealership");
                return;
            }
            if (name == null) {
                System.out.println("Give your dealership a name");
                return;
            }
            open = true;
            System.out.println("[ DEALERSHIP "+ name +" OPENED ]");
        }
    }


    public void fillLot(int numberOfCars) {
        // fills the lot arraylist with random cars 

        for (int i = 0; i < numberOfCars; i++) {
            
        }



    }


    public void sell(Cars car) {
        lot.remove(car);
        cash += car.getPrice();

        System.out.println("[ COMPLETED PURCHASE ]\n");
        car.stats();
    }


    // overriding string for printing better
    public String toString() { 
        return ("\n-------------------------------------\n"+"[ "+name.toUpperCase()+" ]\n"+"\nCASH:\t\t\t$"+cash+"\nNUMBER OF CARS:\t\t"+numberOfCars+"\nOPEN:\t\t\t"+open+"\n-------------------------------------\n");
    }


}