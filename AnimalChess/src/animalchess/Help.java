
package animalchess;

/**
 * A help class for accomplishing some auxiliary functions.
 * 
 * @author 200010781
 * @version 1
 */
public class Help {
    /**
     * A method to check a square is a legal move for the piece or not.
     * 
     * @param game    This game object.
     * @param row     The square's row number.
     * @param col     The square's column number.
     * @param ownerNm The owner number of owner who owns the piece.
     * @return If is legal, return true. If is illegal, return false.
     */
    public static boolean checkSquare(Game game, int row, int col, int ownerNm) {
        boolean isLeagle = false;
        if (game.getSquare(row, col).getPiece() == null) {
            isLeagle = true;
        } else {
            if (game.getSquare(row, col).getPiece().getOwner().getPlayerNumber() == ownerNm) {
                isLeagle = false;
            } else {
                isLeagle = true;
            }
        }
        return isLeagle;

    }

}
