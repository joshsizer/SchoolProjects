package main;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// simple proof
		Rational one = new Rational(
				(int) (Math.random() * 50), (int) (Math.random() * 50));
		Rational two = new Rational(
				(int) (Math.random() * 50), (int) (Math.random() * 50));
		
		System.out.println("First: " + one.toString() + ", Second: " + two.toString());
		
		int compare = one.compareTo(two);
		
		if (compare == 0)
			System.out.println("The two rationals are equal");
		else if (compare > 0)
			System.out.println("The first rational is larger than the second rational");
		else
			System.out.println("The first rational is smaller than the second rational");
		
		// more complex proof
		Rational[] list = new Rational[(int) (Math.random() * 5) + 5];
				
		//fill array with random rational numbers
		for (int i = 0; i < list.length; i++) {
			list[i] = new Rational(
				(int) (Math.random() * 50), (int) (Math.random() * 50));
		}
		
		System.out.println("\nUnsorted: " + printArray(list));
		
		//bubble sort using compare to method
		for (int i = 0; i < list.length; i++) {
			for (int k = 0; k < list.length - i - 1; k++) {
				if (list[k].compareTo(list[k+1]) > 0) {
					Rational smallest = list[k+1];
					list[k+1] = list[k];
					list[k] = smallest;
				}
			}
		}
		
		System.out.println("Sorted: " + printArray(list));
	}
	
	public static String printArray(Rational[] array) {
		String toPrint = "[";
		for (int i = 0; i < array.length-1; i++) {
			toPrint += array[i] + ", ";
		}
		toPrint+= array[array.length - 1] + "]";
		return toPrint;
	}
}
