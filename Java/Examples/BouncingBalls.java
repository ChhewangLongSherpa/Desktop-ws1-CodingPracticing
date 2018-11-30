/** An example animation: a collection of bouncing balls.
Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/BouncingBalls.java */

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;

public class BouncingBalls {
  /** Creates a new box of bouncing balls. */
  public BouncingBalls(Stage s) {
    // add the help message as a prop, all in one line
    String msg = "BouncingBalls! (q to quit, s to stop, r to resume," +
      " + to speed up, - to slow down, " +
      "click or drag to create more balls)";
    s.addProp(new ShapeProp(new TextShape(msg, 10, 5)));
  }

  /** Run the Bouncing Balls animation. */
  public static void test() {
    GWindow window = new GWindow("BouncingBalls!!", 700, 400);
    Stage stage = new Stage(window);
    BouncingBalls l = new BouncingBalls(stage);
    BouncingBallsEventHandler h = new BouncingBallsEventHandler(stage);
    stage.registerEventHandler(h);
    stage.animate();
    stage.close();
  }

}