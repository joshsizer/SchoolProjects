package main;

import java.util.List;

public class LinearSearch {
	public static int lastNumComparisons;
	
	/**
	 * Returns the last number of comparisons the last search took.
	 * @return
	 */
	public static int getLastNumComparisons() {
		return lastNumComparisons;
	}
	
	/**
	 * Sorts the given list using a linear sort. 
	 * @param list Can be unsorted or sorted, doesn't matter
	 * @param target The target to find in the list
	 * @return The first occurance of the target. 
	 */
	public static int search(List<Integer> list, int target) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == target) 
				return i;
		}
		return -1;
	}

}
