import java.util.Scanner;
import java.math.*;

public class all {
   
    public static class Cell{
        public boolean isPit, isBat, isArrow, isWumpus, isPlayer;
        public int[] coords = new int[2]; 
        public boolean pitNear, batNear, arrowNear, wumpNear = false; 

        public Cell(boolean isPitIn, boolean isBatIn, boolean isArrowIn, boolean isWumpusIn, boolean isPlayerIn, int x, int y) {
            isPit = isPitIn;
            isBat = isBatIn;
            isArrow = isArrowIn;
            isWumpus = isWumpusIn;
            isPlayer = isPlayerIn;
            coords[0] = x; // x
            coords[1] = y; // y
        }


        public boolean[] testAround(Cell[][] grid) {
            for (int i = coords[0] - 1; i <= coords[0] + 1; i++) { // Four loops through all adjacent cells
                for (int j = coords[1] - 1; j <= coords[1] + 1; j++) {
                        if (grid[i][j].isBat) {
                            batNear = true;
                        } 
                        if (grid[i][j].isArrow) {
                            arrowNear = true;
                        }
                        if (grid[i][j].isPit) {
                            pitNear = true;
                        }
                        if (grid[i][j].isWumpus) {
                            wumpNear = true;
                        }

                    }
                }

            boolean[] near = new boolean[]{pitNear, batNear, arrowNear, wumpNear};                
            // for (int h = 0;  h<4; h++) {
            //     System.out.println(near[h]);
            // }

            return near;

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

                Cell cell = new Cell(isPit, isBat, isArrow, false, false, i, j);
                grid[i][j] = cell;
                System.out.println("PIT: "+isPit);
                System.out.println("BAT: "+isBat);
                System.out.println("ARROW: "+ isArrow);
                System.out.println("____");

            }
        }

        boolean checking = true;
        while (checking) { // wumpus creation
            int X = (int) (Math.random()*5);
            int Y = (int) (Math.random()*5);

            if (!grid[X][Y].isArrow && !grid[X][Y].isBat && !grid[X][Y].isPit) {
                grid[X][Y].isWumpus = true;
                checking = false;
                System.out.println("Wumpus");
            }
        }

        boolean checking2= true;
        while (checking2) { // player creation
            int X = (int) (Math.random()*5);
            int Y = (int) (Math.random()*5);

            if (!grid[X][Y].isArrow && !grid[X][Y].isBat && !grid[X][Y].isPit && !grid[X][Y].isWumpus) {
                grid[X][Y].isPlayer = true;
                checking2 = false;
                System.out.println("Player");
            }
        }




        grid[1][1].testAround(grid);

   

    }
}