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
	
	/**
	 * This writes out all the quizes in a quiztime object to file
	 * @param path The path of the file to write to
	 * @param quizTime The QuizTime object containing the quizes to 
	 * 			write out to file
	 * @throws IOException
	 */
	public static void writeQuizesToFile(String path, QuizTime quizTime) throws IOException {
		StringBuilder output = new StringBuilder();
		
		for (Quiz cur: quizTime.getQuizes()) {
			output.append("quiz " + cur.getName() + "\n\n");
			for (Question q : cur.getQuestions()) {
				output.append("question " + q.getComplexity() + "\n");
				output.append(q.getQuestion() + "\n");
				output.append(q.getAnswer() + "\n");
				output.append("endQuestion\n\n");
			}
			output.append("endQuiz\n");
		}
		toFile(path, output.toString());
	}
	
	/**
	 * Parses the specified file for quizes and returns them as 
	 * a Quiz array
	 * @param path The file to parse
	 * @return An array of quizes
	 * @throws FileNotFoundException
	 */
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
				if (quizQuestions.size() < QuizTime.MIN_QUESTIONS && QuizTime.USE_MIN) {
					System.out.println("Quiz " + quizName + " is invalid because it has less than 10 questions");
				} else {
					allQuizes.add(new Quiz(quizName, quizQuestions.toArray(new Question[]{})));
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
	

	/**
	 * Writes a string to a file
	 * @param path The file to write to
	 * @param data The data that we want to write to that file
	 * @throws IOException
	 */
	public static void toFile(String path, String data) throws IOException {
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path));	
		fileWriter.write(data);
		fileWriter.close();
	}
}
