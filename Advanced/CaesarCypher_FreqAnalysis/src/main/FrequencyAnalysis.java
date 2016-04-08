package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class can determine the offset (key) used to encrypt a string of text with a Caesar Cipher. 
 * By counting the frequency of letter occurrences, an educated guess can be made by finding the difference
 * between the most frequently occurring letter in the string and 'E', the most common letter in the 
 * English alphabet. The encrypted text is decrypted with this assumed offset, and the decrypted text is parsed 
 * for English words. If none are found, the next most common letter in the English language 'T' is used, and the 
 * steps are repeated until the correct offset decrypts the string into intelligible English. 
 * 
 * @author Josh Sizer
 */
public class FrequencyAnalysis {
	private static final String DICTIONARY_FILE_PATH = "Dictionary.txt";
	
	/** The calculated offset for the data inputed into constructor. */
	private int offset;
	
	/** The array with all the words in the English dictionary */
	private static String[] dictionary = loadDictionary();
	
	/** A list of the most frequent letters, in order. */
	private static final char[] frequent = new char[] 
			{'E', 'T', 'A', 'O', 'I', 'N', 'S', 'H', 'R', 
					'D', 'L', 'C', 'U', 'M', 'W', 'F', 'G',
					'Y', 'P', 'B', 'V', 'K', 'J', 'X', 'Q', 'Z'};
	
	/**
	 * Create a FrequencyAnalysis object that calculates the correct offset
	 * for a CaesarCipher. Optionally, you can  use the class's static methods
	 * instead of making an instance.
	 * @param data The encrypted data to calculate the offset to.
	 */
	public FrequencyAnalysis(String data) {
		this.offset = getOffset(data);
	}
	
	/**
	 * Get the offset used to encrypt the string inputed into the constructor
	 * @return The offset that can decrypt the data
	 */
	public int getOffset() {
		return offset;
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
	 * Actually calculates the offset (duh)
	 * @param data The encrypted string
	 * @return The offset that can decrypt the data. 
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
				ArrayList<String> wordsFound = new ArrayList<String>();
				// finds the offset by finding the distance between the current frequent letter
				// and the letter that has occurred the most in the encrypted data
				int offset = CaesarCipher.bound0to25((bigIndex + 'A') - frequent[i]);  
				// here, we make a cipher with the temporary offset
				// and decrypt the encrypted text with it. Then, we
				// go through each word in the decrypted text, and compare it
				// to the english dictionary to see if the word is an English word
				CaesarCipher cipher = new CaesarCipher(offset);
				String decrypted = cipher.decrypt(data);
				int wordCounter = 0;
				String[] words = tokenize(decrypted);
				for (String word : words) {
					if (isWord(word)) {
						if (!wordsFound.contains(word)) {
							wordsFound.add(word);
							wordCounter++;
						}
					}
				}
				
				// as long as the decrypted string has at least 10 words in them, we return the current offset.
				// if the decrypted string has less than 9 actual tokens, we  make sure
				// that at least one of them is an English word
				if ((wordCounter > 10) || (words.length <= 10 && wordCounter > 0)) {
					return offset;
				}
			}
		}
		// if an offset cannot be calculated or if the dictionary cannot be found, we just return 
		// the offset assuming E is the most occurring letter
		return CaesarCipher.bound0to25((bigIndex + 'A') - 'E'); 
	}
	
	/**
	 * Tallies up all the occurrences of a letter in a string
	 * @param data
	 * @return An <code>int[]</code> where the first index is the number of occurrences for A, 
	 * the second index is the number of occurrences for B, and so on
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
			// checks if it is only characters, 
			// and adds it only if it only contains characters
			boolean isOnlyCharacters = true;
			for (int i = 0; i < curToken.length(); i++) {
				if (curToken.charAt(i) < 'A' || curToken.charAt(i) > 'Z') {
					isOnlyCharacters = false;
				}
			}
			if (isOnlyCharacters) {
				data += curToken + " ";
				size++;
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
	 * @param word The word to check
	 * @return True if it is a word in the dictionary, false if it is not.
	 */
	private static boolean isWord(String word) {
		for (String cur : dictionary) {
			if (cur.equalsIgnoreCase(word))
				return true;
		}
		return false;
	}
	
	/**
	 * Reads in the words in a dictionary file
	 * @return A <code>String[]</code> containing all the words in a dictionary file
	 */
	private static String[] loadDictionary() {
		Scanner input;
		try {
			input = new Scanner(new File(DICTIONARY_FILE_PATH));
		} catch (FileNotFoundException e) {return null;}
		
		String data = "";
		
		while (input.hasNextLine()) {
			data = data.toUpperCase();
			data += input.nextLine() + "\n";
		}
		input.close();
		return tokenize(data);
	}
}
