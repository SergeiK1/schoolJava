import java.util.Scanner;

public class volume {
    public static void main(String[] args){
        Scanner getValue = new Scanner(System.in);
        System.out.println(" ");
        System.out.println(" ");
        System.out.print("  [ Select ] \n\n  ( 1 ) Rectangular Prism \n  ( 2 ) Sphere \n  ( 3 ) Cube \n  ( 4 ) Cone \n\n --> ");
        int choice = getValue.nextInt();
        switch (choice){
            case 1:
            // Rectangle
            System.out.println("[ RECTANGLE AREA ]");
            System.out.print("     Length: ");
            double length = getValue.nextDouble();
            System.out.print("     Width: ");
            double width = getValue.nextDouble();
            System.out.print("     Height: ");
            double height = getValue.nextDouble();

            double area = length*height*width;
            System.out.println("[ Result ] =  " + area);
            case 2:
            // sphere
            case 3:
            // cube
            case 4:
            // cone
        }
    }
}