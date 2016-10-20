package main;

import java.util.List;

/**
 * A class with static methods to perform a BinarySearch
 * @author joshs
 *
 */
public class BinarySearch {
	public static int lastNumComparisons;
	
	/**
	 * Returns the last number of comparisons the last search took.
	 * @return
	 */
	public static int getLastNumComparisons() {
		return lastNumComparisons;
	}
	
	/**
	 * Returns the index of which the BinarySearch finds the occurance of the target.
	 * @param <T>
	 * 
	 * @param list The SORTED list which (hopefully) contains your target
	 * @param target Your target integer
	 * @return The index of your target if it exists in the list, or -1 if it does not.
	 */
	public static <T> int search(List<EarthQuake> list, double target, Sortator<EarthQuake> sortator) {
		 int low = 0, high = list.size() - 1, middle = (low + high) / 2;
	      lastNumComparisons = 0;

	      while (sortator.get(list, middle) != target && low <= high) {
	    	  lastNumComparisons++;
	    	  if (target < sortator.get(list, middle))
	    		 high = middle - 1;
	    	  else
	    		 low = middle + 1;
	    	  lastNumComparisons++;
	    	  middle = (low + high) / 2;
	      }
	      
	      lastNumComparisons++;
	      if (sortator.get(list, middle) == target)
	         return middle;
	      else
	         return -1;
		}
}
