package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import animalchess.Game;
import animalchess.Help;
import animalchess.Player;

public class MyHelpTests {

    private Game myGame;
    private Player p0;
    private Player p1;

    @Before
    public void setup() {
        p0 = new Player("Michael", 0);
        p1 = new Player("Oz", 1);
        myGame = new Game(p0, p1);
    }

    // Test checkSquare() method in Help.java
    // P0's chick cannot move to its right side
    @Test
    public void testCheckSquareFail() {
        // Chick chick0 = (Chick) myGame.getSquare(2, 3).getPiece();
        assertFalse(Help.checkSquare(myGame, 2, 2, 0));
    }

    // Test checkSquare() method in Help.java
    // p0's chick can move forward
    @Test
    public void testCheckSquare() {
        assertTrue(Help.checkSquare(myGame, 3, 3, 0));
    }

}