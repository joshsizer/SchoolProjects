package main;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author 18jsizer
 *
 */
public class Frame extends JFrame {
	private static final long serialVersionUID = 1400966800860689104L;
	public Dimension panelSize;
	public Dimension buttonSize;
	public JPanel panel;
	public JButton theButton;
	public JLabel clicks;
	public int numClicks;
	
	public Frame() {
		super("Click this Button. I dare you.");
		
		panelSize = new Dimension(800, 450);
		buttonSize = new Dimension(90, 30);
		panel = new JPanel();
		panel.setPreferredSize(panelSize);
		panel.setLayout(null);
		panel.addMouseListener(new ClickListener());
		
		clicks = new JLabel("Clicks: 0");
		clicks.setSize(90, 15);
		clicks.setLocation(new Point(0, 0));
		
		theButton = new JButton("Click me!");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(panelSize);
		setResizable(false);
		
		theButton.setSize(buttonSize);
		// center the button at the start
		theButton.setLocation(
				(panelSize.width/2) - (buttonSize.width/2),
				(panelSize.height/2) - (buttonSize.height/2));
		theButton.addMouseListener(new MouseIntersectListener());
		theButton.addActionListener(new ButtonListener());
		
		panel.add(clicks);
		panel.add(theButton);
		getContentPane().add(panel);
		
		numClicks = 0;
	}
	
	/**
	 * Starts showing the GUI
	 */
	public void display() {
		pack();
		setVisible(true);
	}
	
	/**
	 * 
	 * @author 18jsizer
	 * Handles the movement of the button if the cursor moved onto it.
	 */
	public class MouseIntersectListener implements MouseListener {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// calculate the next x and y coordinates to move the button to
			int x = (int)(Math.random() * (panelSize.width - buttonSize.width));
			int y = (int)(Math.random() * (panelSize.height - buttonSize.height));
			
			// find the button's current location
			Point loc = theButton.getLocation();
			
			// ensures that the button's abs(Dx) and abs(Dy) are greater than the 
			// button's size
			while ((x > loc.x - theButton.getSize().width && x < loc.x + theButton.getSize().width)
					|| (y > loc.y - theButton.getSize().height && y < loc.y + theButton.getSize().height)) {
				x = (int)(Math.random() * (panelSize.width - buttonSize.width));
				y = (int)(Math.random() * (panelSize.height - buttonSize.height));
				System.out.println("Corrected for button placement!");
			}	
			
			theButton.setLocation(x, y);	
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	/**
	 * Handles what happens if the button is pressed...
	 * @author 18jsizer
	 *
	 */
	public class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int answer = JOptionPane.showOptionDialog(
					panel, "Wow.... you did it, and it only took you "
							+ numClicks + " tries!\n"
									+ "Would you like to play again?",
					"Wow...",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null, null, null);
			
			if (answer == 1) {
				System.exit(0);
			}
			theButton.setLocation(
					(panelSize.width/2) - (buttonSize.width/2),
					(panelSize.height/2) - (buttonSize.height/2));
		}
	}
	
	/**
	 * Counts the number of clicks inside the main frame
	 * @author 18jsizer
	 *
	 */
	public class ClickListener implements MouseListener {
		@Override
		public void mousePressed(MouseEvent arg0) {
			numClicks++;
			clicks.setText("Clicks: " + numClicks);
			
			if (numClicks > 10)
				theButton.setText("Keep trying!");
			if (numClicks > 20)
				theButton.setText("Almost got me >:)");
			if (numClicks > 30)
				theButton.setText("Sorry, try again");
			if (numClicks > 40)
				theButton.setText("Alright, you're really bad at this");
			
		}
		
		// these are all useless
		@Override
		public void mouseClicked(MouseEvent arg0) {}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
}
