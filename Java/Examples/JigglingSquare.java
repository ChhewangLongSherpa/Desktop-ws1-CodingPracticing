/** A jiggling square actor, for use in the checkerboard animation. */
//https://courses.cs.washington.edu/courses/cse142/01au/dist/JigglingSquare.java
import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;
import java.util.Random;

/** This class is a square in a checkerboard, which jiggles */
class JigglingSquare implements Actor {
  /** the square image */
  private Rectangle theSquare;

  /** the initial position, before jiggling */
  private int initialX;
  private int initialY;

  /** the amount the square can jiggle in any direction */
  private int maxJiggle;

  /* a random number generator */
  private Random randomNums;

  /** Create a new jiggling square with the given upper-left
      coordinates, size, and color */
  public JigglingSquare(int x, int y, int size, Color color) {
    int blankBorder = 1;  // # of pixels around square
    int jiggleBorder = 2; // # of pixels around square that it can jiggle in
    int border = blankBorder + jiggleBorder;  // total border
    this.initialX = x + border;
    this.initialY = y + border;
    this.maxJiggle = jiggleBorder;
    int realSize = size - border*2;
    this.theSquare = new Rectangle(this.initialX, this.initialY, 
                                   realSize, realSize, color, true);
    // create a random number generator for this square
    // (hashCode generates a nearly unique integer for each object,
    // which helps make sure that the random numbers generated for this
    // square will be different than for any other square)
    this.randomNums = new Random(this.hashCode());
  }

  /** Do the jiggle action */
  public void doAction(Stage s) {
    int maxJiggle = this.maxJiggle;
    // generate two random numbers between -maxJiggle and +maxJiggle, inclusive
    int randomDeltaX = this.randomNums.nextInt(maxJiggle*2+1) - maxJiggle;
    int randomDeltaY = this.randomNums.nextInt(maxJiggle*2+1) - maxJiggle;
    // move the house by that amount
    this.theSquare.moveTo(this.initialX + randomDeltaX, 
                          this.initialY + randomDeltaY);
  }

  /** Make the square appear on the window */
  public void addTo(GWindow w) {
    this.theSquare.addTo(w);
  }

  /** Make the square disappear from its window */
  public void removeFromWindow() {
    this.theSquare.removeFromWindow();
  }
}