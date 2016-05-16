package main;

import java.util.ArrayList;

/** 
 * Compresses data. 
 * @author 18jsizer
 *
 */
public class RunLength {
	public static ArrayList<Integer> encode(int[] input) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		int inARow = 1;
		for (int index = 0; index < input.length; index++) {
			int current = input[index];
			if (index + 1 < input.length && input[index + 1] == current) {
				inARow++;
			} else {
				int number = input[index];
				if ((inARow > 3 && number != 0) || (inARow > 1 && number == 0)) {
					output.add(0);
					output.add(inARow);
					output.add(number);
				} else if (number != 0) {
					for (int i = 0; i < inARow; i++) {
						output.add(number);
					}
				} else {
					output.add(0);
					output.add(0);
				}
				inARow = 1;
			}
		}
		return output;
	}
	
	public static ArrayList<Integer> decode(int[] input) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			int cur = input[i];
			if (cur == 0) {
				if (i + 1 < input.length && input[i + 1] == 0) {
					output.add(0);
					i++;
				} else if (i + 2 < input.length) {
					int runLength = input[i+1];
					int number = input[i+2];
					for (int k = 0; k < runLength; k++) {
						output.add(number);
					}
					i += 2;
				}
			} else {
				output.add(input[i]);
			}
		}
		return output;
	}
}
