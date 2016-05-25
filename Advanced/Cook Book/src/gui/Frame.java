package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import cookbook.CookBook;
import cookbook.Recipe;

/**
 * The main frame for this program. This component houses the recipe panel
 * and the edit panel, and there are methods to switch between them.
 * 
 * @author Josh Sizer
 *
 */
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
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new Actions.CloseWindow());
	}

	/**
	 * Updates and shows the edit panel based on the currently
	 * selected recipe.
	 */
	public void updateEditPanel() {
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
				stepsOutput += steps.get(i) + "\n";
			}
			
			cat = currentRecipe.getCatagories();
			categories = new Integer[cat.size()];
			for (int i = 0; i < categories.length; i++) {
				categories[i] = cat.get(i);
			}
		}

		editPanel.nameTextField.setText(name);
		editPanel.ingredientsTextArea.setText(ingredientsOutput);
		editPanel.stepsTextArea.setText(stepsOutput);
		editPanel.categoryList.setListData(categories);
		//editPanel.categorySelection.setSelectedIndex(0);
		
		
		if (getContentPane().getComponent(0) == editPanel)
			return;
		
		getContentPane().remove(recipePanel);
		getContentPane().add(editPanel);
		
		revalidate();
		repaint();
	}
	
	/**
	 * Updates and shows the currently selected recipe.
	 */
	public void updateRecipePanel() {		
		Recipe cur = CookBook.getInstance().getCurrentRecipe();

		if (cur == null) {
			CookBook.getInstance().setCurrentRecipe(0);
			cur = CookBook.getInstance().getCurrentRecipe();
		} else {
			
		}
		
		String recipeString = "";
		String nameString = "Name: ";

		if (CookBook.getInstance() != null && cur != null) {
			recipeString = cur.toString();
			nameString += cur.getName();
		}

		GUI.frame.recipePanel.recipeDisplayTextArea.setText(recipeString);
		GUI.frame.recipePanel.recipeNameLabel.setText(nameString);
		
		if (getContentPane().getComponent(0) == recipePanel)
			return;
		
		getContentPane().remove(editPanel);
		getContentPane().add(recipePanel);
		revalidate();
		repaint();
	}
}
