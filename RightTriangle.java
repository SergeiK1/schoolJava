import java.util.Scanner;

public class RightTriangle{

    public static String drawRow(int length){
        String answer = "";
        for (int i =0; i <= length; i++){
            answer+="*";
        }
        return answer;
    }

    public static String drawTriangle(int sideLength) {
        String answer = "";

        for (int i = 0; i<sideLength; i++){
            answer += drawRow(i) +"\n";
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.print("Enter Side Length: ");
        Scanner getValue = new Scanner(System.in);
        int value = getValue.nextInt();
        getValue.close();
        System.out.println(drawTriangle(value));
    }
}