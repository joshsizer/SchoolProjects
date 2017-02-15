package main;

import java.io.IOException;
import java.util.List;

/**
 * A webpage object that can return a list of URLs
 *
 * @author Joshua Sizer
 */
public class Webpage {

  private WebpageConnection webConnection;
  private HyperLinkSniffer linkSniffer;

  /**
   * The constructor for a webpage
   *
   * @param address The address of the webpage to connect to
   * @throws IOException MalformedURLException for malformed URL IOException if unable to open the
   * connection to the URL
   */
  public Webpage(String address) throws IOException {
    webConnection = new WebpageConnection(address);
    webConnection.openConnection();
    linkSniffer = new HyperLinkSniffer(webConnection.getInputStream());
  }

  /**
   * Gets the underlying <code>WebpageConnection</code>
   *
   * @return the WebpageConnection based upon the input address
   */
  public WebpageConnection getConnection() {
    return webConnection;
  }

  /**
   * Get the list of all hyper links found on this webpage
   *
   * @return An <code>ArrayList</code> of HyperLinks
   */
  public List<HyperLink> getLinks() {
    return linkSniffer.getHyperLinks();
  }
}