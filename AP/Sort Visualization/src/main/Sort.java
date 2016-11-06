package main;

import java.util.Arrays;

import gui.Frame;
import gui.IntegerBar;
import gui.RectangleManager;

public class Sort {
	public static void selectionSort(IntegerBar[] a, Frame GUI, RectangleManager manager) {
		int min;
		for (int i = 0; i < a.length - 1; i++) {
			min = i;
			for (int k = i + 1; k < a.length; k++) {
			
	
			if (a[k].getInt() < a[min].getInt()) 
				min = k;
			}

			IntegerBar t = a[i];
			a[i] = a[min];
			a[min] = t;
			
			manager.setXPos(a[min], min);
			manager.setXPos(a[i], i);
			
			holdOn();
			GUI.set(a, -1, -1);
			GUI.repaint();
		}
	}
	
	public static void insertionSort(IntegerBar[] a, Frame GUI, RectangleManager manager) {
		for (int i = 1; i < a.length - 1; i++) {
			IntegerBar key = a[i];
			int position = i;
			while (position > 0 && a[position - 1].getInt() > key.getInt()) {
				IntegerBar t = a[position];
				a[position] = a[position - 1];
				a[position - 1] = t;
				manager.setXPos(a[position], position);
				manager.setXPos(a[position - 1], position - 1);
				position--;
				holdOn();
				GUI.set(a, -1, -1);
				GUI.repaint();
			}
			a[position] = key;
			manager.setXPos(a[position], position);
			
			
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int t = arr[b];
		arr[b] = arr[a];
		arr[a] = t;
	}
	
	public static void holdOn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
