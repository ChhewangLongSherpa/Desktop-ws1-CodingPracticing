/** A class that defines a Tree shape.  (It also implements the Prop
    interface.)  
Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/Tree.java	*/

import uwcse.graphics.*;
import uwcse.animation.*;

import java.awt.Color;

public class Tree implements Prop {
	private Rectangle trunk;
	private Triangle crown;

	/** Creates a new Tree shape at the given location and size.
		@param centerX the center x-coordinate of the tree
		@param bottomY the bottom y-coordinate of the tree
		@param trunkWidth the width of the trunk of the tree
		@param trunkHeight the height of the trunk of the tree
		@param crownWidth the width of the crown of the tree
		@param crownHeight the height of the crown of the tree
	*/
	public Tree(int centerX, int bottomY, 
                    int trunkWidth, int trunkHeight, 
                    int crownWidth, int crownHeight) {
		Color brown = new Color(150, 100, 50);
		this.trunk =
			new Rectangle(centerX - trunkWidth/2,
				      bottomY - trunkHeight,
				      trunkWidth, trunkHeight, brown, true);
		int crownBottom = bottomY - trunkHeight;
                int crownTop = crownBottom - crownHeight;
                int crownLeftX = centerX - crownWidth/2;
                int crownRightX = centerX + crownWidth/2;
		this.crown =
			new Triangle(crownLeftX, crownBottom,
			             centerX, crownTop,
			             crownRightX, crownBottom,
			             Color.green, true);
	}

	/** Displays a tree on a window.
	         @param w    the window to display on */
	public void addTo(GWindow w) {
		this.trunk.addTo(w);
		this.crown.addTo(w);
	}

	/** Displays a tree from its window. */
	public void removeFromWindow() {
		this.trunk.removeFromWindow();
		this.crown.removeFromWindow();
	}

	/** Returns the x coordinate of the center of the tree.
	         @return    the x-coordinate of the center of the tree */
	public int getCenterX() {
		return this.trunk.getX() + this.trunk.getWidth()/2;
	}

	/** Returns the y coordinate of the bottom of the tree.
	         @return    the y-coordinate of the bottom of the tree */
	public int getBottomY() {
		return this.trunk.getY() + this.trunk.getHeight();
	}
}