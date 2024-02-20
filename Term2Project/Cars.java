public class Cars {
    
    private String type;
    private String color;
    private String brand;

    protected int condition; // out of 100 
    private double fuelTotal; // in gallons
    protected double currentFuel; 
    private double price; 

    
// **** add constructor 
    public double getPrice() { return price;}

    public void stats() {

        System.out.println("Type: "+type);
        System.out.println("Color: "+color);
        System.out.println("Brand: "+brand);
        System.out.println("Fuel Total: "+fuelTotal);
        System.out.println("Condition: "+condition + "%");
        System.out.println("Current Fuel Level: "+currentFuel + "%");
        System.out.println("\n");
        System.out.println("[ PRICE ] \t\t$" + price);
    }  


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

    public void fixUp() {
        condition += (int)(Math.random()*100+1);
        if (condition > 100) { condition = 100;}
        System.out.println("Condition: " + condition + "%");
    }





}
