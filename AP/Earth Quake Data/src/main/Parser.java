package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser {
	
	public static List<EarthQuake> getEarthQuakes(String path) throws FileNotFoundException {
		List<EarthQuake> earthQuakes = new ArrayList<EarthQuake>();
		String fileContents = readFile(path);
		Scanner scanner = new Scanner(fileContents);
		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			String[] tokens = currentLine.split(",");
		}
		
		return earthQuakes;
	}
	
	/**
	 * Reads from a file.
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String readFile(String path) throws FileNotFoundException {
		BufferedReader fileInput = new BufferedReader(new FileReader (path));
		Scanner scanner = new Scanner(fileInput);
		StringBuilder fileContents = new StringBuilder();
		
		while (scanner.hasNextLine()) {
			fileContents.append(scanner.nextLine() + "\n");
		}
			
		scanner.close();
		return fileContents.toString();
	}
}
