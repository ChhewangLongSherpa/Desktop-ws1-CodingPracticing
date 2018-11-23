/* See README.TXT for information about this software 
Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/ShapeProp.java
*/

package uwcse.animation;

/** This is a prop that is just one of the standard Shapes from the
    Graphics library, e.g. Rectangle, Oval, etc. */

import uwcse.graphics.*;

public class ShapeProp implements Prop {
  private Shape theShape;

  /** Create a new ShapeProp, given a standard shape from the UWCSE
      graphics library (e.g., a Rectangle, Oval, Triangle, Line, or
      Polygon) */
  public ShapeProp(Shape shape) {
    this.theShape = shape;
  }

  /** Add the shape to the window */
  public void addTo(GWindow w) {
    this.theShape.addTo(w);
  }

  /** Remove the shape from its window */
  public void removeFromWindow() {
    this.theShape.removeFromWindow();
  }
}