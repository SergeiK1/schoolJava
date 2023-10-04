import java.util.Scanner;


public class q5 {
    public static void main(String[] args) {


        



        System.out.println("[ Enter Your Birthday ]");
        Scanner getValue = new Scanner(System.in);

        int totalDayCount = 0;


        System.out.print("Year: ");
        int birthYear = getValue.nextInt();
        System.out.print("Month (number): ");
        int birthMonth = getValue.nextInt(); 
        System.out.print("Day: ");
        int birthDay = getValue.nextInt();

        System.out.println(" ");
        System.out.println("[ Enter Current Day ]");

        System.out.print("Year: ");
        int currentYear = getValue.nextInt();
        System.out.print("Month (number): ");
        int currentMonth = getValue.nextInt(); 
        System.out.print("Day: ");
        int currentDay = getValue.nextInt(); 

        getValue.close();

        totalDayCount += 365.25*(currentYear - birthYear); 


        System.out.println(totalDayCount);

    }
}