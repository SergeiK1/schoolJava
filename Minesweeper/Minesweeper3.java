package Minesweeper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Minesweeper3 {

    public class Cell{
        // Attributes for defining each cell on the board
        private boolean isMine, isFlagged, isRevealed, setFlag;
        private int adjacentMines;
        private int x, y;
        private JButton button; 
        private Game game;


        // New Cell creation
        public Cell(int xIn, int yIn, boolean isMineIn, Game gameIn){
            x = xIn;
            y = yIn;
            isMine = isMineIn;
            isFlagged = false;
            isRevealed = false;
            setFlag = false;
            button = new JButton();
            game = gameIn;

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
                    game.gameOver(false);
                    
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
        private String winLoseText =" [   New Game   ]      ";


        // Game Getters
        public boolean getGameStatus() { return gameGoing; }
        public int getDifficulty() { return difficulty; }

        // Game Setter
        public boolean setGameStatus(boolean status) {gameGoing = status; return gameGoing;}

        // Start Game Method
        public void startGame(int difficultyIn) {
            difficulty = difficultyIn;
            gameGoing = false;
            switch (difficulty) { // defines main parameters of game
                case 1:
                    width = 10;
                    height = 10;
                    mineChance = 0.1;
                    break;
                case 2:
                    width = 20;
                    height = 20;
                    mineChance = 0.12;
                    break;
                case 3:
                    width = 30;
                    height = 30;
                    mineChance = 0.14;
                    break;
                default:
                    System.out.println("Difficulty Error NOT (1-3): " + difficulty);
            }

            cells = new Cell[width][height]; // creates an array of cell classes


            gameGoing = true;
            // Board board = new Board(width, height, mineChance);
            UI ui = new UI();
            ui.drawBoard(cells, mineChance, this);
        }

        
        public void startNewGame(){
            // New Frame popup for new game 
            // Create and set up the window
            JFrame frame = new JFrame("Game Difficulty Selection");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 100);
            frame.setLayout(new FlowLayout());


            // Win / Lose Announcement
            JLabel winLoseLabel = new JLabel();
            winLoseLabel.setText(winLoseText);
            winLoseLabel.setFont(new Font("Arial", Font.BOLD, 24));
            frame.add(winLoseLabel);


            // Difficulty selection label
            JLabel textLabel = new JLabel("Select Difficulty");
            textLabel.setFont(new Font("Arial", Font.BOLD, 14));
            frame.add(textLabel);

            // Radio buttons for difficulty selection
            JRadioButton difficulty1 = new JRadioButton("1");
            JRadioButton difficulty2 = new JRadioButton("2");
            JRadioButton difficulty3 = new JRadioButton("3");


            // Add radio buttons to the frame
            frame.add(difficulty1);
            frame.add(difficulty2);
            frame.add(difficulty3);

            // Group the radio buttons
            ButtonGroup group = new ButtonGroup();
            group.add(difficulty1);
            group.add(difficulty2);
            group.add(difficulty3);

            // New Game button
            JButton newGameButton = new JButton("New Game");
            frame.add(newGameButton);

            // Action listener for the New Game button
            newGameButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int difficulty = 1;
                    if (difficulty2.isSelected()) {
                        difficulty = 2;
                    } else if (difficulty3.isSelected()) {
                        difficulty = 3;
                    }
                    // Add logic to start a new game with the selected difficulty
                    System.out.println("Starting new game with difficulty: " + difficulty);

                    //Start new game
                    startGame(difficulty);

                }
            });
            // Display the window
            frame.setVisible(true);
        }


        public void gameOver(boolean win) {
            gameGoing = false;
            System.out.println("GAME OVER ");
            if (win) {winLoseText = "[   VICTORY   ]     ";} else { winLoseText = "[   DEATH   ]     ";}
            startNewGame();

        }
    }
    

    // User Interface class for handling visuals and user input
    public class UI {
        public void drawBoard(Cell[][] cells, double mineChance, Game game) {
            JFrame window = new JFrame();
            JPanel panel = new JPanel();
            panel.setBackground(Color.black);
            panel.setLayout(new GridLayout(cells.length, cells[0].length));
            boolean clear = true; // necessary for when hitting a mine so it doesnt infa looop

            // Create new grid of cells
            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    boolean isMine = Math.random() < mineChance;

                    Cell cell = new Cell(x, y, isMine, game); // creates a new cell

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
        Game game = minesweeper.new Game();
        game.startNewGame();
    }
}
