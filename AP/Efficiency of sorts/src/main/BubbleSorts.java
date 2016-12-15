/**
 * @author rsteinberg

 * @date	12/14/16
 * 
 * 3 different versions of bubble sort are shown in this class.
 */

/*
 * 
 * Note: I removed the printing of the Arrays, since it was unattractive
 * and removed focus from the main point: the efficiency of the bubble sorts.
 * 
 * The version of bubble sort that is most efficient is bubble sort
 * #1. With an array size of 50, it averaged around 1200 iterations, while
 * bubble sort 2 was constant 1225 iterations, and bubble sort 3 was a constant
 * 2450 iterations.
 * 
 * With an array size of 100, the average iterations for bubble sort 1 was
 * 4850, while bubble sort 2 has a constant 4950 iterations and bubble sort 
 * 3 has a constant of 9900 iterations
 * 
 * There is a small difference in the efficiency between sort 1 and 2,
 * where sort 1 always performs at least the same as sort 2, but on average
 * performs better. Bubble sort 3 is always  2 times as inefficient,
 * taking 2 times as many iterations. 
 * 
 * 
 */

package main;

import java.util.Random;

public class BubbleSorts {
	public static int b1Count;
	public static int b2Count;
	public static int b3Count;

	public static void main(String[] args) {
		int arraysize = 4000;

		int[] bs1 = new int[arraysize];
		int[] bs2 = new int[arraysize];
		int[] bs3 = new int[arraysize];

		Random rnd = new Random();
		
		// How many sorts to make an average from
		int numAverage = 50;
		int averageb1 = 0;
		int averageb2 = 0;
		int averageb3 = 0;

		System.out.println("Array size: " + arraysize);
		System.out.println("Number of averaged sorts: " + numAverage);
		// runs the sorts for the specified numAverage
		for (int i = 0; i < numAverage; i++) {
			// refills the array with random numbers
			for (int k = 0; k < arraysize; k++) {
				bs1[k] = bs2[k] = bs3[k] = rnd.nextInt(arraysize);
			}

			bs1 = bubbleSort1(bs1);
			bs2 = bubbleSort2(bs2);
			bs3 = bubbleSort3(bs3);

			averageb1 += b1Count;
			averageb2 += b2Count;
			averageb3 += b3Count;
		}
		System.out.println("Bubble Sort 1 always has a better average.");
		System.out.println("B1 Average: " + averageb1/numAverage);
		System.out.println("B2 Average: " + averageb2/numAverage);
		System.out.println("B3 Average: " + averageb3/numAverage);
	}

	/**
	 * bubbleSort1 uses the bubblesort algorithm to put an array in order from
	 * least to greatest
	 * 
	 * @param int[]
	 *            the array passed into the method
	 * @return int[] the sorted array
	 */
	public static int[] bubbleSort1(int arr[]) {
		b1Count = 0;
		boolean unsorted = true;
		int n = arr.length;
		int temp;

		while (unsorted) {
			unsorted = false;
			for (int i = 1; i < n; i++) {
				if (arr[i] < arr[i - 1]) {
					temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					unsorted = true;
				}
				b1Count++;
			}
			n--;
		}
		return arr;
	}

	/**
	 * bubbleSort2 uses the bubblesort algorithm to put an array in order from
	 * least to greatest
	 * 
	 * @param int[]
	 *            the array passed into the method
	 * @return int[] the sorted array
	 */
	public static int[] bubbleSort2(int arr[]) {
		b2Count = 0;
		int temp;
		for (int pass = 1; pass <= arr.length; pass++) {
			for (int i = 1; i <= arr.length - pass; i++) {
				if (arr[i - 1] > arr[i]) {
					temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
				}
				b2Count++;
			}
		}
		return arr;
	}

	/**
	 * bubbleSort3 uses the bubblesort algorithm to put an array in order from
	 * least to greatest
	 * 
	 * @param int[]
	 *            the array passed into the method
	 * @return int[] the sorted array
	 */
	public static int[] bubbleSort3(int arr[]) {
		b3Count = 0;
		int temp;
		for (int pass = 0; pass < arr.length; pass++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
				b3Count++;
			}
		}
		return arr;
	}
}
