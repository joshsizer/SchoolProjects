package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cookbook.Category;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	/**
	 * The "File" menu, which contains options to save or save as.
	 */
	private JMenu file;
	private JMenuItem neww;
	private JMenuItem load;
	private JMenuItem save;
	private JMenuItem saveAs;

	/**
	 * The "Recipe" menu;
	 */
	private JMenu recipe;
	private JMenu sort;
	private JMenuItem[] categories;

	public MenuBar() {
		initMenu();
	}

	/**
	 * Initializes the menu bar for this program.
	 */
	private void initMenu() {
		file = new JMenu("File");
		neww = new JMenuItem("New");
		load = new JMenuItem("Load...");
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As...");

		recipe = new JMenu("Recipe");
		sort = new JMenu("Sort");

		categories = new CategoryMenuItem[Category.numberOfCategories];

		for (int i = 0; i < categories.length; i++) {
			CategoryMenuItem item = new CategoryMenuItem(Category.toString(i),
					i);
			item.addActionListener(new Actions.SortByCategory());
			sort.add(item);
			categories[i] = item;
		}

		load.addActionListener(new Actions.LoadCookBook());
		save.addActionListener(new Actions.SaveCookBook(false));
		saveAs.addActionListener(new Actions.SaveCookBook(true));

		file.add(neww);
		file.add(load);
		file.add(save);
		file.add(saveAs);
		recipe.add(sort);

		add(file);
		add(recipe);
	}


}
