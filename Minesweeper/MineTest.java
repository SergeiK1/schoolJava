package Minesweeper;
import java.util.Random;
import java.util.Scanner;


// NOT MY CODE

public class MineTest {

    private static final int SIZE = 10;
    private static final int MINES = 20;
    private char[][] board = new char[SIZE][SIZE];
    private char[][] display = new char[SIZE][SIZE];
    private boolean gameover = false;

    public MineTest() {
        initBoard();
        placeMines();
        initDisplay();
    }

    private void initBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '0';
            }
        }
    }

    private void placeMines() {
        int minesPlaced = 0;
        Random rand = new Random();
        while (minesPlaced < MINES) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);
            if (board[x][y] != '*') {
                board[x][y] = '*';
                minesPlaced++;
            }
        }
    }

    private void initDisplay() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                display[i][j] = '-';
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!gameover) {
            printDisplay();
            System.out.println("Enter your move (x y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (board[x][y] == '*') {
                gameover = true;
                System.out.println("You hit a mine! Game over.");
                printBoard();
            } else {
                reveal(x, y);
                if (checkWin()) {
                    gameover = true;
                    System.out.println("Congratulations! You won.");
                    printBoard();
                }
            }
        }
        scanner.close();
    }

    private void reveal(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || display[x][y] != '-') return;
        if (board[x][y] == '*') return;
        int mines = countMines(x, y);
        if (mines > 0) {
            display[x][y] = (char) (mines + '0');
        } else {
            display[x][y] = ' ';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    reveal(x + i, y + j);
                }
            }
        }
    }

    private int countMines(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i < SIZE && y + j >= 0 && y + j < SIZE && board[x + i][y + j] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (display[i][j] == '-' && board[i][j] != '*') {
                    return false;
                }
            }
        }
        return true;
    }

    private void printDisplay() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(display[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MineTest game = new MineTest();
        game.play();
    }
}
