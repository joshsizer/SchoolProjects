package gui;

import java.awt.Dimension;

public class GUI {
	private Frame frame;
	protected static int perferredHeight = 400;
	protected static int perferredWidth = 350;
	protected static Dimension perferredSize = new Dimension(
			perferredWidth, perferredHeight);
	
	public GUI() {
		frame = new Frame();
	}
	
	public void display() {
		frame.pack();
		frame.setVisible(true);
	}
}
