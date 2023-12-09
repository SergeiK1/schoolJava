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
            boolean stopLoop = false;
            for (int i = coords[0] - 1; i <= coords[0] + 1; i++) { // Four loops through all adjacent cells
                for (int j = coords[1] - 1; j <= coords[1] + 1; j++) {


                        
                        // takes care of looping back over so never out of bounds 
                        if (j > 4) {
                            j = 0;
                            stopLoop = true;
                        }
                        if (j < 0) {
                            j = 4;
                            stopLoop = true;
                        }
                        if (i < 0) {
                            i = 4;
                            stopLoop = true;
                        }
                        if (i > 4) {
                            i = 0;
                            stopLoop = true;
                        }
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


                        if (stopLoop){ // stop infa loop since altering i and j 
                            break;
                        }

                    }
                    if (stopLoop) {
                        break;
                    }
                }

            boolean[] near = new boolean[]{pitNear, batNear, arrowNear, wumpNear};                
            // for (int h = 0;  h<4; h++) {
            //     System.out.println(near[h]);
            // }

            return near;

            }
        }




        public static class Player {
            public int arrows;
            public int[] coords = new int[2];
            public boolean alive;

            public Player(Cell[][] grid) {
                arrows = 5;
                alive = true;
                boolean checking = true;
                while (checking) {
                    int x = (int) (Math.random()*5);
                    int y = (int) (Math.random()*5);

                    if (!grid[x][y].isArrow && !grid[x][y].isBat && !grid[x][y].isPit && !grid[x][y].isWumpus) {
                        coords[0] = x;
                        coords[1] = y;
                        checking = false;
                    }

                }
            }

            public void enterCell(Cell[][] grid) {
                Cell cell = grid[coords[0]][coords[1]]; // identifies current cell

                if (cell.isPit) { 
                    alive = false;
                    System.out.println("Died in a Pit");
                } else if (cell.isWumpus) {
                    // wumpus logic

                    System.out.println("You have encountered the mighty WUMPUS");
                    System.out.println("Mighty Wumpus is Startled");

                    if (Math.random() < 0.5) {
                        //dead
                        alive = false;
                        System.out.println("You died -- wump");
                    } else {
                        // wampus gets out 
                        System.out.println("The wumpus ran away");

                        /// FINISH WUMPUS MOVEMENT TTTTTTTT
                    }


                } else if (cell.isBat) { 
                    //bat logic
                    System.out.println("BATS ...");
                    coords[0] = (int) (Math.random()*5); 
                    coords[1] = (int) (Math.random()*5);
                    // enterCell(grid);
                } else if (cell.isArrow) {
                    arrows += 1;
                    System.out.println("You have picked up a lucky arrow");
                }
                if (alive) {
                    boolean[] results = cell.testAround(grid);
                    if (results[0]) { // pit
                        System.out.println("I feel a breeze ...");
                    }
                    if (results[1]) { // bat
                        System.out.println("I hear flapping nearby...");
                    }
                    if (results[2]) {
                        // arrow
                    }
                    if (results[3]) { // wump
                        System.out.println("I smell wump");
                    }
                }
                
            }


        }




    

    public static void main(String[] args) {

        // GRID CREATION =========================
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
                // System.out.println("PIT: "+isPit);
                // System.out.println("BAT: "+isBat);
                // System.out.println("ARROW: "+ isArrow);
                // System.out.println("____");

            }
        }

        boolean checking = true;
        while (checking) { // wumpus creation
            int X = (int) (Math.random()*5);
            int Y = (int) (Math.random()*5);

            if (!grid[X][Y].isArrow && !grid[X][Y].isBat && !grid[X][Y].isPit) {
                grid[X][Y].isWumpus = true;
                checking = false;
                // System.out.println("Wumpus");
            }
        }

        // boolean checking2= true;
        // while (checking2) { // player creation
        //     int X = (int) (Math.random()*5);
        //     int Y = (int) (Math.random()*5);

        //     if (!grid[X][Y].isArrow && !grid[X][Y].isBat && !grid[X][Y].isPit && !grid[X][Y].isWumpus) {
        //         grid[X][Y].isPlayer = true;
        //         checking2 = false;
        //         System.out.println("Player");
        //     }
        // }




        // Player Creation ===================================


            Player player = new Player(grid); // new player 
            Scanner getValue = new Scanner(System.in);

            while (player.alive) {
                // the game goes onn
                player.enterCell(grid);
                System.out.print("\tWASD Move: "); // this doubles when you die for sm reasoon 
                String userMove = (getValue.nextLine()).toLowerCase();

                switch (userMove) {
                    case "w":
                        //move up
                        player.coords[1] -= 1;
                        if (player.coords[1] < 0) {
                            player.coords[1] = 4;
                        }
                        break;
                    case "a":
                        //move left 
                        player.coords[0] -= 1;
                        if (player.coords[0] < 0) {
                            player.coords[0] = 4;
                        }
                        break;
                    case "s":
                        // move down
                        player.coords[1] += 1;
                        if (player.coords[1] > 4) {
                            player.coords[1] = 0;
                        }
                        break;
                    case "d":
                        // move right
                        player.coords[0] += 1;
                        if (player.coords[0] > 4) {
                            player.coords[0] = 0;
                        }
                        break;
                
                    default:
                        System.out.println("W A S D please: "+userMove);
                        break;
                }

            }

            getValue.close();




    
   

    }
}