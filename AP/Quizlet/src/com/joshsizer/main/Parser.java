package com.joshsizer.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {


	/**
	 * Reads from a file.
	 * 
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String readFile(String path) throws FileNotFoundException {
		BufferedReader fileInput = new BufferedReader(new FileReader(path));
		Scanner scanner = new Scanner(fileInput);
		StringBuilder fileContents = new StringBuilder();

		while (scanner.hasNextLine()) {
			fileContents.append(scanner.nextLine() + "\n");
		}

		scanner.close();
		return fileContents.toString();
	}

	public static void toFile(String path) throws IOException {
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path));

		StringBuilder output = new StringBuilder();
	
		fileWriter.write(output.toString());
		fileWriter.close();
	}
}
