package cookbook;

import java.util.ArrayList;

public class CookBook {
	/**
	 * A list of all the recipes in this cook book
	 */
	private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

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
	}

	/**
	 * Removes the specifies recipe
	 * 
	 * @param recipe
	 *            The recipe to remove
	 */
	public void removeRecipe(Recipe recipe) {
		recipes.remove(recipe);
	}

	/**
	 * Returns only the recipes that have the specified category
	 * 
	 * @param category
	 *            The category, or "genre" of food
	 * @return An <code>ArrayList</code> of recipes.
	 */
	public ArrayList<Recipe> getRecipies(int category) {
		ArrayList<Recipe> qualifiedRecipes = new ArrayList<Recipe>();

		for (Recipe current : recipes) {
			if (current.getCatagories().equals(category))
				qualifiedRecipes.add(current);
		}

		return qualifiedRecipes;
	}

}
