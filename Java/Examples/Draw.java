/** A class that displays a bitmap and lets drawing be done. */
//https://courses.cs.washington.edu/courses/cse142/01au/dist/Draw.java

import uwcse.graphics.*;
import java.awt.Color;
import java.util.Random;

public class Draw {
  private Bitmap bitmap;  // the bitmap

  private Color penColor; // the current color to paint

  private Random random; // a random number generator

  public Draw(GWindow w) {
      // create a bitmap to fill the window
      int pixelSize = 10; // the size in real pixels of each cell of the bitmap
      int width = w.getWindowWidth() / pixelSize;
      int height = (w.getWindowHeight()-20) / pixelSize;
      this.bitmap = new Bitmap(0, 0, width, height, pixelSize, Color.blue);

      // add the bitmap to the window
      this.bitmap.addTo(w);

      // add some instructions to the window
      String msg = "Type p to change pen color, </4 to shift left, ^/8 to shift up, >/6 to shift right, and _/2 to shift down";
      TextShape instructions = new TextShape(msg, 10, w.getWindowHeight()-18);
      instructions.addTo(w);

      // start the pen colored red
      this.penColor = Color.red;

      // register event handler for drawing
      DrawEventHandler h = new DrawEventHandler(this);
      w.addEventHandler(h);

      // create a new random number generator
      this.random = new Random();
  }

  /** respond to a mouse press event by painting a pixel */
  public void mousePressed(int x, int y) {
    this.bitmap.colorPixelFromCoordinates(x, y, this.penColor);
  }

  /** respond to a shift-left key press event */
  public void shiftLeft() {
    this.bitmap.shiftLeft(this.penColor);
  }

  /** respond to a shift-up key press event */
  public void shiftUp() {
    this.bitmap.shiftUp(this.penColor);
  }

  /** respond to a shift-right key press event */
  public void shiftRight() {
    this.bitmap.shiftRight(this.penColor);
  }

  /** respond to a shift-down key press event */
  public void shiftDown() {
    this.bitmap.shiftDown(this.penColor);
  }

  /** respond to a new pen color key press event */
  public void newPenColor() {
    Color randomColor = new Color(this.random.nextInt(256),
				  this.random.nextInt(256),
				  this.random.nextInt(256));
    this.penColor = randomColor;
  }

  /** A test method */
  public static void test() {
    GWindow w = new GWindow(650,500);
    Draw d = new Draw(w);
  }
}
