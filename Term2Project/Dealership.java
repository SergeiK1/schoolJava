import java.util.ArrayList;

public class Dealership {


    private int numberOfCars;
    private int cash; 
    private boolean open; 
    private String name;
    private ArrayList<Cars> lot = new ArrayList<Cars>();
    
    public Dealership(String name, int cash) {
        numberOfCars = 0;
        this.cash = cash;
        this.name = name;
        open = false; 
    }

    public void openDealership() { 
        if (!open) {
            if (cash < 10000) {
                System.out.println("Need more money to open dealership");
                return;
            }
            if (cars.isEmpty()) {
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


    public void fillLot() {
        // fills the lot arraylist with random cars 
    }


    public void sell(Cars car) {
        lot.remove(car);
        cash += car.getPrice();

        System.out.println("[ COMPLETED PURCHASE ]\n");
        car.stats();
    }





}