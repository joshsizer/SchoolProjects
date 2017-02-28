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
  public static LinkedList list;
  public static int n = 10;

  /*
   * main method - creates JFrame
   */
  public static void main(String[] args) {
    DrawShape drawing = new DrawShape();
    drawing.setVisible(true);
    try {
      list = FileParser.getLinkedList(new File("Bone.txt"));
      trim(list, 14);
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
      g.setColor(Color.WHITE);
      g.drawPolygon(poly);
    }
  }

  public static void trim(LinkedList list, int n) {
    Associated[] nodesByImportance = new Associated[list.size()];
    Node p = list.getHeadNode();
    Node last = list.getTailNode();
    Node next;
    Point p_, last_, next_;
    double importance;
    int index = 0;
    
    while (p != null) {
      next = p.getNext();
      if (next != null && last != null) {
        p_ = (Point)p.getData();
        last_ = (Point)last.getData();
        next_ = (Point)next.getData();
        
        double d1 = p_.distance(last_);
        double d2 = p_.distance(next_);
        double d3 = last_.distance(next_);
        importance = d1 + d2 - d3;
        Associated a = new Associated(importance, p);
        nodesByImportance[index] = a;
        index++;
      }
      last = p;
      p = next;
    }
    Arrays.sort(nodesByImportance, new Comparator<Associated>() {
      public int compare(Associated a1, Associated a2) {
        if (a1.importance == a2.importance) {
          return 0;
        } else if (a1.importance < a2.importance){
          return -1;
        } else {
          return 1;
        }
      }
    });
    System.out.println(Arrays.toString(nodesByImportance));
  }
  
  public static class Associated {
    
    public double importance;
    public Node node;
    
    public Associated(double imp, Node n) {
      importance = imp;
      node = n;
    }
    
    @Override
    public String toString() {
      return String.valueOf(importance);
    }
  }
}


