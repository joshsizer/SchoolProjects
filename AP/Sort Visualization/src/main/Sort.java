package main;

import gui.Frame;
import gui.IntegerBar;
import gui.IntegerBarManager;

public class Sort {
	
	/**
	 * Sorts the data, waiting 1 second in between each sort pass.
	 * @param a The array of IntegerBars to sort
	 * @param GUI The frame of the program
	 * @param manager The IntegerBarManager that was used to generate the list of IntegerBars from
	 * the original data set.
	 */
	public static void selectionSort(IntegerBar[] a, Frame GUI, IntegerBarManager manager) {
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
				
				// updates the x position of the swapped IntegerBars
				// so they are drawn in the correct place
				manager.setXPos(a[min], min);
				manager.setXPos(a[i], i);
				
				holdOn();
				GUI.set(a);
				GUI.repaint();
		}
	}
	
	/**
	 * Sorts the data, waiting 1 second in between each sort pass.
	 * @param a The array of IntegerBars to sort
	 * @param GUI The frame of the program
	 * @param manager The IntegerBarManager that was used to generate the list of IntegerBars from
	 * the original data set.
	 */
	public static void insertionSort(IntegerBar[] a, Frame GUI, IntegerBarManager manager) {
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
				GUI.set(a);
				GUI.repaint();
			}
			a[position] = key;
			manager.setXPos(a[position], position);
		}
	}
	
	/**
	 * Puts the current thread to sleep for one second
	 */
	public static void holdOn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
