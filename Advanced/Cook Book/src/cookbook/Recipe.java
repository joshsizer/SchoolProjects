package cookbook;

import java.util.ArrayList;

/**
 * A class to represent a recipe. A recipe includes:
 * 
 * A name (i.e. Chicken Cheese Steak)
 * A category (i.e. Desert)
 * A list of ingredients
 * A list of steps
 * 
 * @author 18jsizer
 *
 */
public class Recipe {
	private final Catagory catagory;
	private final String name;
	private final ArrayList<String> ingredients;
	private final ArrayList<String> steps;

	/**
	 * Initializes this recipe to have the specified ingredients and steps
	 * 
	 * @param name The name of this recipe
	 * @param catagory The category this recipe belongs to.
	 * @param ingredients The list of ingredients for this recipe
	 * @param steps The list of steps for this recipe
	 */
	public Recipe(String name, Catagory catagory, ArrayList<String> ingredients, ArrayList<String> steps) {
		this.catagory = catagory;
		this.name = name;
		this.ingredients = ingredients;
		this.steps = steps;
	}
	
	public void addStep(String step) {
		steps.add(step);
	}
	
	public void remove(int step) {
		steps.remove(step - 1);
	}
	
	public void addIngredient(String ingredient) {
		ingredients.add(ingredient);
	}
	
	public void removeIngredient(String ingredientToRemove) {
		ingredients.remove(ingredientToRemove);
	}

	public Catagory getCatagory() {
		return catagory;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	public ArrayList<String> getSteps() {
		return steps;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Recipe) {
			Recipe recipe = (Recipe)o;
			boolean containsIngredients = getIngredients().containsAll(recipe.getIngredients());
			boolean stepsInOrder = getSteps().equals(recipe.getSteps());
			return containsIngredients 
					&& stepsInOrder 
					&& getName().equals(recipe.getName())
					&& getCatagory().equals(recipe.getCatagory());
		} 
		return false;
	}
	
	@Override
	public String toString() {
		String ret = "Ingredients:\n";
		for (String currentIngredient : ingredients) {
			ret += "\t" + currentIngredient + "\n";
		} 
		
		ret += "\nSteps:\n";
		
		for (int i = 0; i < steps.size(); i++) {
			ret += "\t" + (i + 1) + ": " + steps.get(i) + "\n";
		}
		
		return ret;
	}
}
