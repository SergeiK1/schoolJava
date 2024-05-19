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


    public static ArrayList<Integer> selectionSort(ArrayList<Integer> list, int k) {
        
        if (!isSorted(list)){
            int lowTemp = 9999;
            int index=-1;
            for (int i = k; i < list.size(); i++) {
                if (list.get(i) < lowTemp) {
                    lowTemp = list.get(i);
                    index = i;
                }
            }
            k++;
            if(k >= list.size()) {
                return list;
            }
            list.remove(index);
            list.add(k-1,lowTemp);
            selectionSort(list, k);
        }
        return list; 
    }


    // public static ArrayList<Integer> insertSort(ArrayList<Integer> list, int k) {
        
    //     for (int i = k; i < list.size(); i++) {
    //         int testVal = list.get(i);
    //         for (int j = k; j >=0; j--) {
    //             if (list.get(j) < list.get(i)){ 
    //                 list.add(j+1, list.remove(i));
    //             } 
    //         }

    //     }
        

    //     return list;
    // }




        public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {



            if (list.size() <= 1) { // base case 
                return list;
            }

            // subdevide into two arrayslists 
            // assisted by the world wide web 
            ArrayList<Integer> list1 = new ArrayList<>(list.subList(0, list.size() / 2));
            ArrayList<Integer> list2 = new ArrayList<>(list.subList(list.size() / 2, list.size()));

            // ArrayList<Integer> list1 = new ArrayList<Integer>();
            // list1 = (ArrayList<Integer>) list.subList(0, (list.size()/2));           
            // ArrayList<Integer> list2 = new ArrayList<Integer>();
            // list2 = (ArrayList<Integer>) list.subList((list.size()/2), list.size());

            // have the merge sequence with the value: "mergeSort(list1) and mergeSort(list2)" --> for recursion 
            // could improve because arraylist shifts when removing values 
            list1 = mergeSort(list1);
            list2 = mergeSort(list2); 
            ArrayList<Integer> listFinal = new ArrayList<Integer>();
            while (list1.size() > 0 && list2.size() > 0) {

                if (list1.get(0) < list2.get(0)) {
                    listFinal.add(list1.remove(0));
                } else {
                    listFinal.add(list2.remove(0)); 
                }
                System.out.println(listFinal);
            }
            while (list1.size() > 0) {
                // fill with list 1
                listFinal.add(list1.remove(0));
            }
            while (list2.size() > 0) {
                // fill with list 2 
                listFinal.add(list2.remove(0));
            }

            return listFinal; 
        }



    // ---------------------------------------------------------------------- 


    public static void main(String[] args) {

        ArrayList<Integer> list = fill(100);
        shuffle(list);
        display(list);
        // list = sort1(list);
        // list = selectionSort(list,0);
        // insertSort(list, 0);
        list = mergeSort(list);
        System.out.println("_____________________________________________\n\n\n\n\n");
        display(list);
        System.out.println(isSorted(list));

    }





}