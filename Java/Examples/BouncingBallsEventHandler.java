/** This class is a helper class to handle mouse or keyboard input
    during the BouncingBalls animation. 
	Source: BouncingBallsEventHandler.java
	*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;
import java.util.Random;

public class BouncingBallsEventHandler implements GWindowEventHandler {
  /** The stage that we're controlling. */
  private Stage theStage;

  /** A random number generator for creating balls. */
  private Random randomNumberGenerator;

  /** The starting location of a mousePressed event */
  private int mouseDownX;
  private int mouseDownY;

  /** Create a new BouncingBallsEventHandler */
  public BouncingBallsEventHandler(Stage s) {
    this.theStage = s;
    this.mouseDownX = -1;
    this.mouseDownY = -1;
    this.randomNumberGenerator = new Random();
  }

  /** Create a new ball wherever the mouse is pressed */
  public void mousePressed(GWindowEvent e) {
    // remember where the mouse went down
    this.mouseDownX = e.getX();
    this.mouseDownY = e.getY();
  }

  /** Give a newly created ball an initial speed based on its dragged
      direction and distance, or a random speed and direction if the
      mouse was simply clicked. */
  public void mouseReleased(GWindowEvent e) {
    int mouseUpX = e.getX();
    int mouseUpY = e.getY();
    int x = this.mouseDownX;
    int y = this.mouseDownY;
    // balls get random diameters between 10 and 20
    int diameter = this.randomNumberGenerator.nextInt(11)+10;
    double velocityX;
    double velocityY;
    if (x == mouseUpX && y == mouseUpY) {
      // the mouse was clicked, not dragged.  so give the new ball a 
      // random initial velocity in the range [-10..10]
      velocityX = this.randomNumberGenerator.nextDouble() * 21 - 10;
      velocityY = this.randomNumberGenerator.nextDouble() * 21 - 10;
    } else {
      // the mouse was dragged, so give the mouse initial velocity 
      // based on the dragging
      velocityX = (mouseUpX - x)/3;
      velocityY = (mouseUpY - y)/3;
    }
    // balls get random colors
    Color color = new Color(this.randomNumberGenerator.nextInt(256),
                            this.randomNumberGenerator.nextInt(256),
                            this.randomNumberGenerator.nextInt(256));
    BouncingBall ball = 
      new BouncingBall(x, y, diameter, color, velocityX, velocityY, 0, 0, 
                       this.theStage.getWidth(), this.theStage.getHeight());
    this.theStage.addActor(ball);
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
      theStage.quitAnimation();
    } else if (key == 's') {
      theStage.suspendAnimation();
    } else if (key == 'r') {
      theStage.resumeAnimation();
    } else if (key == '+') {
      // speed up by cutting the time per round in half
      theStage.setTimeForOneRound(theStage.getTimeForOneRound() / 2);
    } else if (key == '-') {
      // speed up by doubling the time per round
      theStage.setTimeForOneRound(theStage.getTimeForOneRound() * 2);
    } else {
      // we ignore any other keys
    }
  }

  /** Ignore keyReleased events */
  public void keyReleased(GWindowEvent e) {
    // do nothing
  }

  /** Ignore timerExpired events */
  public void timerExpired(GWindowEvent e) {
    // do nothing
  }
}