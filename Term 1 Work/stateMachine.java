import java.util.Scanner;

public class stateMachine {
    public static void main(String[] args){
        // make a long string with broekn down into sections = array
        String states = "XO:aPdRbYcB, XP:bBcGdR, XG:aBcR, XB:bRdY, XY:bB, XR:aYbOcPdG,";
        Scanner getValue = new Scanner(System.in);
        System.out.print("[ Starting Color ]  \n  [o]range \n  [p]urple \n  [g]reen \n  [b]lue \n  [y]ellow \n  [r]ed \n\n   --> ");
        String start = getValue.nextLine();

        switch (start) {
            case "o":
                start = "XO";
                break;
            case "p":
                start = "XP";
                break;
            case "g":
                start = "XG";
                break; 
            case "b":
                start = "XB";
                break; 
            case "y":
                start = "XY";
                break; 
            case "r":
                start = "XR";
                break; 
        }
        // System.out.println("Case Start: " + start);

        // int current = states.indexOf(start, 0);
        // System.out.println("Current: "+ current);
        System.out.print("\n\n[ Order ] \n   --> ");
        String order = getValue.nextLine();
        int current = states.indexOf(start, 0);
        // System.out.println("Current: "+current);
        int length = order.length();
        getValue.close();
        for (int j = 0; j < length; j++) { // iterates through the greater order
            // System.out.println("-- Next Order Cycle --");
            // System.out.println("J: " + j + "    Original order lenght: " + length);
            char orderC = order.charAt(0);
            for (int i =current+3; i <=states.indexOf(",", i); i++){ // iterates through each section of states
                char stateC = states.charAt(i); // selects each character of section state
                // System.out.println("Searching for: " + orderC +" in "+stateC);
                if (stateC == orderC){
                    char newStart = states.charAt(i+1);
                    // System.out.println("Found: "+orderC);
                    switch (newStart) {
                        case 'O':
                            start = "XO";
                            break;
                        case 'P':
                            start = "XP";
                            break;
                        case 'G':
                            start = "XG";
                            break; 
                        case 'B':
                            start = "XB";
                            break; 
                        case 'Y':
                            start = "XY";
                            break; 
                        case 'R':
                            start = "XR";
                            break; 
                    }
                    // System.out.println("New Start: " +start);
                    order = order.substring(1);
                    // System.out.println("New Order: "+order);
                    current = states.indexOf(start, 0);
                    // System.out.println("Current: "+current);
                    break;
                } else {
                    // System.out.println("Not: " + orderC + "  searching next... ");
                }
                // System.out.println(stateC);
            }
        }
        String end = "";
        // System.out.println("## DONE ##");
        switch (start) {
            case "XO":
                end = "Orange";
                break;
            case "XP":
                end = "Purple";
                break;
            case "XG":
                end = "Green";
                break; 
            case "XB":
                end = "Blue";
                break; 
            case "XY":
                end = "Yellow";
                break; 
            case "XR":
                end = "Red";
                break; 
        }
        System.out.println("\n======  Final State: " + end);
           
    }
} 