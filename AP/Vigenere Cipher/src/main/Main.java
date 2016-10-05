package main;

import java.util.Scanner;

public class Main {
	public static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Enter 0 for encryption and 1 for decryption: ");
		int choice = safeInputNumber();
		if (choice >= 1)
			choice = 1;
		else 
			choice = 0;
		
		System.out.print("Enter text: ");
		String input = userInput.nextLine();
		
		System.out.print("Enter key: ");
		String key = userInput.nextLine();
		
		Cipher cipher = new Cipher(input, key, choice);
		
		System.out.println("Result: " + cipher.getResult());
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
	
	/** Returns true if the string only contains numbers
	 * @param num The string to check
	 * @return True if it only contains numbers, false if otherwise
	 */
	public static boolean isNumber(String num) {
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) < '0' || num.charAt(i) > '9')
				return false;
		}
		return true;
	}
}
