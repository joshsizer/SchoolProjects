package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a cipher that can have text encrypted and decrypted, by direct substitution,
 * based on an offset (key)
 * @author Josh Sizer
 *
 */
public class CaesarCipher {
	/**
	 * the number of characters away from the plain 
	 * text character (can be positive or negative)
	 */
	private final int k; 
	
	/** 
	 * the positive only number to represent k, since -3 can be expressed as +23 and 33 can be expressed as 7
	 * this makes the decrypt logic much easier when wrapping around the ends of the alphabet
	 */
	private final int offset; 
	
	/**
	 * The one and only constructor for this object
	 * @param k The offset on which to base the substitution encryption on
	 */
	public CaesarCipher(int k) {
		this.k = k;
		this.offset = bound0to25(this.k);
	}
	
	/**
	 * Encrypts a string by substituting every letter with the letter 
	 * of the desired offset (as inputed into the constructor) away from the plain text.
	 * @param plainText The text to be encrypted
	 * @return The encrypted text, all upper case with spaces kept. 
	 */
	public String encrypt(String plainText) {
		String encryptedText = "";
		plainText = plainText.toUpperCase(); // convert to upper-case
		
		for (int i = 0; i < plainText.length(); i++) {
			char curChar = plainText.charAt(i); // the current character
			int desiredChar = curChar + this.offset; // the theoretically desired character without wrap
			
			if (curChar < 'A' || curChar > 'Z') { // if it's not a letter, just keep it as is
				encryptedText += curChar;
			} else if (desiredChar > 'Z') { // else if we need to wrap it
				// the wrap will be the number of letters above Z added to @ (the character before A)
				int wrap = '@' + (desiredChar - 'Z');
				encryptedText += (char)wrap;
			} else {
				encryptedText += (char)desiredChar;
			}
		}
		return encryptedText;
	}
	
	/**
	 * Decrypts a string by finding the original letter that was substituted with the inputed offset.
	 * 
	 * @param encryptedText The text to be decrypted
	 * @return The decrypted, plain text
	 */
	public String decrypt(String encryptedText) {
		String decryptedText = "";
		encryptedText = encryptedText.toUpperCase(); // convert to upper-case
		
		for (int i = 0; i < encryptedText.length(); i++) {
			char curChar = encryptedText.charAt(i); // the current character
			int desiredChar = curChar - this.offset; // the theoretically desired character without wrap
	
			if (curChar < 'A' || curChar > 'Z') { 	// if it's not a letter, just keep it as is
				decryptedText += curChar;
			} else if (desiredChar < 'A') { // else if we need to wrap it 
				// the wrap will be the number of letters below A subtracted from [ (the character after Z)
				int wrap = '[' + (desiredChar - 'A');
				decryptedText += (char)wrap;
			} else {
				decryptedText += (char)desiredChar;
			}
		}
		return decryptedText;
	}
	
	/**
	 * Encrypts the data in a text file.
	 * @param file The file object from which to read text and encrypt
	 * @return The encrypted data as a string.
	 * @throws FileNotFoundException If the specified file cannot be found or opened
	 */
	public String encrypt(File file) throws FileNotFoundException {
		String data = readFile(file);
		return encrypt(data);
	}
	
	/**
	 * Decrypts the data in a text file.
	 * @param file The file obect from which to read text and decrypt
	 * @return The decrypted data as a string
	 * @throws FileNotFoundException If the specified file cannot be found or opened
	 */
	public String decrypt(File file) throws FileNotFoundException {
		String data = readFile(file);
		return decrypt(data);
	}
	
	/**
	 * 
	 * @return The offset or key that this object was created with
	 */
	public int getOffset() {
		return this.k;
	}
	
	/** 
	 * Adds or subtracts 26 until the argument is in the bound 0 to 25
	 * @param k The value to bind
	 * @return The equivalent value of k in the range of 0 to 25
	 */
	public static int bound0to25(int k) {
		while (k > 25 || k < 0) {
			if (k > 25)
				k -= 26;
			else
				k += 26;
		}
		return k;
	}
	
	/**
	 * Reads in text from a file.
	 * 
	 * @param file The file object representing the file to be read
	 * @return A string with the complete file including carriage returns. 
	 * @throws FileNotFoundException If the file passed can not be found on the file system
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
	
	/**
	 * Writes text to a file.
	 * 
	 * @param file The file object representing the file to write to
	 * @param data The desired text to be written to the file
	 * @throws IOException If something goes wrong in the process 
	 * 			(can't find file or incorrect permissions) 
	 */
	public static void writeToFile(File file, String data) throws IOException {
		if (!file.exists()) {
			if (file.getParentFile() != null)
				file.getParentFile().mkdirs();
		}
		BufferedWriter output = new BufferedWriter(new FileWriter(file));
		output.write(data);
		output.close();
	}
}
