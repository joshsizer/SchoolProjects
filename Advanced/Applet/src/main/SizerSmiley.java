package main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Draws a "Smiley" face
 * @author Josh Sizer
 */
public class SizerSmiley extends Applet {
	private Dimension windowSize;
	
	public void paint(Graphics window) {
		windowSize = super.getSize(); // gets the current size of the window
		drawFace(window); // draws the face
	}
	
	public void drawFace(Graphics window) {
		drawHead(window);
		drawMouth(window);
		drawEyes(window);
		drawNose(window);
	}
	
	/**
	 * Draws the head (the circle encompassing the eyes, mouth, and nose)
	 * @param window The applet window
	 */
	private void drawHead(Graphics window) {
		double XPos = (windowSize.getWidth() * 0.05);
		double YPos = (windowSize.getHeight() * 0.05);
		double Width = (windowSize.getWidth() * 0.90);
		double Height = (windowSize.getHeight() * 0.90);
		window.setColor(Color.BLACK);
		window.fillOval((int)XPos, (int)YPos, (int)Width, (int)Height);
		XPos = (windowSize.getWidth() * 0.08);
		YPos = (windowSize.getHeight() * 0.08);
		Width = (windowSize.getWidth() * 0.84);
		Height = (windowSize.getHeight() * 0.84);
		window.setColor(Color.YELLOW);
		window.fillOval((int)XPos, (int)YPos, (int)Width, (int)Height);
	}
	
	/**
	 * Draws the mouth
	 * @param window The applet window
	 */
	private void drawMouth(Graphics window) {
		double XPos = (windowSize.getWidth() * 0.23);
		double YPos = (windowSize.getHeight() * 0.51);
		double Width = (windowSize.getWidth() * 0.55);
		double Height = (windowSize.getHeight() * 0.4);
		window.setColor(Color.BLACK);
		window.fillOval((int)XPos, (int)YPos, (int)Width, (int)Height);
		XPos = (XPos + windowSize.getWidth() * 0.025);
		YPos = (YPos + windowSize.getHeight() * 0.02);
		Width = (Width * 0.91);
		Height = (Height * 0.91);
		window.setColor(Color.RED);
		window.fillOval((int)XPos, (int)YPos, (int)Width, (int)Height);
		XPos = (windowSize.getWidth() * 0.23);
		YPos = (windowSize.getHeight() * 0.51);
		Width = (windowSize.getWidth() * 0.55);
		Height = (windowSize.getHeight() * 0.18);
		window.setColor(Color.yellow);
		window.fillRect((int)XPos, (int)YPos, (int)Width, (int)Height);
		window.setColor(Color.black);
		YPos = YPos + Height;
		window.drawLine((int)XPos, (int)YPos, (int)(XPos + Width), (int)(YPos));
	}
	
	/**
	 * Draws the eyes
	 * @param window The applet window
	 */
	private void drawEyes(Graphics window) {
		double XPos = (windowSize.getWidth() * 0.20);
		double YPos = (windowSize.getHeight() * 0.25);
		double Width = (windowSize.getWidth() * 0.3);
		double Height = (windowSize.getHeight() * 0.35);
		window.setColor(Color.black);
		window.fillOval((int)XPos, (int)YPos, (int)Width, (int)Height);
		XPos = (XPos + windowSize.getWidth() * 0.4);
		YPos = (YPos + windowSize.getHeight() * 0.1);
		Width = (windowSize.getWidth() * 0.25);
		Height = (windowSize.getHeight() * 0.30);
		window.fillOval((int)XPos, (int)YPos, (int)Width, (int)Height);
	}
	
	/**
	 * Draws the nose
	 * @param window The applet window
	 */
	private void drawNose(Graphics window) {
		double XPos = (windowSize.getWidth() * 0.52);
		double YPos = (windowSize.getHeight() * 0.56);
		double Width = (windowSize.getWidth() * 0.07);
		double Height = (windowSize.getHeight() * 0.1);
		window.setColor(Color.black);
		int[] x = {(int) XPos, (int) (XPos + Width), (int) (XPos - Width)};
		int[] y = {(int) YPos, (int) (YPos + Height), (int) (YPos + (windowSize.getHeight() * 0.09))};
		window.fillPolygon(new Polygon(x, y, 3));
	}

}
