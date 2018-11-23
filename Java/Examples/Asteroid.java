/** An example actor: an Asteroid that is attracted to all other
    Asteroids on the Stage. 
	Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/Asteroid.java*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;
import java.util.*;

public class Asteroid implements Actor {
  /** the visual representation of the asteroid */
  private Oval circle;

  /** the current position of the asteroid */
  private double x;
  private double y;

  /** the current velocity of the asteroid */
  private double velocityX;
  private double velocityY;

  /** Create an Asteroid of the given size and color in the given
      location with the given initial speed. */
  public Asteroid(int x, int y, int diameter, Color color, 
                  double deltaX, double deltaY) {
    this.x = x;
    this.y = y;
    this.velocityX = deltaX;
    this.velocityY = deltaY;
    this.circle = new Oval(x-diameter/2, y-diameter/2,
                           diameter, diameter, color, true);
  }

  /** Make the asteroid move to the other asteroids, based on the
      force of gravity. */
  public void doAction(Stage stage) {
    // first, get all the asteroids in the scene
    ArrayList asteroids = stage.getActors();

    // then go through each asteroid, and compute the force it exerts
    // on this asteroid, in terms of a change to the asteroid's velocity
    Iterator iter = asteroids.iterator();
    while (iter.hasNext()) {
      Asteroid other = (Asteroid)iter.next();
      if (other == this) {
        // an asteroid doesn't exert any forces on itself, so skip this one
      } else {
        // compute the difference in X and Y coordinates between the asteroids
        double deltaX = this.getX() - other.getX();
        double deltaY = this.getY() - other.getY();

        // compute the distance between the asteroids
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        if (distance == 0) {
          // watch out! don't want to compute infinite forces for two 
          // asteroids at the same point, so just skip it

        } else {
          // now compute the force that the other asteroid exerts on this one
          // F = G * m2 / distance^2
          double G = 0.01; // a magic number that seems to work OK in practice
          double force = G * other.getMass() / (distance * distance);

          // now translate that into a tug toward the other asteroid
          // in the x and y directions
          double forcePerDistance = - force / distance;
          double forceX = forcePerDistance * deltaX;
          double forceY = forcePerDistance * deltaY;

          // now add the force to the asteroid's current velocity
          velocityX = velocityX + forceX;
          velocityY = velocityY + forceY;
        }
      }
    }

    // update the asteroid's position
    this.x = this.x + velocityX;
    this.y = this.y + velocityY;

    // move the asteroid (converting from center to upper-left position)
    int upperLeftX = ((int)this.getX()) - this.circle.getWidth()/2;
    int upperLeftY = ((int)this.getY()) - this.circle.getWidth()/2;
    this.circle.moveTo(upperLeftX, upperLeftY);
  }

  /** Return the asteroid's center's X coordinate */
  public double getX() {
    return this.x;
  }

  /** Return the asteroid's center's Y coordinate */
  public double getY() {
    return this.y;
  }

  /** Return the asteroid's "mass" (which is assumed to be equal to
      its volume) */
  public int getMass() {
    // volume of a sphere of radius r = (4/3)* pi * r^3
    int diameter = this.circle.getWidth();
    double radius = diameter/2.0;
    double volume = (4.0/3.0) * 3.1415927 * radius * radius * radius;
    return (int)volume;
  }

  /** Add the asteroid to the window */
  public void addTo(GWindow w) {
    this.circle.addTo(w);
  }

  /** Remove the asteroid from its window */
  public void removeFromWindow() {
    this.circle.removeFromWindow();
  }
}