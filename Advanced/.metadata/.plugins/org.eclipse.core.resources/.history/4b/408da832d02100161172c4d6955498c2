package gui;

import java.awt.Dimension;

public class GUI {
	protected static Frame frame;
	protected static int perferredWidth = 680;
	protected static int perferredHeight = 480;
	protected static Dimension perferredSize = new Dimension(
			perferredWidth, perferredHeight);
	
	static {
		frame = new Frame();
	}
	
	public static void display() {
		frame.pack();
		frame.setPreferredSize(perferredSize);
		frame.setVisible(true);
		frame.repaint();
	}
}
