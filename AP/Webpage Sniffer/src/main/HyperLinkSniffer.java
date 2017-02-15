package main;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class will accept an input stream and can parse it for hyper links
 *
 * @author Joshua Aizer
 */
public class HyperLinkSniffer {

  private InputStream inputStream;
  private Scanner scanner;
  // a "cache", so we don't have to read the stream more than once... DO NOT USE DIRECTLY.
  private String webpageAsString = null;

  public HyperLinkSniffer(InputStream stream) {
    inputStream = stream;
    scanner = new Scanner(inputStream);
  }

  /**
   * Iterates through the webpage and finds hyperlinks
   *
   * @return An array list of hyperlinks in the webpage
   */
  public List<HyperLink> getHyperLinks() {
    List<HyperLink> list = new ArrayList<HyperLink>();
    String webpage = getWebpageAsString();
    scanner = new Scanner(webpage);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      try {
        HyperLink toAdd = new HyperLink(line);
        if (toAdd != null) {
          list.add(toAdd);
        }
      } catch (MalformedHyperLinkException e) {
        // don't really want to do anything about it
      }
    }
    return list;
  }

  /**
   * Gets the webpage in string representation
   */
  public String getWebpageAsString() {
    if (webpageAsString == null) {
      StringBuilder builder = new StringBuilder();
      while (scanner.hasNextLine()) {
        builder.append(scanner.nextLine() + "\n");
      }
      webpageAsString = builder.toString();
    }
    return webpageAsString;
  }

  public void printStream() {
    System.out.println(getWebpageAsString());
  }
}