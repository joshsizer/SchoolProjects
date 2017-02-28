package main;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileParser {
  
  public static String readFile(File file) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(file));
    StringBuilder builder = new StringBuilder();
    
    String line = reader.readLine();
    while (line != null) {
      builder.append(line + System.lineSeparator());
      line = reader.readLine();
    }
    
    reader.close();
    
    return builder.toString();
  }
  
  public static LinkedList getLinkedList(File file) throws IOException {
    String fileContents = readFile(file);
    LinkedList list = new LinkedList();
    int x, y = 0;
    Scanner scanner = new Scanner(fileContents);
    
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] tokens = line.split(" ");
      
      if (tokens.length != 2) {
        continue;
      }
      
      x = Integer.parseInt(tokens[0]);
      y = Integer.parseInt(tokens[1]);
      
      Point p = new Point(x, y);
      list.insertFront(p);
    }
    
    return list;
  }
}
