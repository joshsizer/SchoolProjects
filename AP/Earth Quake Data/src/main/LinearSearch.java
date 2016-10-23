package main;

import java.util.List;

public class LinearSearch {
	public static int lastNumComparisons = 0;
	
	/**
	 * Sorts the given list using a linear sort. 
	 * @param list Can be unsorted or sorted, doesn't matter
	 * @param target The target to find in the list
	 * @return The first occurance of the target. 
	 */
	public static int search(List<EarthQuake> list, Object target, Searcher comparator) {
		lastNumComparisons = 0;
		for (int i = 0; i < list.size(); i++) {
			lastNumComparisons++;
			if (comparator.compare(list.get(i), target) == 0) {
				return i;
			}
		}
		return -1;
	}

}
