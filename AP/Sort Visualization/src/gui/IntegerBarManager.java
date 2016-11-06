package gui;

import java.awt.Dimension;
import java.awt.Point;

/**
 * This is the class that will populate an array of rectangle objects so that the largest
 * data value will live as the rectangle with a height of MAX_HEIGHT and the smallest data
 * value will live as the rectangle with a height of MIN_HEIGHT.
 * 
 * @author Josh Sizer
 *
 */
public class IntegerBarManager {
	private int minHeight;
	private int maxHeight;
	private int width;
	private int gap;
	private double heightScaleFactor;
	private Dimension windowSize;
	private int[] data;
	private int offset;
	
	/**
	 * Creates a IntegerBarManager  
	 * @param data The integer array of data values
	 * @param minHeight the minimum height for the bar representation of the data 
	 * @param maxHeight the maximum height for the bar representation of the data
	 * @param windowSize the size of the window that these bars will be printed to
	 * @param gap the amount of pixels in between each bar
	 */
	public IntegerBarManager(int[] data, int minHeight, int maxHeight, Dimension windowSize, int gap) {
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.gap = gap;
		this.data = data;
		this.windowSize = windowSize;
		calcHeightScaleFactor();
		calcBarWidth();
		calcOffset();
	}
	
	/**
	 * Calculates the scale factor to multiply the current data piece by in order to 
	 * attain a corresponding IntegerBar height
	 */
	private void calcHeightScaleFactor() {
		int range = data[getMaxIndex()] - data[getMinIndex()];
		heightScaleFactor = (double)(maxHeight - minHeight) / (double)range;
	}
	
	/**
	 * Calculates the width of the IntegerBars based on the specified gaps and the 
	 * data set size
	 */
	private void calcBarWidth() {
		int gapTotal = gap * (data.length + 1);
		width = (int)((windowSize.getWidth() - gapTotal) / (double)data.length);
	}
	
	/**
	 * Finds the index of the smallest value in the array by doing a linear search.
	 * @return The index of the smallest value in the array
	 */
	public int getMinIndex() {
		int min = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] < data[min])
				min = i;
		}
		return min;
	}
	
	/**
	 * Finds the index of the largest value in the array by doing a linear search.
	 * @return The index of the largest value in the array
	 */
	public int getMaxIndex() {
		int max = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] > data[max])
				max = i;
		}
		return max;
	}
	
	/** 
	 * Calculates the appropriate offset for this data set.
	 * Since the IntegerBar representation of the data set involves only positive heights,
	 * this offset the absolute value of the smallest number in the data set, only if
	 * the smallest number in the data set it less than 0. If the smallest number in the data
	 * set is greater than 0, the offset will be zer0. This is so we can scale all the elements
	 * of the data set to be between 0 and the largest value + offset, which we can then
	 * multiply by the heightScaleValue to attain a pixel height representation of the data.
	 */
	public void calcOffset() {
		int minValue = data[getMinIndex()];
		if (minValue < 0) {
			offset = 0 - minValue;
		} else {
			offset = 0;
		}
	}
	
	/**
	 * Generates an array list of IntegerBars that have an appropriate 
	 * height, width, and top left corner.
	 * @return
	 */
	public IntegerBar[] generateRectangles() {
		IntegerBar[] bars = new IntegerBar[data.length];	
		
		for (int i = 0; i < data.length; i++) {
			int height = calcBarHeight(data[i]);
			Dimension size = new Dimension(width, height);
			Point topLeft = calcTopLeft(i, height);
			bars[i] = new IntegerBar(topLeft, size, data[i]);
		}
		return bars;
	}
	
	/**
	 * Determines the height of the bar, based on the elements value plus
	 * the object wide offset.
	 * 
	 * @param barValue The integer value of the current value in the array.
	 * @return The correct height for the current IntegerBar
	 */
	private int calcBarHeight(int barValue) {
		barValue += offset;
		return (int)((double)barValue * heightScaleFactor) + minHeight;
	}
	
	/**
	 * Calculates the top left point of the current IntegerBar based on it's 
	 * index in the data set and it's height.
	 * 
	 * The x position is found by counting the number of gaps and Integer bars that come
	 * before it. The Y position is found by subtracting the window's height by the 
	 * desired height for the current IntegerBar. This is done because the bottom of the 
	 * window's Y-Value is not 0, but actually the window's height.
	 * @param index The current index of the value in the data set.
	 * @param height The desired height for this IntegerBar
	 * @return The point calculated by the index and height.
	 */
	public Point calcTopLeft(int index, int height) {
		int x = calcXPos(index);
		int y = windowSize.height - height;
		return new Point(x, y);
	}
	
	/**
	 * Calculates the X-position of the IntegerBar based on it's position in the data set
	 * @param index The position of the data in the data set.
	 * @return The calculated X position
	 */
	public int calcXPos(int index) {
		return (gap * (index + 1)) + (width * index);
	}
	
	/**
	 * Sets the X position of the inputed IntegerBar based on inputed index.
	 * @param bar The IntegerBar to set the x position for
	 * @param index It's position in the data set
	 */
	public void setXPos(IntegerBar bar, int index) {
		bar.setXPos(calcXPos(index));
	}
}
