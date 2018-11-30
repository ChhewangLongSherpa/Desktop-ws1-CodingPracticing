/** An example actor: a House that moves randomly as its action. 
SOurce: https://courses.cs.washington.edu/courses/cse142/01au/dist/JigglingHouse.java
*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.util.Random;

public class JigglingHouse implements Actor {
  /* the House that we want to make jiggle */
  private House theHouse;

  /* a random number generator */
  private Random randomNumberGenerator;

  /** Create a JigglingHouse from a regular House */
  public JigglingHouse(House h) {
    this.theHouse = h;
    // create a random number generator for this house
    // (hashCode generates a nearly unique integer for each object,
    // which helps make sure that the random numbers generated for this
    // house will be different than for any other house)
    this.randomNumberGenerator = new Random(h.hashCode());
  }

  /** Make the House jiggle a bit. */
  public void doAction(Stage stage) {
    // generate two random numbers between -10 and 10, inclusive
    int randomDeltaX = this.randomNumberGenerator.nextInt(21) - 10;
    int randomDeltaY = this.randomNumberGenerator.nextInt(21) - 10;
    // move the house by that amount
    this.theHouse.moveBy(randomDeltaX, randomDeltaY);
  }

  /** Add the house to the window */
  public void addTo(GWindow w) {
    this.theHouse.addTo(w);
  }

  /** Remove the house from its window */
  public void removeFromWindow() {
    this.theHouse.removeFromWindow();
  }
}