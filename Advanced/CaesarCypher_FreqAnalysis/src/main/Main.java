package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * The "driver" for the caesar cipher and frequency analysis. An example usage demonstrating all aspects
 * could include:
 * 
 * 1) Encrypt text from a file and save it to another file
 * 2) Run the program once more and decrypt the text from the file you just saved
 * 3) Enjoy!
 * 
 * ...4) Yes, you can probably trick this thing if you only have a few words to decrypt, but that's not my fault! It's
 * the fault of the algorithm. 
 * 
 * @author Josh Sizer
 */
public class Main {
	public static void main (String[] args) {
		Scanner userInput = new Scanner(System.in);
		CaesarCipher cipher;
		String encryptOrDecrypt = "";
		String fileOrConsole = "";
		String filePath;
		String key = "0";
		String input = "";
		String output = "";
		
		System.out.print("Would you like to encrypt(1) or decrypt(2)? ");
		encryptOrDecrypt = userInput.nextLine();
		
		while (!is1or2(encryptOrDecrypt)) {
			System.out.print("Invalid number. Enter a 1 or 2: ");
			encryptOrDecrypt = userInput.nextLine();
		}
		
		System.out.print("Would you like to read from a file(1) or from the console(2)? ");
		fileOrConsole = userInput.nextLine();
		
		while (!is1or2(fileOrConsole)) {
			System.out.print("Invalid number. Enter a 1 or 2: ");
			fileOrConsole = userInput.nextLine();
		}
				
		
		// if we want to encrypt
		if (encryptOrDecrypt.equals("1")) {
			System.out.print("Enter the key for encrypting: ");
			key = userInput.nextLine();
			while (!isNumber(key)) {
				System.out.print("Invalid input. Enter a number: ");
				key = userInput.nextLine();
			}
			
			cipher = new CaesarCipher(Integer.parseInt(key));
			if (fileOrConsole.equals("1")) { // and read from file
				System.out.print("\nEnter file path: ");
				filePath = userInput.nextLine();
				try {
					input = CaesarCipher.readFile(new File(filePath));
				} catch (FileNotFoundException e) {
					System.err.println("File path entered is invalid file path. Bye Bye.");
					System.exit(0);
				}
			} else { // or read from console
				System.out.print("\nEnter text: ");
				input = userInput.nextLine();
			}
			output = cipher.encrypt(input);
		} else { // if we want to decrypt
			if (fileOrConsole.equals("1")) { // and want to read in from file
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
			cipher = new CaesarCipher(FrequencyAnalysis.getOffset(input));
			output = cipher.decrypt(input);
		}
		
		System.out.println("The input text is:\n" + input);
		System.out.println("\nThe output text is:\n" + output);
		
		if (encryptOrDecrypt.equals("2"))
			System.out.println("It was determined through frequency analysis that the key is: "
					+ cipher.getOffset());
		
		System.out.print("Would you like to save the output to a file?(1 for yes, 2 for no) ");
		String saveFile = userInput.nextLine();
		
		while (!is1or2(saveFile)) {
			System.out.print("Invalid input. Enter 1 or 2");
			saveFile = userInput.nextLine();
		}
		
		if (saveFile.equals("1")) {
			System.out.print("Enter file path: ");
			String fileName = userInput.nextLine();
			try {
				CaesarCipher.writeToFile(new File(fileName), output);
				System.out.print("Output Saved!");
			} catch (IOException e) {
				System.err.println("Could not write to file! Sorry.");
				System.exit(0);
			}
		}
		userInput.close();
	}
	
	public static boolean is1or2(String num) {
		return (num.length() == 1 && (num.charAt(0) == '1' || num.charAt(0) == '2'));
	}
	
	public static boolean isNumber(String num) {
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) >= '0' && num.charAt(i) <= '9')
				return true;
		}
		return false;
	}
}
