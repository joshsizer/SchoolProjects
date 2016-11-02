package com.joshsizer.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static Scanner userInput = new Scanner(System.in);
	public static String path = "Test Quiz.txt";

	public static void main(String[] args) {
		if (args.length != 0) {
			path = args[0];
		}
		QuizTime quizTime;
	
		try {
			quizTime = new QuizTime(path);
		} catch (FileNotFoundException e) {
			quizTime = new QuizTime();
		}
		
		String userCommand = "";

		while (!userCommand.equals("exit")) {
			printOptions();
			userCommand = userInput.nextLine();
			int toDo = getOption(userCommand);
			doOption(toDo, userCommand, quizTime);
		}
	
	}
	
	/** Prints out the list of possible commands
	 * 
	 */
	public static void printOptions() {
		String output = "The following are available commands:\n"
				+ "\tlist\n"
				+ "\tadd quiz\n"
				+ "\tadd question -quizname\n"
				+ "\ttake quiz -quizname\n"
				+ "\tsave -path\n"
				+ "\tload -path\n"
				+ "\texit\n";
		System.out.print(output);
	}
	
	/**
	 * Performs the desired option
	 * @param option The integer option
	 * @param command The command the user entered
	 * @param quizTime the quizTime object that hold all the 
	 * 			quizes
	 */
	public static void doOption(int option, String command, QuizTime quizTime) {
		switch (option) {
		case 1:
			quizTime.listQuizes();
			System.out.println();
			break;
		case 2:
			quizTime.userAddQuiz();
			break;
		case 3:
			String name = command.substring(command.indexOf("add question -") + 14);
			Quiz toAdd = quizTime.getQuiz(name);
			if (toAdd == null) {
				System.out.println("Could not find quiz");
				break;
			}
			String question = "", answer = "";
			int complexity;
			System.out.println("Enter question: ");
			question = userInput.nextLine();
			System.out.println("Enter answer: ");
			answer = userInput.nextLine();
			System.out.println("Enter complexity");
			complexity = Integer.parseInt(userInput.nextLine());
			Question newQuestion = new Question(question, answer);
			newQuestion.setComplexity(complexity);
			toAdd.addQuestion(newQuestion);
			break;
		case 4:
			String name2 = command.substring(command.indexOf("take quiz -") + 11);
			quizTime.giveQuiz(name2);
			break;
		case 5:
			String path2 = command.substring(command.indexOf("save -") + 6);
			try {
				Parser.writeQuizesToFile(path2, quizTime);
			} catch (IOException e1) {
				System.out.println("Could not write to that file");
			}
			break;
		case 6:
			String path = command.substring(command.indexOf("load -") + 6);
			try {
				quizTime.addQuizes(Parser.getQuizes(path));
			} catch (FileNotFoundException e) {
				System.out.println("Could not load from this file");
			}
			break;
		case 7:
			System.out.println("Bye bye");
			break;
		default:
			System.out.println("The command you entered is unknown.");
			break;
		}
	}
	
	/**
	 * Returns the integer option of the user's command
	 * by parsing the input text
	 * @param command The user's input text
	 * @return The command that the user chose
	 */
	public static int getOption(String command) {
		if (command.startsWith("list")) {
			return 1;
		} else if (command.startsWith("add quiz")) {
			return 2;
		} else if (command.startsWith("add question")) {
			return 3;
		} else if (command.startsWith("take quiz -")) {
			return 4;
		} else if (command.startsWith("save -")) {
			return 5;
		} else if (command.startsWith("load -")) {
			return 6;
		} else if (command.startsWith("exit")) {
			return 7;
		} else {
			return -1;
		}
	}
}
