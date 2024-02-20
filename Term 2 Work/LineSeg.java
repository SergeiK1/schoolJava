
public class LineSeg {

    private MyPoint first, second;

    public LineSeg(double xIn1, double yIn1, double xIn2, double yIn2) {
        first = new MyPoint(xIn1, yIn1);
        second = new MyPoint(xIn2, yIn2);
    }

    public LineSeg() {
        // overides the previous consturctor
    }



    public double SegLength() {
        double distance = Math.sqrt((Math.pow(second.x - first.x, 2) + (Math.pow(second.y-first.y,2))));
        return distance;
    }



}