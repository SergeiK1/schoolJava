import java.util.Scanner;

public class Minesweeper{


    public class Cell {
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

    public class Board {

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
                    if(Math.random() < mineChance){
                        isMine = true;
                    }
                    cells[x][y] = new Cell(isMine);
                }
            }
        }


    }


    public class Game {
        private char gameStatus; // "w" - win    "l" - lose  "o" - ongoing
        private int difficulty; // "1 2 3" --> "easy medium hard"



        public char getGameStatus(){return gameStatus;};
        public int getDifficulty(){return difficulty;};

    }

    public class UI {

        public void drawBoard(){
            // makes the visuals 
        }
        public void userInput(){
            // handel user input
        }
    }




    public static void main(String[] args){ // Main function



    }



}