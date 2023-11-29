import java.util.Scanner;

public class password{
    public static void main(String[] args){
        String password = "secretcode";
        int tries = 0;
        boolean access = false;
        Scanner getValue = new Scanner(System.in);

        while (tries < 3){
            System.out.print("[ Enter Password ]: ");
            String attempt = getValue.nextLine();
            if (attempt.equals(password)){
                System.out.println("[ --  Access Granted  -- ]");
                access=true;
                break;
            } else {
                System.out.println("INCORRECT PASSWORD");
            }
            tries ++;
        } 
        if (!access) { 
            System.out.println("{ LOCKED OUT }");
        }
    }
}