

public class MyPoint {
    double x, y;

    public MyPoint(double xIn, double yIn) {
        x = xIn;
        y = yIn;
    }

    private double distance(MyPoint point){
        double distance = Math.sqrt((Math.pow(point.x - x, 2) + (Math.pow(point.y-y,2))));
        return distance;
    }

    
}