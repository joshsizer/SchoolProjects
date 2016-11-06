package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

/**
 * The window of this program that contains the drawn data
 * @author Josh Sizer
 *
 */
public class Frame extends JFrame {
	private static final long serialVersionUID = 4743270606172960944L;
	
	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 1200;
	public IntegerBar[] curBars;
	
	/**
	 * Sets up the main container for this program, the frame.
	 * @param title The title of the frame 
	 */
	public Frame(String title) {
		super(title);
		super.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Set the current array list of IntegerBars to be shown to the frame
	 * @param bars
	 */
	public void set(IntegerBar[] bars) {
		curBars = bars;
	}
	
	/**
	 * Draws the currently set IntegerBars. This will set the background
	 * to be completely white before drawing the new bars, otherwise nothing
	 * would display properly.
	 */
	public void paint(Graphics g){
		drawRectangle(g, new Rectangle(new Point(0, 0), new Dimension(Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT)), Color.WHITE);
		for (int i = 0; i < curBars.length; i++) {
			Rectangle bounds = curBars[i].getBounds();
			drawRectangle(g, bounds, Color.RED);
		}
    }
	
	/**
	 * Draws a rectangle to the frame
	 * @param g The graphics component
	 * @param rect The rectangle to draw
	 * @param color The color to draw it in
	 */
	public void drawRectangle(Graphics g, Rectangle rect, Color color) {
		int x = rect.getLocation().x;
		int y = rect.getLocation().y;
		int width = rect.width;
		int height = rect.height;
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
