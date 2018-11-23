/* See README.TXT for information about this software 
Source:https://courses.cs.washington.edu/courses/cse142/01au/dist/Actor.java
*/

package uwcse.animation;

/** The basic interface for an actor in an animation. */

import uwcse.graphics.*;

public interface Actor {
  /** Every Actor must implement some fundamental action.
      @param stage the stage on which the actor is performing. */
  public void doAction(Stage stage);

  /** Every Actor must be able to draw itself on a GWindow. */
  public void addTo(GWindow w);

  /** Every Actor must be able to remove itself from its GWindow. */
  public void removeFromWindow();
}