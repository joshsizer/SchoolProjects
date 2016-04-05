package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static final Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		Library myLib;
		
		System.out.print("Do you want load books from file? (1 for yes, 2 for no): ");
		int loadFromFile = promptForNumber();
		while (loadFromFile != 1 && loadFromFile != 2) {
			System.out.println("Enter a 1 or 2: ");
			loadFromFile = promptForNumber();
		}
		
		if (loadFromFile == 1) {
			System.out.println("Enter file name: ");
			String fileName = userInput.nextLine();
			try {
				myLib = new Library(new File(fileName));
			} catch (FileNotFoundException e) {
				System.out.println("Could not locate file. No books loaded.");
				myLib = new Library();
			}
		} else {
			myLib = new Library();
		}
		
		int toDo = homePage();
		
		while (toDo > 0) {
			switch (toDo) {
			case 1:
				System.out.print("How many books would you like to add? ");
				int numBooks = promptForNumber();
				while (numBooks < 0) {
					System.out.print("Enter a positive number: ");
					numBooks = promptForNumber();
				}
				if (numBooks != 0)
					addBooksFromUser(numBooks, myLib);
				break;
			case 2:
				System.out.print("Enter title: ");
				Book b = myLib.getBook(userInput.nextLine());
				if (b == null) 
					System.out.println("Could not find book. Perhaps this library does not have"
							+ " this book, or you mispelled the title.");
				else
					System.out.println(b);
				break;
			case 3:
				myLib.listBooks(5);
				break;
			case 4:
				System.out.print("Add location: ");
				myLib.setLocation(userInput.nextLine());	
				break;
			case 5:
				System.out.println(myLib.getLocation());
				break;
			case 6:
				System.out.print("Add librarian: ");
				myLib.setLibrarian(userInput.nextLine());	
				break;
			case 7:
				System.out.println(myLib.getLibrarian());
				break;
			case 8:
				try {
					myLib.save();
				} catch (IOException e) {
					System.out.print("Enter filepath to save to: ");
					String filepath = userInput.nextLine();
					try {
						myLib.save(new File(filepath));
					} catch (IOException e1) {
						System.out.println("Could not find or access file to save to.");
					}
				}
				break;
			default:
				System.out.println("Enter a number between 1 and 7, or 0 if you'd like to quit.");
				break;
			}
			System.out.println();
			toDo = homePage();
		}
		System.out.print(myLib);
	}
	
	public static void addBooksFromUser(int num, Library lib) {
		String title = "";
		String author = "";
		String subject = "";
		String ISBN = "";
		String pages = "";
		
		for (int i = 1; i <= num; i++) {
			System.out.println("Book: " + i);
			System.out.print("Enter title: ");
			title = askTillNotEmpty();
			System.out.print("Enter author: ");
			author = askTillNotEmpty();
			System.out.print("Enter subject: ");
			subject = askTillNotEmpty();
			System.out.print("Enter ISBN: ");
			ISBN = askTillNotEmpty();
			while (ISBN.length() != 10) {
				ISBN = askTillNotEmpty();
			}
			System.out.print("Enter pages: ");
			pages = askTillNotEmpty();
			System.out.println();
			
			int i_pages = 0;
			try { 
				i_pages = Integer.parseInt(pages);
			} catch (NumberFormatException e) {}
			
			Book b = new Book(title, author, subject, ISBN, i_pages);
			lib.addBook(b);
		}
	}
	public static String askTillNotEmpty() {
		String input = userInput.nextLine();
		while (input.isEmpty()) {
			System.out.print("You must enter a value: ");
			input = userInput.nextLine();
		}
		return input;
	}
	
	public static int homePage() {
		System.out.println("Would you like to: ");
		System.out.println("1) Add books\n2) Look up book\n3) List books\n4) Add location\n5) List location\n6) Add librarian\n7) List librarian\n"
				+ "8) Save library to file\n0) To exit");
		return promptForNumber();
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
}
