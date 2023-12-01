import java.util.Scanner;


public class Arrays{
    public static void main(String[] args) {

        Scanner getValue = new Scanner(System.in);
        int[] myArray = new int[5];
        

        for (int i = 0; i < 5; i++) {
            boolean duplicate = false;
            if (i<0){i=0;};
            System.out.print("Gimme Number: ");
            int value = getValue.nextInt();
            if (value > 10 && value < 100){
                for (int j = 0; j < myArray.length; j++){
                    if (value == myArray[j]){
                        // System.out.println("Value: "+value);
                        // System.out.println("myArray[j]: "+myArray[j]);
                        System.out.println("Already Contains");
                        duplicate = true;
                        i --;
                        continue;
                    }
                }
                if (!duplicate){
                myArray[i] = value;
                // System.out.println("myArray[i]"+myArray[i]);
                }
                
                
            } else {
                System.out.println("Between 10 and 100");
                i --;
                continue;
            }
        }

        for (int k = 0; k < myArray.length; k++){
            System.out.println(myArray[k]);
        }
        
        getValue.close();
    }
}