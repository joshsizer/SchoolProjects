package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import cookbook.Category;
import cookbook.CookBook;
import cookbook.Recipe;

public class Actions {
	static JFileChooser fileChooser = new JFileChooser();
	static FileNameExtensionFilter filter = new FileNameExtensionFilter(
			"Cook Book Files", CookBook.extension);

	static {
		fileChooser.setFileFilter(filter);
	}

	/**
	 * A class that handles a save event
	 * 
	 * @author Josh Sizer
	 */
	public static class SaveCookBook implements ActionListener {
		boolean saveAs;

		public SaveCookBook(boolean saveAs) {
			this.saveAs = saveAs;
		}

		@Override
		public void actionPerformed(ActionEvent savePressed) {
			boolean i_saveAs = saveAs
					|| CookBook.getInstance().getSaveLocation() == null;

			int option = -1;
			if (i_saveAs) {
				option = fileChooser.showSaveDialog(null);
			}
			if (option == JFileChooser.APPROVE_OPTION) {
				CookBook.getInstance()
						.setSaveLocation(fileChooser.getSelectedFile());
			} else return;

			try {
				CookBook.getInstance().save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static class LoadCookBook implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent loadPressed) {
			showChooseFileDialogue();
			changeListValues(CookBook.getInstance().getRecipesAsArray());
		}

		public void showChooseFileDialogue() {
			if (fileChooser
					.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				CookBook.getInstance();
				try {
					CookBook.load(fileChooser.getSelectedFile());
					System.out.println(CookBook.getInstance());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
					showChooseFileDialogue();
				}
			}
		}
	}

	public static class SortByCategory implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent menuPressed) {
			// gets which category was pressed in the menu
			CategoryMenuItem category = (CategoryMenuItem) menuPressed
					.getSource();
			System.out.println(Category.toString(category.getCategory()));
			
			changeListValues(CookBook.getInstance()
					.getRecipesAsArray(category.getCategory()));
		}
	}
	
	public static class EditRecipe implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			GUI.frame.showEditPanel();
			Recipe currentRecipe = CookBook.getInstance().getCurrentRecipe();
			
			ArrayList<String> ingredients; 
			String ingredientsOutput = "";
			
			ArrayList<String> steps;
			String stepsOutput = "";
			
			if (currentRecipe != null) {
				ingredients = currentRecipe.getIngredients();
				for (String ingredient : ingredients) {
					ingredientsOutput += ingredient + "\n";
				}
				
				steps = currentRecipe.getSteps();
				for (int i = 0; i < steps.size(); i++) {
					stepsOutput += (i + 1) + ") " + steps.get(i) + "\n";
				}
			}

			GUI.frame.editPanel.ingredientsTextArea.setText(ingredientsOutput);
			GUI.frame.editPanel.stepsTextArea.setText(stepsOutput);
		}
	}
	
	public static class NewCookBook implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	public static class RecipeSelected implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			@SuppressWarnings("unchecked")
			JList<Recipe> source = (JList<Recipe>) arg0.getSource();
			Recipe recipe = (Recipe) source.getSelectedValue();
			CookBook.getInstance().setCurrentRecipe(recipe);
			GUI.frame.repaint();
		}
		
	}
	
	public static class ShowAllRecipes implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			changeListValues(CookBook.getInstance().getRecipesAsArray());
		}
	}
	
	public static class CancelEdit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			GUI.frame.showRecipePanel();
		}
	}
	
	public static class AddRecipe implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CookBook.getInstance().setCurrentRecipe(null);
			GUI.frame.showEditPanel();
		}
	}
	
	public static class SaveRecipe implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Recipe currentRecipe = CookBook.getInstance().getCurrentRecipe();
			if (currentRecipe == null) {
				String ingredients = GUI.frame.editPanel.ingredientsTextArea
						.getText();
				String steps = GUI.frame.editPanel.stepsTextArea.getText();
			}
		}
	}
	
	private static void changeListValues(Recipe[] recipes) {
		if (recipes == null) {
			recipes = new Recipe[0];
		}
		GUI.frame.recipePanel.recipeList.setListData(recipes);
		if (recipes.length == 0) {
			CookBook.getInstance().setCurrentRecipe(null);
		} else {
			GUI.frame.recipePanel.recipeList.setSelectedIndex(0);
			CookBook.getInstance().setCurrentRecipe(0);
		}
		GUI.frame.repaint();
	}
}
