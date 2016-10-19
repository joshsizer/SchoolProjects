package gui;

import java.awt.Dimension;

/**
 * A static class that has one method to display the program. This class
 * is static to allow other classes within this package to have access
 * to components within the frame without having to create an instance in
 * the main class. 
 * 
 * @author Josh Sizer
 *
 */
public class GUI {
	protected static Frame frame;
	protected static int perferredWidth = 680;
	protected static int perferredHeight = 480;
	protected static Dimension perferredSize = new Dimension(
			perferredWidth, perferredHeight);
	
	static {
		frame = new Frame();
	}
	
	/**
	 * Starts displaying the GUI
	 */
	public static void display() {
		frame.pack();
		frame.setPreferredSize(perferredSize);
		frame.setVisible(true);
		frame.updateRecipePanel();
	}
}
