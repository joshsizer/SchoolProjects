package main;

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
	 * Parses the file for all earth quakes.
	 * 
	 * @param path
	 *            The path to the file containing earth quake information
	 * @return An array list of all the earth quakes
	 * @throws FileNotFoundException
	 *             If the file cannot be found.
	 */
	public static List<EarthQuake> getEarthQuakes(String path) throws FileNotFoundException {
		List<EarthQuake> earthQuakes = new ArrayList<EarthQuake>();

		String fileContents = readFile(path);
		Scanner scanner = new Scanner(fileContents);

		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();

			String[] tokens = currentLine.split(",");
			if (tokens.length == 5)
				earthQuakes.add(new EarthQuake(tokens));
		}

		scanner.close();

		return earthQuakes;
	}

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

	public static void toFile(String path, EarthQuake[] arr) throws IOException {
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path));

		StringBuilder output = new StringBuilder();
		for (EarthQuake cur : arr) {
			output.append(cur.toString() + "\n");
		}

		fileWriter.write(output.toString());
		fileWriter.close();
	}
}
