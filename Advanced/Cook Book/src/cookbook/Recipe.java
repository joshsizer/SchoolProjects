package cookbook;

import java.util.ArrayList;

/**
 * A class to represent a recipe. A recipe includes: a name (i.e. Chicken Cheese
 * Steak), category (i.e. Desert), list of ingredients, and a list of steps.
 * 
 * @author 18jsizer
 *
 */
public class Recipe {
	/**
	 * The name of this recipe
	 */
	private final String name;

	/**
	 * The categories to which this belong. A recipe has the potential to belong
	 * to more than one category.
	 */
	private final ArrayList<Integer> categories;

	/**
	 * The ingredients required for this recipe
	 */
	private final ArrayList<String> ingredients;

	/**
	 * The steps required to make this recipe
	 */
	private final ArrayList<String> steps;

	/**
	 * Initializes this recipe to have the specified ingredients and steps
	 * 
	 * @param name
	 *            The name of this recipe
	 * @param category
	 *            The category this recipe belongs to.
	 * @param ingredients
	 *            The list of ingredients for this recipe
	 * @param steps
	 *            The list of steps for this recipe
	 */
	public Recipe(String name, ArrayList<Integer> category,
			ArrayList<String> ingredients, ArrayList<String> steps) {
		this.name = name;
		this.categories = category;
		this.ingredients = ingredients;
		this.steps = steps;
	}

	/**
	 * Add a step to this recipe
	 * 
	 * @param step
	 */
	public void addStep(String step) {
		steps.add(step);
	}

	/**
	 * Remove a step from this recipe
	 * 
	 * @param step
	 */
	public void removeStep(String step) {
		steps.remove(step);
	}

	/**
	 * Add an ingredient to this recipe
	 * 
	 * @param ingredient
	 */
	public void addIngredient(String ingredient) {
		ingredients.add(ingredient);
	}

	/**
	 * Remove an ingredient from this recipe
	 * 
	 * @param ingredientToRemove
	 */
	public void removeIngredient(String ingredientToRemove) {
		ingredients.remove(ingredientToRemove);
	}

	/**
	 * Get the categories to which this recipe belongs
	 * 
	 * @return an <code>ArrayList</code> of categories
	 */
	public ArrayList<Integer> getCatagories() {
		return categories;
	}

	/**
	 * Get the name of this recipe
	 * 
	 * @return the name of this recipe
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the ingredients for this recipe
	 * 
	 * @return An <code>ArrayList</code> of ingredients
	 */
	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	/**
	 * Get the steps for this recipe
	 * 
	 * @return An <code>ArrayList</code> of steps
	 */
	public ArrayList<String> getSteps() {
		return steps;
	}

	/**
	 * Returns true if the two recipes have: the same name, the same categories,
	 * the same ingredients, and the same steps.
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Recipe)) {
			return false;
		}
		
		Recipe recipe = (Recipe) o;
		
		boolean containsIngredients = getIngredients()
				.containsAll(recipe.getIngredients());
		
		boolean stepsInOrder = getSteps().equals(recipe.getSteps());
		
		return containsIngredients && stepsInOrder
				&& getName().equals(recipe.getName())
				&& getCatagories().containsAll(recipe.getCatagories());
	}

	/**
	 * Format:
	 * 
	 * Categories: X, Y, Z
	 * Ingredients:
	 * 		1 cup A
	 * 		4 oz B
	 * 
	 * Steps: 
	 * 		1. Do this first step
	 * 		2. Do this second step
	 */
	@Override
	public String toString() {
		// formats the categories
		String ret = "Categories: ";
		for (int i = 0; i < categories.size(); i++) {
			ret += Category.toString(categories.get(i));

			if (i == categories.size() - 1)
				break;

			ret += ", ";
		}
		
		// formats the ingredients
		ret += "\nIngredients:\n";
		for (String currentIngredient : ingredients) {
			ret += "\t" + currentIngredient + "\n";
		}
		
		// formats the steps
		ret += "\nSteps:\n";
		for (int i = 0; i < steps.size(); i++) {
			ret += "\t" + (i + 1) + ": " + steps.get(i) + "\n";
		}

		return ret;
	}
}
