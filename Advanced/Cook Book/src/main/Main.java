package main;

import java.util.ArrayList;

import cookbook.Category;
import cookbook.CookBook;
import cookbook.Recipe;
import gui.GUI;

public class Main {	
	public static void main(String[] args) {
		ArrayList<String> testIngredients = new ArrayList<String>();
		ArrayList<String> testSteps = new ArrayList<String>();
		
		ArrayList<String> testIngredients2 = new ArrayList<String>();
		ArrayList<String> testSteps2 = new ArrayList<String>();
		
		ArrayList<Integer> categories = new ArrayList<Integer>();
		ArrayList<Integer> categories2 = new ArrayList<Integer>();
		
		Recipe cookies = new Recipe("Cookies", categories, testIngredients, testSteps);
		Recipe cookies2 = new Recipe("Butter", categories2, testIngredients2, testSteps2);
		
		testIngredients.add("1 oz Butter");
		testIngredients.add("2 cups Milk");
		
		testIngredients2.add("1 oz Butter");
		testIngredients2.add("2 cups Milk");

		testSteps.add("Cut butter into sugar");
		testSteps.add("Mix dry ingredients into wet ingredients");
		
		testSteps2.add("Get milk");
		testSteps2.add("Churn milk");
		
		categories.add(Category.BREAKFAST);
		categories.add(Category.VEGETARIAN);
		
		categories2.add(Category.BREAKFAST);
		
		//System.out.println(cookies);
		//System.out.println(cookies2);
		
		CookBook.getInstance().addRecipe(cookies);
		CookBook.getInstance().addRecipe(cookies2);
	
		GUI.display();
	}
}
