// import java.util.Scanner;

public class walk{
    public static void main(String[] args) {
        int distance = 4;
        while (distance >= 0 && distance <= 7){
            int step = (int)(Math.random()*2 + 1);
            if (step == 2){
                step = -1;
            }
            distance += step;
            System.out.print(distance+" ");
        }
   }
}