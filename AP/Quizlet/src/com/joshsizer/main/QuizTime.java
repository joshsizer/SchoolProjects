package com.joshsizer.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class QuizTime {
	private Quiz[] myQuizes;
	public static final boolean USE_MIN = true;
	public static final int MIN_QUESTIONS = 10;

	/**
	 * Creates a QuizTime with 0 quizes
	 */
	public QuizTime() {
		this(new Quiz[0]);
	}

	/**
	 * Creates a quiz time with the specified Quiz[]
	 * 
	 * @param quizes
	 */
	public QuizTime(Quiz[] quizes) {
		this.myQuizes = quizes;
	}

	/**
	 * Attempts to create a quiz time with the quizes parsed from the given file
	 * 
	 * @param path
	 *            The file to parse
	 * @throws FileNotFoundException
	 */
	public QuizTime(String path) throws FileNotFoundException {
		this(Parser.getQuizes(path));
	}

	/**
	 * Gives the 1st quiz in this class (the quiz at the 0th position of the
	 * Quiz[])
	 */
	public void giveQuiz() {
		giveQuiz(0);
	}

	/**
	 * Gives the quiz with the specified name if it exists in this QuizTime
	 * 
	 * @param name
	 */
	public void giveQuiz(String name) {
		int index = findQuizByName(name);
		if (index != -1) {
			giveQuiz(index);
		}
	}

	/**
	 * Gives the quiz corresponding to the index in the Quiz[]
	 * 
	 * @param whichQuiz
	 */
	public void giveQuiz(int whichQuiz) {
		if (whichQuiz < 0 || whichQuiz > myQuizes.length - 1) {
			System.out.println("Index out of bounds!");
			return;
		}
		myQuizes[whichQuiz].giveQuiz();
	}

	/**
	 * Returns the quiz with the specified name
	 * 
	 * @param name
	 * @return
	 */
	public Quiz getQuiz(String name) {
		int index = findQuizByName(name);
		if (index != -1)
			return myQuizes[index];
		else
			return null;
	}

	/**
	 * Returns a Quiz[] with all the quizes contained in this object
	 * 
	 * @return
	 */
	public Quiz[] getQuizes() {
		return myQuizes;
	}

	/**
	 * Adds a quiz to this object
	 * 
	 * @param quiz
	 */
	public void addQuiz(Quiz quiz) {
		Quiz[] newArr = new Quiz[myQuizes.length + 1];
		for (int i = 0; i < newArr.length - 1; i++)
			newArr[i] = myQuizes[i];
		newArr[newArr.length - 1] = quiz;

		myQuizes = newArr;
	}

	/**
	 * Adds the quizes in the inputed Quiz[]
	 * 
	 * @param quizes
	 */
	public void addQuizes(Quiz[] quizes) {
		for (Quiz cur : quizes) {
			addQuiz(cur);
		}
	}

	/**
	 * Prompts the user to add a quiz
	 */
	public void userAddQuiz() {
		Quiz newQuiz = null;
		Question[] questions;
		String name = "";
		int numQuestions = 0;

		System.out.print("Enter the name of the quiz: ");
		name = Main.userInput.nextLine();

		System.out.print("Enter the number of questions: ");
		numQuestions = Integer.parseInt(Main.userInput.nextLine());
		while (numQuestions < QuizTime.MIN_QUESTIONS && QuizTime.USE_MIN) {
			System.out.println("The quiz must have at least " + QuizTime.MIN_QUESTIONS + " questions!");
			System.out.print("How many questions will be in this quiz? ");
			numQuestions = Integer.parseInt(Main.userInput.nextLine());
		}
		questions = new Question[numQuestions];

		for (int i = 0; i < questions.length; i++) {
			String question = "";
			String answer = "";
			int complexity = 0;
			System.out.print("\nEnter question: ");
			question = Main.userInput.nextLine();

			System.out.print("Enter answer: ");
			answer = Main.userInput.nextLine();

			System.out.print("Enter complexity: ");
			complexity = Integer.parseInt(Main.userInput.nextLine());

			questions[i] = new Question(question, answer);
			questions[i].setComplexity(complexity);
		}

		newQuiz = new Quiz(name, questions);
		addQuiz(newQuiz);
	}

	/**
	 * Finds the index of the quiz by it's name
	 * 
	 * @param name
	 * @return
	 */
	public int findQuizByName(String name) {
		for (int i = 0; i < myQuizes.length; i++) {
			if (myQuizes[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Lists all the quizes contained in this QuizTime object
	 */
	public void listQuizes() {
		System.out.println("The following are available quizes:");
		for (Quiz cur : myQuizes) {
			System.out.println("\t" + cur.getName());
		}
	}
}
