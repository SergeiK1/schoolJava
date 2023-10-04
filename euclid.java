import java.util.Scanner;

public class euclid {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("Enter Coordinates:  ");
        String coords = getValue.next();    

        int semicolon = coords.indexOf(",");

        String x = coords.substring(1, semicolon);
        String y = coords.substring(semicolon+1, coords.length()-1);

        double xDouble = Double.parseDouble(x); 
        double yDouble = Double.parseDouble(y); 




        System.out.print("Enter Coordinates 2:  ");
        String coords2 = getValue.next();    
        int semicolon2 = coords2.indexOf(",");

        String x2 = coords2.substring(1, semicolon2);
        String y2 = coords2.substring(semicolon2+1, coords2.length()-1);

        double xDouble2 = Double.parseDouble(x2); 
        double yDouble2 = Double.parseDouble(y2); 


        double distance = Math.sqrt(Math.pow((xDouble2-xDouble),2) + Math.pow((yDouble2-yDouble),2));
        System.out.println("Distnace: "+distance);
        


    }

}
