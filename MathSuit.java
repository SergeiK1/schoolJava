import java.util.Scanner;

public class MathSuit{

    public static int Factorial(int num){
        if (num == 0){
            return 1;
        }
        int answer = 1;
        for (int i = num; i>0; i--){
            answer *= i;
        }
        return answer;
    }

    public static int Permutation(int n, int r){
        return ((Factorial(n))/(Factorial((n-r))));
    }
    public static int Combination(int n, int r){
        return ((Factorial(n))/(Factorial((n-r))*Factorial(r)));
    }

    public static String Pascal(int row){
        String answer = "";
        for (int i = 0; i<=row; i++){
            for (int j = 0; j<=i; j++){
                answer = answer + Combination(i, j)+" ";
            }
            answer += "\n";
        }
        return answer;
    }

    public static double Pi(){
        int limit = 30;
        double sum = 0;
        for(int n=0;n<limit;n++){
            // sum += Math.pow(-1,n + 1)/((2*n) - 1);// arctan centered at 1 = pi/4 --> mutlitplied by 4 == [pi]
            sum += (Math.pow(-1,n)*(Math.pow((1/Math.sqrt(3)),2*n+1)))/(2*n+1);
        }
        return 6*sum;
    }

    public static double E(int x){
        double series = 0;
        for (int n=0; n<14; n++){
            if ((Math.pow(x,n) / Factorial(n))<0.01){
                break;
            } else {
                series += (Math.pow(x,n) / Factorial(n));
            }
            
        }
        return series;
    }
    public static double Sin(int x){
        double series = 0;
        for (int n=0; n<15; n++){
            if ((Math.pow(-1,n)*Math.pow(x, (2*n+1)))/(Factorial(2*n+1))<0.005 && Math.pow(-1,n)*Math.pow(x, (2*n+1))/(Factorial(2*n+1))>-0.005) {
                break;
            } else {
                series += ((Math.pow(-1,n)*Math.pow(x, (2*n+1)))/(Factorial(2*n+1)));
            }
        }
        return series;
    }
    public static double Cos(int x){
        double series = 0;
        for (int n=0; n<15; n++){
            if ((Math.pow(-1,n)*Math.pow(x, (2*n)))/(Factorial(2*n))<0.005 && Math.pow(-1,n)*Math.pow(x, (2*n))/(Factorial(2*n))>-0.005) {
                break;
            } else {
                series += ((Math.pow(-1,n)*Math.pow(x, (2*n)))/(Factorial(2*n)));
            }
        }
        return series;
    }
    public static double Tan(int x){
        return Sin(x)/Cos(x);
    }
    public static double Arctan(int x){
        double series = 0;
        for (int n=0; n<15; n++){
            System.out.println("Term: "+((Math.pow(-1,n)*Math.pow(x, (2*n+1)))/(2*n+1)));
            if ((Math.pow(-1,n)*Math.pow(x, (2*n+1)))/(2*n+1)<0.05 && Math.pow(-1,n)*Math.pow(x, (2*n+1))/2*n+1>-0.05) {
                break;
            } else {
                series += ((Math.pow(-1,n)*Math.pow(x, (2*n+1)))/(2*n+1));
            }
        }
        return series;
    }

    public static void main(String[] args){
        System.out.println("Welcome to MathSuit! What would you like to calculate today?");
        System.out.print("\n\t[1] Factorial (!)\n\t[2] Permutation (nPr)\n\t[3] Combination (nCr)\n\t[4] Pascal's Triangle\n\t[5] Pi Estimate\n\t[6] e Estimate\n\t[7] e^x\n\t[8] sin(x)\n\t[9] cos(x)\n\t[10] tan(x)\n\t[11] arctan(x)\n\n [SELECT] ");
        Scanner getValue = new Scanner(System.in);
        int selection = getValue.nextInt();
        int value = 0;
        switch (selection) {
 
            case 1:
                System.out.print("---  Factorial  ---\n[Input] ");
                value = getValue.nextInt();
                System.out.println(Factorial(value));
                break;
            case 2:
                System.out.print("---  Permutation (nPr)  ---\n[Input N] ");
                int value_n = getValue.nextInt();
                System.out.print("[Input R] ");
                int value_r = getValue.nextInt();
                System.out.println(Permutation(value_n, value_r));
                break;
            case 3:
                System.out.print("---  Combination (nCr)  ---\n[Input N] ");
                value_n = getValue.nextInt();
                System.out.print("[Input R] ");
                value_r = getValue.nextInt();
                System.out.println(Combination(value_n, value_r));
                break;
            case 4:
                System.out.print("---  Pascal's Triangle  ---\n[Input] ");
                value = getValue.nextInt();
                System.out.println(Pascal(value));
                break;
            case 5:
                System.out.print("---  Pi Estimate  --- ");
                System.out.println(Pi());
                break;
            case 6:
                System.out.println("---  e Estimate  ---");
                System.out.println(E(1));
                break;
            case 7:
                System.out.print("---  e^x  ---\n[Input] ");
                value = getValue.nextInt();
                System.out.println(E(value));
                break;
            case 8:
                System.out.print("---  sin(x)  ---\n[Input] ");
                value = getValue.nextInt();
                System.out.println(Sin(value));
                break;
            case 9:
                System.out.print("---  cos(x)  ---\n[Input] ");
                value = getValue.nextInt();
                System.out.println(Cos(value));
                break;
            case 10:
                System.out.print("---  tan(x)  ---\n[Input] ");
                value = getValue.nextInt();
                System.out.println(Tan(value));
                break;
            case 11:
                System.out.print("---  arctan(x)  ---\n[Input] ");
                value = getValue.nextInt();
                System.out.println(Arctan(value));
                break;
            default:
                System.out.println("Please select 1-11");
        }
        getValue.close();
    }
}