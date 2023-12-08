import java.util.Scanner;
import java.math.*;

public class all {
   
    public class Cell{
        public boolean isPit, isBat, isArrow, isWumpus;
        public int[] coords = new int[2]; 

        public Cell(boolean isPitIn, boolean isBatIn, boolean isArrowIn, boolean isWumpusIn) {
            isPit = isPitIn;
            isBat = isBatIn;
            isArrow = isArrowIn;
            isWumpus = isWumpusIn;
            coords[0] = 0; // x
            coords[1] = 0; // y
        }


    }




    

    public static void main(String[] args) {

        // main run here 
        boolean pitCreated = false;
        boolean batCreated = false;
        boolean arrowCreated = false;

        Cell[][] grid = new Cell[5][5]; // creates game grid  out of cell classes 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // Pit Creation
                boolean isPit = false;
                isPit = Math.random() < 0.1;
                if (isPit) { // tells the program at least one pit was created 
                    pitCreated = true;
                }
                if (i == grid.length-1 && j == grid[0].length-1) { // if none were created the last one is guarenteed to be a pit  --> 8% chance technically 
                    if(!pitCreated){
                        isPit = true;
                    }
                }
                
                // Bat Creation
                boolean isBat = false;
                if (!isPit) { // no overlap
                    isBat = Math.random() < 0.1;
                    if (isBat) { // tells the program at least one bat was created 
                        batCreated = true;
                    }
                    if (i == grid.length-1 && j == grid[0].length-1) { // if none were created the last one is guarenteed to be a bat  --> 8% chance technically 
                        if(!batCreated){
                            isBat = true;
                        }
                    } 
                }

                // Arrow Creation
                boolean isArrow = false;
                if (!isPit && !isBat) { // no overlap
                    isArrow = Math.random() < 0.1;
                    if (isArrow) { // tells the program at least one arrow was created 
                        arrowCreated = true;
                    }
                    if (i == grid.length-1 && j == grid[0].length-1) { // if none were created the last one is guarenteed to be a arrow  --> 8% chance technically 
                        if(!arrowCreated){
                            isArrow = true;
                        }
                    } 
                }

                // Cell cell = new Cell(isPit, isBat, false, false);
                System.out.println("PIT: "+isPit);
                System.out.println("BAT: "+isBat);
                System.out.println("ARROW: "+ isArrow);
                System.out.println("____");



            }
        }

    }
}