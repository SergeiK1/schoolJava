package Final;

import java.util.ArrayList;

public class Project {
    

    public static ArrayList<Maze> mazes = new ArrayList<Maze>();


    // this is a maze solver that generates random mazes (solvable and unsolvable) 
    // then it merge sorts them based on timing 
    // however it solves the maze every check meaning there is time descrepency every comparison

    public static void fill() {
        for (int i = 0; i<40; i++) {
            Maze maze = new Maze((int)(i%3));
            mazes.add(maze);
        }
        System.out.println("Filled");
    }


    public static ArrayList<Maze> mergeSort(ArrayList<Maze> mazes) {
        

        if (mazes.size() <= 1) {
            return mazes;
        }

        ArrayList<Maze> list1 = new ArrayList<Maze>();
        ArrayList<Maze> list2 = new ArrayList<Maze>();

        for(int i = 0; i < (mazes.size()/2); i++){
            list1.add(mazes.get(i));
            // System.out.println(mazes.get(i));
        }
        for(int i = (mazes.size()/2); i < mazes.size(); i++){
            list2.add(mazes.get(i));
            // System.out.println(mazes.get(i));
        }

        System.out.println(list1.size());
        System.out.println(list2.size());
        list1 = mergeSort(list1);
        list2 = mergeSort(list2); 
        ArrayList<Maze> listFinal = new ArrayList<Maze>();
        while (list1.size() > 0 && list2.size() > 0) {
            double time2 = list2.get(0).solveMaze();
            double time1 = list1.get(0).solveMaze();

            //if checkign the positives (solved mazes)
            if(time1 > 0 && time2 > 0) {
                if ((time1 < time2)) {
                    listFinal.add(list1.remove(0));
                } else {
                    listFinal.add(list2.remove(0)); 
                }

            } else if(time1 < 0 && time2 < 0) {
                if ((time1 > time2)) {
                    listFinal.add(list1.remove(0));
                } else {
                    listFinal.add(list2.remove(0)); 
                }

            } else {
                if (time2 < 0) {
                    listFinal.add(list1.remove(0));
                } else {
                    listFinal.add(list2.remove(0)); 
                }            }

           
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



    public static void main(String[] args) {

        

        fill();
        ArrayList<Maze> finalList = new ArrayList<Maze>();
        finalList = mergeSort(mazes);


        
        // SICE IT RUNS THE MAZE EVERY TIME THERE IS DESCREPENCY EACH RUN SO ITS NOT NECESSARILY CONSISTNET FROM START TO END 
        // Thats why it works with negative numbers (since the distance is consistent) 
        // but doesnt work with positive (solved) mazes as it takes longer or shorter each time to solve
        // this descrepency can come from the number of thing such as CPU load, memory usage, or backgorund operations
        // since this is all being timed in nanoseconds small changes will cause big descrepencies 


        for (int i = 0; i < finalList.size(); i++){
            System.out.print("--------  Maze: "+i + " --------\n");
            finalList.get(i).printMaze();
            System.out.println(finalList.get(i).solveMaze());
            System.out.println();
        }
    }


}




