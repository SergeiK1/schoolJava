public class Cars {
    
    private String type;
    private String color;
    private String brand;

    private int condition; // out of 100 
    private double fuelTotal; // in gallons
    private double currentFuel; 
    private double price; 

    
// **** add constructor 

    public void testDrive() {
        if (currentFuel < 10) {
            System.out.println("Needs refueling before test drive");
            return;
        }
        if (condition < 10) {
            System.out.println("Won't start up");
            return;
        }

        currentFuel -= (int)(Math.random()*30+1);
        if (currentFuel < 0) {currentFuel = 0;};

        condition -= (int)(Math.random()*20+1);
        if (condition < 0) {
            condition = 0;
            System.out.println("The car blew up");
        }

        if (10 > Math.random()*100) {
            System.out.println("You crashed on your test drive");
            condition = 0;
        }
    }

    public void refuel() {currentFuel = 100;}

    public void purchase() {
        // purchase car 
    }

    


}
