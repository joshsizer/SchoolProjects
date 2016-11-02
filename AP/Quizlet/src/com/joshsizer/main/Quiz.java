package com.joshsizer.main;

public class Quiz {
	private Question[] myQuestions;
	private String[] yourAnswers;
	private boolean[] scoreTable;
	private String name;
	
	/**
	 * Creates a Quiz with the specified number of questions and name
	 * @param name The name of the quiz
	 * @param questions The questions contained within the quiz
	 */
	public Quiz(String name, Question[] questions) {		
		myQuestions = questions;
		this.name = name;
		scoreTable = new boolean[myQuestions.length];
		yourAnswers = new String[myQuestions.length];
	}
	
	/**
	 * Creates a new quiz with no name and 
	 * sets the Questions array to have 10 null questions
	 */
	public Quiz() {
		this("", new Question[10]);
	}
	
	/**
	 * @return The question array of this class
	 */
	public Question[] getQuestions() {
		return myQuestions;
	}
	
	/**
	 * 
	 * @return the name of this quiz
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Adds a question to this quiz
	 * @param question The question to add
	 */
	public void addQuestion(Question question) {
		Question[] newArr = new Question[myQuestions.length + 1];
		for (int i = 0; i < newArr.length - 1; i++)
				newArr[i] = myQuestions[i];
		newArr[newArr.length - 1] = question;	
		
		myQuestions = newArr;
		scoreTable = new boolean[myQuestions.length];
		yourAnswers = new String[myQuestions.length];
	}
	
	/**
	 * Prompts the user to take the quiz
	 */
	public void giveQuiz() {
		int index = 0, correct = 0;
		for (Question curQues : myQuestions) {
			System.out.print((index + 1) + "\t" + curQues.getQuestion() + "\n\t");
			String possibleAnswer = Main.userInput.nextLine();
			yourAnswers[index] = possibleAnswer;
			boolean result = curQues.answerCorrect(possibleAnswer);
			scoreTable[index++] = result;
			correct = (result == true ? correct + 1 : correct);
			System.out.println();
		}
		double percentage = (double)(correct) / (double)(myQuestions.length);
		System.out.println("You recieved an " + toLetterGrade(percentage * 100) + " (" + 
				(Double.toString(percentage * 100).length() < 4 ? Double.toString(percentage * 100).substring(0, 3) : Double.toString(percentage * 100).substring(0, 4))
				+ "). Here's the breakdown: ");
		index = 0;
		for (Question curQues : myQuestions) {
			System.out.print((index + 1));
			if (scoreTable[index])
				System.out.print(" (correct)     ");
			else
				System.out.print(" (incorrect)   ");
			System.out.println(curQues.getQuestion() + " (Level " + curQues.getComplexity() + " complexity)");
			System.out.println("\t\tYou answered \"" + yourAnswers[index++] + "\".");
			System.out.println("\t\tThe correct answer is \"" + curQues.getAnswer() + "\".\n");
		}
	}
	
	/**
	 * Returns the letter grade of the specified percentage
	 * @param percentage A number between 0 and 100
	 * @return
	 */
	public String toLetterGrade(double percentage) {
		if (percentage >= 90) {
			return "A";
		} else if (percentage >= 80) {
			return "B";
		} else if (percentage >= 70) {
			return "C";
		} else if (percentage >= 65) {
			return "D";
		} else {
			return "F";
		}
	}
	
	/**
	 * Returns the questions in this quiz as with new lines between each question
	 */
	@Override
	public String toString() {
		String out = "";
		for (Question q : myQuestions) {
			out += q.toString() + "\n";
		}
		return out;
	}
}
