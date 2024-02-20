public class Sport extends Cars {
    
    String type = "sport";
    int minFuelForTrack = 80;
    int minQualityForTrack = 90;

    public void revEngine() {
        System.out.println("vvvvvVVVRRRRRRRMMMMmMmMmMMmmmmmm mm mm mm trtrtrrtrrttrtrttt");
        return;
    }

    public void testDrive() { 
        if (currentFuel < minFuelForTrack) {
            System.out.println("Needs refuling before track test");
            return;
        }
        if (condition < minQualityForTrack) {
            System.out.println("Needs higher quality before track test");
            return;
        }

        currentFuel -= (int)(Math.random()*90+1);
        if (currentFuel < 0) {currentFuel = 0;};

        condition -= (int)(Math.random()*70+1);
        if (condition < 0) {
            condition = 0;
            System.out.println("The car blew up");
        }

        if (30 > Math.random()*100) {
            System.out.println("You crashed on the track ");
            condition = 0;
        }
    }

}
