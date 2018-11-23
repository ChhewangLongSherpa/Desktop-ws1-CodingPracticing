/** An example actor: a Sun that rises.
Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/RisingSun.java
 */

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;

public class RisingSun implements Actor {
  /** the sun's image */
  private Oval theSun;

  /** the velocity */
  private int deltaX;
  private int deltaY;

  /** Create a rising sun object, at the given initial center
      position, size, and color, with the given velocity. */
  public RisingSun(int x, int y, int width, int height, Color color,
                   int deltaX, int deltaY) {
    this.theSun = new Oval(x-width/2, y-height/2, width, height, color, true);
    this.deltaX = deltaX;
    this.deltaY = deltaY;
  }

  /** Make the sun rise. */
  public void doAction(Stage stage) {
    this.theSun.moveBy(this.deltaX, this.deltaY);
  }

  /** Add the sun to the window */
  public void addTo(GWindow w) {
    this.theSun.addTo(w);
  }

  /** Remove the sun from its window */
  public void removeFromWindow() {
    this.theSun.removeFromWindow();
  }
}