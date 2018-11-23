/** This class is a helper class to handle mouse or keyboard input
    during the Asteroids animation. 
	Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/AsteroidsEventHandler.java
	*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;
import java.util.Random;

public class AsteroidsEventHandler implements GWindowEventHandler {
  /** The stage that we're controlling. */
  private Stage theStage;

  /** A random number generator for creating asteroids. */
  private Random randomNumberGenerator;

  /** The starting location of a mousePressed event */
  private int mouseDownX;
  private int mouseDownY;

  /** Create a new AsteroidsEventHandler */
  public AsteroidsEventHandler(Stage s) {
    this.theStage = s;
    this.mouseDownX = -1;
    this.mouseDownY = -1;
    this.randomNumberGenerator = new Random();
  }

  /** Create a new Asteroid wherever the mouse is pressed */
  public void mousePressed(GWindowEvent e) {
    // remember where the mouse went down
    this.mouseDownX = e.getX();
    this.mouseDownY = e.getY();
  }

  /** Give a newly created Asteroid an initial speed based on its
      dragged direction and distance */
  public void mouseReleased(GWindowEvent e) {
    int mouseUpX = e.getX();
    int mouseUpY = e.getY();
    int x = this.mouseDownX;
    int y = this.mouseDownY;
    // asteroids get random diameters between 5 to 10
    int diameter = this.randomNumberGenerator.nextInt(6)+5;
    int deltaX = (mouseUpX - x)/5;
    int deltaY = (mouseUpY - y)/5;
    // asteroids get random colors
    Color color = new Color(this.randomNumberGenerator.nextInt(256),
                            this.randomNumberGenerator.nextInt(256),
                            this.randomNumberGenerator.nextInt(256));
    Asteroid asteroid = new Asteroid(x, y, diameter, color, deltaX, deltaY);
    this.theStage.addActor(asteroid);
  }

  /** Ignore mouseDragged events */
  public void mouseDragged(GWindowEvent e) {
    // do nothing
  }

  /** If 'q' is typed, then quit the animation.
      If 's' is typed, then suspend the animation.
      If 'r' is typed, then resume the animation.
      If '+' is typed, then speed up the animation.
      If '-' is typed, then slow down the animation.
      Otherwise, ignore the key. */
  public void keyPressed(GWindowEvent e) {
    // e.getKey() looks up what key was pressed on the keyboard
    char key = e.getKey();
    if (key == 'q') {
      this.theStage.quitAnimation();
    } else if (key == 's') {
      this.theStage.suspendAnimation();
    } else if (key == 'r') {
      this.theStage.resumeAnimation();
    } else if (key == '+') {
      // speed up by cutting the time per round in half
      this.theStage.setTimeForOneRound(this.theStage.getTimeForOneRound() / 2);
    } else if (key == '-') {
      // speed up by doubling the time per round
      this.theStage.setTimeForOneRound(this.theStage.getTimeForOneRound() * 2);
    } else {
      // we ignore any other keys
    }
  }

  /** Ignore keyReleased events */
  public void keyReleased(GWindowEvent e) {
    // do nothing
  }

  /** Create a new asteroid periodically */
  public void timerExpired(GWindowEvent e) {
    // asteroids get random initial positions
    int x = this.randomNumberGenerator.nextInt(this.theStage.getWidth());
    int y = this.randomNumberGenerator.nextInt(this.theStage.getHeight());
    // asteroids get random initial velocities between -2..2
    int deltaX = this.randomNumberGenerator.nextInt(5)-2;
    int deltaY = this.randomNumberGenerator.nextInt(5)-2;
    // asteroids get random diameters between 5 to 10
    int diameter = this.randomNumberGenerator.nextInt(6)+5;
    // asteroids get random colors
    Color color = new Color(this.randomNumberGenerator.nextInt(256),
                            this.randomNumberGenerator.nextInt(256),
                            this.randomNumberGenerator.nextInt(256));
    Asteroid asteroid = new Asteroid(x, y, diameter, color, deltaX, deltaY);
    this.theStage.addActor(asteroid);
  }
}