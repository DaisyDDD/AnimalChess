
package animalchess;

import java.util.ArrayList;

/**
 * An abstract class for all pieces chess.
 * 
 * @author 200010781
 * @version 1
 */
public abstract class Piece {
    /**
     * A player object that represents the owner of this piece.
     */
    private Player owner;
    /**
     * A square object that represents the location of this piece.
     */
    private Square square;
    /**
     * An arrayList that represents all legal moves of this piece.
     */
    protected ArrayList<Square> legalMoves = new ArrayList<Square>();

    /**
     * A constructor to create a piece.
     * 
     * @param owner  The owner of this piece.
     * @param square The location square of this piece.
     * @throws IllegalArgumentException when the location square is occupied.
     */
    public Piece(Player owner, Square square) {
        if (square.getPiece() == null) {
            this.setOwner(owner);
            this.setSquare(square);
            square.setPiece(this);
        } else {
            throw new IllegalArgumentException("The Square is occupied!!");
        }
    }

    /**
     * A getter for getting this piece's legal moves.
     * 
     * @return this piece's legal moves arrayList.
     */
    public ArrayList<Square> getLegalMoves() {
        this.setLegalMoves();
        return legalMoves;
    }

    /**
     * A method to move a piece to next square.
     * 
     * @param toSquare The square object of the expected location.
     */
    public void move(Square toSquare) {
        // if (getLegalMoves().contains(toSquare))

        try {
            if (toSquare.getPiece() != null) {
                toSquare.getPiece().beCaptured(owner);
            }
            this.getSquare().removePiece();
            legalMoves.clear();
            setSquare(toSquare);
            toSquare.placePiece(this);
        } catch (IllegalArgumentException e) {
            System.out.print(e);
        }
    }

    /**
     * A method used when this piece is captured by the other player.
     * 
     * @param capturer The player object of the other player.
     */
    public void beCaptured(Player capturer) {
        setOwner(capturer);
        capturer.addPieceToHand(this);
    }

    /**
     * A getter to get the owner of this piece.
     * 
     * @return The owner object.
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * A getter to get this piece's locating square.
     * 
     * @return The piece's locating square object.
     */
    public Square getSquare() {
        return square;
    }

    /**
     * A setter to set this piece's owner.
     * 
     * @param owner The owner of this piece.
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * A setter to set this piece's location square.
     * 
     * @param square The piece's location square.
     */
    public void setSquare(Square square) {
        this.square = square;
    }

    /**
     * An abstract method for setting legal moves for piece.
     */
    public abstract void setLegalMoves();
}
