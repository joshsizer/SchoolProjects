package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
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

	public static class CloseWindow extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			if (CookBook.getInstance().getSaveValue() == true) {
				e.getWindow().dispose();
				return;
			}
			Object[] options = new Object[] { "Save", "Don't save", "Cancel" };
			int selection = JOptionPane.showOptionDialog(GUI.frame,
					"Would you like to save " + "this cookbook?",
					"Confirm exit", 0, 0, null, options, null);

			if (selection == 0) {
				SaveCookBook save = new SaveCookBook(false);
				save.actionPerformed(null);
			} else if (selection == 1) {
				e.getWindow().dispose();
				return;
			}
		}

		public static void showSaveWindow() {

		}
	}

	/**
	 * A class that handles a save event
	 * 
	 */
	public static class SaveCookBook implements ActionListener {
		boolean saveAs;

		public SaveCookBook(boolean saveAs) {
			this.saveAs = saveAs;
		}

		@Override
		public void actionPerformed(ActionEvent savePressed) {
			boolean i_saveAs = saveAs || CookBook.getInstance()
					.getSaveLocation() == null;

			int option = -1;
			if (i_saveAs) {
				option = fileChooser.showSaveDialog(null);
			}
			if (option == JFileChooser.APPROVE_OPTION) {
				CookBook.getInstance().setSaveLocation(fileChooser
						.getSelectedFile());
			} else
				return;

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

		// recursion...
		public void showChooseFileDialogue() {
			if (fileChooser.showOpenDialog(
					null) == JFileChooser.APPROVE_OPTION) {
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

			changeListValues(CookBook.getInstance().getRecipesAsArray(category
					.getCategory()));
		}
	}

	public static class EditRecipe implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (CookBook.getInstance().getCurrentRecipe() == null) {
				return;
			}
			GUI.frame.updateEditPanel();
		}
	}

	public static class NewCookBook implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (CookBook.getInstance().getSaveValue() == false && CookBook
					.getInstance().getRecipes().size() != 0) {
				Object[] options = new Object[] { "Save", "Don't save",
						"Cancel" };
				int selection = JOptionPane.showOptionDialog(GUI.frame,
						"Would you like to save " + "this cookbook?",
						"Confirm exit", 0, 0, null, options, null);

				if (selection == 0) {
					SaveCookBook save = new SaveCookBook(false);
					save.actionPerformed(null);
				} else if (selection == 2) {
					return;
				}
			}
			CookBook.newCookBook();
			changeListValues(CookBook.getInstance().getRecipesAsArray());
			GUI.frame.updateRecipePanel();
		}
	}

	public static class RecipeSelected implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			@SuppressWarnings("unchecked")
			JList<Recipe> source = (JList<Recipe>) arg0.getSource();
			Recipe recipe = (Recipe) source.getSelectedValue();
			CookBook.getInstance().setCurrentRecipe(recipe);
			GUI.frame.updateRecipePanel();
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
			GUI.frame.updateRecipePanel();
		}
	}

	public static class AddRecipe implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CookBook.getInstance().setCurrentRecipe(null);
			GUI.frame.updateEditPanel();
		}
	}

	public static class SaveRecipe implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Recipe currentRecipe = CookBook.getInstance().getCurrentRecipe();

			ArrayList<String> ingredients = parse(
					GUI.frame.editPanel.ingredientsTextArea.getText());
			ArrayList<String> steps = parse(GUI.frame.editPanel.stepsTextArea
					.getText());

			String name = GUI.frame.editPanel.nameTextField.getText();

			ListModel<Integer> categoriesLM = GUI.frame.editPanel.categoryList
					.getModel();
			ArrayList<Integer> categories = new ArrayList<Integer>();

			for (int i = 0; i < categoriesLM.getSize(); i++) {
				categories.add(categoriesLM.getElementAt(i));
			}

			if (currentRecipe == null) {
				Recipe newRecipe = new Recipe(name, categories, ingredients,
						steps);
				CookBook.getInstance().addRecipe(newRecipe);
				CookBook.getInstance().setCurrentRecipe(newRecipe);
				changeListValues(CookBook.getInstance().getRecipesAsArray());
			} else {
				CookBook.getInstance().getCurrentRecipe().update(name,
						categories, ingredients, steps);
			}

			GUI.frame.updateRecipePanel();
		}

		public static ArrayList<String> parse(String raw) {
			ArrayList<String> steps = new ArrayList<String>();
			Scanner lineSeparator = new Scanner(raw);
			while (lineSeparator.hasNextLine()) {
				String line = lineSeparator.nextLine();
				if (!line.equals(""))
					steps.add(line);
			}
			lineSeparator.close();
			return steps;
		}
	}

	public static class RemoveRecipe implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CookBook.getInstance().removeRecipe(CookBook.getInstance()
					.getCurrentRecipe());
			changeListValues(CookBook.getInstance().getRecipesAsArray());
		}

	}

	public static class AddCategory implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Integer categoryToAdd = (Integer) GUI.frame.editPanel.categorySelection
					.getSelectedItem();
			ListModel<Integer> categories = GUI.frame.editPanel.categoryList
					.getModel();

			Integer[] updatedCategories = new Integer[categories.getSize() + 1];
			for (int i = 0; i < categories.getSize(); i++) {
				updatedCategories[i] = categories.getElementAt(i);

				// does not add the selected category if the recipe already has
				// that category specified
				if (updatedCategories[i].equals(categoryToAdd))
					return;
			}

			updatedCategories[updatedCategories.length - 1] = categoryToAdd;

			GUI.frame.editPanel.categoryList.setListData(updatedCategories);
		}
	}

	public static class RemoveCategory implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Integer categoryToRemove = (Integer) GUI.frame.editPanel.categoryList
					.getSelectedValue();

			ListModel<Integer> currentCategories = GUI.frame.editPanel.categoryList
					.getModel();
			ArrayList<Integer> temp = new ArrayList<Integer>();

			for (int i = 0; i < currentCategories.getSize(); i++) {
				temp.add(currentCategories.getElementAt(i));
			}

			temp.remove(categoryToRemove);

			Integer[] updatedCategories = new Integer[temp.size()];

			for (int i = 0; i < updatedCategories.length; i++) {
				updatedCategories[i] = temp.get(i);
			}

			GUI.frame.editPanel.categoryList.setListData(updatedCategories);
		}
	}

	public static void changeListValues(Recipe[] recipes) {
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

	public void parseSteps() {
		// TODO Auto-generated method stub

	}
}
