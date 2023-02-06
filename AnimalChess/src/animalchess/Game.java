
package animalchess;

import java.util.ArrayList;

/**
 * A class for whole chess game.
 * 
 * @author 200010781
 * @version 1
 */
public class Game {
    /**
     * A constant variable created to set game row number.
     */
    private static final int HEIGHT = 6;
    /**
     * A constant variable created to set game column number.
     */
    private static final int WIDTH = 5;
    /**
     * A player object that represents the first player.
     */
    private Player p0;
    /**
     * A player object that represents the second player.
     */
    private Player p1;
    /**
     * An arrayList for all 30 game squares to be stored.
     */
    private ArrayList<Square> map = new ArrayList<Square>();

    /**
     * A constructor for creating a new game.
     * 
     * @param p0 The first player sitting on the top.
     * @param p1 The second player sitting on the bottom.
     */
    public Game(Player p0, Player p1) {
        this.p0 = p0;
        this.p1 = p1;
        p0.setGame(this); // Set player0's game to be this game
        p1.setGame(this); // Set player0's game to be this game
        this.initialGame();

    }

    /**
     * A method to initial a game when creating a new game. Creates 30 squares at
     * first and then places all piece.
     * 
     */
    public void initialGame() {

        // Firstly, creates all squares
        // Secondly, places all pieces
        int row, col;

        for (row = 0; row < HEIGHT; row++) {
            for (col = 0; col < WIDTH; col++) {
                Square sq;
                // Create 30 squares;
                if (row < 2) {
                    sq = new Square(this, row, col, p1);
                } else if (row > 3) {
                    sq = new Square(this, row, col, p0);
                } else {
                    sq = new Square(this, row, col);
                }
                map.add(sq);
            }
        }

        for (int i = 0; i < map.size(); i++) {
            // Place pieces;
            // Set pieces to be NULL for squares that have no piece at first
            Square sq = map.get(i);
            row = sq.getRow();
            col = sq.getCol();

            if (row == 0) {
                if (col == 0 || col == 4) {
                    new Cat(p0, sq);
                } else if (col == 1 || col == 3) {
                    new Giraffe(p0, sq);
                } else {
                    new Lion(p0, sq);
                }
            } else if (row == 2) {
                if (col >= 1 && col <= 3) {
                    new Chick(p0, sq);
                }
            } else if (row == 3) {
                if (col >= 1 && col <= 3) {
                    new Chick(p1, sq);
                }
            } else if (row == 5) {
                if (col == 0 || col == 4) {
                    new Cat(p1, sq);
                } else if (col == 1 || col == 3) {
                    new Giraffe(p1, sq);
                } else {
                    new Lion(p1, sq);
                }
            } else {
                sq.setPiece(null);
            }
        }

    }

    /**
     * A method to get player object according to its number.
     * 
     * @param playerNumber The number of a specific player (0/1).
     * @return The object of the specific player.
     * @throws IllegalArgumentException when there is a wrong player number.
     */
    public Player getPlayer(int playerNumber) {

        if (p0.getPlayerNumber() == playerNumber) {
            return p0;
        } else if (p1.getPlayerNumber() == playerNumber) {
            return p1;
        } else {
            throw new IllegalArgumentException("The player number can only be 0 or 1!");
        }
    }

    /**
     * A getter for getting the game winner.
     * 
     * @return The winner object.
     */
    public Player getWinner() {
        if (p0.hasWon()) {
            return p0;
        } else if (p1.hasWon()) {
            return p1;
        } else {
            // throw new IllegalArgumentException("Nobody wins now!");
            return null;
        }

    }

    /**
     * A getter for getting a specific square according to row and column.
     * 
     * @param row The row number of the specific square.
     * @param col The column number of the specific square.
     * @return The object of the specific with the same row and column number. If
     *         there is no such square,return null.
     */
    public Square getSquare(int row, int col) {

        Square square = null;
        for (int i = 0; i < map.size(); i++) {
            Square sq = map.get(i);
            if (sq.getRow() == row && sq.getCol() == col) {
                square = sq;
                break;
            }
        }
        return square;

    }

    /**
     * A method to add square to ArrayList map.
     * 
     * @param sq The square to be added in to ArrayList map.
     */
    public void addMap(Square sq) {
        map.add(sq);
    }

    /**
     * A method to get ArrayList map that stores all the squares.
     * 
     * @return ArrayList map that stores all the squares
     */
    public ArrayList<Square> getMap() {
        return map;
    }

}
