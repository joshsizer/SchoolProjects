package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the human that wants to make a sentence out of 
 * the letters obtained from alphabet soup. I couldn't figure 
 * out what else to call this class. 
 * @author Josh Sizer
 */
public class StringConstructor {
	private final String string;
	private int bowlsOfSoup;
	private ArrayList<AlphabetSoup> usedBowls;
	private char limitingFactor;
	private final int[] lettersInString;
	
	/** 
	 * The constructor for a string
	 * @param string The string to calculate how many bowls of alphabet soup
	 * it would take to create. 
	 */
	public StringConstructor(String string) {
		this.string = string.toUpperCase();
		lettersInString = countLetters(this.string);
		usedBowls = new ArrayList<AlphabetSoup>();
		calculate();
	}
	
	public StringConstructor(File file) throws FileNotFoundException {
		this(readFile(file));
	}
	
	/**
	 * Returns the number of bowls it would take to construct 
	 * the inputed string. 
	 * @return
	 */
	public int getNumberBowls() {
		return bowlsOfSoup;
	}
	
	public ArrayList<AlphabetSoup> getUsedBowls() {
		return usedBowls;
	}
	
	public char getLimitingFactor() {
		return limitingFactor;
	}
	
	public int[] getLettersInString() {
		return lettersInString;
	}
	
	/**
	 * Calculates the number of bowls of soup needed
	 * 1) Counts the letters in the string
	 * 2) While we still need more letters:
	 *  	A) Create a bowl of soup
	 *  	B) Subtract all the letters in the bowl of soup
	 *  		from the string's needed number of letters
	 *  	C) Done if: EVERY LETTER IN THE 
	 *  		STRING'S NEEDED NUMBER OF LETTERS IS LESS
	 *  		THAN ZERO
	 */
	private void calculate() {
		int[] temp = new int[lettersInString.length];
		System.arraycopy(lettersInString, 0, temp, 0, lettersInString.length);
		boolean done = false;
		while (!done) {
			done = true;
			AlphabetSoup soup = new AlphabetSoup();
			usedBowls.add(soup);
			bowlsOfSoup++;
			int[] lettersInSoup = soup.getLetters();
			for (int i = 0; i < temp.length; i++) {
				temp[i] -= lettersInSoup[i];
				done = temp[i] <= 0 && done;
				if (temp[i] > 0) 
					limitingFactor = (char)(i + 'A');
			}
		}
	}
	
	/**
	 * Counts the letters in the string
	 * @param str The string to count
	 * @return The number of each letter contained in the 
	 * string.
	 */
	private static int[] countLetters(String str) {
		int[] lettersInString = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				lettersInString[ch - 'A']++;
		}
		return lettersInString;
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
