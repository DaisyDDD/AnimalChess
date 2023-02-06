
package animalchess;

/**
 * A class for Cat chess which can be promoted.
 * 
 * @author 200010781
 * @version 1
 */
public class Cat extends PromotablePiece {

    /**
     * A constructor to create a new cat piece.
     * 
     * @param owner  The owner of this cat piece.
     * @param square The first square of this cat piece should be placed at.
     */
    public Cat(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * A setter to set the ArrayList legalMoves of a cat piece.
     */
    @Override
    public void setLegalMoves() {
        // TODO Auto-generated method stub

        // If it's a normal cat, can move straight forward and four diagonal directions
        // If it's promoted, can move straight forwards/backwards, left/right and front
        // diagonal directions

        legalMoves.clear();
        Player ow = getOwner();
        Game gm = ow.getGame();
        Square currentSq = getSquare();
        int row = currentSq.getRow();
        int col = currentSq.getCol();
        int owNum = ow.getPlayerNumber();

        if (this.getIsPromoted()) {
            // Promoted
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

            if (owNum == 0) {
                for (int j = col - 1; j <= col + 1; j += 2) {
                    // For player 0, move down diagonal directions
                    if (j != -1 && j != 5 && row != 5) {
                        if (Help.checkSquare(gm, row + 1, j, owNum)) {
                            legalMoves.add(gm.getSquare(row + 1, j));
                        }
                    }
                }

            } else {
                for (int j = col - 1; j <= col + 1; j += 2) {
                    // For player 1, move up diagonal directions
                    if (j != -1 && j != 5 && row != 0) {
                        if (Help.checkSquare(gm, row - 1, j, owNum)) {
                            legalMoves.add(gm.getSquare(row - 1, j));
                        }
                    }
                }

            }

        } else {
            // Not promoted
            for (int i = row - 1; i <= row + 1; i += 2) {
                // Move four diagonal directions
                for (int j = col - 1; j <= col + 1; j += 2) {
                    if ((i != -1 && i != 6) && (j != -1 && j != 5)) {
                        if (Help.checkSquare(gm, i, j, owNum)) {
                            legalMoves.add(gm.getSquare(i, j));
                        }
                    }
                }
            }

            if (owNum == 0) {
                // For player 0, move straight towards down side
                if ((row != 5) && Help.checkSquare(gm, row + 1, col, owNum)) {
                    legalMoves.add(gm.getSquare(row + 1, col));
                }
            } else {
                // For player 1, move straight towards up side
                if ((row != 0) && Help.checkSquare(gm, row - 1, col, owNum)) {
                    legalMoves.add(gm.getSquare(row - 1, col));
                }
            }
        }

    }

}
