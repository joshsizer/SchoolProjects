package cookbook;

/**
 * An enumeration for a category. A standard enum was
 * not used in order to have a toString method to access the 
 * categories associated name.
 * 
 * @author Josh Sizer
 *
 */
public class Category {
	public static final int BREAKFAST = 0;
	public static final int LUNCH = 1;
	public static final int DINNER = 2;
	public static final int VEGETARIAN = 3;
	public static final int VEGAN = 4;
	public static final int DESERT = 5;
	public static final int numberOfCategories = 6;

	public static String toString(int category) {
		switch (category) {
		case 0:
			return "Breakfast";
		case 1:
			return "Lunch";
		case 2:
			return "Dinner";
		case 3:
			return "Vegetarian";
		case 4:
			return "Vegan";
		case 5:
			return "Desert";
		default:
			return "Food";
		}
	}
}
