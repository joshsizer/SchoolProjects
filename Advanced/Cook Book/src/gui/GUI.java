package gui;

import java.awt.Dimension;

public class GUI {
	private Frame frame;
	protected static int perferredHeight = 480;
	protected static int perferredWidth = 640;
	protected static Dimension perferredSize = new Dimension(
			perferredWidth, perferredHeight);
	
	public GUI() {
		frame = new Frame();
		frame.setResizable(false);
	}
	
	public void display() {
		frame.setSize(perferredSize);
		frame.setVisible(true);
	}
}
