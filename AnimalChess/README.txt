This archive contains all souces for practical 2, with Help.class and JUnit tests added.
Using IDE to run this project is highly recommended, especially Eclipse IDE, which is my
developing environment.


Project structure
=================
1. All .java files can be found in /src/animalchess package.
2. Personal created JUnit tests can be found in /tests package.


Before running through IDE
==========================
Before running, please put tests package into src directory, so that tests package and 
animalchess package are both locate in CS5001-p2-animal-chess/src/  path.

The reason I did not submit my practical with tests package inside src directory is because 
stacscheck cannot compile org.junit.jupiter.api. So I can only put it outside src directory.

So if you want to use stacscheck, please make sure the tests package is not in src directory.


New-created class and tests description
=========================
1. Help.class is used for some auxiliary functions. One method in it is used for checking whether 
a square is a legal move of a piece or not.

2. I created some extra JUnit tests during programming to test my methods. I tested:
--* initialGame() method in Game.java to test normal squares, promotable squares and number of pieces;
--* promote() method in PromotablePiece.java when a player wants double promoting;
--* checkSquare() method in Help.java to test whether it can work correctly.

