
package animalchess;

import java.util.ArrayList;

/**
 * A class for players (usually two players).
 * 
 * @author 200010781
 * @version 1
 */
public class Player {
    /**
     * A game object that player belongs to.
     */
    private Game game;
    /**
     * A variable represents the name of player.
     */
    private String name;
    /**
     * A variable represents the number of player(1/0).
     */
    private int playerNumber;
    /**
     * A boolean variable represents whether a player wins or not.
     */
    private boolean ifWon = false;
    /**
     * An arrayList represents pieces that hold in player.
     */
    private ArrayList<Piece> inHandPiece = new ArrayList<Piece>();

    /**
     * A constructor to create a new player.
     * 
     * @param name         The name of the player.
     * @param playerNumber The number of the player(1/0).
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    /**
     * A getter to get player's name.
     * 
     * @return The name of player.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter to get player's number.
     * 
     * @return The number of player.
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * A getter to get player's in-hand pieces.
     * 
     * @return The arrayList of in-hand pieces inHandPiece.
     */
    public ArrayList<Piece> getHand() {

        return inHandPiece;

    }

    /**
     * A method for adding a piece to player's in-hand piece arrayList.
     * 
     * @param piece The piece that need to add into arrayList.
     */
    public void addPieceToHand(Piece piece) {
        inHandPiece.add(piece);
        piece.getSquare().setPiece(null);
        piece.setSquare(null);

    }

    /**
     * A method for dropping a in-hand piece into a square.
     * 
     * @param piece  The in-hand piece that need to drop.
     * @param square The square that decide drop at.
     */
    public void dropPiece(Piece piece, Square square) {
        if (inHandPiece.contains(piece)) {
            try {
                inHandPiece.remove(piece);
                square.placePiece(piece);
                piece.setSquare(square);
            } catch (IllegalArgumentException e) {
                System.out.print(e);
            }
        } else {
            throw new IllegalArgumentException("There is no such piece in the player's hand");

        }

    }

    /**
     * A method to represent game is over and this player is the winner.
     */
    public void winGame() {
        setHasWon(true);
    }

    /**
     * A method to check whether a player has won or not.
     * 
     * @return The variable ifWon to show whether the player has won(true) or
     *         not(false).
     */
    public boolean hasWon() {
        return ifWon;
    }

    /**
     * A method to set the variable ifWon be true(win) or false(not win).
     * 
     * @param ifWon A boolean variable to represent whether a player wins or not.
     */
    public void setHasWon(boolean ifWon) {
        this.ifWon = ifWon;
    }

    /**
     * A getter to get the game.
     * 
     * @return The game object.
     */
    public Game getGame() {
        return game;
    }

    /**
     * A setter to set the game.
     * 
     * @param game The game object of the player belongs to.
     */
    public void setGame(Game game) {
        this.game = game;
    }

}
