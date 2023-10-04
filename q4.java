import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        System.out.print("Time Input: ");
        Scanner getSeconds = new Scanner(System.in);

        int seconds = getSeconds.nextInt();
        int min = seconds/60; 
        String newSecond = "";
        seconds %= 60;

        getSeconds.close();

        if (seconds < 10) {
            newSecond = "0"+seconds;
        }
        
        System.out.println("[Time]: " + min+":"+newSecond);

    }
}