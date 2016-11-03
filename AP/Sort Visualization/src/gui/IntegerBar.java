package gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * This is the core representation of a piece of data, more specifically an integer.
 * There is a width, which is set at the time of creation, and a height which
 * is proportional to it's value. It will be scaled so that the highest value in
 * the data set will own the rectangle with the maximum height, and the smallest
 * value will own the rectangle with the smallest height. This encapsulates a rectangle
 * plus an integer value, which is used when sorting.
 * 
 * @author joshs
 *
 */
public class IntegerBar extends Rectangle {
	private static final long serialVersionUID = 2477578822881198313L;
	private int int_;
	
	public IntegerBar(Point topLeft, Dimension size, int int_) {
		super(topLeft, size);
		this.int_ = int_;
	}
	
	public int getInt() {
		return this.int_;
	}
	
	public String toString() {
		return "Top left: x = " + this.getLocation().x
				+ " . Y = " + this.getLocation().y;
	}
}
