/** An example animation: a field of asteroids whose motions obey the
    laws of gravity. 
	Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/Asteroids.java
	*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;

public class Asteroids {
  /** Creates a new asteroid field, on the given stage. */
  public Asteroids(Stage s) {
    // add the help message as a prop, all in one line
    String msg = "Asteroids! (q to quit, s to stop, r to resume," +
      " + to speed up, - to slow down, " +
      "click or drag to create more asteroids)";
    s.addProp(new ShapeProp(new TextShape(msg, 10, 5)));
    // add an initial planet in the center of the window
    Asteroid planet = 
      new Asteroid(s.getWidth()/2, s.getHeight()/2, 25, Color.gray, 0, 0);
    s.addActor(planet);
  }

  /** Run the Asteroid Field animation. */
  public static void test() {
    // create the window on which the animation will run
    GWindow w = new GWindow("Asteroids!!", 700, 400);

    // create the stage
    Stage stage = new Stage(w);

    // create the asteriods animation object
    Asteroids l = new Asteroids(stage);

    // create the handler for input & timer events; register it with the stage
    AsteroidsEventHandler h = new AsteroidsEventHandler(stage);
    stage.registerEventHandler(h);

    // start sending timer events, one every three seconds
    stage.startTimerEvents(3000);

    // if the stage's window is closed, quit the asteroids application
    stage.quitWhenWindowClosed();

    // start the animation
    stage.animate();

    // when the animation finishes, close the window
    stage.close();
  }

  /** Asteroids can be invoked directly, e.g. "java Asteroids", or by
      double-clicking on the Asteroids.jar file.  This calls the
      following main() method. */
  public static void main(String[] args) {
    // just run the test method to run the Asteroids application
    test();
  }

}