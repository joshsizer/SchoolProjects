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
public class RectangleMaker {
	public static final int MAX_HEIGHT = Frame.WINDOW_HEIGHT - 10;
	public static final int MIN_HEIGHT = 10;
	public static final int MIN_WIDTH = 10;
	public static final int MAX_WIDTH = Frame.WINDOW_WIDTH - 50;
	
	
	public static IntegerBar[] generateRectangles(int[] data) {
		int gap = 30;
		int min = 0;
		int max = 0;
		double width;
		double scaleFactorHeight;
		int range;
		int gapTotal;
		IntegerBar[] bars = new IntegerBar[data.length];
		
		// Finds the smallest and largest value in the data set
		for (int i = 1; i < data.length; i++) {
			if (data[i] < data[min])
				min = i;
			else if (data[i] > data[max])
				max = i;
		}
		
		gapTotal = gap * (data.length + 1);
		width = (double)(Frame.WINDOW_WIDTH - gapTotal) / data.length;
		range = data[max] - data[min];
		scaleFactorHeight = (double)(Frame.WINDOW_HEIGHT - 50) / range;
		
		for (int i = 0; i < data.length; i++) {
			int dataChunk = data[i];
			if (data[min] < 0) {
				dataChunk += Math.abs(data[min]) + 20;
			}
			int height = (int) ((double)(dataChunk) * scaleFactorHeight);
			Point bottomRight;
			Point topRight;
			if (i == 0)
				bottomRight = new Point(gap, MAX_HEIGHT);
			else
				bottomRight = new Point(((i + 1) * gap) + (int)(i * width), MAX_HEIGHT);
			
			topRight = new Point(bottomRight.x,(bottomRight.y - height));
			
			bars[i] = new IntegerBar(topRight, new Dimension((int) width, height), data[i]);
		}
		return bars;
	}
}
