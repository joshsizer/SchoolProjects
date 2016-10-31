package com.joshsizer.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class QuizTime {
	private Quiz[] myQuizes;
	public static final boolean USE_MIN = false;
	public static final int MIN_QUESTIONS = 10;
	
	public QuizTime() {
		this(new Quiz[0]);
	}
	
	public QuizTime(Quiz[] quizes) {
		this.myQuizes = quizes;
	}
	
	public QuizTime(String path) throws FileNotFoundException {
		this(Parser.getQuizes(path));
	}
	
	public void giveQuiz() {
		giveQuiz(0);
	}
	
	public void giveQuiz(String name) {
		int index = findQuizByName(name);
		if (index != -1) {
			giveQuiz(index);
		}
	}
	
	public void giveQuiz(int whichQuiz) {
		if (whichQuiz < 0 || whichQuiz > myQuizes.length - 1) {
			System.out.println("Index out of bounds!");
			return;
		}
		myQuizes[whichQuiz].giveQuiz();
	}
	
	public Quiz getQuiz(String name) {
		int index = findQuizByName(name);
		if (index != -1)
			return myQuizes[index];
		else
			return null;
	}
	
	public Quiz[] getQuizes() {
		return myQuizes;
	}
	
	public void addQuiz(Quiz quiz) {
		Quiz[] newArr = new Quiz[myQuizes.length + 1];
		for (int i = 0; i < newArr.length - 1; i++)
				newArr[i] = myQuizes[i];
		newArr[newArr.length - 1] = quiz;	
		
		myQuizes = newArr;
	}
	
	public void addQuizes(Quiz[] quizes) {
		for (Quiz cur : quizes) {
			addQuiz(cur);
		}
	}
	
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
			numQuestions = Main.userInput.nextInt();
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
	
	public int findQuizByName(String name) {
		for (int i = 0; i < myQuizes.length; i++) {
			if (myQuizes[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void listQuizes() {
		System.out.println("The following are available quizes:");
		for(Quiz cur : myQuizes) {
			System.out.println("\t" + cur.getName());
		}
	}
	
	public void writeToFile(String path) throws IOException {
		StringBuilder output = new StringBuilder();
		
		Parser.toFile(path, output.toString());
	}
}
