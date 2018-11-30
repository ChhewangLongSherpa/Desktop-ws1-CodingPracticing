/** This class is a helper class to handle mouse or keyboard input
    during the JigglingCheckerboard animation. */
//https://courses.cs.washington.edu/courses/cse142/01au/dist/JigglingCheckerboardEventHandler.java
import uwcse.graphics.*;
import uwcse.animation.*;

public class JigglingCheckerboardEventHandler implements GWindowEventHandler {
  /** The checkerboard that we're controlling. */
  private JigglingCheckerboard theBoard;

  /** Create a new JigglingCheckerboardEventHandler */
  public JigglingCheckerboardEventHandler(JigglingCheckerboard b) {
    this.theBoard = b;
  }

  /** Tell the board that the mouse was clicked */
  public void mousePressed(GWindowEvent e) {
    // e.getX() and e.getY() look up the x and y positions of the mouse
    int mouseX = e.getX();
    int mouseY = e.getY();
    // notify the board that the mouse was pressed
    this.theBoard.mousePressed(mouseX, mouseY);
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
      this.theBoard.getStage().quitAnimation();
    } else if (key == 's') {
      this.theBoard.getStage().suspendAnimation();
    } else if (key == 'r') {
      this.theBoard.getStage().resumeAnimation();
    } else if (key == '+') {
      // speed up by cutting the time per round in half
      this.theBoard.getStage().setTimeForOneRound(
        this.theBoard.getStage().getTimeForOneRound() / 2);
    } else if (key == '-') {
      // speed up by doubling the time per round
      this.theBoard.getStage().setTimeForOneRound(
        this.theBoard.getStage().getTimeForOneRound() * 2);
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