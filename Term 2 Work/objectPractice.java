import java.util.Scanner;


public class objectPractice {

    public class Point {
        double x, y;

        public Point(double xIn, double yIn) {
            x = xIn;
            y = yIn;
        }

        private double distance(Point point){
            double distance = Math.sqrt((Math.pow(point.x - x, 2) + (Math.pow(point.y-y,2))));
            return distance;
        }
    }


    public static void main(String[] args) {

        Scanner getValue = new Scanner(System.in);
        System.out.print("x: ");
        int x = getValue.nextInt();
        System.out.println("");
        System.out.print("y: ");
        int y = getValue.nextInt();

        Point newPoint = new Point(x, y);





    }
}