package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Insertion {
	
	public static void sortStrings(String[] input) {
		String toSort;
		int sortedIndex;
		
		for (int i = 1; i < input.length; i++) {
			toSort = input[i];
			sortedIndex = i;
			while (sortedIndex > 0 && input[sortedIndex-1].compareToIgnoreCase(toSort) > 0) {
				input[sortedIndex] = input[sortedIndex - 1];
				sortedIndex--;
			}
			input[sortedIndex] = toSort;
		}
	}
	
	public static void sortIntegers(int[] input) {
		int toSort;
		int sortedIndex;
		
		for (int i = 1; i < input.length; i++) {
			toSort = input[i];
			sortedIndex = i;
			while (sortedIndex > 0 && input[sortedIndex-1] > toSort) {
				input[sortedIndex] = input[sortedIndex - 1];
				sortedIndex--;
			}
			input[sortedIndex] = toSort;
		}
	}
	
	public static String[] sortFile(File file) throws FileNotFoundException {
		String[] words = tokenizeFile(file);
		sortStrings(words);
		return words;
	}
	
	public static String[] tokenizeFile(File file) throws FileNotFoundException {
		String[] tokens;
		int size = 0;
		String text = readFile(file);
		Scanner lineTokenizer = new Scanner(text);
		
		while (lineTokenizer.hasNextLine()) {
			String line = lineTokenizer.nextLine();
			Scanner wordTokenizer = new Scanner(line);
			while (wordTokenizer.hasNext()) {
				wordTokenizer.next();
				size++;
			}
		}
		tokens = new String[size];
		
		lineTokenizer = new Scanner(text);
		
		int index = 0;
		while (lineTokenizer.hasNextLine()) {
			String line = lineTokenizer.nextLine();
			Scanner wordTokenizer = new Scanner(line);
			while (wordTokenizer.hasNext()) {
				String word = wordTokenizer.next();
				word = word.replaceAll("[.!?\\-'\"{}<>();*]_", "");
				tokens[index++] = word;
			}
		}
		return tokens;
	}

	/**
	 * Reads in text from a file.
	 * 
	 * @param file
	 *            The file object representing the file to be read
	 * @return A string with the complete file including carriage returns.
	 * @throws FileNotFoundException
	 *             if the file passed can not be found on the file system
	 */
	public static String readFile(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		String data = "";
		while (input.hasNextLine()) {
			data += input.nextLine() + "\n";
		}
		input.close();
		return data;
	}
}
