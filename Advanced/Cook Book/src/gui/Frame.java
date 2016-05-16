package gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	/**
	 * The menu bar, the bar at the top that has "File" and all that jazz
	 */
	private MenuBar menuBar;
	private RecipePanel recipePanel;

	public Frame() {
		menuBar = new MenuBar();
		recipePanel = new RecipePanel();
		
		setJMenuBar(menuBar);
		add(recipePanel);
	}
}
