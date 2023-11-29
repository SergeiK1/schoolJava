import java.util.Scanner;

public class euclid3d {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("Enter Coordinates:  ");
        String coords = getValue.next();    

        int comma = coords.indexOf(",");
        int comma2 = coords.indexOf(",", comma+ 1);

        String x = coords.substring(1, comma);
        String y = coords.substring(comma+1, comma2);
        String z = coords.substring(comma2+1, coords.length()-1);
        double xDouble = Double.parseDouble(x); 
        double yDouble = Double.parseDouble(y);
        double zDouble = Double.parseDouble(z);

        System.out.print("Enter Coordinates 2:  ");
        String coordsb = getValue.next();    

        int commab = coordsb.indexOf(",");
        int commab2 = coordsb.indexOf(",", commab+ 1);
        
        String xb = coordsb.substring(1, commab);
        String yb = coordsb.substring(commab+1, commab2);
        String zb = coordsb.substring(commab2+1, coordsb.length()-1);
        double xDoubleB = Double.parseDouble(xb); 
        double yDoubleB = Double.parseDouble(yb);
        double zDoubleB = Double.parseDouble(zb);




        double distance = Math.sqrt(Math.pow((xDoubleB-xDouble),2) + Math.pow((yDoubleB-yDouble),2) + Math.pow(zDoubleB-zDouble,2));
        System.out.println("Distnace: "+distance);
        


    }

}
