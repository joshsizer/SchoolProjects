package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 4743270606172960944L;
	
	public static final int WINDOW_HEIGHT = 800;
	public static final int WINDOW_WIDTH = 1200;
	private IntegerBar[] bars;
	
	public Frame(IntegerBar[] bars) {
		super.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		super.setResizable(false);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.bars = bars;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		for (IntegerBar cur : bars) {
			Rectangle bounds = cur.getBounds();
			int x = (int) bounds.getLocation().getX();
			int y = (int) bounds.getLocation().getY();
			int width = (int) bounds.getSize().getWidth();
			int height = (int) bounds.getSize().getHeight();
			g.fillRect(x, y, width, height);
		}
	}
}
