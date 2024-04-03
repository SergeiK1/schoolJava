import java.util.Scanner;
import java.util.ArrayList;

public class Pegs {
 
    public static void solve(int n, int s, int e, int o) {

        // 6-(start + end) 
        if (n == 1) {
            System.out.println(s + " ==> " + e);
        }
         else {
            solve(n-1, s, o, e);
            System.out.println(s + " ==> " + e);  
            solve(n-1, o, e, s);
        }


    }
 // ----------------------------------------------------------------



    public static void report(ArrayList[] board) { 
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < board[i].size(); j++) {
                System.out.print(board[i].get(j) + " ");
            }
            System.out.print("\n");
        }
        System.out.println("------------\n");
    }


    public static ArrayList[] setup(ArrayList[] board, int n) {


        for (int j = 0; j < board.length; j++) {
            board[j] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            board[0].add(i);
        }
        report(board);
        return board;
    }

   
    public static void bogoSolve(ArrayList[] board, int end, int n) {
        while (board[end].size() != n) {
            int ranPegOne = (int) (Math.random()*3);
            int ranPegTwo = (int) (Math.random()*3);

            if (ranPegOne != ranPegTwo) { 
                if (board[ranPegOne].size())
            }

            // write out to find one ring 
            // then another and check 
            // System.out.println(ranPegOne);
            // System.out.println(ranPegTwo);
            if (ranPegOne == ranPegTwo) {
                continue;
            } if (board[ranPegOne].size() > 0 && board[ranPegTwo].size() > 0 && (int) (board[ranPegOne].get(0)) > (int) (board[ranPegTwo].get(0))) {
                continue;
            } else if ((board[ranPegOne].size() > 0 && board[ranPegTwo] == null) || (board[ranPegOne].size() > 0 && board[ranPegTwo].size() > 0 && (int) (board[ranPegOne].get(0)) < (int) (board[ranPegTwo].get(0)))) { 
                board[ranPegTwo].add(0, (int)(board[ranPegOne].get(0)));
                board[ranPegOne].remove(0); 
            }
            report(board);

        }
    }





    public static void main(String[] args) {
        System.out.print("Number of Rings: ");
        Scanner getValue = new Scanner(System.in);
        int n = getValue.nextInt(); 
        ArrayList[] board = new ArrayList[3]; 


        setup(board, n);
        bogoSolve(board, 2, n);
        // solve(n,1,3,2);








    }
}
