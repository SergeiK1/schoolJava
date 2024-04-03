public class Recursion {
    
    public static double mystery(double x){
       int len = (Double.toString(x)).length(); 
       int a = Math.pow(10, len);

       return x/Math.pow(10, len)+ mystery(x); 
    }


    public static void main(String[] args) {
        System.out.println(mystery(10));
    }
}
