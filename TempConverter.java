import java.util.Scanner;

public class TempConverter{
    
    public static double FarCel(double f) { 
        return (f - 32.0)*(5.0/9.0);
    }
    public static double CelFar(double c) { 
        return ((c*9.0)/5.0)+32.0;
    }
    public static double CelKel(double c) { 
        return c+273.15;
    }
    public static double KelCel(double k) { 
        return k-273.15;
    }
    public static double FarKel(double f) { 
        return CelKel(FarCel(f));
    }
    public static double KelFar(double k) { 
        return CelFar(KelCel(k));
    }



    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("\n\nInput Value: ");
        double value = getValue.nextDouble();
        System.out.print("[Identify Conversion]\n\n [1] Fahrenheit to Celcius \n [2] Celcius to Fahrenheit \n [3] Celcius to Kelvin \n [4] Kelvin to Celcius \n [5] Fahrenheit to Kelvin \n [6] Kelvin to Fahrenheit\n\n  -->  ");
        int conversion = getValue.nextInt();
        getValue.close();

        switch (conversion) { 
            case 1:
                System.out.println("Celcius: "+FarCel(value));
                break;
            case 2:
                System.out.println("Fahrenheit: "+CelFar(value));
                break;
            case 3:
                System.out.println("Kelvin: "+CelKel(value));
                break;
            case 4:
                System.out.println("Celcius: "+KelCel(value));
                break;
            case 5:
                System.out.println("Kelvin: "+FarKel(value));
                break;
            case 6:
                System.out.println("Fahrenheit: "+KelFar(value));
                break;
        }
    }
}