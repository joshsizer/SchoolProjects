package main;

import java.util.Arrays;

/**
 * A class that creates and array and fills it with random numbers. Because the array is not
 * sorted, this class only has an associated linear search.
 * @author Joshua Sizer
 *
 */
public class SearchableArray {
	private static final int MAX = 1000;
	private static final int MIN = -1000;
	private final int SIZE;
	private final int[] arr;
	
	/**
	 * Populates an array of the specified size with random numbers
	 * between an arbitrary MIN and MAX value, as defined within this class.
	 * 
	 * @param size The size of the desired array
	 */
	public SearchableArray(final int size) {
		this.SIZE = size;
		this.arr = new int[this.SIZE];
		populate(arr);
	}
	
	/**
	 * Populates an array with random numbers between the local
	 * MIN and MAX value.
	 * 
	 * @param a The array to fill
	 */
	private void populate(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int random = (int)(Math.random() * (MAX - MIN)) + MIN;
			a[i] = random;
		}
	}
	
	/**
	 * Returns this class's array
	 * @return
	 */
	public int[] getArray() {
		return arr;
	}
	
	/**
	 * Searches for the specified target within the array.
	 * Returns the index where the target is found.
	 *
	 * @param target
	 * @return -1 if the target does not exist within the array.
	 */
	public int linearSearch(int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target)
				return i;
		}
		return -1;
	}
	
	/**
	 * Returns the string representation of the underlying
	 * integer array.
	 */
	@Override
	public String toString() {
		return "SearchableArray: " + Arrays.toString(arr);
	}
}
