// import java.util.Scanner;

public class walk{
    public static void main(String[] args) {
        int max = 0;
        int total = 0;
        int number = 50;
        for (int j = 0; j<number; j++){
            int counter = 0;
            int distance = 4;
            while (distance >= 0 && distance <= 7){
                int step = (int)(Math.random()*2 + 1);
                if (step == 2){
                    step = -1;
                }
                distance += step;
                System.out.print(distance+" ");
                counter ++;
            }
            System.out.println("\n");
            total += counter;
            if (counter > max) {
                max = counter;
            }
        }
        System.out.println("\n\nMax Length: "+max);
        System.out.println("Average: "+(total/number));
  }
}