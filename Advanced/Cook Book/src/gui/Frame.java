package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cookbook.Category;
import cookbook.CookBook;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	/**
	 * The menu bar, the bar at the top that has "File" and all that jazz
	 */
	private JMenuBar menuBar;

	/**
	 * The "File" menu, which contains options to save or save as.
	 */
	private JMenu file;
	private JMenuItem save;
	private JMenuItem saveAs;

	/**
	 * The "Recipe" menu;
	 */
	private JMenu recipe;
	private JMenu sort;
	private JMenuItem[] categories;
	private JMenuItem BREAKFAST;
	private JMenuItem LUNCH;
	private JMenuItem DINNER;

	public Frame() {
		initMenu();
	}

	/**
	 * Initializes the menu bar for this program.
	 */
	private void initMenu() {
		menuBar = new JMenuBar();

		file = new JMenu("File");
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As...");

		recipe = new JMenu("Recipe");
		sort = new JMenu("Sort");

		categories = new CategoryMenuItem[Category.numberOfCategories];

		for (int i = 0; i < categories.length; i++) {
			CategoryMenuItem item = new CategoryMenuItem(Category.toString(i),
					i);
			item.addActionListener(new Actions.CategoryPressed());
			sort.add(item);
			categories[i] = item;
		}

		save.addActionListener(new Actions.SaveAction(false));
		saveAs.addActionListener(new Actions.SaveAction(true));

		file.add(save);
		file.add(saveAs);
		recipe.add(sort);

		menuBar.add(file);
		menuBar.add(recipe);
		super.setJMenuBar(menuBar);
	}

}
