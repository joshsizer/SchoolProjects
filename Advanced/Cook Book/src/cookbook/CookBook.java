package cookbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CookBook implements Serializable {
	private static final long serialVersionUID = -795614831645998443L;
	public static final String extension = "ckb";

	private static CookBook instance;

	/**
	 * Returns the global instance of the cook book
	 * 
	 * @return the global cook book object
	 */
	public static CookBook getInstance() {
		if (instance == null)
			instance = new CookBook();
		return instance;
	}
	
	/**
	 * Loads a serialized cook book object and and sets it
	 * to be the global instance of the cook book. This class
	 * is static because I could not figure out how to make 
	 * a statement like <code>this = ObjectInputStream.readObject();
	 * </code>
	 * 
	 * @param file
	 *            the file the object is stored in
	 * @return the CookBook object that was serialized
	 * @throws IOException
	 *             if the file cannot be read
	 * @throws ClassNotFoundException
	 *             if this class cannot be found
	 */
	public static void load(File file)
			throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fileIn);
		instance = (CookBook) in.readObject();
		in.close();
		fileIn.close();
	}
	
	public static void newCookBook() {
		instance = new CookBook();
	}

	/**
	 * The file location to save to
	 */
	private File saveLocation;
	
	/**
	 * Whether or not this object has been saved since last
	 * edited
	 */
	private boolean saved;
	
	/**
	 * The currently opened recipe
	 */
	private Recipe currentRecipe;

	/**
	 * A list of all the recipes in this cook book
	 */
	private ArrayList<Recipe> recipes;

	/**
	 * Creates a blank cook book (no recipes).
	 */
	public CookBook() {
		this(new ArrayList<Recipe>());
	}

	/**
	 * Creates a cook book with the specified recipes
	 * 
	 * @param recipes
	 *            An <code>ArrayList</code> of recipes
	 */
	public CookBook(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
		setCurrentRecipe(0);
		saved = false;
	}

	/**
	 * Returns all the of the recipes in this cook book.
	 * 
	 * @return An <code>ArrayList</code> of all recipes
	 */
	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	/**
	 * Adds the specified recipe
	 * 
	 * @param recipe
	 *            The recipe to add
	 */
	public void addRecipe(Recipe recipe) {
		recipes.add(recipe);
		if (recipes.size() == 1) currentRecipe = recipe;
		saved = false;
	}

	/**
	 * Removes the specifies recipe
	 * 
	 * @param recipe
	 *            The recipe to remove
	 */
	public void removeRecipe(Recipe recipe) {
		recipes.remove(recipe);
		saved = false;
	}

	/**
	 * Returns only the recipes that have the specified category
	 * 
	 * @param category
	 *            The category, or "genre" of food
	 * @return An <code>ArrayList</code> of recipes.
	 */
	public ArrayList<Recipe> getRecipes(int category) {
		ArrayList<Recipe> qualifiedRecipes = new ArrayList<Recipe>();

		for (Recipe current : recipes) {
			if (current.getCatagories().contains(category))
				qualifiedRecipes.add(current);
		}

		return qualifiedRecipes;
	}
	
	private Recipe[] getRecipesAsArray(ArrayList<Recipe> recipes) {
		Recipe[] array = new Recipe[recipes.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = recipes.get(i);
		}
		
		return array;
	}
	
	/**
	 * Gets all the recipes as an array. Useful for populating
	 * a JList
	 * 
	 * @return This cook book's recipes as an array.
	 */
	public Recipe[] getRecipesAsArray() {
		return getRecipesAsArray(this.recipes);
	}
	
	public Recipe[] getRecipesAsArray(int category) {
		return getRecipesAsArray(getRecipes(category));
	}

	/**
	 * Sets the save location of this cook book. It will append the file
	 * extension ".ckb" to the end if the file's path does not already end in
	 * it.
	 * 
	 * @param file
	 *            the file to save to
	 */
	public void setSaveLocation(File file) {
		String absolutePath = file.getAbsolutePath();
		int index = absolutePath.lastIndexOf('.');
		if (index == -1) {
			saveLocation = new File(absolutePath + "." + extension);
			return;
		}

		String extension = absolutePath.substring(index);
		if (extension.equals("." + CookBook.extension)) {
			saveLocation = file;
			return;
		}

		saveLocation = new File(absolutePath + "." + extension);
	}

	/**
	 * Returns the currently set location to save this cook book to
	 *
	 * @return a <code>File</code> representing the location to save to.
	 */
	public File getSaveLocation() {
		return saveLocation;
	}
	
	/**
	 * Returns the currently "opened" recipe.
	 * 
	 * @return the current recipe
	 */
	public Recipe getCurrentRecipe() {
		return currentRecipe;
	}

	public void setCurrentRecipe(int index) {
		if (index < recipes.size())
			setCurrentRecipe(recipes.get(index));
	}
	
	public void setCurrentRecipe(Recipe recipe) {
			currentRecipe = recipe;
	}
	
	/**
	 * Serializes, or saves, this object to the save location Nothing will be
	 * saved if the save location is <code>null</code>
	 * 
	 * @throws IOException
	 *             if the file cannot be accessed
	 */
	public void save() throws IOException {
		if (saveLocation == null) {
			return;
		}
		FileOutputStream fileOut = new FileOutputStream(saveLocation);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);
		out.close();
		fileOut.close();
		System.out.printf(
				"Serialized data saved in " + saveLocation.getAbsolutePath());
		saved = true;
	}

	/**
	 * Serializes, or saves, this object to the specified file
	 * 
	 * @param file
	 *            the file to save to
	 * @throws IOException
	 *             if the file cannot be accessed
	 */
	public void save(File file) throws IOException {
		setSaveLocation(file);
		save();
	}
	
	/**
	 * Returns whether or not this cook book has been saved since edited. 
	 * 
	 * @return
	 */
	public boolean getSaveValue() {
		return saved;
	}
	
	@Override
	public String toString() {
		String ret = "";
		for (Recipe recipe : recipes) {
			ret += recipe.toString() + "\n";
		}
		return ret;
	}
}
