/** An example animation: a Checkerboard whose squares jiggle and
    which can have pieces placed on it.  (But it doesn't follow the
    rules of checkers.) */
//https://courses.cs.washington.edu/courses/cse142/01au/dist/JigglingCheckerboard.java
import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;
import java.util.Random;

public class JigglingCheckerboard {
  /** the stage */
  private Stage theStage;

  /** the dimensions of the checkerboard */
  int numRows;
  int numCols;
  int squareSize;

  /** which player is adding a checker next (0 or 1) */
  int playerNumber;

  /** the instructions, which change as the player changes */
  ShapeProp instructions;

  /** the state of the board elements */
  Checker[][] checkers;

  /** Creates a new jiggling checkerboard.
      @param numRows the number of rows in the checkerboard 
      @param numCols the number of columns in the checkerboard 
      @param squareSize the size in pixels of each square in the board */
  public JigglingCheckerboard(int numRows, int numCols, int squareSize) {
    this.numRows = numRows;
    this.numCols = numCols;
    this.squareSize = squareSize;

    // the height of the legend at the bottom of the screen
    int legendHeight = 30;

    // create the stage
    GWindow window = new GWindow("Checkers",
				 numCols * squareSize, 
				 numRows * squareSize + legendHeight);
    this.theStage = new Stage(window);

    // install an input event handler
    JigglingCheckerboardEventHandler h =
      new JigglingCheckerboardEventHandler(this);
    this.theStage.registerEventHandler(h);
    
    // draw the background grid
    for (int row = 0; row < numRows; row ++) {
      // add a horizontal line separating rows, including a bottom row
      int y = (row + 1) * squareSize;
      int leftX = 0;
      int rightX = numCols * squareSize;
      Line horizontalLine = new Line(leftX, y, rightX, y, Color.black);
      this.theStage.addProp(new ShapeProp(horizontalLine));
    }
    for (int col = 0; col < numCols-1; col ++) {
      // add a vertical line separating columns, but 
      // we don't need a right edge line, so stop at numCols-1
      int x = (col + 1) * squareSize;
      int topY = 0;
      int bottomY = numRows * squareSize;
      Line verticalLine = new Line(x, topY, x, bottomY, Color.black);
      this.theStage.addProp(new ShapeProp(verticalLine));
    }
    
    // add in the red and black jiggling squares
    for (int row = 0; row < numRows; row ++) {
      for (int col = 0; col < numCols; col ++) {
        // decide the color of the square
        Color squareColor;
        if ((row + col) % 2 == 0) {
          squareColor = Color.red;
        } else {
          squareColor = Color.black;
        }
        int upperLeftX = col * squareSize;
        int upperLeftY = row * squareSize;
        JigglingSquare square =
          new JigglingSquare(upperLeftX, upperLeftY, squareSize, squareColor);
        this.theStage.addActor(square);
      }
    }

    // create the checkers grid, initialized to null
    this.checkers = new Checker[numRows][numCols];

    // start off with player 0
    this.playerNumber = 0;

    // print the instructions
    this.printInstructions();
  }

  /** return the stage */
  Stage getStage() {
    return this.theStage;
  }

  /** Place a piece on the square where the mouse was clicked */
  public void mousePressed(int x, int y) {
    // figure out which square the mouse was clicked in
    int row = y / this.squareSize;
    int col = x / this.squareSize;

    if (row >= this.numRows || col >= this.numCols) {
      // off the edge of the board; ignore this mouse click
      return;
    }

    // see if there's a piece already stored at that position
    Checker checker = this.checkers[row][col];
    
    if (checker != null) {
      // there's already a piece there; ignore this click
      // [we could make a beep sound if we wanted, or
      // we could add a text shape with an error message]
      return;
    }

    // no checker already there, so create one
    checker = new Checker(col * this.squareSize,
                          row * this.squareSize, 
                          this.squareSize, this.playerNumber);

    // add the checker to the stage
    this.theStage.addProp(checker);

    // remember that we've placed a checker
    checkers[row][col] = checker;

    // go to next player
    this.nextPlayer();
  }

  /** Update the player number */
  private void nextPlayer() {
    int numPlayers = 2;
    this.playerNumber = (this.playerNumber + 1) % numPlayers;
    this.printInstructions();
  }

  /** Print the instructions */
  private void printInstructions() {
    if (this.instructions != null) {
      // remove the old instructions
      this.theStage.removeProp(this.instructions);
    }

    // create the (new) instructions (a text prop)
    String msg =
      "Player " + (this.playerNumber+1) +
      ": click on a square to place your piece";
    Color playerColor;
    if (playerNumber == 0) {
      playerColor = Color.blue;
    } else {
      playerColor = Color.green;
    }
    TextShape legend = 
	new TextShape(msg, 50, this.theStage.getHeight() - 25, playerColor);
    ShapeProp prop = new ShapeProp(legend);

    // add the text prop to the stage
    this.theStage.addProp(prop);

    // remember the text prop, so we can remove it later
    this.instructions = prop;
  }

  /** Run the animation */
  public void run() {
    this.theStage.animate();
    this.theStage.close();
  }

  /** Run the Jiggling Checkerboard animation */
  public static void test() {
    JigglingCheckerboard board = new JigglingCheckerboard(8, 8, 50);
    board.run();
  }

}