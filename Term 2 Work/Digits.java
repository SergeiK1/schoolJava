import java.util.*;

public class Digits {
    public static void main(String[] args) {

        System.out.print("Enter: ");
        Scanner getValue = new Scanner(System.in);
        int num = getValue.nextInt();
        getValue.close();

        ArrayList<Integer> list = new ArrayList<Integer>();



        for (int i = 1; i < 10; i++) {

            int num2 = (int) ((double)(num % (Math.pow(10, i))) / Math.pow(10, i-1)); // digit by digit 

            if (num2 == 0) { // end condition
                break;
            }

            System.out.println("A: "+num2);
            list.add(num2);

        }

        System.out.println("___________");
        Collections.reverse(list);
        System.out.println(list);
    }
    
}