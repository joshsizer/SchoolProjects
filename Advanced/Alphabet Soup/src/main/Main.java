package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		StringConstructor toddler = null;

		System.out.print("Would you like to enter text from a file (1) or console (2)? ");
		int choice = promptForNumber();
		while (choice != 1 && choice != 2) {
			choice = promptForNumber();
		}
		
		if (choice == 1) {
			System.out.print("Enter file path: ");
			try {
				toddler = new StringConstructor(new File(userInput.nextLine()));
			} catch (FileNotFoundException e) {
				System.out.println("Could not find file. Enter text from console.");
				choice = 2;
			}
		}  
		if (choice == 2) {
			System.out.print("Enter text: ");
			toddler = new StringConstructor(userInput.nextLine());
		}
		System.out.println("It took " + toddler.getNumberBowls() + " bowls of alphabet soup to construct the text.");
		
		System.out.print("\nWould you like to see proof? (1 for yes, 2 for no) ");
		int proof = promptForNumber();
		while (proof != 1 && proof != 2) {
			proof = promptForNumber();
		}
		
		if (proof == 1) {
			ArrayList<AlphabetSoup> usedBowls = toddler.getUsedBowls();
			System.out.println("Limiting factor: " + toddler.getLimitingFactor());
			
			System.out.println("Source:\n" + outputArray(toddler.getLettersInString()) + "\n");
			for (AlphabetSoup bowl : usedBowls) {
				System.out.println(bowl.toString());
			}
		}
	}
	
	public static boolean isNumber(String s_num) {
		for (int i = 0; i < s_num.length(); i++) {
			if ((s_num.charAt(i) < '0' || s_num.charAt(i) > '9')
					&& s_num.charAt(i) != '-')
				return false;
		}
		return true;
	}
	
	public static int promptForNumber() {
		String in = userInput.nextLine();
		while (!isNumber(in)) {
			System.out.println("Enter a number: ");
			in = userInput.nextLine();
		}
		return Integer.parseInt(in);
	}
	
	public static String outputArray(int[] array) {
		String formated = "[";
		for (int i = 0; i < 26; i++) {
			formated += (char)('A' + i) + ": " + array[i];
			if (i == 25)
				break;
			formated += ", ";
		}
		return formated += "]";
	}

}
