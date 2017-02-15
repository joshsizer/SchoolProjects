package main;

/**
 * This represents an exception based upon a malformed hyper link
 *
 * @author Joshua Sizer
 */
@SuppressWarnings("serial")
public class MalformedHyperLinkException extends Exception {

  public MalformedHyperLinkException(String message) {
    super(message);
  }
}