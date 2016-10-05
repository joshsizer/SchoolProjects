package main;

/**
 * This is the Cipher class which does the encryption and decryption. 
 * 
 * The flow of encryption: 
 * 1) Convert input and key to uppercase, and remove punctuation.
 * 2) Generate the entire key for the text to be encrypted. This is 
 * 		accomplished by counting the number of non-space characters in the
 * 		input text, then appending the input text (to a specified index) 
 * 		to onto the key.
 * 3) Use the Key as the X-axis of the encryption table and the input character
 * 		as the y-axis of the encryption character. 
 * 4) Skip over spaces, so that the spaces are retained in the original text.
 * 
 * The flow of decryption:
 * 1) Convert input and key to uppercase and remove punctuation.
 * 2) Start decryption using the key alone. This entails finding the
 * 		y-value of the current encrypted character in the key-columb
 * 2) During decryption, we must assemble the rest of the key while 
 * 		deciphering.
 * 
 * @author Josh Sizer
 *
 */

public class Cipher {
	/**
	 * The input text. This is either encrypted or plain text.
	 */
	private String input = "";
	/**
	 * The full key to which encrypts the string or the partial key which decrypts 
	 * the string
	 */
	private String key = "";
		
	/**
	 * This is the output of the cipher. It will either be the decrypted
	 * or encrypted String, based on the action argument in the constructor. 
	 */
	private String result = "";
	
	/**
	 * The cipher table with the 2D array of letters A-Z.
	 */
	private char[][] table;

	public static int ENCRYPT = 0;
	public static int DECRYPT = 1;
	
	/**
	 * Creates an object which holds the key, input text, 
	 * and ciphered/plain text. 
	 * @param input The input text to be encrypted or decrypted
	 * @param key The key for which encryption and decryption can occur
	 * @param action The desired action of encryption or decryption. The 
	 * 			class has static integers to designate your intent
	 */
	public Cipher(String input, String key, int action) {
		table = new char[26][26];
		initializeTable();
		//printTable();
		
		// cook the input data
		input = input.toUpperCase();
		input = removePunctuation(input);
		this.input = input;
		key = key.toUpperCase();
		key = removePunctuation(key);
		key = key.replaceAll(" ", "");
		this.key = key;		
		
		if (action == ENCRYPT) {
			generateFullKey();
			result = encrypt();
		} else {
			result = decrypt();
		}
	}
	
	/**
	 * Encrypts the input string using the provided key. 
	 * @return the encrypted String
	 */
	private String encrypt() {
		int inputLet = 0;
		char curInput;
		char curKey;
		String output = "";

		// goes through the input text
		for (int i = 0; i < this.input.length(); i++) {
			curInput = input.charAt(i);
			/*
			 *  the index of the current key character
			 *  will be different than index of the current
			 *  character in the input text, so we must keep
			 *  track of the correct index in the key.
			 */
			curKey = key.charAt(inputLet);

			// if the current character is a space, we add
			// it to the output and that's all
			if (curInput == ' ') {
				output += " ";
				continue;
			}
			
			/*
			 * Just finds the character at the (key, input character)
			 * point in the cipher table
			 */
			output += table[curKey - 'A'][curInput - 'A'];
			inputLet++;
		}
		return output;
	}

	/**
	 * Decrypts the entered string with the provided key.
	 * @return
	 */
	private String decrypt() {
		int finalKeySize = input.replaceAll(" ", "").length();
		int inputLet = 0;
		char curInput;
		char curKey;
		String output = "";

		// goes through the input text
		for (int i = 0; i < this.input.length(); i++) {
			curInput = input.charAt(i);
			/*
			 *  the index of the current key character
			 *  will be different than index of the current
			 *  character in the input text, so we must keep
			 *  track of the correct index in the key.
			 */
			curKey = key.charAt(inputLet);
			
			// just add spaces to the output array
			if (curInput == ' ') {
				output += " ";
				continue;
			}
			
			/*
			 * Here we calculate what the decrypted letter should
			 * be, where outChar is a number between 0 and 25, 
			 * representing the character.
			 * 
			 * The way we do this is by finding the distance between
			 * the key and the input letter. This avoids having
			 * to itterate through the 2D array to find what y-index
			 * the input letter occurs at. 
			 */
			int outChar;
			
			/*
			 * If the key character is after the input character,
			 * then we gotta find the "wrapped distance" or the
			 * shortest distance from the key to the input character
			 * if the alphabet was assumed to wrap.
			 */
			if (curKey > curInput) 
				outChar = 26 - (curKey - curInput);
			else
				outChar = curInput - curKey;
			
			outChar = outChar + 'A';
			output += (char)outChar; 
			
			/*
			 * Add the decrypted character to the key until there
			 * is enough letters in the key to decrypt the
			 * entire input string.
			 */
			if (key.length() < finalKeySize) 
				key += (char)outChar;
			
			// increments the counter for the current key
			inputLet++;
		}
		return output;
	}
	
	
	/**
	 * Removes all but capital letters and spaces. 
	 * @param input The text to remove punctuation
	 * @return A string with only spaces and capital letters
	 */
	public String removePunctuation(String input) {
		String output = "";
		if (input.charAt(0) == ' ')
			input = input.substring(1);
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur == ' ' || (cur >= 'A' && cur <= 'Z'))
				output += cur;
		}
		return output;
	}
	
	/**
	 * If encrypting, this generates the full key before
	 * the start of encryption.
	 */
	private void generateFullKey() {
		// the spaces in the input must be removed in this part
		String inputWOSpaces = input.replaceAll(" ", "");
		
		// basically figure out how many letters from the input is needed
		// for the key
		int numLetKey = key.length();
		int numLetInput = inputWOSpaces.length();
		int numAppend = numLetInput - numLetKey;
		if (numAppend > 0);
			this.key = key + inputWOSpaces.substring(0, numAppend);		
	}
	
	/**
	 * Fills the table with all the correct letters
	 */
	private void initializeTable() {
		for (int y = 0; y < table.length; y++) {
			char let = (char) ('A' + y);
			for (int x = 0; x < table[0].length; x++) {
				if (let > 'Z')
					let = 'A';
				table[x][y] = let;
				let++;
			}
		}
	}
	
	/**
	 * Returns the decrypted or encrypted string.
	 * @return
	 */
	public String getResult() {
		return result;
	}
	
	/**
	 * Prints the table for debugging purposes. 
	 */
	private void printTable() {
		for (int y = 0; y < table.length; y++) {
			for (int x = 0; x < table[0].length; x++) {
				System.out.print(table[x][y] + " ");
			}
			System.out.println();
		}
	}
}
