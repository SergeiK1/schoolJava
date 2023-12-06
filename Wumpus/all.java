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

        int[] pitCoords = new int[2]; // makes sure there is a pit created randomly 
        pitCoords[0] = (int) Math.random()*4;
        pitCoords[1] = (int) Math.random()*4;

        int[] batCoords = new int[2]; // makes sure there is a pit created randomly 
        batCoords[0] = (int) Math.random()*4;
        batCoords[1] = (int) Math.random()*4;


        Cell[][] grid = new Cell[5][5]; // creates game grid  out of cell classes 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean isPit = false;
                if (i == pitCoords[0] && j == pitCoords[1]) {
                    isPit = true;
                } else {
                    isPit = Math.random() < 0.1;
                }


                Cell cell = new Cell(isPit, false, false, false);


            }
        }

    }
}