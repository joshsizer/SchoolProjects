package gui;

import java.awt.Dimension;

public class GUI {
	private Frame frame;
	protected static int perferredHeight = 720;
	protected static int perferredWidth = 1280;
	protected static Dimension perferredSize = new Dimension(
			perferredWidth, perferredHeight);
	
	public GUI() {
		frame = new Frame();	
	}
	
	public void display() {
		frame.setSize(perferredSize);
		frame.setVisible(true);
	}
}
