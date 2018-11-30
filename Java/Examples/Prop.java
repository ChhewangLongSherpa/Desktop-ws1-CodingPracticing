/* See README.TXT for information about this software 
Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/Prop.java
*/

package uwcse.animation;

/** The basic interface for a prop in an animation. */

import uwcse.graphics.*;

public interface Prop {
  /** Every Prop must be able to draw itself on a GWindow. */
  public void addTo(GWindow w);

  /** Every Prop must be able to remove itself from its GWindow. */
  public void removeFromWindow();
}