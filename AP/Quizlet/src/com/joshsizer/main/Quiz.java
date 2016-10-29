package com.joshsizer.main;

import java.util.Arrays;

public class Quiz {
	private Question[] myQuestions;
	private boolean[] scoreTable;
	private String name;
	
	public Quiz(String name, Question[] questions) {
		myQuestions = questions;
		this.name = name;
		scoreTable = new boolean[myQuestions.length];
	}
	
	public Question[] getQuestions() {
		return myQuestions;
	}
	
	public void giveQuiz() {
		int index = 0;
		for (Question curQues : myQuestions) {
			System.out.print((index + 1) + "\t" + curQues.getQuestion() + "\n\t");
			String possibleAnswer = Main.userInput.nextLine();
			scoreTable[index++] = curQues.answerCorrect(possibleAnswer);
			System.out.println();
		}
		System.out.println(Arrays.toString(scoreTable));
	}
	
	public String getName() {
		return name;
	}
}
