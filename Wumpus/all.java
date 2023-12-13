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

                        if (grid[(i+10)%10][(j+10)%10].isBat) {
                            batNear = true;
                        } 
                        if (grid[(i+10)%10][(j+10)%10].isArrow) {
                            arrowNear = true;
                        }
                        if (grid[(i+10)%10][(j+10)%10].isPit) {
                            pitNear = true;
                        }
                        if (grid[(i+10)%10][(j+10)%10].isWumpus) {
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

            return near;

            }
        }




        public static class Player {
            public int arrows;
            public int[] coords = new int[2];
            public boolean alive, wumpAlive;


            public Player(Cell[][] grid) {
                arrows = 5;
                alive = true;
                wumpAlive = true;
                boolean checking = true;
                while (checking) {
                    int x = (int) (Math.random()*10);
                    int y = (int) (Math.random()*10);

                    if (!grid[x][y].isArrow && !grid[x][y].isBat && !grid[x][y].isPit && !grid[x][y].isWumpus) {
                        coords[0] = x;
                        coords[1] = y;
                        checking = false;
                    }

                }
            }


            public void move(String userMove) {
                 switch (userMove) {
                    case "w":
                        //move up
                        coords[1] -= 1;
                        if (coords[1] < 0) {
                            coords[1] = 9;
                        }
                        break;
                    case "a":
                        //move left 
                        coords[0] -= 1;
                        if (coords[0] < 0) {
                            coords[0] = 9;
                        }
                        break;
                    case "s":
                        // move down
                        coords[1] += 1;
                        if (coords[1] > 9) {
                            coords[1] = 0;
                        }
                        break;
                    case "d":
                        // move right
                        coords[0] += 1;
                        if (coords[0] > 9) {
                            coords[0] = 0;
                        }
                        break;
                
                    default:
                        System.out.println("W A S D please: "+userMove);
                        break;
                }
            }


            public void shoot(Cell[][] grid, String direction) {
                if (arrows > 0) {
                    switch (direction) {
                        case "w":
                            //y decrease
                            // grid[coords[0]][coords[1]-1].isWumpus || (grid[coords[0]][4].isWumpus && coords[1]==0)
                            if (grid[coords[0]][((coords[1]-1)+10)%10].isWumpus){
                                System.out.println("Shot Wumps");
                                wumpAlive = false;
                            } else {
                                System.out.println("MISSED");
                            }
                            break;
                        case "a":
                            //x decrease
                            if (grid[((coords[0]-1)+10)%10][coords[1]].isWumpus){
                                System.out.println("Shot Wumps");
                                wumpAlive = false;
                            } else {
                                System.out.println("MISSED");
                            }
                            break;    
                        case "s":
                            //y increase
                            if (grid[coords[0]][((coords[1]+1)+10)%10].isWumpus){
                                System.out.println("Shot Wumps");
                                wumpAlive = false;
                            } else {
                                System.out.println("MISSED");
                            }
                            break;
                        case "d":
                            //x increase
                            if (grid[((coords[0]+1)+10)%10][coords[1]].isWumpus){
                                System.out.println("Shot Wumps");
                                wumpAlive = false;
                            } else {
                                System.out.println("MISSED");
                            }
                            break;

                        default:
                            System.out.println("Please pick W A S D: "+direction);

                    }
                } else {
                    // System.out.println(arrows);
                    System.out.println("No arrows");
                }
                if (arrows > 0){
                    arrows --;
                }
                
            }    

            public void enterCell(Cell[][] grid) {

                Cell cell = grid[coords[0]][coords[1]]; // identifies current cell
                // cell.testAround(grid);
                if (cell.isPit) { 
                    alive = false;
                    System.out.println("-- Died in a Pit --");
                    System.exit(0);
                } else if (cell.isWumpus) {
                    // wumpus logic

                    System.out.println("You have encountered the mighty WUMPUS");
                    System.out.println("Mighty Wumpus is Startled");

                    if (Math.random() < 0.5) {
                        //dead
                        alive = false;
                        System.out.println("You died -- The Wump");
                        System.exit(0);
                    } else {
                        // wampus gets out 
                        System.out.println("The wumpus ran away");
                        int x1 = (int) (Math.random()*3-1);
                        int y1 = (int) (Math.random()*3-1);
                        grid[coords[0]][coords[1]].isWumpus = false;
                        grid[coords[0]+x1][coords[1]+y1].isWumpus = true;
                    }


                } else if (cell.isBat) { 
                    //bat logic
                    System.out.println("You've been evicted -- Bats");
                    coords[0] = (int) (Math.random()*10); 
                    coords[1] = (int) (Math.random()*10);
                    // enterCell(grid);
                } else if (cell.isArrow) {
                    arrows += 1;
                    System.out.println("You picked up a lucky arrow");
                    cell.isArrow = false;
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

        Cell[][] grid = new Cell[10][10]; // creates game grid  out of cell classes 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // Pit Creation
                boolean isPit = false;
                isPit = Math.random() < 0.06;
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
                    isArrow = Math.random() < 0.01;
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

            }
        }

        boolean checking = true;
        while (checking) { // wumpus creation
            int X = (int) (Math.random()*10);
            int Y = (int) (Math.random()*10);


            if (!grid[X][Y].isArrow && !grid[X][Y].isBat && !grid[X][Y].isPit) {
                grid[X][Y].isWumpus = true;
                checking = false;
            }
        }




        // Player Creation ===================================


            Player player = new Player(grid); // new player 
            Scanner getValue = new Scanner(System.in);

            while (player.alive && player.wumpAlive) {
                // for (int i = 0; i < grid.length; i++) {
                //     for (int j = 0 ; j < grid[0].length; j++) {
                //         if (grid[i][j].isWumpus) {
                //             System.out.print("# ");
                //         }
                //         else if (player.coords[0] == i && player.coords[1] == j){
                //             System.out.print("! ");
                //         }
                //         else if (grid[i][j].isBat) {
                //             System.out.print("& ");
                //         }
                //         else if (grid[i][j].isArrow){
                //             System.out.print("1 ");
                //         }
                //         else if (grid[i][j].isPit){
                //             System.out.print("P ");
                //         } 
                //         else {
                //             System.out.print("0 ");
                //         }
                //     }
                //     System.out.print("\n");
                // }
                // the game goes onn
                player.enterCell(grid);
                System.out.print("\t [M]ove or [S]hoot: ");
                String userSelect = (getValue.nextLine()).toLowerCase();
                
                if (userSelect.equals("s")) {
                    System.out.print("\tSHOOT W A S D:  ");
                    String shootDirection = (getValue.nextLine()).toLowerCase();
                    player.shoot(grid, shootDirection);
                }

                if (userSelect.equals("m")) {
                    System.out.print("\t MOVE W A S D:  ");
                    String moveDirection = (getValue.nextLine()).toLowerCase(); 
                    player.move(moveDirection);
                }
            }

            getValue.close();




    
   

        }
}