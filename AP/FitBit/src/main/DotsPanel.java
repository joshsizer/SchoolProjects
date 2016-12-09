//********************************************************************
//  DotsPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents the primary panel for the Dots program on which the
//  dots are drawn.
//********************************************************************
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

public class DotsPanel extends JPanel {
	private final int WIDTH = 600, HEIGHT = 600;

	private ImagePanel background;


	// -----------------------------------------------------------------
	// Sets up this panel to listen for mouse events.
	// -----------------------------------------------------------------
	public DotsPanel() {
		background = new ImagePanel(new File("stars-02.jpg"));
		
		add(background);
		

		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	// -----------------------------------------------------------------
	// Draws all of the dots stored in the list.
	// -----------------------------------------------------------------
	
}
