package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import animalchess.Chick;
import animalchess.Game;
import animalchess.Player;

public class MyPromPieceTests {

    private Game myGame;
    private Player p0;
    private Player p1;

    @Before
    public void setup() {
        p0 = new Player("Michael", 0);
        p1 = new Player("Oz", 1);
        myGame = new Game(p0, p1);
    }

    // Test promote() method in PromotablePiece.java
    // A promoted piece cannot be promoted again
    @Test(expected = IllegalArgumentException.class)
    public void testPromoteAgainFail() {
        Chick ch = new Chick(p1, myGame.getSquare(1, 2));
        assertFalse(ch.getIsPromoted());
        ch.promote();
        assertTrue(ch.getIsPromoted());
        ch.promote();
        fail("the last line was supposed to throw an IllegalArgumentException");
    }
}