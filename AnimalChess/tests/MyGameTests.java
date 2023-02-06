package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import animalchess.Cat;
import animalchess.Game;
import animalchess.Piece;
import animalchess.Player;
import animalchess.Square;

public class MyGameTests {

    private Game myGame;
    private Player p0;
    private Player p1;

    @Before
    public void setup() {
        p0 = new Player("Michael", 0);
        p1 = new Player("Oz", 1);
        myGame = new Game(p0, p1);
    }

    // Test initialGame() method in PromotablePiece.java
    // After creating a new Game object, test Squares number
    @Test
    public void testInitialGameSquare() {
        assertEquals(30, myGame.getMap().size());
    }

    // Test initialGame() method in PromotablePiece.java
    // After creating a new Game object, test pieces on the game board
    @Test
    public void testInitialGamePiece() {
        Square catSquare1 = myGame.getSquare(5, 4);
        Piece cat1 = catSquare1.getPiece();
        assertNotNull(cat1);
        assertTrue(cat1 instanceof Cat);
    }

    // Test initialGame() method in PromotablePiece.java
    // After creating a new Game object, test promotable square on game
    @Test
    public void testInitialGamePromotionSquare() {
        Square catSquare1 = myGame.getSquare(0, 0);
        assertEquals(p1, catSquare1.getPromotesPlayer());
    }
}