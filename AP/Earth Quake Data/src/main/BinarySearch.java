package main;

import java.util.List;

/**
 * A class with static methods to perform a BinarySearch
 * 
 * @author joshs
 *
 */
public class BinarySearch {
	public static int lastNumComparisons;

	/**
	 * Returns the index of which the BinarySearch finds the occurance of the
	 * target.
	 * 
	 * @param <T>
	 * 
	 * @param list
	 *            The SORTED list which (hopefully) contains your target
	 * @param target
	 *            Your target integer
	 * @param order The order of the data, either low to high or high to low
	 * 
	 * @return The index of your target if it exists in the list, or -1 if it
	 *         does not.
	 */
	public static <T> int search(List<EarthQuake> list, Object target, Searcher comparator, int order) {
		if (order == DataProcessing.LOW_TO_HIGH) {
			int low = 0, high = list.size() - 1, middle = (low + high) / 2;
			lastNumComparisons = 0;
			
	
			while (comparator.compare(list.get(middle), target) != 0 && low <= high) {
				lastNumComparisons++;
				if (comparator.compare(list.get(middle), target) > 0)
					high = middle - 1;
				else
					low = middle + 1;
				lastNumComparisons++;
				middle = (low + high) / 2;
			}
	
			lastNumComparisons++;
			if (comparator.compare(list.get(middle), target) == 0)
				return middle;
			else
				return -1;
		} else {
			int low = 0, high = list.size() - 1, middle = (low + high) / 2;
			lastNumComparisons = 0;
			
			while (comparator.compare(list.get(middle), target) != 0 && low <= high) {
				lastNumComparisons++;
				if (comparator.compare(list.get(middle), target) < 0)
					high = middle - 1;
				else
					low = middle + 1;
				lastNumComparisons++;
				middle = (low + high) / 2;
			}
	
			lastNumComparisons++;
			if (comparator.compare(list.get(middle), target) == 0)
				return middle;
			else
				return -1;
		}
	}
}
