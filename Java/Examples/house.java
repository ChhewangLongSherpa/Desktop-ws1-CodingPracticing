/** A class that defines a House shape 
Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/House.java
*/
import uwcse.graphics.*;

import java.awt.Color;

public class House {
	private Rectangle frame;
	private Triangle roof;

	/** Creates a new House shape. */
	public House() {
		int width = 100;
 		int height = 50;
		int leftX = 50;
		int topY = 50;
		int roofHeight = height/2;
		int overhang = 10;
		int roofY = topY + roofHeight;
		this.frame =
			new Rectangle(leftX, roofY, width, height, Color.blue, true);
		this.roof =
			new Triangle(leftX - overhang, roofY,
			             leftX + width/2, topY,
			             leftX + width + overhang, roofY,
			             Color.red, true);
	}

	/** Creates a new House shape at the given location and size.
		@param frameLeft the left edge of the frame
		@param frameTop the top of the frame, and the bottom of the roof 
		@param frameWidth the width of the frame
		                  (the roof is a little wider)
		@param frameHeight the height of the frame
			               (the roof height is half the frame height)
	*/
	public House(int frameLeft, int frameTop, int frameWidth, int frameHeight) {
		int roofHeight = frameHeight/2;
		int topY = frameTop - roofHeight;
		int overhang = 10;
		this.frame =
			new Rectangle(frameLeft, frameTop, frameWidth, frameHeight,
			              Color.blue, true);
		this.roof =
			new Triangle(frameLeft - overhang, frameTop,
			             frameLeft + frameWidth/2, topY,
			             frameLeft + frameWidth + overhang, frameTop,
			             Color.red, true);
	}

	/** Displays a house on a window.
	         @param w    the window to display on */
	public void addTo(GWindow w) {
		this.frame.addTo(w);
		this.roof.addTo(w);
	}

	/** Removes a house from its window. */
	public void removeFromWindow() {
		this.frame.removeFromWindow();
		this.roof.removeFromWindow();
	}

	/** Moves the house.
	         @param deltaX    the change in x-coordinate
	         @param deltaY    the change in y-coordinate
	*/
	public void moveBy(int deltaX, int deltaY) {
	  this.frame.moveBy(deltaX, deltaY);
	  this.roof.moveBy(deltaX, deltaY);
	}

	/** Returns the x coordinate of the left edge of the house's frame.
	         @return    the x-coordinate */
	public int getX() {
		return this.frame.getX();
	}

	/** Returns the y coordinate of the top of the house's frame,
		which is the bottom of the roof.
	         @return    the y-coordinate */
	public int getY() {
		return this.frame.getY();
	}

	/** Returns the x coordinate of the center of the house.
	         @return    the x-coordinate of the center of the house */
	public int getCenterX() {
		return this.frame.getX() + this.frame.getWidth()/2;
	}

	/** Returns the y coordinate of the bottom of the house's frame.
	         @return    the y-coordinate of the bottom of the house */
	public int getBottomY() {
		return this.frame.getY() + this.frame.getHeight();
	}
}