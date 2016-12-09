package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private BufferedImage image;
    
	private ArrayList<Point> pointList;
	private final int RADIUS = 6;
	private double totalDistance = 0;
	private Point lastPoint;

    public ImagePanel(File file) {
       try {                
          image = ImageIO.read(file);
       } catch (IOException ex) {
            // handle exception...
       }
       
       Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
       setPreferredSize(size);
       setMinimumSize(size);
       setMaximumSize(size);
       setSize(size);
       setLayout(null);
       
       pointList = new ArrayList<Point>();
       DotsListener dl = new DotsListener();
		addMouseListener(dl);
		addMouseMotionListener(dl);

    }
    
    public void paintComponent(Graphics page) {
		super.paintComponent(page);

		page.setColor(Color.green);

		for (Point drawPoint : pointList) {
			page.fillOval(drawPoint.x - RADIUS, drawPoint.y - RADIUS, RADIUS * 2, RADIUS * 2);
		}

		page.drawString("Distance: " + totalDistance, 5, 15);
	}

	// *****************************************************************
	// Represents the listener for mouse events.
	// *****************************************************************
	private class DotsListener implements MouseListener, MouseMotionListener {
		// --------------------------------------------------------------
		// Adds the current point to the list of points and redraws
		// whenever the mouse button is pressed.
		// --------------------------------------------------------------
		public void mousePressed(MouseEvent event) {
			lastPoint = event.getPoint();
			findTheDistance(event);
		}

		// ---------------------------------------------------------------
		// Provide empty definitions for unused event methods.
		// ---------------------------------------------------------------
		public void mouseClicked(MouseEvent event) {
		}

		public void mouseReleased(MouseEvent event) {
		}

		public void mouseEntered(MouseEvent event) {
		}

		public void mouseExited(MouseEvent event) {
		}

		@Override
		public void mouseDragged(MouseEvent event) {
			findTheDistance(event);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}
	
	private void findTheDistance(MouseEvent event) {
		Point thisPoint = event.getPoint();
		pointList.add(thisPoint);
		repaint();
		totalDistance += 
				Math.sqrt(Math.pow(thisPoint.getX() - lastPoint.getX(), 2) 
						+ Math.pow(thisPoint.getY() - lastPoint.getY(), 2)); 
		lastPoint = thisPoint;
	}

}