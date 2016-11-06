package main;

import java.util.Scanner;

import gui.Frame;
import gui.IntegerBar;
import gui.RectangleManager;

public class Main {

	public static void main(String[] args) {
		int[] test = new int[50];
		fillRandom(test, -100, 100);
		Frame GUI;

		
		Scanner userInput = new Scanner(System.in);
		System.out.println("Would you like see a visualization for selection sort(0) or insertion sort(1)?");
		int choice = Integer.parseInt(userInput.nextLine());
		// create the frame
		if (choice == 0)
			GUI = new Frame("Selection Sort");
		else
			GUI = new Frame("Insertion Sort");
		GUI.setVisible(true);
		GUI.setAlwaysOnTop(true);
		
		
		//generate all the rectangle
		RectangleManager manager = new RectangleManager(test, 50, GUI.getHeight() - 50, GUI.getSize(), 30);
		
		IntegerBar[] bars = manager.generateRectangles();
		GUI.set(bars, -1, -1);
		//maker = new RectangleMaker(test2, 50, GUI.getHeight() - 50, GUI.getSize(), 30);
		//bars = maker.generateRectangles();
		//GUI.getPanel().setIntegerBars(bars);
		
		if (choice == 0)
			Sort.selectionSort(bars, GUI, manager);
		else 
			Sort.insertionSort(bars, GUI, manager);
	}
	
	public static void fillRandom(int[] arr, int min, int max) {
		int range = max - min;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * (double)range) + min;
		}
	}

}
