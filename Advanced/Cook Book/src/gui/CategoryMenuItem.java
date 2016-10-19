package gui;

import javax.swing.JMenuItem;

/**
 * A class which wraps a JMenuItem to have a category associated with it
 * 
 * @author Josh Sizer
 *
 */
@SuppressWarnings("serial")
public class CategoryMenuItem extends JMenuItem {
	/**
	 * This menu item's category
	 */
	private int category;

	/**
	 * Creates a <code>JMenuItem</code> with the specified name and category
	 * 
	 * @param name
	 *            the name of the menu item
	 * @param category
	 *            the category to which it belongs
	 */
	public CategoryMenuItem(String name, int category) {
		super(name);
		this.category = category;
	}

	/**
	 * Returns this menu item's category
	 * 
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}
}
