public class Cars {
    
    private String type;
    private String color;
    private String brand;
    
    private String[] types = new String[]{"truck","sedan","sport"};
    private String[] brands = new String[]{"Mercedes","Ford","Porche","Chevy","Audi","Lexus","Subaru"};
    private String[] colors = new String[]{"Cherry Red","Jet Black","Matte Black","Silver","Snow White","Forest Green","Midnight Blue"};


    protected int condition; // out of 100 
    private int fuelTotal; // in gallons
    protected int currentFuel; 
    private double price; 



    public Cars() { 
        type = types[(int) (Math.random()*types.length+1)];
        brand = brands[(int) (Math.random()*brands.length+1)];
        color = colors[(int) (Math.random()*colors.length+1)];

        condition = (int) (20 + Math.random()*110-9); // confusing way thats prolly does the same chance but whatever it makes sense brand
        fuelTotal = (int) (10 + Math.random()*12);
        currentFuel = (int) (Math.random()*fuelTotal);

        if(type == "truck") {
            price = ((int) (Math.random()*3000000)) / 100.00;
        }
        else if(type == "sedan") {
            price = ((int) (Math.random()*5000000)) / 100.00;
        }
        else if(type == "sport") {
            price = ((int) (Math.random()*50000000)) / 100.00;
        }
    }



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
        // subtract money 
        System.out.println("Condition: " + condition + "%");
    }





}
