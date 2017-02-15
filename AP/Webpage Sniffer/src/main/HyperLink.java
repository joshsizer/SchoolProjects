package main;

/**
 * A representation for a HyperLink. This will throw a <code>MalformedHyperLinkException</code>
 * if the link is bad in some way;
 *
 * @author Joshua Sizer
 */
public class HyperLink {

  private static final String HYPER_LINK_TAG_START = "<a href=\"";
  private static final String HYPER_LINK_TAG_END = "</a>";

  private String hyperLinkUrl;

  /**
   * Creates a HyperLink object by parsing the input string for the first found hyperlink.
   *
   * @param link The line to parse
   * @throws MalformedHyperLinkException If a hyperlink is found but is determined to be malformed.
   */
  public HyperLink(String link) {
    hyperLinkUrl = link;
  }

  /**
   * Gets the URL of this HyperLink
   * @return
   */
  public String getUrl() {
    return hyperLinkUrl;
  }

  /**
   * This will attempt to find a link inside a line (can be any line of characters). It will return
   * null if the hyperlink start tag is not found, and will throw a MalformedHyperLinkExepction if
   * the ending tag does not exist.
   *
   * @param line The line to parse
   * @return A string containing the link
   */
  public static HyperLink parseLineForHyperLink(String line) throws MalformedHyperLinkException {
    if (!line.contains(HYPER_LINK_TAG_START)) {
      return null;
    }

    int tagStartIndex = line.indexOf(HYPER_LINK_TAG_START);
    int linkStartIndex = tagStartIndex + HYPER_LINK_TAG_START.length();
    int linkEndIndex = line.indexOf("\"", linkStartIndex);
    int tagEndIndex = line.indexOf(HYPER_LINK_TAG_END, linkStartIndex);

    if (linkEndIndex == -1 || tagEndIndex == -1) {
      throw new MalformedHyperLinkException("HyperLink is missing end tag" +
          line);
    }
    String link = line.substring(linkStartIndex, linkEndIndex);

    if (!link.startsWith("http")) {
      throw new MalformedHyperLinkException("Link does not conform to http protocol");
    }
    return new HyperLink(link);
  }
}