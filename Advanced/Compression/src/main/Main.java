package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The input for this program is:
 * 	The number of sequences to decode and then for each sequence,
 * 		The number of elements in the sequence 
 * 		The actual sequence
 * @author 18jsizer
 *
 */
public class Main {
	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		// asks user for the number of sequences to be decoded
		int numberOfSequences = promptForNumber();
		ArrayList<?>[] inputs = new ArrayList<?>[numberOfSequences];
		ArrayList<?>[] outputs = new ArrayList<?>[numberOfSequences];
		
		// for every sequence to be decodes, the user is asked 
		// how many numbers are in the current sequence, and then 
		// the sequence
		for (int i = 0; i < numberOfSequences; i++) {
			int arraySize = promptForNumber();
			String list = userInput.nextLine();
			int[] toDecode = parseSequence(list, arraySize);
			ArrayList<Integer> decoded = RunLength.decode(toDecode);
			
			// adds the inputed sequence and the output sequence
			// to an array
			inputs[i] = toArrayList(toDecode);
			outputs[i] = decoded;
		}
		
		// prints each input and corresponding output
		for (int i = 0; i < numberOfSequences; i++) {
			printArrayList(inputs[i]);
			System.out.println();
			printArrayList(outputs[i]);
			System.out.println("\n");
		}
	}
	
	/**
	 * Converts an int array into an Arraylist
	 * @param input The array to be converted
	 * @return The array list
	 */
	public static ArrayList<Integer> toArrayList(int[] input) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			output.add(input[i]);
		}
		return output;
	}
	
	/**
	 * Parses a string of numbers seperated by spaces and puts
	 * each element into an index of an array
	 * @param input The string to be parsed
	 * @param size The number of elements in the string
	 * @return An array with all elements contained within the 
	 * original string
	 */
	public static int[] parseSequence(String input, int size) {
		int[] sequence = new int[size];
		Scanner parser = new Scanner(input);
		for (int i = 0; i < sequence.length && parser.hasNextInt(); i++) {
			sequence[i] = parser.nextInt();
		}
		parser.close();
		return sequence;
	}
	
	/**
	 * Prints an array list
	 * @param list The array list to print
	 */
	public static void printArrayList(ArrayList<?> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	/**
	 * Asks a user for an input until that input
	 * is a number.
	 * @return The number inputted by the user.
	 */
	public static int promptForNumber() {
		String input = userInput.nextLine();
		while (!isNumber(input)) {
			input = userInput.nextLine();
		}
		return Integer.parseInt(input);
	}
	
	/**
	 * Checks if a given string contains only numeric characters
	 * @param n The input string
	 * @return True if it only contains numeric characters,
	 * false if it contains any other
	 */
	public static boolean isNumber(String n) {
		return n.matches("[0-9]+");
	}
}
