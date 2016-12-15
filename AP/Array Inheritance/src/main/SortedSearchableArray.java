package main;

import java.util.Arrays;

/**
 * A class which instantiates an array and fills it with random numbers, and then sorts them.
 * Because this subclass of SearchableArray sorts the array, it has a binary search method for
 * super fast searching (although it fills it with random numbers... so how do you know what you
 * want to find...).
 * 
 * @author Joshua Sizer
 *
 */
public class SortedSearchableArray extends SearchableArray {

	/**
	 * Creates an array with random numbers, and then sorts them.
	 * 
	 * @param size
	 */
	public SortedSearchableArray(int size) {
		super(size);
		sort(super.getArray());
	}

	/**
	 * Sorts the specified array using insertion sort
	 * @param a the array to sort
	 */
	private void sort(int[] a) {
		int key; // value that i will compare to
		int position; // where i am comparing in my array

		for (int index = 1; index < a.length; index++) {
			key = a[index];
			position = index;

			// shift larger values to the right
			while (position > 0 && a[position - 1] > key) {
				a[position] = a[position - 1];
				position--;
			}
			a[position] = key;
		}
	}

	/**
	 * Finds the index of the target using Java lib binary search.
	 * 
	 * @param target
	 *            The target to search for
	 * @return -1 if the target does not exist in the list
	 */
	public int binarySearch(int target) {
		return Arrays.binarySearch(super.getArray(), target);
	}
	
	/**
	 * Returns the string representation of the underlying
	 * integer array.
	 */
	@Override
	public String toString() {
		return "Sorted" + super.toString();
	}
}
