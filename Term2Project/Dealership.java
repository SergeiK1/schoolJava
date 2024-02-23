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

    public int getNumberOfCars() {return numberOfCars;};

    public void fillLot(int numberOfCars) {
        // fills the lot arraylist with random cars 
        for (int i = 0; i < numberOfCars; i++) {
            int guess = (int) (Math.random()*100);
            if (guess < 40) {
                Trucks truck = new Trucks();
                lot.add(truck);
            } else if (guess < 10) {
                Sport sportCar = new Sport();
                lot.add(sportCar);
            } else {
                Sedan sedanCar = new Sedan();
                lot.add(sedanCar);
            }
        }
    }


    public void sell(int num) {
        lot.get(num).stats();
        cash += lot.get(num).getPrice();

        System.out.println("[ COMPLETED SALE ]\n");
        lot.remove(num);
    }
    public void buy(String type) {
        if (type.equals("t")) {
            // truck
            Trucks truck = new Trucks();
            lot.add(truck);

        } else if (type.equals("s")) {
            // sedan
            Sedan carSedan = new Sedan();
            lot.add(carSedan);
        } else if (type.equals("sp")) {
            // sport 
            Sport carSport = new Sport();
            lot.add(carSport);
        } else {
            System.out.println("please stick to the letters");
        }
        lot.get(lot.size()-1).stats();
        cash -= lot.get(lot.size()-1).getPrice();
        System.out.println("[ COMPLETED PURCHASE ]\n");
    }



    // overriding string for printing better
    public String toString() { 
        String returnString = "";
        returnString += "\n-------------------------------------\n"+"[ "+name.toUpperCase()+" ]\n"+"\nCASH:\t\t\t$"+cash+"\nNUMBER OF CARS:\t\t"+numberOfCars+"\nOPEN:\t\t\t"+open+""+"\n-------------------------------------\n";

        if (!lot.isEmpty()) {
            for (int i = 0; i < lot.size(); i++) {
                returnString += "\n\nCar: "+i;
                returnString += "\n\t Type: "+lot.get(i).getType();
                returnString += "\n\t Brand: "+lot.get(i).getBrand();
                returnString += "\n\t Color: "+lot.get(i).getColor();
                returnString += "\n\t Condition: "+lot.get(i).getCondition();
                returnString += "\n\t Fuel Total: "+lot.get(i).getFuelTotal();
                returnString += "\n\t + Current Fuel: "+lot.get(i).getCurrentFuel();
                returnString += "\n\n\t PRICE: $" + lot.get(i).getPrice();
                returnString += "\n\n";
            }
        }


        return returnString;
    }


}