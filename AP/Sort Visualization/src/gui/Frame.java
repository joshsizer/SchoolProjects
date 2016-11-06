package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 4743270606172960944L;
	
	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 1200;
	public IntegerBar[] curBars;
	private int key;
	private int lookingAt;
	
	public Frame(String title) {
		super.setTitle(title);
		super.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void set(IntegerBar[] bars, int key, int lookingAt) {
		curBars = bars;
		this.key = key;
		this.lookingAt = lookingAt;
	}
	
	public void paint(Graphics g){
		drawRectangle(g, new Rectangle(new Point(0, 0), new Dimension(Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT)), Color.WHITE);
		for (int i = 0; i < curBars.length; i++) {
			Color color;
			if (i == key) {
				color = Color.GREEN;
			} else if (i == lookingAt){
				color = Color.BLUE;
			} else {
				color = Color.RED;
			}
			Rectangle bounds = curBars[i].getBounds();
			drawRectangle(g, bounds, color);
		}
    }
	
	public void drawRectangle(Graphics g, Rectangle rect, Color color) {
		int x = rect.getLocation().x;
		int y = rect.getLocation().y;
		int width = rect.width;
		int height = rect.height;
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
