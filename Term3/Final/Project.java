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


    public static ArrayList<Maze> mergeSort(ArrayList<Maze> mazes) { // uses arraylist 
        

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

        // System.out.println(list1.size());
        // System.out.println(list2.size());
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


        // sixth clause 

        // SICE IT RUNS THE MAZE EVERY TIME THERE IS DESCREPENCY EACH RUN SO ITS NOT NECESSARILY CONSISTNET FROM START TO END 
        // Thats why it works with negative numbers (since the distance is consistent) 
        // but doesnt work with positive (solved) mazes as it takes longer or shorter each time to solve
        // this descrepency can come from the number of thing such as CPU load, memory usage, or backgorund operations
        // since this is all being timed in nanoseconds small changes will cause big descrepencies 


        // the sorting actually works as seen by negative numbers its just special for positives

        // ive also observed that when being printed it says that the first mazes take a long time then its shorter than its longer again
        // this is after its been sorted meaning this is during the printing stage so I think this weird high low high structure of positive mazes
        // i belive must come from some internal cycle that either the compiler or computer runs when printing 


        for (int i = 0; i < finalList.size(); i++){
            System.out.print("--------  Maze: "+i + " --------\n");
            System.out.println("[ Start Coords ]\t X: "+finalList.get(i).getStartCoords()[0] + "\t Y: "+ finalList.get(i).getStartCoords()[1]);
            finalList.get(i).printMaze();
            System.out.println(finalList.get(i).solveMaze());
            System.out.println();
        }
    }


}




