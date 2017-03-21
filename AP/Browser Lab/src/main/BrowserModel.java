package main;

import java.util.Stack;

/**
 * The BrowserModel which handles what is foward and what is backwards. If a link is clicked,
 * all "foward" pages are cleared and the last page is added to the history.
 * 
 * @author Joshua Sizer
 * @since 3/20/17
 *
 */
public class BrowserModel {

  private BrowserView view;
  private Stack<Integer> history;
  private Stack<Integer> future;
  private int current;
  
  /**
   * Initializes the stacks and set's the current line to be 0
   * @param view
   */
  public BrowserModel(BrowserView view)  {
    this.view = view;
    current = 0;
    view.update(current);
    history = new Stack<>();
    future = new Stack<>();
  }
  
  /**
   * Traverses to the last line
   */
  public void back() {
    if (!history.isEmpty()) {
      future.add(current);
      current = history.pop();
      view.update(current);
    }
  }
  
  /**
   * Traverses to the next line
   */
  public void forward() {
    if (!future.isEmpty()) {
      history.add(current);
      current = future.pop();
      view.update(current);
    }
  }
  
  /**
   * Clears all history, fowards and back, and updates to the first line
   */
  public void home() {
    view.update(0);
    history.clear();
    future.clear();
  }
  
  /**
   * Updates the line to be what is in the link
   * @param n
   */
  public void followLink(int n) {
    future.clear();
    history.add(current);
    current = n;
    view.update(current);
  }
  
  /**
   * Returns true if there is a page to go back to
   * @return
   */
  public boolean hasBack() {
   return !history.isEmpty(); 
  }
  
  /**
   * Returns true id there is a page to go foward to
   * @return
   */
  public boolean hasForward() {
    return !future.isEmpty();
  }
}
