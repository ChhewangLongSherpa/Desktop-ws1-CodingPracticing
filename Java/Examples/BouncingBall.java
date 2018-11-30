/** An example actor: a ball that has a position and velocity and than
    bounces off the walls of the stage. 
	Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/BouncingBall.java
	*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;
import java.util.*;

public class BouncingBall implements Actor {
  /** the visual representation of the ball */
  private Oval circle;

  /** the current position of the ball */
  private double x;
  private double y;

  /** the current velocity of the ball */
  private double velocityX;
  private double velocityY;

  /** The min and max X and Y values within which the ball can be displayed */
  private int minX;
  private int minY;
  private int maxX;
  private int maxY;


  /** Create a BouncingBall of the given size and color in the given
      location with the given initial speed, constrained to operate in
      the bounding box described by min/max X/Y. */
  public BouncingBall(int x, int y, int diameter, Color color, 
                      double deltaX, double deltaY, 
                      int minX, int minY, int maxX, int maxY) {
    this.x = x;
    this.y = y;
    this.velocityX = deltaX;
    this.velocityY = deltaY;
    this.minX = minX;
    this.minY = minY;
    this.maxX = maxX;
    this.maxY = maxY;
    this.circle = new Oval(x-diameter/2, y-diameter/2,
                           diameter, diameter, color, true);
  }

  /** Make the ball move, and have it bounce off the walls of the stage. */
  public void doAction(Stage stage) {
    // update the ball's position
    this.x = this.x + this.velocityX;
    this.y = this.y + this.velocityY;

    // now check to see if we've bounced off any walls
    if (this.x < this.minX) {
      // bounced off left wall
      this.x = this.minX + (this.minX - this.x);
      this.velocityX = - this.velocityX;
    }
    if (this.y < this.minY) {
      // bounced off top wall
      this.y = this.minY + (this.minY - this.y);
      this.velocityY = - this.velocityY;
    }
    if (this.x > this.maxX) {
      // bounced off right wall
      this.x = this.maxX - (this.x - this.maxX);
      this.velocityX = - this.velocityX;
    }
    if (this.y > this.maxY) {
      // bounced off bottom wall
      this.y = this.maxY - (this.y - this.maxY);
      this.velocityY = - this.velocityY;
    }

    // move the ball (converting from center to upper-left position)
    int upperLeftX = ((int)this.x) - this.circle.getWidth()/2;
    int upperLeftY = ((int)this.y) - this.circle.getWidth()/2;
    this.circle.moveTo(upperLeftX, upperLeftY);
  }

  /** Add the ball to the window */
  public void addTo(GWindow w) {
    this.circle.addTo(w);
  }

  /** Remove the ball from its window */
  public void removeFromWindow() {
    this.circle.removeFromWindow();
  }
}