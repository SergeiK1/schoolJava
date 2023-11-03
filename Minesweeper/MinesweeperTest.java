package Minesweeper;
import java.io.IOException;
import java.util.Scanner;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;
import org.jline.utils.NonBlockingReader;

public class MinesweeperTest{


    public class Cell { // each individual cell or tile that is being revelead and flagged 
        private boolean isMine, isFlagged, isRevealed; 
        private int adjacentMines; 

        public Cell(boolean isMineIn){
            isMine= isMineIn;
            isFlagged = false;
            isRevealed = false;
        }

        public boolean getIsMine(){return isMine;};
        public boolean getIsFlagged(){return isFlagged;};
        public boolean getIsRevealed(){return isRevealed;};
        public int getAdjacentMines(){return adjacentMines;};


        

    }

    public class Board { // the data of the board containing all the cells 

        private Cell[][] cells; 
        private int width, height;
        private double mineChance;

        public Board(int difficulty){
            switch (difficulty){
                case 1:
                    width = 10;
                    height = 10;
                    mineChance = 0.15;
                    break;
                case 2: 
                    width = 15;
                    height = 15;
                    mineChance = 0.2;
                    break;
                case 3: 
                    width = 20;
                    height = 20;
                    mineChance = 0.25;
                    break;
                default: // if difficulty is not 1-3 error handeling 
                    System.out.println("Difficulty Error NOT (1-3): "+difficulty);
            }
            cells = new Cell[width][height];
            for (int x = 0; x < width; x++){
                for (int y = 0; y < height; y++){
                    boolean isMine = false;
                    if(Math.random() < mineChance){ // randomly selects if that cell is a mine 
                        isMine = true;
                    }
                    cells[x][y] = new Cell(isMine); // double for loop to input fill up the board with class `cells`
                }
            }
        }

        public Cell[][] getCells() {return cells;};


    }


    public class Game { // main game functions and overal loop / functionality 
        private char gameStatus; // "w" - win    "l" - lose  "o" - ongoing  "x" - not started
        private int difficulty; // "1 2 3" --> "easy medium hard"

        public Game(int difficultyIn){
            difficulty = difficultyIn;
            gameStatus = 'x';
        }

        public char getGameStatus(){return gameStatus;};
        public int getDifficulty(){return difficulty;};

        public void startGame(){
            // create board
            gameStatus = 'o';
            Board board = new Board(difficulty);
            UI ui = new UI();
            ui.drawBoard(board);

        }

    }


    public class UI {
        private Terminal terminal;
        private NonBlockingReader reader;
        private int currentX = 0;
        private int currentY = 0;

        public UI() throws IOException {
            terminal = TerminalBuilder.builder()
                .system(true)
                .build();
            reader = terminal.reader();
        }

        public void drawBoard(Board board) {
            terminal.puts(InfoCmp.Capability.clear_screen);
            // ... Draw the board with the cursor at currentX, currentY ...
        }

        public void listenToArrowKeys(Board board) throws IOException {
            drawBoard(board);
            boolean running = true;
            while (running) {
                int key = reader.read();
                switch (key) {
                    case NonBlockingReader.LEFT:
                        currentX = Math.max(0, currentX - 1);
                        break;
                    case NonBlockingReader.RIGHT:
                        currentX = Math.min(board.getWidth() - 1, currentX + 1);
                        break;
                    case NonBlockingReader.UP:
                        currentY = Math.max(0, currentY - 1);
                        break;
                    case NonBlockingReader.DOWN:
                        currentY = Math.min(board.getHeight() - 1, currentY + 1);
                        break;
                    case 'q': // Quit on 'q' key press
                        running = false;
                        break;
                    // Add more cases to handle other keys like Enter for revealing a cell
                }
                drawBoard(board);
            }
        }

        public void closeTerminal() throws IOException {
            reader.close();
            terminal.close();
        }
    }



    // public class UI { // user interface and all the visuals and user input handeling

    //     public void drawBoard(Board board){
    //         // makes the visuals 

    //         for (int x = 0; x < board.getCells().length; x++){
    //             for (int y = 0; y < board.getCells()[x].length; y++){
    //                 System.out.print("#  ");
    //             }
    //             System.out.print("\n");

    //         }
    //     }
    //     public void userInput(){
    //         // handel user input
    //     }
    // }




    public static void main(String[] args){ // Main function

        MinesweeperTest minesweeper = new MinesweeperTest(); // initiate outer function >> internet suggestion

        Game testGame = minesweeper.new Game(2); // creates a new game 

        testGame.startGame();




    }



}