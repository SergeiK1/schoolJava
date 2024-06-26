package Maze;

public class Maze {
    

    static int[][] maze1 = new int[][] { { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                                        { 1, 0, 1, 1, 0, 1, 1, 1, 1, 1 }, 
                                        { 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, 
                                        { 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
                                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
                                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
                                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                                        { 1, 1, 1, 1, 1, 0, 0, 0, 0, 3 }, 
                                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };


    static int[][] maze2 = new int[][]      {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
                                            {1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                            {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                            {1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                                            {1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                                            {1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                                            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                            {1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                                            {1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                                            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
                                            {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1},
                                            {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                                            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                                            {1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};


    static int[][] maze = new int[][] {
                                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                                            {1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                                            {1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                                            {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                                            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                                            {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                                            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                                            {1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                                            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1},};
                                            




    public static void display(int[][] maze) { 
        for (int i = 0; i < maze.length; i++) { 
            for (int j = 0; j < maze[i].length; j++) {
                int value = maze[i][j];
                if (value == 1) {
                    System.out.print("# ");
                } else if (value == 4) {
                    System.out.print(". ");
                } else if (value == 0) {
                    System.out.print("  ");
                } else if (value == 3) {
                    System.out.print("! ");
                } else {
                    System.out.print("f ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\n\n");
    }

    public static boolean solve(int x, int y) { 
        // System.out.println("solve");
        boolean value = false; 

        if(x < 0 || x >= maze.length || y < 0 || y >= maze[0].length ) { // checks out of bounds 
            value = false;
        }

        else if (maze[x][y] == 3) { // exit 
            // System.out.println("Done\n\n");
            value = true;
        } else if (maze[x][y] == 1) { // wall 
            value = false;
        } else if (maze[x][y] == 4) { // traversed 
            value = false; 
        } else if (maze[x][y] == 0) { // open space 
            maze[x][y] = 4;
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

        
  
        

        return value; // base ?? 
    }

    public static void main(String[] args) {
        solve(3,11);
        display(maze);

    }

}
