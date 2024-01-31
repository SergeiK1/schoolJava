
public class test {

    public static void main(String[] args) {
        int[][] grid = new int[2][15];
        int MAX = 100;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                int num;
                while (true) {
                    num = (int) (Math.random()*MAX);
                    if (num%10 == 0 && num%100 != 0) {
                        break;
                    }

                }
                grid[i][j] = num;
                System.out.print(num+" ");
            }
            System.out.println("\n");
        }


        int count = 0;
        for (int col = 0; col < grid[0].length; col++) {
            boolean increasing = true;
            for (int row = 1; row < grid.length; row++) {
                if (grid[row][col] < grid[row-1][col]) {
                    increasing = false;
                }

            }
            if (increasing) {
                count++;
                System.out.println("coutingg");
            } else {
                System.out.println("no");
            }
        }
        System.out.println("Count: "+count);
    }
}