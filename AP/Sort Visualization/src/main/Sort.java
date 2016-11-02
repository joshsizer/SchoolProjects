package main;

public class Sort {
	public static void selectionSort(int[] a) {
		int min;
		for (int i = 0; i < a.length - 1; i++) {
			min = i;
			for (int k = i + 1; k < a.length; k++) {
				if (a[k] < a[min])
					min = k;
			}
			int t = a[i];
			a[i] = a[min];
			a[min] = t;
		}
	}
	
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length - 1; i++) {
			int key = a[i];
			int position = i;
			while (position > 0 && a[position - 1] > key) {
				a[position] = a[position - 1];
				position--;
			}
			a[position] = key;
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int t = arr[b];
		arr[b] = arr[a];
		arr[a] = t;
	}
}
