package com.joshsizer.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

	public static Quiz[] getQuizes(String path) throws FileNotFoundException {
		ArrayList<Quiz> allQuizes = new ArrayList<Quiz>();
		ArrayList<Question> quizQuestions = new ArrayList<Question>();
		
		String quizName = "", question = "", answer = "";
		int complexity = 0;
		
		String fileData = readFile(path);	
		Scanner scanner = new Scanner(fileData);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
		
			if (line.startsWith("quiz")) {
				quizName = line.substring(line.indexOf("quiz ") + 5);
				quizQuestions = new ArrayList<Question>();
			} else if (line.startsWith("question")) {
				complexity = Integer.parseInt(line.substring(line.indexOf("question ") + 9));
			} else if (line.startsWith("q ")) {
				question = line.substring(line.indexOf("q ") + 2);
			} else if (line.startsWith("a ")) {
				answer = line.substring(line.indexOf("a ") + 2);
			} else if (line.startsWith("endQuestion")) {
				Question newQuestion = new Question(question, answer);
				newQuestion.setComplexity(complexity);
				quizQuestions.add(newQuestion);
			} else if (line.startsWith("endQuiz")) {
				try {
					allQuizes.add(new Quiz(quizName, quizQuestions.toArray(new Question[]{})));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		scanner.close();
		return allQuizes.toArray(new Quiz[]{});
		
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

	public static void toFile(String path, String data) throws IOException {
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path));	
		fileWriter.write(data);
		fileWriter.close();
	}
}
