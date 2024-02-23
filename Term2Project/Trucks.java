public class Trucks extends Cars  {
    private String[] brands = new String[]{"Ford","Chevy","Jeep","GMC", "RAM", "Volvo"};



    public Trucks() {
        price = 10000+(((int) (Math.random()*300000)) / 100.00);
        brand = brands[(int) (Math.random()*brands.length)];
        type = "truck";

    }

    public void testTruckBed() {
        System.out.println(" *clang* *clang* very sturdy bed can probably fit my whole bed here ");
        return;
    }
    
}
