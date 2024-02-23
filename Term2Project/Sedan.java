public class Sedan extends Cars {

    private String[] brands = new String[]{"Kia","Subaru","Audi","Volvo", "Toyota", "Honda"};
    
    public Sedan() {
        type = "sedan";
        brand = brands[(int) (Math.random()*brands.length)];
        price = 20000 + (((int) (Math.random()*500000)) / 100.00);

    }
}
