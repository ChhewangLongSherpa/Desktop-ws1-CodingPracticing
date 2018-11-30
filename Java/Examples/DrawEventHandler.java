//https://courses.cs.washington.edu/courses/cse142/01au/dist/DrawEventHandler.java

/** This class is a helper class to handle mouse or keyboard input for
    the draw. */

import uwcse.graphics.*;

public class DrawEventHandler implements GWindowEventHandler {
  /** The draw that we're controlling. */
  private Draw draw;

  /** Create a new DrawEventHandler */
  public DrawEventHandler(Draw d) {
    this.draw = d;
  }

  /** Tell the drawer that the mouse was clicked */
  public void mousePressed(GWindowEvent e) {
    // e.getX() and e.getY() look up the x and y positions of the mouse
    int mouseX = e.getX();
    int mouseY = e.getY();
    // notify the draw that the mouse was pressed
    this.draw.mousePressed(mouseX, mouseY);
  }

  /** Mouse drag events are just like mouse press events */
  public void mouseDragged(GWindowEvent e) {
    this.mousePressed(e);
  }

  /** Handle different key presses */
  public void keyPressed(GWindowEvent e) {
    // e.getKey() looks up what key was pressed on the keyboard
    char key = e.getKey();
    if (key == '<' || key == '4' /* left arrow on keypad */) {
      // shift the bits left
      this.draw.shiftLeft();
    } else if (key == '^' || key == '8' /* up arrow on keypad */) {
      // shift the bits up
      this.draw.shiftUp();
    } else if (key == '>' || key == '6' /* right arrow on keypad */) {
      // shift the bits right
      this.draw.shiftRight();
    } else if (key == '_' || key == '2' /* down arrow on keypad */) {
      // shift the bits down
      this.draw.shiftDown();
    } else if (key == 'p') {
      // get a new pen color
      this.draw.newPenColor();
    } else {
      // we ignore any other keys
    }
  }

  /** Ignore mouseReleased events */
  public void mouseReleased(GWindowEvent e) {
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