package com.joshsizer.main;

public class Quiz {
	private Question[] myQuestions;
	private String[] yourAnswers;
	private boolean[] scoreTable;
	private String name;
	
	public Quiz(String name, Question[] questions) throws Exception {
		if (questions.length < 10) 
			throw new Exception("A quiz must have at least 10 questions");
		
		myQuestions = questions;
		this.name = name;
		scoreTable = new boolean[myQuestions.length];
		yourAnswers = new String[myQuestions.length];
	}
	
	public Question[] getQuestions() {
		return myQuestions;
	}
	
	public String getName() {
		return name;
	}
	
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
		System.out.println("You recieved an " + toLetterGrade(percentage * 100) + " (" + (Double.toString(percentage * 100).substring(0, 4)) + "). Here's the breakdown: ");
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
	
	@Override
	public String toString() {
		String out = "";
		for (Question q : myQuestions) {
			out += q.toString() + "\n";
		}
		return out;
	}
}
