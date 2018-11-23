/** An example animation: a Landscape whose Houses jiggle, but whose
    other shapes do not.
Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/JigglingLandscape.java
	*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;

public class JigglingLandscape {
  /** Creates a new landscape that can jiggle, on the given stage. */
  public JigglingLandscape(Stage s) {
    int groundY = s.getHeight() - 100;

    // Add a rising sun actor (i.e. it moves).
    // Put it first to make it behind the ground.
    s.addActor(new RisingSun(10, groundY+30, 40, 30, Color.orange, 2, -2));

    // Add the ground as a prop (i.e., it doesn't move).
    // Add it early so the later shapes appear on top of it.
    Rectangle ground = 
      new Rectangle(0, groundY, s.getWidth(), 50, Color.green, true);
    s.addProp(new ShapeProp(ground));

    // Add the first house actor.
    House h1 = new House(75, groundY-50, 100, 50);
    JigglingHouse jh1 = new JigglingHouse(h1);
    s.addActor(jh1);

    // Add the second house actor, all in one line.
    s.addActor(new JigglingHouse(new House(250, groundY-100, 120, 100)));

    // Add a tree as a prop, all in one line.
    s.addProp(new Tree(500, groundY, 20, 30, 75, 100));

    // Add the help message as a prop.
    String msg = "Earthquake! (q to quit, s to stop, r to resume," +
      " + to speed up, - to slow down, click to create more houses)";
    s.addProp(new ShapeProp(new TextShape(msg, 10, groundY+55)));
  }

  /** Run the Jiggling Landscape animation! */
  public static void test() {
    GWindow window = new GWindow("Earthquake!!", 600, 400);
    Stage stage = new Stage(window);
    JigglingLandscape l = new JigglingLandscape(stage);
    JigglingLandscapeEventHandler h = new JigglingLandscapeEventHandler(stage);
    stage.registerEventHandler(h);
    stage.animate();
    stage.close();
  }

}