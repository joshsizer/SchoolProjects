package gui;

import java.awt.Dimension;
import java.awt.Point;

/**
 * This is the class that will populate an array of rectangle objects so that the largest
 * data value will live as the rectangle with a height of MAX_HEIGHT and the smallest data
 * value will live as the rectangle with a height of MIN_HEIGHT.
 * 
 * @author joshs
 *
 */
public class RectangleManager {
	private int minHeight;
	private int maxHeight;
	private int width;
	private int gap;
	private double heightScaleFactor;
	private Dimension windowSize;
	private int[] data;
	private int offset;
	
	/**
	 * 
	 * @param data The integer array of data values
	 * @param minHeight the minimum height for the bar representation of the data 
	 * @param maxHeight the maximum height for the bar representation of the data
	 * @param windowSize the size of the window that these bars will be printed to
	 * @param gap the amount of pixels in between each bar
	 */
	public RectangleManager(int[] data, int minHeight, int maxHeight, Dimension windowSize, int gap) {
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.gap = gap;
		this.data = data;
		this.windowSize = windowSize;
		calcHeightScaleFactor();
		calcBarWidth();
		calcOffset();
	}
	
	public void setXPos(IntegerBar bar, int index) {
		bar.setXPos(calcXPos(index));
	}
	
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
	
	public int calcXPos(int index) {
		return (gap * (index + 1)) + (width * index);
	}
	
	public Point calcTopLeft(int index, int height) {
		int x = calcXPos(index);
		int y = windowSize.height - height;
		return new Point(x, y);
	}
	
	public void calcOffset() {
		int minValue = data[getMinIndex()];
		if (minValue < 0) {
			offset = 0 - minValue;
		} else {
			offset = 0;
		}
	}
	
	public void calcHeightScaleFactor() {
		int range = data[getMaxIndex()] - data[getMinIndex()];
		heightScaleFactor = (double)(maxHeight - minHeight) / (double)range;
	}
	
	private void calcBarWidth() {
		int gapTotal = gap * (data.length + 1);
		width = (int)((windowSize.getWidth() - gapTotal) / (double)data.length);
	}
	
	private int calcBarHeight(int barValue) {
		barValue += offset;
		return (int)((double)barValue * heightScaleFactor) + minHeight;
	}
	
	public int getMinIndex() {
		int min = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] < data[min])
				min = i;
		}
		return min;
	}
	
	public int getMaxIndex() {
		int max = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i] > data[max])
				max = i;
		}
		return max;
	}
}
