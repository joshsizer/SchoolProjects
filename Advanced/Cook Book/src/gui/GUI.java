package gui;

import java.awt.Dimension;

public class GUI {
	private Frame frame;
	
	public GUI() {
		frame = new Frame();	
	}
	
	public void display() {
		Dimension frameSize = new Dimension(1280, 720);
		frame.setSize(frameSize);
		frame.setVisible(true);
	}
}
