/*
 * DrawShape.java
 * 
 * This program is the driver for a stand-alone application which will draw shapes generated from
 * the mpeg7 shape files. the original shape is drawn, then user inputs a number of points to
 * remove. the points are taken out of the list and the new shape is redrawn. Removal of points is
 * handled in the build shape class.
 * 
 * Inputs: Apple.txt Bone.txt Butterfly.txt Swirl.txt
 * 
 * Outputs: A jframe generates a window with the shapes drawn.
 * 
 * Constants: int width - determines the width of the jframe window int height - determines the
 * height of the jframe window
 * 
 * Instance Variables none
 * 
 * Constructors: DrawShape creates a jframe for the program
 * 
 * Methods: main - sets up the jframe paint - draws the shapes on the jframe
 * 
 *
 * If you are not familiar with Java Swing, here is a simple program that will demonstrate the basic
 * functionality that you need: DrawShape.java
 *
 * Below is a list of 5 shapes from the MPEG7 Shape data set that you can use to test your program.
 * The files consist of 100 lines with two numbers per line. The 100 lines represents 100 points,
 * and the two numbers per line are the x and y coordinates of that point. The files are: Apple.txt
 * Bone.txt Butterfly.txt Octopus.txt Swirl.txt
 * 
 */
package main;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.awt.Color;

// class which inherits JFrame
public class DrawShape extends JFrame {
  public static int WIDTH = 800;
  public static int HEIGHT = 800;
  public static LinkedList listOriginal;
  public static LinkedList listAfter;
  public static int n = 10;
  public static String fileName = "Butterfly.txt";

  /*
   * main method - creates JFrame
   */
  public static void main(String[] args) {
    DrawShape drawing = new DrawShape();
    drawing.setVisible(true);
    try {
      listOriginal = FileParser.getLinkedList(new File(fileName));
      listAfter = trim(listOriginal, n);
      drawing.repaint();
    } catch (IOException e) {
      System.out.println("Could not read file!");
    }
  }

  /*
   * constructor
   */
  public DrawShape() {
    super("Graphing a MPEG7 Shape");
    setSize(WIDTH, HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.BLACK);
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.Container#paint(java.awt.Graphics) draws the shapes in the JFrame
   */
  public void paint(Graphics g) {
    super.paint(g);
    drawList(g, listOriginal, Color.RED);
    drawList(g, listAfter, Color.WHITE);
  }

  /**
   * Draws a given LinkedList of Points
   * @param g The graphics object
   * @param list The LinkedList of points
   * @param color The color to draw with
   */
  public void drawList(Graphics g, LinkedList list, Color color) {
    if (list != null) {
      Polygon poly;
      int size = list.size();
      int[] xPoints = new int[size];
      int[] yPoints = new int[size];
      int index = 0;
      Node nextNode = list.getHeadNode();
      while (nextNode != null) {
        Point p = (Point) nextNode.getData();
        xPoints[index] = p.x;
        yPoints[index] = p.y;
        nextNode = nextNode.getNext();
        index++;
      }
      poly = new Polygon(xPoints, yPoints, size);
      g.setColor(color);
      g.drawPolygon(poly);
    }
  }
  /**
   * Recursively trims the linked list to only have the most important points as nodes
   * @param list The list of points to trim
   * @param n The number of final points
   * @return The trimmed list
   */
  public static LinkedList trim(LinkedList list, int n) {
    if (list.size() <= n) {
      return list;
    } else {
      Node leastImportant = list.getHeadNode();
      double leastImportantValue = Double.MAX_VALUE;
      Node p = null, last = null, next = null;

      //iterate through the whole list to find the least significant node
      for (int i = 0; i < list.size(); i++) {
        if (i == 0) {
          p = list.getHeadNode();
          last = list.getTailNode();
        } else {
          last = p;
          p = next;
        }
        if (i == list.size() - 1) {
          next = list.getHeadNode();
        } else {
          next = p.getNext();
        }
        double importance = importance((Point)p.getData(), (Point)last.getData(), (Point)next.getData());
        // Keep track of a the least important point
        if (importance < leastImportantValue) {
          leastImportantValue = importance;
          leastImportant = p;
        }
      }
      // create a new linked list by adding each point in succession, except for the point that is
      // least important
      Node cur = list.getHeadNode();
      LinkedList ret = new LinkedList();
      for (int i = 0; i < list.size(); i++) {
        if (cur.equals(leastImportant)) {
          cur = cur.getNext();
          continue;
        }
        ret.insertFront((Point)cur.getData());
        cur = cur.getNext();
      }
      return trim(ret, n);
    }
  }
  
  /**
   * Calculates the importance of a point based on the two points next to it
   * @param p
   * @param last
   * @param next
   * @return A double value of this point's importance
   */
  public static double importance(Point p, Point last, Point next) {
    double d1 = p.distance(last);
    double d2 = p.distance(next);
    double d3 = last.distance(next);
    return d1 + d2 - d3;
  }
}


