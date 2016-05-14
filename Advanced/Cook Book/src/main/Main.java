package main;

import java.util.ArrayList;

import cookbook.Catagory;
import cookbook.Recipe;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> testIngredients = new ArrayList<String>();
		ArrayList<String> testSteps = new ArrayList<String>();
		
		ArrayList<String> testIngredients2 = new ArrayList<String>();
		ArrayList<String> testSteps2 = new ArrayList<String>();
		
		Recipe cookies = new Recipe("Cookies", Catagory.DESERT, testIngredients, testSteps);
		Recipe cookies2 = new Recipe("Cookies", Catagory.DESERT, testIngredients2, testSteps2);
		
		testIngredients.add("1 oz Butter");
		testIngredients.add("2 cups Milk");
		
		testIngredients2.add("2 cups Milk");
		testIngredients2.add("1 oz Butter");

		testSteps.add("Cut butter into sugar");
		testSteps.add("Mix dry ingredients into wet ingredients");
		
		testSteps2.add("Cut butter into sugar");
		testSteps2.add("Mix dry ingredients into wet ingredients");
		
		System.out.println(cookies.equals(cookies2));
	}

}
