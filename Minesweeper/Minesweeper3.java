package Minesweeper;
import javax.swing.*;
import java.awt.*;



public class Minesweeper3 {





    public class Cell{
        // Attributes for defining each cell on the board
        private boolean isMine, isFlagged, isRevealed, setFlag;
        private int adjacentMines;
        private int x, y;
        private JButton button; 


        // New Cell creation
        public Cell(int xIn, int yIn, boolean isMineIn){
            x = xIn;
            y = yIn;
            isMine = isMineIn;
            isFlagged = false;
            isRevealed = false;
            setFlag = false;
            button = new JButton();

            // button visuals
            button.setBackground(new Color(237, 155, 51));
            button.setOpaque(true);
            button.setBorder(BorderFactory.createLineBorder(new Color(5, 28, 44), 1));
            button.setForeground(new Color(5, 28, 44));
        }



        // Getters for the cell attributes
        public JButton getButton() { return button; }
        public boolean getIsMine() { return isMine; }
        public boolean getIsFlagged() { return isFlagged; }
        public boolean getIsRevealed() { return isRevealed; }
        public int getAdjacentMines() { return adjacentMines; }
        public int getX() { return x; }
        public int getY() { return y; }



        public void handleCellClick(Cell[][] cells, boolean clear){

            if (isMine) { // Mine logic
                System.out.println("MINE HIT");
                button.setBackground(new Color(255, 112, 69));
                button.setText("*");

                
                if (clear) {
                    clear = false;
                    for (int x = 0; x < cells.length; x++) { // this infinite loops cause it keeps hitting mines 
                        for (int y = 0; y < cells[x].length; y++) {
                            try {
                                cells[x][y].handleCellClick(cells, clear);
                                } catch (Exception e) {
                                    System.out.println("Error: " + e );
                                } 
                        }
                    }
                }
                // add game over logic
                return;


            } else if (isFlagged) { // flagged logic
                System.out.println("Null: Flagged");
                // add flag logic
                return;


            } else if (!isRevealed) { // unopened blank cell logic
                isRevealed = true;

                // calculates # of adjacent mines
                for (int i = x - 1; i <= x + 1; i++) { // Four loops through all adjacent cells
                    for (int j = y - 1; j <= y + 1; j++) {
                        try {
                            if (cells[i][j].isMine) {
                                adjacentMines++;
                            }
                        } catch (Exception e) { // error handeling for corners
                            System.out.println("Error: " + e);
                        }
                    }
                }

                button.setText(Integer.toString(adjacentMines));


                if (adjacentMines == 0) {
                button.setText(" ");
                button.setBackground(new Color(5, 28, 44)); // Example color
                button.setOpaque(true);
                button.setBorderPainted(false);
                    System.out.println("ZERO");
                    // For Loops through all adjacent cells
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            try {
                            cells[i][j].handleCellClick(cells, clear);
                            } catch (Exception e) {
                                System.out.println("Error: " + e );
                            }

                        }
                    }
                }
            }
        }
    }

    // Main game class that controls the game flow
    public class Game {
        //attributes of overall game
        private boolean gameGoing;
        private int difficulty, width, height;
        private double mineChance;
        private Cell[][] cells;


        // creation of a new game based on difficulty 
        public Game(int difficultyIn) {
            difficulty = difficultyIn;
            gameGoing = false;
            switch (difficulty) { // defines main parameters of game
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
                    mineChance = 0.1;
                    break;
                default:
                    System.out.println("Difficulty Error NOT (1-3): " + difficulty);
            }

            cells = new Cell[width][height]; // creates an array of cell classes
        }


        // Game Getters
        public boolean getGameStatus() { return gameGoing; }
        public int getDifficulty() { return difficulty; }

        // Game Setter
        public boolean setGameStatus(boolean status) {gameGoing = status; return gameGoing;}



        // Start Game Method
        public void startGame() {
            gameGoing = true;
            // Board board = new Board(width, height, mineChance);
            UI ui = new UI();
            ui.drawBoard(cells, mineChance);
        }
    }

    // User Interface class for handling visuals and user input
    public class UI {
        public void drawBoard(Cell[][] cells, double mineChance) {
            JFrame window = new JFrame();
            JPanel panel = new JPanel();
            panel.setBackground(Color.black);
            panel.setLayout(new GridLayout(cells.length, cells[0].length));
            boolean clear = true;

            // Create new grid of cells
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    boolean isMine = Math.random() < mineChance;

                    Cell cell = new Cell(x, y, isMine); // creates a new cell

                    cell.getButton().addActionListener(e -> { // create the button action listener to detect onclick
                        cell.handleCellClick(cells, clear);
                    });

                    cells[x][y] = cell; // push to overall cell array
                
                    panel.add(cell.getButton()); // add the buttons to the ui panel
                }
            }

            window.add(panel);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(500, 500);
            window.setVisible(true);
        }
    }

    // Main method to start the Minesweeper game
    public static void main(String[] args) {
        Minesweeper3 minesweeper = new Minesweeper3();
        Game testGame = minesweeper.new Game(3);
        testGame.startGame();


        // Main game loop
        while (testGame.getGameStatus()) {
            // Game logic here
        }
    }
}
