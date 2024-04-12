import java.util.ArrayList;
import java.util.Collections;

public class Sorting {


    public static boolean isSorted(ArrayList<Integer> list) {
        boolean sorted = true;

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) > list.get(i+1)) { 
                sorted = false;
                break; 
            }
        }
        return sorted;
    }

    public static ArrayList<Integer> fill(int n) { 
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
            list.add(i);
        }
        return list;
    }

    public static void display(ArrayList<Integer> list) {
        System.out.println(list.toString());
    }

    public static ArrayList<Integer> shuffle(ArrayList<Integer> list) { 
        Collections.shuffle(list); 
        return list;
    }


    // ----------------------------------------------------------------------



    public static ArrayList<Integer> sort1(ArrayList<Integer> list) {
        while(!isSorted(list)) {
            for (int i = 0; i < list.size()-1; i++) { 
                int current = list.get(i);
                int next = list.get(i+1);
                if (current > next) { 
                    list.set(i, next);
                    list.set(i+1, current);
                }
            }
        }
        return list;
    }



    // ---------------------------------------------------------------------- 


    public static void main(String[] args) {

        ArrayList<Integer> list = fill(30);
        shuffle(list);
        display(list);
        sort1(list);
        display(list);
        System.out.println(isSorted(list));

    }





}