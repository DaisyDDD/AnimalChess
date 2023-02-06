
package animalchess;

/**
 * An abstract class for promotable pieces chess.
 * 
 * @author 200010781
 * @version 1
 */
public abstract class PromotablePiece extends Piece {

    /**
     * A boolean variable to check whether a piece is promoted or not.
     */
    private boolean isPromoted = false;

    /**
     * A constructor for creating a new promotable piece.
     * 
     * @param owner  The owner of this promotable piece.
     * @param square The first location square of this piece.
     */
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * A getter to get whether this piece is promoted or not.
     * 
     * @return The variable representing a piece is promoted or not.
     */
    public boolean getIsPromoted() {
        return isPromoted;
    }

    /**
     * A method to promote a promotable piece.
     * 
     * @throws IllegalArgumentException while this piece is already promoted
     */
    public void promote() {
        if (!isPromoted) {
            setIsPromoted(true);
            legalMoves.clear();
        } else {
            throw new IllegalArgumentException("This piece is promoted already.");
        }
    }

    /**
     * A override method used to move a piece into destination square.
     * 
     * @param toSquare The destination square object.
     */
    @Override
    public void move(Square toSquare) {
        super.move(toSquare);

        if (this.getOwner() == toSquare.getPromotesPlayer()) {
            setIsPromoted(true);
            // this.setLegalMoves();
        }

    }

    /**
     * A override method used when a promotable piece is captured.
     * 
     * @param capturer The player who capture this piece.
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        isPromoted = false;

    }

    /**
     * A setter that set the variable isPromoted.True for promoted, and false for
     * not promoted.
     * 
     * @param isPromoted The boolean variable shows whether a promotable piece is
     *                   promoted or not.
     */
    public void setIsPromoted(boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

}
