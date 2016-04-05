package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyAnalysis {
	private static final String DICTIONARY_FILE_PATH = "Dictionary.txt";
	
	/** The data to analyze. */
	private int offset;
	
	/** The array with all the words in the English dictionary */
	private static String[] dictionary;
	
	/** A list of the most frequent letters, in order. */
	private static final char[] frequent = new char[] 
			{'E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R', 
					'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G',
					'Y', 'P', 'B', 'V', 'K', 'J', 'X', 'Q', 'Z'};
	
	/**
	 * Create a FrequencyAnalysis object that calculates the correct offset
	 * for a CaesarCipher. Optionally, you can just use the classes static methods
	 * instead of making an instance.
	 * @param data The encrypted data to calculate the offset to.
	 */
	public FrequencyAnalysis(String data) {
		data = data.toUpperCase();
		dictionary = loadDictionary();
		this.offset = calculateOffset(data);
	}
	
	/** 
	 * Get the offset used to encrypt the inputed string
	 * @param data The encrypted data
	 * @return The offset that can decrypt the data
	 */
	public static int getOffset(String data) {
		if (dictionary == null)
			dictionary = loadDictionary();
		data = data.toUpperCase();
		return calculateOffset(data);
	}
	
	/**
	 * Get the offset used to encrypt the string inputed into the constructor
	 * @return The offset that can decrypt the data
	 */
	public int getOffset() {
		return offset;
	}
	
	/**
	 * Actually calculates the offset (duh)
	 * @param data the encrypted string
	 * @return the offset that can decrypt the data
	 */
	private static int calculateOffset(String data) {
		int[] letterCount = countLetters(data); // counts how many times each letter occurs
		int biggest = 0; // keeps track of the largest number of letters
		int bigIndex = 0; // keeps track of which letter occurs the most
		for (int i = 0; i < letterCount.length; i++) {
			if (letterCount[i] > biggest) {
				biggest = letterCount[i];
				bigIndex = i;
			}
		}
		
		if (dictionary != null) {
			for (int i = 0; i < frequent.length; i++) {
				// finds the offset by finding the distance between the current frequent letter
				// and the letter that has occurred the most in the encrypted data
				int offset = bound0to26((bigIndex + 'A') - frequent[i]);  
				// here, we make a cipher with the temporary offset
				// and decrypt the encrypted text with it. Then, we
				// go through each word in the decrypted text, and compare it
				// to the english dictionary to see if the word is an english word
				CaesarCipher cipher = new CaesarCipher(offset);
				String decrypted = cipher.decrypt(data);
				int wordCounter = 0;
				String[] words = tokenize(decrypted);
				for (String word : words) {
					if (isWord(word))
						wordCounter++;
				}
				
				// as long as the decrypted string has at least 5 words in them, we return the current offset.
				// if the decrypted string has less than 4 actual tokens, we  make sure
				// that at least one of them is an english word
				if ((wordCounter > 4 && words.length > 4) || (words.length <= 4 && wordCounter > 0)) {
					return offset;
				}
			}
		}
		return (bigIndex + 'A') - 'E';
	}
	
	/**
	 * Tallies up all the occurrences of a letter in a string
	 * @param data
	 * @return an int[] where the first index is the number of occurrence for A, and so on
	 */
	private static int[] countLetters(String data) {
		int[] letterCount = new int[26];
		for (int i = 0; i < data.length(); i++) {
			int cur = data.charAt(i);
			if (cur >= 'A' && cur <= 'Z') 
				letterCount[cur - 'A']++;
		}
		return letterCount;
	}
	
	/**
	 * Splits a string into its separate words, separated by spaces. A token will only
	 * be counted as a token if all of its characters are letters.
	 * @param string The string to tokenize
	 * @return An array of all the words in the string.
	 */
	private static String[] tokenize(String string) {
		Scanner tokenizer = new Scanner(string);
		String data = "";
		int size = 0;
		while (tokenizer.hasNext()) {
			String curToken = tokenizer.next();
			for (int i = 0; i < curToken.length(); i++) {
				if (curToken.charAt(i) >= 'A' && curToken.charAt(i) <= 'Z') {
					data += curToken + " ";
					size++;
				}
			}
		}
		
		String[] ret = new String[size];
		tokenizer.close();
		tokenizer = new Scanner(data);
		for (int i = 0; i < size; i++) {
			if (tokenizer.hasNext())
				ret[i] = tokenizer.next();
		}
		tokenizer.close();
		return ret;
	}
	
	/**
	 * Checks if a string is a word found in the English dictionary
	 * @param word the word to check
	 * @return True if it is a word in the dictionary, false if it is not.
	 */
	private static boolean isWord(String word) {
		for (String cur : dictionary) {
			if (cur.equalsIgnoreCase(word))
				return true;
		}
		return false;
	}
	
	private static String[] loadDictionary() {
		Scanner input;
		try {
			input = new Scanner(new File(DICTIONARY_FILE_PATH));
		} catch (FileNotFoundException e) {return null;}
		
		String[] allWords;
		String data = "";
		int size = 0;
		
		while (input.hasNextLine()) {
			data += input.nextLine() + "\n";
			size++;
		}
		input.close();
		
		allWords = new String[size];
		Scanner tokenizer = new Scanner(data);
	
		for (int i = 0; i < data.length(); i++) {
			if (tokenizer.hasNextLine())
				allWords[i] = tokenizer.nextLine();
		}
		
		tokenizer.close();
		return allWords;
	}
	
	// adds or subtracts 26 until the argument is in the bound 0 to 26
	private static int bound0to26(int k) {
		while (k > 25 || k < 0) {
			if (k > 25)
				k -= 26;
			else
				k += 26;
		}
		return k;
	}
}
