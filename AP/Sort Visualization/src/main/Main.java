package main;

import gui.Frame;
import gui.RectangleMaker;

public class Main {

	public static void main(String[] args) {
		int[] test = new int[] {3, 8, -22, -19, 22, -122, 78};
		//Sort.selectionSort(test);
		
		Frame GUI = new Frame(RectangleMaker.generateRectangles(test));

		GUI.setVisible(true);
	}

}
