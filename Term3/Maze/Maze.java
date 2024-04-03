package Maze;

public class Maze {
    

    static int[][] maze = new int[][] { { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
                                        { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
                                        { 1, 0, 1, 1, 0, 1, 1, 1, 1, 1 }, 
                                        { 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 }, 
                                        { 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
                                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
                                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
                                        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                                        { 1, 1, 1, 1, 1, 0, 0, 0, 0, 3 }, 
                                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };


    public static boolean solve(int x, int y) { 
        System.out.println("solve");
        boolean value = false; 

        if(x < 0 || x > maze.length || y < 0 || y > maze[0].length ) { // checks out of bounds 
            value = false;
        }

        else if (maze[x][y] == 3) { // exit 
            value = true;
        } else if (maze[x][y] == 1) { // wall 
            value = false;
        } else if (maze[x][y] == 4) { // traversed 
            value = false; 
        } else if (maze[x][y] == 0) { // open space 
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

        maze[x][y] = 4;
        

        return value; // base ?? 
    }

    public static void main(String[] args) {
        solve(0,1);
    }

}
