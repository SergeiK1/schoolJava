package Minesweeper;
import java.util.Scanner;
// import for dialog boxes
import javax.swing.JOptionPane;
import javax.swing.JButton;
// import for making a window
import javax.swing.JFrame;

import java.awt.Color;
// import for the Graphics object that actually draws
import java.awt.Graphics;

// import for drawable JPanel object
import javax.swing.JPanel;
import java.awt.event.*;  
import javax.swing.*;    
import java.awt.GridLayout;



public class Minesweeper{




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

        public void handelClick(int x, int y, Board board, JButton clickedButton){
            System.out.println("Clicked: " + x + "," + y);

            if (isMine){
                System.out.println("-----  Game Over  -----");
                clickedButton.setText("*");
                // end game 
            }
            
            else if(isFlagged){
                System.out.println("Flagged");
                // do nothing 
            }
            else if (!isRevealed){
                System.out.println("Reveal");
                isRevealed = true;
                // set the button to number or blank

                // find number of adjacent mines
                for (int i = x-1; i <= x+1; i++){
                    for (int j = y-1; j <= y+1; j++){
                        // checks one block radius off of selected cell
                        // !!! Needs error handeling for border cells
                       if (board.getCells()[i][j].isMine){
                            adjacentMines +=1; // if detects mine in a one block radius it adds to the adjacentMines int 
                       }
                    }
                }
                System.out.println("# adjacent mines = " + adjacentMines);
                clickedButton.setText(Integer.toString(adjacentMines));
            }


        }
        

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



    public class DrawPanel extends JPanel {

        // note no main method because this class does not automatically run
    
        // single method for drawing
        public void paintComponent(Graphics g) {
    
            // calls upon method of the same name that parent JPanel already has
            super.paintComponent(g);
    
            // JPanel also has getter methods (accessors) for its own dimensions
            int width = getWidth();
            int height = getHeight();
    
        }
    
    }

    public class UI { // user interface and all the visuals and user input handeling

        public void drawBoard(Board board){
            // makes the visuals 


            // graphics in window demo
            
            // construct a new frame/window
            JFrame window = new JFrame();
            
            // and construct a drawable area within it 
            DrawPanel panel = new DrawPanel(); // condense if not used to just JPanel panel = new JPanel();
            panel.setBackground(Color.black);
            panel.setLayout(new GridLayout(board.getCells().length, board.getCells()[0].length)); // Set layout to grid (visual)
            for (int x = 0; x < board.getCells().length; x++){
                for (int y = 0; y < board.getCells()[x].length; y++){
                    // JButton b = new JButton(Integer.toString(x)+ ", " +Integer.toString(y)); //tracking button coords
                    JButton b = new JButton(" "); // makes a button for each cell 
                    b.setActionCommand(x + "," + y); // Set the action command to the coordinates
                    b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  // change based on event e ?? input coords as the event e ?? --> or make the ui button creation within the cell creation (but thats lowkey mixing so maybe not) 
                            String command = e.getActionCommand(); // gets coords 
                            JButton clickedButton = (JButton) e.getSource(); // Get the source of the click
                            // System.out.println("Button clicked at: " + command);
                            int comma = command.indexOf(",");
                            int x = Integer.parseInt(command.substring(0,comma));
                            int y = Integer.parseInt(command.substring(comma+1));
                            Cell clickedCell = board.getCells()[x][y];
                            clickedCell.handelClick(x, y, board, clickedButton); 
                        }  
                    });  
                    panel.add(b);

                }
            }
            
            // add the drawable area to the window
            window.add(panel);
            
            // set other properties of the window
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(500, 500); // change to be responsive to number of buttons and make the size unchangable 
            window.setVisible(true);
            



        }
    }




    public static void main(String[] args){ // Main function

        Minesweeper minesweeper = new Minesweeper(); // initiate outer function >> internet suggestion

        Game testGame = minesweeper.new Game(3); // creates a new game 


        testGame.startGame();




    }



}