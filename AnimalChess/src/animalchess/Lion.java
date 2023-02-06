package animalchess;

/**
 * A class for Lion chess which can end the game if captured.
 * 
 * @author 200010781
 * @version 1
 */
public class Lion extends Piece {
    /**
     * A constructor to create a new lion piece.
     * 
     * @param owner  The owner of this lion piece.
     * @param square The first square of this lion piece should be placed at.
     */
    public Lion(Player owner, Square square) {
        // try catch a exception
        super(owner, square);

    }

    /**
     * A method for declaring this lion piece is captured by the other player who
     * wins the game.
     * 
     * @param capturer The player who capture this lion piece.
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);

        capturer.winGame();
    }

    /**
     * A setter to set the ArrayList legalMoves of a lion piece.
     */
    @Override
    public void setLegalMoves() {
        // TODO Auto-generated method stub

        // Can move to all 8 different directions

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

        for (int i = row - 1; i <= row + 1; i += 2) {
            // Move to four diagonal directions
            for (int j = col - 1; j <= col + 1; j += 2) {

                if ((i != -1 && i != 6) && (j != -1 && j != 5)) {
                    if (Help.checkSquare(gm, i, j, owNum)) {
                        legalMoves.add(gm.getSquare(i, j));
                    }
                }
            }
        }

    }

}
