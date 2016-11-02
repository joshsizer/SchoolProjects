package main;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] test = new int[] {3, 8, -22, -19, 22, -122, 78};
		Sort.selectionSort(test);
		System.out.print(Arrays.toString(test));

	}

}
