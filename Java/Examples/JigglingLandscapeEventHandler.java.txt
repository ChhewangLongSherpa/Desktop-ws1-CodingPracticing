/** This class is a helper class to handle mouse or keyboard input
    during the JigglingLandscape animation. 
	Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/JigglingLandscapeEventHandler.java
	*/

import uwcse.graphics.*;
import uwcse.animation.*;

class JigglingLandscapeEventHandler implements GWindowEventHandler {
  /** The stage that we're controlling. */
  private Stage theStage;

  /** Create a new JigglingLandscapeEventHandler */
  public JigglingLandscapeEventHandler(Stage s) {
    this.theStage = s;
  }

  /** Create a new House wherever the mouse was clicked */
  public void mousePressed(GWindowEvent e) {
    // e.getX() and e.getY() look up the x and y positions of the mouse
    int mouseX = e.getX();
    int mouseY = e.getY();
    House h = new House(mouseX, mouseY, 100, 75);
    JigglingHouse jh = new JigglingHouse(h);
    this.theStage.addActor(jh);
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

  /** Ignore mouseReleased events */
  public void mouseReleased(GWindowEvent e) {
    // do nothing
  }

  /** Ignore mouseDragged events */
  public void mouseDragged(GWindowEvent e) {
    // do nothing
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
