package gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	/**
	 * The menu bar, the bar at the top that has "File" and all that jazz
	 */
	private MenuBar menuBar;
	protected RecipePanel recipePanel;
	protected EditPanel editPanel;

	public Frame() {
		menuBar = new MenuBar();
		recipePanel = new RecipePanel();
		editPanel = new EditPanel();
		
		setJMenuBar(menuBar);
		super.getContentPane().add(recipePanel);
	}
	
	@Override
	public void repaint() {
		recipePanel.paint();
		super.repaint();
	}
	
	public void showEditPanel() {
		if (getContentPane().getComponent(0) == editPanel)
			return;
		
		getContentPane().remove(recipePanel);
		getContentPane().add(editPanel);
		revalidate();
		repaint();
	}
	
	public void showRecipePanel() {
		if (getContentPane().getComponent(0) == recipePanel)
			return;
		
		getContentPane().remove(editPanel);
		getContentPane().add(recipePanel);
		revalidate();
		repaint();
	}
}
