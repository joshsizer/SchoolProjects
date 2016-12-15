package main;

/**
 * 
 * @author Joshua Sizer
 *
 */
public class Main {
	public static void main(String[] args) {
		// the size of the SearchableArray and SortedSearchableArray
		int SIZE = 20;
		// the index of the numbers which we will use to prove our searching
		// capabilities. Since these arrays are random, we must attain a value
		// from some index to use as the target for our searches.
		int index1 = (int) (Math.random() * SIZE);
		int index2 = (int) (Math.random() * SIZE);
		int index3 = (int) (Math.random() * SIZE);
		SearchableArray SA1 = new SearchableArray(SIZE);
		
		System.out.println("=======SearchableArray==============");
		System.out.println(SA1);
		//Proof of linear search capabilities of SearchableArray
		System.out.println("Linear search performed to find " 
				+ SA1.getArray()[index1] + " at position: " + 
				SA1.linearSearch(SA1.getArray()[index1]));
		
		SortedSearchableArray SSA1 = new SortedSearchableArray(SIZE);
		
		System.out.println("\n=======SortedSearchableArray========");
		System.out.println(SSA1);
		// Proof of linear search capabilities of SortedSearchableArray.
		// This method is present because it inherited the method from its
		// super class, SearchableArray
		System.out.println("Linear search performed to find " 
				+ SSA1.getArray()[index2] + " at position : " + 
				SSA1.linearSearch(SSA1.getArray()[index2]));
		
		System.out.println("=======EXTRA FUNCTIONALITY==========\n"
				+ "SortedSearchableArray also has a binarySearch method," +
				" whereas SearchableArray does not.");
		
		// The binary search is a method only in the subclass SortedSearchableArray
		// because it was defined in the child class, so only the child class and all of 
		// its children will have the binary search method
		System.out.println("Binary search performed to find " 
				+ SSA1.getArray()[index3] + " at position : " + 
				SSA1.linearSearch(SSA1.getArray()[index3]));
	}
}
