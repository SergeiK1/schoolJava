package Final;

public class Maze {
    
    private int[][] theMaze; 
    private int[] startCoords = new int[2];
    private int[] endCoords = new int[2];

    private int x,y;


    public Maze(int difficulty) {

        if (difficulty == 0) {
            x = 5;
            y = 5;            
        }
        else if (difficulty == 1) {
            x = 10;
            y = 10;  
        }
        else if (difficulty == 2) {
            x = 25;
            y = 25;  
        }

        theMaze = new int[x][y];
            
        startCoords[0] = (int)(Math.random()*x);
        startCoords[1] = (int)(Math.random()*y);
        endCoords[0] = (int)(Math.random()*x);
        endCoords[1] = (int)(Math.random()*y); 
        while (endCoords[0] == startCoords[0] || endCoords[1] == startCoords[1]) {
            endCoords[0] = (int)(Math.random()*x);
            endCoords[1] = (int)(Math.random()*y);
        }

        
        createMaze();

    }

    public void createMaze() {
        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                    if (Math.random() < 0.45) {
                        theMaze[i][j] = 1;
                    } else {
                        theMaze[i][j] = 0;
                    }
            }
        }
        theMaze[startCoords[0]][startCoords[1]] = 0;
        theMaze[endCoords[0]][endCoords[1]] = 3;
    }   

    public double solveMaze() {
        double startTime = System.nanoTime(); 
        double totalTime = 0.0;

        if(solve(startCoords[0],startCoords[1]) == false) {
            //calculate distance 
            totalTime = Math.sqrt(Math.pow(endCoords[0] - startCoords[0], 2) + Math.pow(endCoords[1] - startCoords[1], 2));
            totalTime *=-1; // indicate its not solved 
        } else {
            double endTime = System.nanoTime();
            totalTime = endTime-startTime;
            
        }


        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                if (theMaze[i][j] == 4) {
                    theMaze[i][j] = 0;
                }
            }
        }
        

        // SOLVE MAZE ALGORYTHM 
        // return negative if not solved and sending distance
        // return positive is solved 

        return totalTime;
    }
    
    public boolean solve(int x, int y) { // stolen from myslef  
        boolean value = false; 
        // System.out.println("\n");
        // this.printMaze();

        if(x < 0 || x >= theMaze.length || y < 0 || y >= theMaze[0].length ) { // checks out of bounds 
            value = false;
        }

        else if (theMaze[x][y] == 3) { // exit 
            // System.out.println("Done\n\n");
            value = true;
        } else if (theMaze[x][y] == 1) { // wall 
            value = false;
        } else if (theMaze[x][y] == 4) { // traversed 
            value = false; 
        } else if (theMaze[x][y] == 0) { // open space 
            theMaze[x][y] = 4;
            if(solve(x, y+1)) {
                value =  true; 
            } else if (solve(x+1, y)){ 
                value =  true;
            } else if (solve(x, y-1)) { 
                value =  true;
            } else if (solve(x-1, y)) { 
                value =  true;
            }
        }


        return value;
    }

    public void printMaze() {
        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                System.out.print(theMaze[i][j] + " ");
            }
            System.out.println();
        }
    }


}
