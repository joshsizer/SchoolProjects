package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * The "driver" for the Caesar Cipher and frequency analysis. An example usage demonstrating all aspects
 * could include:
 * <ol>
 * <li>Encrypting text from a file and saving it to another file</li>
 * <li>Running the program once more and decrypting the text from the file you just saved.</li>
 * 		<ul><li>This will use frequency analysis to determine the key</li></ul>
 * <li>Enjoy!</li>
 * <li>...Yes, you can probably trick this thing if you only have a few words to decrypt, but that's not my fault! It's
 * the fault of the algorithm. </li>
 * </ol>
 * Note: this works best with a dictionary file (in the case that the sentence being decrypted has less 'e's than
 * other characters), but it still works reasonably well without it.
 * 
 * @author Josh Sizer
 */
public class Main {
	public static final Scanner userInput = new Scanner(System.in);
	
	public static void main (String[] args) {
		CaesarCipher cipher;
		int encryptOrDecrypt = 0;
		int fileOrConsole = 0;
		int key = 0;
		String filePath;
		String input = "";
		String output = "";
		
		System.out.print("Would you like to encrypt(1) or decrypt(2)? ");
		encryptOrDecrypt = safeInput1or2();
		
		System.out.print("Would you like to read from a file(1) or from the console(2)? ");
		fileOrConsole = safeInput1or2();
		
		// if we want to encrypt
		if (encryptOrDecrypt == 1) {
			System.out.print("Enter the key for encrypting: ");
			key = safeInputNumber();
			cipher = new CaesarCipher(key);
			
			if (fileOrConsole == 1) { // and read from file
				System.out.print("\nEnter file path: ");
				filePath = userInput.nextLine();
				try {
					input = CaesarCipher.readFile(new File(filePath));
				} catch (FileNotFoundException e) {
					System.err.println("File path entered is an invalid file path. Bye Bye.");
					System.exit(0);
				}
			} else { // or read from console
				System.out.print("\nEnter text: ");
				input = userInput.nextLine();
			}
			output = cipher.encrypt(input);
		} else { // if we want to decrypt
			if (fileOrConsole == 1) { // and want to read in from file
				System.out.print("\nEnter file path: ");
				filePath = userInput.nextLine();
				try {
					input = CaesarCipher.readFile(new File(filePath));
				} catch (FileNotFoundException e1) {
					System.err.println("File path entered is invalid file path. Bye Bye.");
					System.exit(0);
				}
			
			} else { // or input text from the console. 
				System.out.print("\nEnter text: ");
				input = userInput.nextLine();
			}
			cipher = new CaesarCipher(FrequencyAnalysis.getOffset(input)); // decrypt by using frequency analysis
			output = cipher.decrypt(input);
		}
		
		System.out.println("The input text is:\n" + input);
		System.out.println("\nThe output text is:\n" + output);
		
		if (encryptOrDecrypt == 2)
			System.out.println("\nIt was determined through frequency analysis that the key is: "
					+ cipher.getOffset());
		
		System.out.print("\nWould you like to save the output to a file?(1 for yes, 2 for no) ");
		int saveFile = safeInput1or2();
		
		if (saveFile == 1) {
			System.out.print("Enter file path: ");
			String fileName = userInput.nextLine();
			try {
				CaesarCipher.writeToFile(new File(fileName), output);
				System.out.print("Output Saved!");
			} catch (IOException e) {
				System.err.println("Could not write to file! Sorry.");
				System.exit(0);
			}
		} else {
			System.out.print("Program completed.");
		}
		userInput.close();
	}
	
	/**
	 * Continues to prompt user for input until the unput is a 1 or 2
	 * @return A 1 or 2 based on user input
	 */
	public static int safeInput1or2() {
		String input;
		input = userInput.nextLine();
		
		while (!is1or2(input)) {
			System.out.print("Invalid number. Enter a 1 or 2: ");
			input = userInput.nextLine();
		}
		return Integer.parseInt(input);
	}
	
	/**
	 * Continues to prompt user for input until the input is a number
	 * @return The number entered by the user.
	 */
	public static int safeInputNumber() {
		String input;
		input = userInput.nextLine();
		while (!isNumber(input)) {
			System.out.print("Invalid input. Enter a number: ");
			input = userInput.nextLine();
		}
		return Integer.parseInt(input);
	}
	
	public static boolean is1or2(String num) {
		return (num.length() == 1 && (num.charAt(0) == '1' || num.charAt(0) == '2'));
	}
	
	public static boolean isNumber(String num) {
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) < '0' || num.charAt(i) > '9')
				return false;
		}
		return true;
	}
}
