package main;

import java.util.ArrayList;

public class Main {
	public static void main (String args[]) {
		SieveArrayList primesArrayList = new SieveArrayList(100);
		SieveArray primesArray = new SieveArray(100);

		System.out.print("The following primes were found by using ArrayLists as the underlying storage mechanism:\n");
		ArrayList<Integer> allPrimesArrayList= primesArrayList.getPrimes();
		for (int i = 0; i < allPrimesArrayList.size(); i++) {
			System.out.print(allPrimesArrayList.get(i) + ", ");
		}		
		System.out.println("\nIts toString method: " + primesArrayList.toString());
		
		System.out.println("\n==================================================================================\n"
				+ "The following primes were found by using arrays as the underlying storage mechanism:");
		int[] allPrimesArray = primesArray.getPrimes();
		for (int i = 0; i < allPrimesArray.length; i++) {
			System.out.print(allPrimesArray[i] + ", ");
		}
		System.out.println("\nIts toString method: " + primesArray.toString());
	}
}
