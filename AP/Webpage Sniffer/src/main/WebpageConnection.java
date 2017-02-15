package main;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Simple wrapper for a connection to a webpage
 *
 * @author Joshua Sizer
 */
public class WebpageConnection {

  private String hostName;
  private URL url;
  private URLConnection urlConnection;

  /**
   * @param webAddress The URL address to connect to
   */
  public WebpageConnection(String webAddress) throws MalformedURLException {
    hostName = webAddress;
    url = new URL(this.hostName);
  }

  /**
   * Attempts to open a connection with the specified webpage
   */
  public void openConnection() throws IOException {
    urlConnection = url.openConnection();
  }

  /**
   * Get the webpage's input stream
   *
   * @return The underlying URLConnection's input stream
   */
  public InputStream getInputStream() throws IOException {
    return urlConnection.getInputStream();
  }
}