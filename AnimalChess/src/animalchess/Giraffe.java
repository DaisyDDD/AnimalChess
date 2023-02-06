
package animalchess;

/**
 * A class for Giraffe chess.
 * 
 * @author 200010781
 * @version 1
 */
public class Giraffe extends Piece {

    /**
     * A constructor to create a new giraffe piece.
     * 
     * @param owner  The owner of this giraffe piece.
     * @param square The first square of this giraffe piece should be placed at.
     */
    public Giraffe(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * A setter to set the ArrayList legalMoves of a giraffe piece.
     */
    @Override
    public void setLegalMoves() {
        // Can move straight forwards/backwards and left/right

        legalMoves.clear();

        Player ow = getOwner();
        Game gm = ow.getGame();
        Square currentSq = getSquare();
        int row = currentSq.getRow();
        int col = currentSq.getCol();
        int owNum = ow.getPlayerNumber();

        for (int i = row - 1; i <= row + 1; i += 2) {
            // Move forwards and backwards
            if (i != -1 && i != 6) {
                if (Help.checkSquare(gm, i, col, owNum)) {
                    legalMoves.add(gm.getSquare(i, col));
                }
            }
        }

        for (int j = col - 1; j <= col + 1; j += 2) {
            // Move left and right
            if (j != -1 && j != 5) {
                if (Help.checkSquare(gm, row, j, owNum)) {
                    legalMoves.add(gm.getSquare(row, j));
                }
            }
        }

    }
}
