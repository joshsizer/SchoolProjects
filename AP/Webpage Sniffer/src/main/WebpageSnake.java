package main;

import java.io.IOException;
import java.util.List;

/**
 * This class will connect to links found on webpages.
 *
 * @author Joshua Sizer
 */
public class WebpageSnake {

  private Webpage webpage;
  private int maxPagesToParse;

  public WebpageSnake(String startAddress, int pagesDeep) throws IOException {
    webpage = new Webpage(startAddress);
    maxPagesToParse = pagesDeep;
  }

  public void traverse() {
    traverse(webpage, 1);
  }

  public void traverse(Webpage page, int depth) {
    if (depth > maxPagesToParse) {
      return;
    }
    List<HyperLink> list = page.getLinks();
    for (HyperLink l : list) {
      for (int i = 1; i < depth; i++) {
        System.out.print(" ");
      }
      System.out.print("Depth: " + depth + ": ");
      System.out.println("Found \"" + l.getUrl() + "\"");
      try {
        Webpage nextWebpage = new Webpage(l.getUrl());
        traverse(nextWebpage, depth + 1);
      } catch (IOException e) {
        System.err.println("Unable to connect to \"" + l.getUrl() + "\"");
      }
    }
  }
}