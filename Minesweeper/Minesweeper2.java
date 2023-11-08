package Minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Minesweeper2 {

    // Represents an individual cell on the Minesweeper board
    public class Cell {
        private boolean isMine, isFlagged, isRevealed;
        private int adjacentMines;

        public Cell(boolean isMineIn) {
            isMine = isMineIn;
            isFlagged = false;
            isRevealed = false;
        }

        // Getters for cell properties
        public boolean getIsMine() { return isMine; }
        public boolean getIsFlagged() { return isFlagged; }
        public boolean getIsRevealed() { return isRevealed; }
        public int getAdjacentMines() { return adjacentMines; }

        // Handles the click action on a cell
        public void handleCellClick(int x, int y, Board board, JButton clickedButton) {
            System.out.println("Clicked: " + x + "," + y);

            if (isMine) {
                System.out.println("-----  Game Over  -----");
                clickedButton.setText("*");
                // Game over logic here
            } else if (isFlagged) {
                // Do nothing if flagged
            } else if (!isRevealed) {
                isRevealed = true;
                // Reveal cell logic here

                // Calculate adjacent mines
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        try {
                            if (board.getCells()[i][j].isMine) {
                                adjacentMines++;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e);
                        }
                    }
                }
                System.out.println("# adjacent mines = " + adjacentMines);
                clickedButton.setText(Integer.toString(adjacentMines));

                // If no adjacent mines, recursively reveal surrounding cells
                if (adjacentMines == 0) {
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            handleCellClick(i, j, board, clickedButton);
                        }
                    }
                }
            }
        }
    }

    // Represents the Minesweeper board
    public class Board {
        private Cell[][] cells;
        private int width, height;
        private double mineChance;

        public Board(int difficulty) {
            // Set board parameters based on difficulty
            switch (difficulty) {
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
                default:
                    System.out.println("Difficulty Error NOT (1-3): " + difficulty);
            }

            // Initialize cells with mines based on mineChance
            cells = new Cell[width][height];
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    cells[x][y] = new Cell(Math.random() < mineChance);
                }
            }
        }

        public Cell[][] getCells() { return cells; }
    }

    // Main game class that controls the game flow
    public class Game {
        private boolean gameGoing;
        private int difficulty;

        public Game(int difficultyIn) {
            difficulty = difficultyIn;
            gameGoing = false;
        }

        public boolean getGameStatus() { return gameGoing; }
        public int getDifficulty() { return difficulty; }

        public void startGame() {
            gameGoing = true;
            Board board = new Board(difficulty);
            UI ui = new UI();
            ui.drawBoard(board);
        }
    }

    // User Interface class for handling visuals and user input
    public class UI {
        public void drawBoard(Board board) {
            JFrame window = new JFrame();
            JPanel panel = new JPanel();
            panel.setBackground(Color.black);
            panel.setLayout(new GridLayout(board.getCells().length, board.getCells()[0].length));

            // Create buttons for each cell
            for (int x = 0; x < board.getCells().length; x++) {
                for (int y = 0; y < board.getCells()[x].length; y++) {
                    JButton b = new JButton(" ");
                    b.setActionCommand(x + "," + y);
                    b.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String command = e.getActionCommand();
                            JButton clickedButton = (JButton) e.getSource();
                            int comma = command.indexOf(",");
                            int x = Integer.parseInt(command.substring(0, comma));
                            int y = Integer.parseInt(command.substring(comma + 1));
                            Cell clickedCell = board.getCells()[x][y];
                            clickedCell.handleCellClick(x, y, board, clickedButton);
                        }
                    });
                    panel.add(b);
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
        Minesweeper2 minesweeper = new Minesweeper2();
        Game testGame = minesweeper.new Game(1);
        testGame.startGame();

        // Main game loop
        while (testGame.getGameStatus()) {
            // Game logic here
        }
    }
}
