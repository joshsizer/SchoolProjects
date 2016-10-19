package main;

import java.util.ArrayList;

/**
 * A class that will find all the prime numbers between 2 and a specified number larger than 2
 * using ArrayLists as the underlying storage mechanism.
 * @author Josh Sizer
 *
 */
public class SieveArrayList {
	private int n;
	private int p;
	private ArrayList<Integer> primes;
	
	/**
	 * Create an object that contains all the prime numbers between 
	 * 2 and n with an array list as the underlying data structure. 
	 * @param n the largest value to check if prime
	 */
	public SieveArrayList (int n) {
		this.n = n;
		this.p = 2;
		primes = new ArrayList<Integer>(); 	// instantiate Integer ArrayList
		fill2toN(); 						// fills ArrayList with all numbers between 2 and n
		populatePrimes();					// removes all non-prime numbers from the arraylist
	}
	
	/**
	 * Gets all the prime numbers between 2 and n, the number inputted into the constructor
	 * @return An arraylist of prime numbers between 2 and n
	 */
	public ArrayList<Integer> getPrimes() {
		return primes;
	}
	
	private void populatePrimes() {
		// keeps on finding multiples of the current prime as long as the square of the prime is no greater than n
		for (int primeIndex = 0; p * p <= n; primeIndex++) { 
			p = primes.get(primeIndex); // the current prime number
			// goes through the array list starting at the first number above the prime number
			for (int i = primeIndex + 1; i < primes.size(); i++) { 
				// removes all multiples of p
				if (primes.get(i) % p == 0) {
					primes.remove(i);
				}
			}
		}
	}
	
	// fills array list with integers between 2 and n
	private void fill2toN() {
		for (int i = 0; i < n - 1; i++) { 
			primes.add(new Integer(i + 2));
		}
	}
	
	/**
	 * Returns a string of all the prime numbers between 2 and n in the format:
	 * [2, 3, 5, ..., 149] all on the same line
	 */
	public String toString() {
		String ret = "[";
		for (int i = 0; i < primes.size() - 1; i++) {
			ret += primes.get(i) + ", ";
		}
		return ret += primes.get(primes.size() - 1) + "]";
	}
}
