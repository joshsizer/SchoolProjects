package main;

import java.util.ArrayList;

/**
 * A class that will find all the prime numbers between 2 and a specified number larger than 2, using arrays 
 * as the underlying storage mechanism. 
 * @author Josh Sizer
 *
 */
public class SieveArray {
	private int n;
	private int p;
	private int[] primes;
	
	public SieveArray (int n) {
		this.n = n;
		this.p = 2;
		primes = new int[n-1]; 	// instantiate Integer ArrayList
		fill2toN(); 						// fills ArrayList with all numbers between 2 and n
		populatePrimes();
	}
	
	/**
	 * Gets all the prime numbers between 2 and n, the number inputed into the constructor
	 * @return An array of prime numbers between 2 and n
	 */
	public int[] getPrimes() {
		return primes;
	}
	
	// removes all non primes from the prime array
	private void populatePrimes() {
		for (int primeIndex = 0; p * p <= n; primeIndex++) {
			int[] nextIterationPrimes;
			int nextIterationPrimesSize = 0;
			p = primes[primeIndex];
			
			// Calculates how many numbers should be in the next iteration of the primes array.
			// Goes through each element in the array. As long as it is not a multiple of p, it 
			// increases the nextIterationPrimes size
			for (int i = 0; i < primes.length; i++) {
				if (primes[i] % p != 0 || primes[i] == p) // since p itself should be included
					nextIterationPrimesSize++;
			}
			// Now we make an array of that calculated size
			nextIterationPrimes = new int[nextIterationPrimesSize];
			
			// Here we fill the array with all the numbers that are not multiples of p
			// we need two counters: one for primes array and one for the nextIterationPrimes array
			int currentTempIndex = 0; 
			for (int i = 0; i < primes.length; i++) { 
				if (primes[i] % p != 0 || primes[i] == p) {
					nextIterationPrimes[currentTempIndex++] = primes[i];
				}
			}
			primes = nextIterationPrimes; // the final primes array is set to the nextIterationPrimes
		} 
	}
	
	// fills the primes array with numbers from 2 to n
	private void fill2toN() {
		for (int i = 0; i < primes.length; i++) {
			primes[i] = i + 2;
		}
	}
	
	/**
	 * Returns a string of all the prime numbers between 2 and n in the format:
	 * [2, 3, 5, ..., 149] all on the same line
	 */
	public String toString() {
		String ret = "[";
		for (int i = 0; i < primes.length - 1; i++) {
			ret += primes[i] + ", ";
		}
		return ret += primes[primes.length - 1] + "]";
	}
}
