/** A piece to place in the checkerboard animation */
//https://courses.cs.washington.edu/courses/cse142/01au/dist/Checker.java

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;

/** This class implements a piece on the board */
class Checker implements Prop {
  Oval ring;
  Oval disk;

  /** Create a checker in in the given square for the given player */
  public Checker(int x, int y, int squareSize, int playerNumber) {
    int ringBorder = 5;
    int ringDiameter = squareSize - (ringBorder*2);
    int ringThickness = 2;
    int diskBorder = ringBorder + ringThickness;
    int diskDiameter = squareSize - (diskBorder*2);

    Color ringColor;
    Color diskColor;
    if (playerNumber == 0) {
      ringColor = Color.green;
      diskColor = Color.blue;
    } else {
      ringColor = Color.blue;
      diskColor = Color.green;
    }

    this.ring =
      new Oval(x+ringBorder, y+ringBorder, ringDiameter, ringDiameter,
               ringColor, true);
    this.disk =
      new Oval(x+diskBorder, y+diskBorder, diskDiameter, diskDiameter,
               diskColor, true);
  }

  /** Add the checker to the window */
  public void addTo(GWindow w) {
    this.ring.addTo(w);
    this.disk.addTo(w);
  }

  /** Remove the checker from the window */
  public void removeFromWindow() {
    this.ring.removeFromWindow();
    this.disk.removeFromWindow();
  }
}