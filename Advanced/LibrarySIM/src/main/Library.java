package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * A class to represent a library (a physical book bearing library). It can only
 * have one librarian, one location, and any number of books between 0 and a
 * very large number. Sure, it probably should be able to have more than one
 * librarian, but who has the money for that!
 * 
 * @author Josh Sizer
 *
 */
public class Library {
	private static final String DATABASE_DELIMETER = ",;,";
	private final ArrayList<Book> books;
	private String librarian = "";
	private String location = "";
	private File database = null;

	/**
	 * Create a library with no books.
	 */
	public Library() {
		this(new ArrayList<Book>());
	}

	/**
	 * Create a library with the given ArrayList of books.
	 * 
	 * @param books
	 *            The <code>ArrayList</code> of books.
	 */
	public Library(ArrayList<Book> books) {
		this.books = books;
	}

	/**
	 * Create a library from the given text file, which represents a database of
	 * all books on file.
	 * 
	 * @param bookDatabase
	 *            The file that contains a number of books
	 * @throws FileNotFoundException
	 *             If the file given cannot be found or accessed.
	 */
	public Library(File bookDatabase) throws FileNotFoundException {
		this(loadBooks(bookDatabase));
		database = bookDatabase;
	}

	/**
	 * Gets all the books stored in this library
	 * 
	 * @return An <code>ArrayList</code> of all books in this library.
	 */
	public ArrayList<Book> getBooks() {
		return this.books;
	}

	/**
	 * Adds a book to the libraries store of books.
	 * 
	 * @param b
	 *            The book object to add.
	 */
	public void addBook(Book b) {
		this.books.add(b);
	}

	public void removeBook(Book b) {
		this.books.remove(b);
	}

	public Book getBook(String title) {
		for (Book cur : books) {
			if (title.equals(cur.getTitle()))
				return cur;
		}
		return null;
	}

	/**
	 * 
	 * @param b
	 * @return
	 */
	public Book getBook(Book b) {
		if (books.contains(b))
			return books.get(books.indexOf(b));
		return null;
	}

	public void setLibrarian(String l) {
		this.librarian = l;
	}

	public String getLibrarian() {
		if (librarian.isEmpty())
			return "No librarian on file.";
		return librarian;
	}

	public void setLocation(String l) {
		this.location = l;
	}

	public String getLocation() {
		if (location.isEmpty())
			return "No location on file.";
		return location;
	}

	/**
	 * Loads all the books stored in a book database file.
	 * 
	 * @param bookDatabase
	 *            The file representing the database file
	 * @return An array list of Books contained within the database file
	 * @throws FileNotFoundException
	 *             If the given file cannot be accessed or found
	 */
	private static ArrayList<Book> loadBooks(File bookDatabase) throws FileNotFoundException {
		String fileContents = readFile(bookDatabase);
		ArrayList<Book> booksToReturn = new ArrayList<Book>();
		Scanner parser = new Scanner(fileContents);

		while (parser.hasNextLine()) {
			String line = parser.nextLine();
			if (!line.isEmpty())
				booksToReturn.add(createBook(line));
		}

		parser.close();
		return booksToReturn;
	}

	/**
	 * Creates a book from a String with the format:
	 * title,;,author,;,subject,;,ISBN,;,pages
	 * 
	 * @param line
	 *            The line to create a book from
	 * @return The Book with the given properties
	 */
	private static Book createBook(String line) {
		Pattern commaDelim = Pattern.compile(DATABASE_DELIMETER);
		Scanner tokenizer = new Scanner(line);
		tokenizer.useDelimiter(commaDelim);
		String[] properties = new String[5];
		int pages = 0;

		for (int i = 0; i < properties.length; i++) {
			if (tokenizer.hasNext())
				properties[i] = tokenizer.next();
			else
				properties[i] = "";
		}
		tokenizer.close();

		try { 
			pages = Integer.parseInt(properties[4]);
		} catch (NumberFormatException e) {}

		return new Book(properties[0], properties[1], properties[2], properties[3], pages);
	}

	/**
	 * Prints all the book titles in this library, with the indicated number of
	 * books per line. Each book is separated by ";"
	 * 
	 * @param booksPerLine
	 *            The number of books to print on each line of the console
	 */
	public void listBooks(int booksPerLine) {
		if (books.isEmpty()) {
			System.out.println("Library has no books on file.");
			return;
		}
		int counter = 1;
		for (Book cur : books) {
			System.out.print(cur.getTitle());
			if (counter % booksPerLine == 0 || cur == books.get(books.size() - 1)) {
				System.out.println();
				counter = 1;
			} else {
				System.out.print("; ");
			}
			counter++;
		}
	}
	
	/**
	 * Saves all the books to file
	 * @throws IOException If the file was never specified in this object
	 */
	public void save() throws IOException {
		if (this.database == null)
			throw new FileNotFoundException();
		String toWrite = "";
		for (Book cur : books) {
			toWrite += cur.getTitle() + DATABASE_DELIMETER
					+ cur.getAuthor() + DATABASE_DELIMETER
					+ cur.getSubject() + DATABASE_DELIMETER
					+ cur.getISBN() + DATABASE_DELIMETER
					+ Integer.toString(cur.getPages());
			if (!cur.equals(books.get(books.size()-1) ))
				toWrite += "\n";
		}
		writeToFile(database, toWrite);
	}
	
	/**
	 * Saves all the books to the specified file
	 * @param file The file to save to
	 * @throws IOException if the file cannot be accessed. 
	 */
	public void save(File file) throws IOException {
		this.database = file;
		save();
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

	/**
	 * Writes text to a file.
	 * 
	 * @param file
	 *            The file object representing the file to write to
	 * @param data
	 *            The desired text to be written to the file
	 * @throws IOException
	 *             If something goes wrong in the process (can't find file or
	 *             incorrect permissions
	 */
	public static void writeToFile(File file, String data) throws IOException {
		BufferedWriter output = new BufferedWriter(new FileWriter(file));
		output.write(data);
		output.close();
	}
	
	@Override
	public String toString() {
		String ret = "Librarian: " + this.librarian + "; Location: " + this.location + "\n";
		ret += "Books: [";
		for (int i = 0; i < books.size(); i++) {
			ret += books.get(i).getTitle();
			if (i != books.size() - 1) {
				ret += ", ";
			}
		}
		return  ret += "]";
	}
}
