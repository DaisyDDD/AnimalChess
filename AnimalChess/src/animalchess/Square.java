
package animalchess;

/**
 * A class for Square (at most 6*5=30).
 * 
 * @author 200010781
 * @version 1
 */
public class Square {

    /**
     * A variable represents square's row number.
     */
    private int row;
    /**
     * A variable represents square's column number.
     */
    private int col;
    /**
     * A game object represents the game that square belongs to.
     */
    private Game game;
    /**
     * A piece object represents the piece on this square(if empty,is null).
     */
    private Piece piece = null;

    /**
     * A player that can promote his/her piece on this square.
     */
    private Player promotesPlayer = null;

    /**
     * A constructor to create a new square.
     * 
     * @param game The game that this square belongs to.
     * @param row  The row number of this square.
     * @param col  The column number of this square.
     */
    public Square(Game game, int row, int col) {
        this.setGame(game);
        this.setRow(row);
        this.setCol(col);
    }

    /**
     * A constructor to create a new square that is promotion region.
     * 
     * @param game           The game that this square belongs to.
     * @param row            The row number of this square.
     * @param col            The column number of this square.
     * @param promotesPlayer The player that can promote his/her piece at this
     *                       square.
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.setGame(game);
        this.setRow(row);
        this.setCol(col);
        this.setPromotesPlayer(promotesPlayer);
    }

    /**
     * A method used to place piece at this square.
     * 
     * @param piece The piece to be placed at this square.
     * @throws IllegalArgumentException if this square is occupied.
     */
    public void placePiece(Piece piece) {
        if (this.piece == null) {
            this.piece = piece;
        } else {
            throw new IllegalArgumentException("The square is occupied!");
        }
    }

    /**
     * A method to remove piece on this square.
     * 
     * @throws IllegalArgumentException if this square has no piece.
     */
    public void removePiece() {
        if (this.piece != null) {
            piece = null;
        } else {
            throw new IllegalArgumentException("The square is already empty!");
        }
    }

    /**
     * A method to check this square is promotion zone for specific player.
     * 
     * @param player The player to check whether is promotion zone for him/her.
     * @return A boolean value. If it is, return true.Otherwise, return false.
     */
    public boolean isPromotionZone(Player player) {
        boolean isPromotaionZone = false;
        if (this.getPromotesPlayer() == player) {
            isPromotaionZone = true;
        } else {
            isPromotaionZone = false;
        }
        return isPromotaionZone;
    }

    /**
     * A getter to get game object that this square belongs to.
     * 
     * @return The game object this square belongs to.
     */
    public Game getGame() {
        return game;
    }

    /**
     * A setter to set game object that this square belongs to.
     * 
     * @param game The game object this square belongs to.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * A getter to get the piece on this square.
     * 
     * @return The piece object on this square.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * A setter to set piece on this square.
     * 
     * @param pc The piece to be located on this square.
     */
    public void setPiece(Piece pc) {
        this.piece = pc;
    }

    /**
     * A getter to get square's row number.
     * 
     * @return The row number of this square.
     */
    public int getRow() {
        return row;
    }

    /**
     * A setter to set square's row number.
     * 
     * @param row The row number of this square.
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * A getter to get square's column number.
     * 
     * @return The column number of this square.
     */
    public int getCol() {
        return col;
    }

    /**
     * A setter to set square's column number.
     * 
     * @param col The column number of this square.
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * A getter to get square's player who can promote piece.
     * 
     * @return The player who can promote piece.
     */
    public Player getPromotesPlayer() {
        return promotesPlayer;
    }

    /**
     * A setter to set square's player who can promote piece.
     * 
     * @param promotesPlayer The player who can promote piece.
     */
    public void setPromotesPlayer(Player promotesPlayer) {
        this.promotesPlayer = promotesPlayer;
    }
}
