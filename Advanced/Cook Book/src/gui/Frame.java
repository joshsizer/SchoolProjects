package gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import cookbook.CookBook;
import cookbook.Recipe;

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
		Recipe currentRecipe = CookBook.getInstance().getCurrentRecipe();
		
		String name = "";
		ArrayList<String> ingredients; 
		String ingredientsOutput = "";
		
		ArrayList<String> steps;
		String stepsOutput = "";
		
		ArrayList<Integer> cat;
		Integer[] categories = new Integer[0];
		
		if (currentRecipe != null) {
			name = currentRecipe.getName();
			
			ingredients = currentRecipe.getIngredients();
			for (String ingredient : ingredients) {
				ingredientsOutput += ingredient + "\n";
			}
			
			steps = currentRecipe.getSteps();
			for (int i = 0; i < steps.size(); i++) {
				stepsOutput += (i + 1) + ") " + steps.get(i) + "\n";
			}
			
			cat = currentRecipe.getCatagories();
			categories = new Integer[cat.size()];
			for (int i = 0; i < categories.length; i++) {
				categories[i] = cat.get(i);
			}
		}

		GUI.frame.editPanel.nameTextField.setText(name);
		GUI.frame.editPanel.ingredientsTextArea.setText(ingredientsOutput);
		GUI.frame.editPanel.stepsTextArea.setText(stepsOutput);
		GUI.frame.editPanel.categoryList.setListData(categories);
		
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
