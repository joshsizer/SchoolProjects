package main;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {

  /**
   * This will initate the sniffing of websites for links. If a link is HTTPS, it will not be
   * able to connect since we are not sending any authentication keys over
   */
  public static void main(String[] args) {
    String startUrl = "http://stackoverflow.com";
    // experimented with higher numbers, but it never ends!
    // for every link, there is usually 20+ more links, soooo...
    int maxPagesToTraverse = 3;
    WebpageSnake snake;
    try {
      snake = new WebpageSnake(startUrl, maxPagesToTraverse);
      snake.traverse();
    } catch (MalformedURLException e) {
      System.out.println("MalformedURLException: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}